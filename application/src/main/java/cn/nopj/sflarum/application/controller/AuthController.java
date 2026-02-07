package cn.nopj.sflarum.application.controller;

import cn.nopj.sflarum.application.service.AccessTokenService;
import cn.nopj.sflarum.application.service.ApiKeyService;
import cn.nopj.sflarum.domian.entity.AccessToken;
import cn.nopj.sflarum.domian.entity.ApiKey;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AccessTokenService accessTokenService;
    private final ApiKeyService apiKeyService;

    @PostMapping("/access-tokens")
    public ResponseEntity<AccessTokenResponse> createAccessToken(@RequestBody AccessTokenCreateRequest request,
                                                                 jakarta.servlet.http.HttpServletRequest httpRequest) {
        AccessToken token = accessTokenService.issueToken(
                request.getUserId(),
                request.getType(),
                request.getTitle(),
                httpRequest.getRemoteAddr(),
                httpRequest.getHeader("User-Agent")
        );
        AccessTokenResponse response = new AccessTokenResponse();
        response.setToken(token.getToken());
        response.setUserId(token.getUserId());
        response.setType(token.getType());
        response.setTitle(token.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/api-keys")
    public ResponseEntity<ApiKeyResponse> createApiKey(@RequestBody ApiKeyCreateRequest request) {
        ApiKey apiKey = apiKeyService.issueKey(
                request.getUserId(),
                request.getScopes(),
                request.getAllowedIps()
        );
        ApiKeyResponse response = new ApiKeyResponse();
        response.setApiKey(apiKey.getKey());
        response.setUserId(apiKey.getUserId());
        response.setScopes(apiKey.getScopes());
        response.setAllowedIps(apiKey.getAllowedIps());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Map<String, Object> payload = new HashMap<>();
        payload.put("principal", authentication.getPrincipal());
        payload.put("authType", authentication.getDetails());
        List<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        payload.put("authorities", authorities);
        return ResponseEntity.ok(payload);
    }

    @Data
    public static class AccessTokenCreateRequest {
        private Long userId;
        private String type;
        private String title;
    }

    @Data
    public static class ApiKeyCreateRequest {
        private Long userId;
        private String scopes;
        private String allowedIps;
    }

    @Data
    public static class AccessTokenResponse {
        private String token;
        private Long userId;
        private String type;
        private String title;
    }

    @Data
    public static class ApiKeyResponse {
        private String apiKey;
        private Long userId;
        private String scopes;
        private String allowedIps;
    }
}
