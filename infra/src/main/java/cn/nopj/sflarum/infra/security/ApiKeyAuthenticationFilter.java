package cn.nopj.sflarum.infra.security;

import cn.nopj.sflarum.domian.entity.ApiKey;
import cn.nopj.sflarum.domian.repository.ApiKeyRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {
    private static final String HEADER = "X-API-Key";
    private final ApiKeyRepository apiKeyRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }

        String apiKey = request.getHeader(HEADER);
        String bearer = request.getHeader("Authorization");
        if (apiKey == null || apiKey.isBlank() || (bearer != null && bearer.startsWith("Bearer "))) {
            filterChain.doFilter(request, response);
            return;
        }

        ApiKey key = apiKeyRepository.findByKey(apiKey);
        if (key == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!isAllowedIp(request.getRemoteAddr(), key.getAllowedIps())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        apiKeyRepository.updateLastActivity(apiKey, java.time.LocalDateTime.now());

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (key.getScopes() != null && !key.getScopes().isBlank()) {
            for (String scope : key.getScopes().split(",")) {
                String s = scope.trim();
                if (!s.isEmpty()) {
                    authorities.add(new SimpleGrantedAuthority("SCOPE_" + s));
                }
            }
        }

        String principal = key.getUserId() == null ? "api_key" : "user:" + key.getUserId();
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(principal, null, authorities);
        auth.setDetails("api_key");
        SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }

    private boolean isAllowedIp(String remoteAddr, String allowedIps) {
        if (allowedIps == null || allowedIps.isBlank()) {
            return true;
        }
        for (String ip : allowedIps.split(",")) {
            if (remoteAddr.equals(ip.trim())) {
                return true;
            }
        }
        return false;
    }
}
