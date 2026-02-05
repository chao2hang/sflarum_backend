# 🚀 SFlarum Backend

![Java 21](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-6DB33F?logo=springboot&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Stateless-000000?logo=jsonwebtokens&logoColor=white)
![Core API](https://img.shields.io/badge/Core-API-0078D7)

> A Spring Boot reimplementation of Flarum core features, focused on the essential discussion experience with an independent architecture.  
> This file is the English companion; see `README.md` for the Chinese version.

---

## 📌 Snapshot

| Dimension | Description |
| --- | --- |
| Positioning | Core discussion platform APIs with a standalone codebase |
| Architecture | Layered adapter/application/domian/infra/common pattern |
| Security | Stateless JWT + Spring Security |
| Runtime | Java 21 + Spring Boot 4 |
| Extension | New features implemented directly in the source |

---

## 🧱 Positioning

- ✅ Focused on the foundational discussion experience (threads, replies, users)  
- ✅ Modular layering keeps teams aligned by domain (controllers, use cases, domain, infrastructure)  
- ✅ Relies on Spring Security/JWT for consistent authentication/authorization

---

## ⚡ Quick Start

```bash
mvn clean install
```

```bash
mvn spring-boot:run -pl infra
```

**Steps**  
1. Configure `infra/src/main/resources/application.yml` or environment variables (database, Redis, JWT secret, etc.)  
2. Start the HTTP API module (`infra` or `adapter`, optionally with `-pl`)  
3. Log in via `/api/auth/login` to obtain a JWT, then add `Authorization: Bearer <token>` to headers  
4. For local testing, combine Postman/Curl with mock data as needed

---

## 📦 Deployment

```bash
mvn clean package -DskipTests
java -jar infra/target/infra-1.0-SNAPSHOT.jar --spring.profiles.active=prod
```

**Checklist**  
- [ ] Upload the built artifact (e.g., `infra/target/infra-1.0-SNAPSHOT.jar`) to the target server  
- [ ] Provide production configuration through `application-prod.yml`, environment variables, or secrets manager  
- [ ] Keep the process alive via nohup/systemd/container orchestration  
- [ ] Optional: place a reverse proxy (Nginx, etc.) in front for HTTPS, rate limiting, and logging

---

## 🛠️ Secondary Development

### Module Responsibilities
| Module | Role |
| --- | --- |
| `adapter` | Controller/DTO/REST API layer |
| `application` | Use cases/business services |
| `domian` | Domain models and repository contracts |
| `infra` | Implementations, MyBatis-Plus, Spring/Wiring |

### Recommended Flow
1. Define new domain entities/repository contracts inside `domian`  
2. Implement persistence or infrastructure logic in `infra`  
3. Compose business rules and transactions in `application`  
4. Expose APIs in `adapter`, transforming DTOs as needed  
5. Keep tests close to the business logic; prefer integration tests at the `application` layer

### Security & JWT
- `JwtTokenProvider` issues/validates tokens and includes username+roles in the payload  
- `CustomUserDetailsService` or another implementation loads `UserDetails` with the right `GrantedAuthority`  
- `JwtAuthenticationFilter` parses tokens and populates the `SecurityContext`  
- `SecurityConfig` inserts the filter via `http.addFilterBefore` and defines URL authorization rules

### Feature Extension Example (comments/likes/tags)
1. Define repositories and DTOs in `domian` (e.g., `CommentRepository`)  
2. Implement mappers/entities/repository implementations in `infra`  
3. Build use cases such as `PublishCommentUseCase` in `application`  
4. Add controllers like `CommentController` in `adapter`  
5. Keep JWT and authorization rules aligned; update `SecurityConfig` as necessary

### Source-First Expansion
- All enhancements are delivered through source changes, keeping architecture and security boundaries consistent.

---

## 🎯 Constraints & Goals

- 🎯 Maintain clear module boundaries and auditability  
- 🎯 Stay focused on discussion platform essentials so the codebase can grow via deliberate source changes

---

## 🌍 Chinese README

- See `README.md` for the Chinese version.
