# 🚀 SFlarum 后端

![Java 21](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4-6DB33F?logo=springboot&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Stateless-000000?logo=jsonwebtokens&logoColor=white)
![核心 API](https://img.shields.io/badge/Core-API-0078D7)

> 基于 Spring Boot 重构 Flarum 核心能力，聚焦基础讨论功能，架构与数据模型完全独立。  
> 本 README 仅面向中文用户，英文版请参考 `README.en.md`。

---

## 📌 项目速览

| 项目维度 | 说明 |
| --- | --- |
| 定位 | 核心讨论平台 API，独立于原有 Flarum 插件体系 |
| 架构 | `adapter` / `application` / `domian` / `infra` / `common` 分层清晰 |
| 安全 | Stateless JWT + Spring Security |
| 运行环境 | Java 21、Spring Boot 4 |
| 扩展方式 | 通过源码扩展业务，遵循模块职责，不依赖运行时插件 |

---

## 🧱 项目定位

- ✅ 聚焦最核心的讨论体验（线程、回复、用户），避免过度扩展带来的复杂度  
- ✅ 采用分层架构，方便不同团队聚焦各自领域（接口 / 业务 / 领域 / 基础设施）  
- ✅ 仅依赖 Spring Security/JWT，保持安全边界的一致性

---

## ⚡ 快速上手

```bash
mvn clean install
```

```bash
mvn spring-boot:run -pl infra
```

**步骤说明**  
1. 编辑 `infra/src/main/resources/application.yml` 或环境变量，配置数据库连接、Redis、JWT secret 等  
2. 启动负责 HTTP 接口的模块（`infra` 或 `adapter`，可通过 `-pl` 指定）  
3. 请求 `/api/auth/login` 获取 JWT，后续在 Header 添加 `Authorization: Bearer <token>`  
4. 本地可以配合 Postman/Curl 及 Mock 数据做联调测试

---

## 📦 部署指南

```bash
mvn clean package -DskipTests
java -jar infra/target/infra-1.0-SNAPSHOT.jar --spring.profiles.active=prod
```

**部署清单**  
- [ ] 将产物上传到目标服务器（例如 `infra/target/infra-1.0-SNAPSHOT.jar`）  
- [ ] 使用 `application-prod.yml` 或环境变量配置生产数据库、JWT secret、Redis 等  
- [ ] 采用 nohup/systemd/容器方式启动并保持进程存活  
- [ ] 建议在前端前端放置 Nginx 等反向代理，负责 HTTPS、限流、访问日志等

---

## 🛠️ 二次开发指引

### 模块职责
| 模块 | 角色 |
| --- | --- |
| `adapter` | 接口层（Controller、DTO、REST API） |
| `application` | 用例/业务服务，组织事务与业务流程 |
| `domian` | 领域模型、仓储接口及中立规则 |
| `infra` | 基础设施（MyBatis-Plus、Spring 配置、Security、JWT） |

### 推荐流程
1. 在 `domian` 定义领域模型与仓储接口（例如新增评论、标签）；  
2. `infra` 实现持久层、事件或安全策略；  
3. `application` 编排业务逻辑与事务边界；  
4. `adapter` 层暴露 REST 接口，执行 DTO 转换；  
5. 配套测试靠近业务点，`application` 层建议编写集成测试。

### 安全与 JWT 拓展
- `JwtTokenProvider` 生成/校验 token，token 中记录用户名和角色；  
- `CustomUserDetailsService`（或其他实现）通过 `UserDetails` 填充 `GrantedAuthority`；  
- `JwtAuthenticationFilter` 解析 token 将认证信息注入 `SecurityContext`；  
- `SecurityConfig` 使用 `http.addFilterBefore` 插入过滤器，并通过 `.authorizeHttpRequests` 配置权限。

### 功能扩展示例（评论/点赞/标签）
1. `domian` 提供接口（如 `CommentRepository`）与 DTO；  
2. `infra` 实现 MyBatis-Plus Mapper、Entity、RepositoryImpl；  
3. `application` 编写 UseCase（如 `PublishCommentUseCase`）；  
4. `adapter` 添加 Controller（如 `CommentController`）处理请求/响应；  
5. 保持 JWT 与权限规则一致，必要时在 `SecurityConfig` 中新增 URL 授权。

### 源码扩展
- 所有新功能通过源码 PR 完成，保持架构与安全边界一致，避免运行时依赖复杂模块。

---

## 🎯 约束与目标

- 🎯 保持架构可审计、责任清晰，便于未来分层演进  
- 🎯 专注讨论平台核心，支持逐步在源码层面扩展更多业务

---

## 🌍 English README

- See `README.en.md` for the English version.  
