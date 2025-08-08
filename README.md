# 📘 Arquitectura de Microservicios para la Gestión Integral de Publicaciones

Este proyecto implementa una plataforma distribuida para la gestión del ciclo de vida de publicaciones académicas (libros y artículos), diseñada bajo el paradigma de **arquitectura de microservicios**.

## 🚀 Microservicios Implementados

| Microservicio                | Puerto  | Funcionalidad principal                                      |
|-----------------------------|---------|--------------------------------------------------------------|
| `ApiRestApplication`        | 9090    | Gestión de autores, libros y artículos (Publicaciones)       |
| `MsNotificacionesApplication| 54542 | Envío de notificaciones por eventos (publicaciones, login)   |
| `MsAuthApplication`         | (n/d)   | Servicio de autenticación (OAuth2, JWT)                      |
| `MsEurekaServerApplication` | 8761    | Descubrimiento de servicios (Eureka)                         |
| `Application`               | 8000    | API Gateway para entrada unificada de peticiones             |
| `OpenaiApplication`         | (n/d)   | (Opcional / futuro desarrollo)                               |
| `CatalogoService` (pendiente) | n/a   | Indexación y consulta de publicaciones aprobadas             |

## 🧰 Tecnologías utilizadas

- Java + Spring Boot
- Spring Cloud Gateway
- Spring Security OAuth2 + JWT
- Eureka Discovery Server
- RabbitMQ
- CockroachDB (base de datos distribuida)
- Docker / Docker Desktop
- IntelliJ IDEA

## 📦 Estructura del proyecto

```
.
├── api-rest/                  # Publicaciones (libros, autores, artículos)
├── ms-notificaciones/         # Notificaciones multicanal
├── ms-auth/                   # Autenticación y autorización
├── ms-eureka-server/          # Eureka Service Discovery
├── api-gateway/               # API Gateway
├── catalogo-service/          # (Pendiente)
└── docker-compose.yml         # Configuración de servicios
```

## ⚙️ Instrucciones de despliegue local

### Requisitos:

- Java 17+
- Maven
- Docker Desktop
- RabbitMQ y CockroachDB ejecutándose (por Docker o servicios cloud)
- IDE recomendado: IntelliJ IDEA

### Pasos:

1. Clonar el repositorio:
```bash
git clone https://github.com/usuario/proyecto-publicaciones.git
cd proyecto-publicaciones
```

2. Iniciar servicios base (RabbitMQ y CockroachDB):
```bash
docker compose up -d
```

3. Ejecutar los microservicios:
- En IntelliJ, correr las clases:
  - `MsEurekaServerApplication`
  - `MsAuthApplication`
  - `ApiRestApplication`
  - `MsNotificacionesApplication`
  - `Application` (API Gateway)

4. Acceder a las interfaces:

| Servicio            | URL                                  |
|---------------------|--------------------------------------|
| API Gateway         | http://localhost:8000                |
| Publicaciones REST  | http://localhost:9090                |
| Eureka Dashboard    | http://localhost:8761                |
| RabbitMQ UI         | http://localhost:15672               |
| CockroachDB UI      | http://localhost:8080                |

## 📊 Diagrama de Arquitectura

```
                     [Usuarios / Clientes]
                              │
                        ┌────────────┐
                        │ API Gateway│
                        └────┬───────┘
                             │
         ┌───────────────────┼────────────────────┐
         │                   │                    │
 ┌────────────┐     ┌────────────────┐    ┌─────────────────┐
 │ AuthService│<───▶│ Publicaciones  │    │ Notificaciones  │
 └────────────┘     └────────────────┘    └─────────────────┘
                                │
                         [RabbitMQ Events]
                                ▼
                         ┌──────────────┐
                         │ Catalogo Svc │
                         └──────────────┘

                         [CockroachDB Cluster]
                     ┌────────┬────────┬────────┐
                     │ auth_db│ pub_db │ notif_db
                     └────────┴────────┴────────┘
```

- 🟢 Comunicación síncrona: REST + Feign Clients
- 🟡 Comunicación asíncrona: RabbitMQ
- 🗃️ Persistencia: CockroachDB (Database-per-Service)

## 📄 Documentación adicional

- [Informe técnico en LaTeX](./docs/informe.pdf)
- [Video demostrativo](./video/demo.mp4)


