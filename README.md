# ADA05_API

## Descripción del Proyecto
Este proyecto es una API REST Segura desarrollada con Spring Boot usando Kotlin como lenguaje y MongoDB como base de datos
Su objetivo es permitir la gestión de tareas con diferentes niveles de acceso según el rol del usuario

## Tablas

### User
- `id`: Identificador del usuario
- `username`: Nombre de usuario que debe ser único
- `password`: Contraseña cifrada
- `roles`: Roles de acceso (`USER` o `ADMIN`)

### Task
- `id`: Identificador de la tarea
- `titulo`: Título de la tarea
- `descripcion`: Descripción de la tarea
- `completada`: Indica si la tarea ha sido completada o no
- `userId`: Identificador del usuario propietario de la tarea

### Address
- `id`: Identificador de la dirección
- `userId`: Identificador del usuario propietario
- `calle`: Nombre de la calle
- `ciudad`: Nombre de la ciudad
- `pais`: Nombre del país

## Endpoints

### Autenticación
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `POST` | `/auth/login` | Loggearse en una cuenta ya existente |
| `POST` | `/auth/register` | Registrar un usuario nuevo |

### Para Usuarios con el rol USER
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `GET` | `/tasks` | Obtiene todas las tareas de este usuario |
| `GET` | `/tasks/{taskId}` | Obtiene una tarea concreta de este usuario |
| `POST` | `/tasks` | Crea una nueva tarea para este usuario |
| `PUT` | `/tasks/{id}/complete` | Marca como completada una tarea de este usuario |
| `DELETE` | `/tasks/{id}` | Elimina una tarea de este usuario |

### Para Usuarios con el rol ADMIN
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `GET` | `/admin/tasks` | Obtiene todas las tareas |
| `GET` | `/admin/tasks/{userId}` | Obtiene todas las tareas de un usuario en concreto |
| `GET` | `/admin/tasks/{userId}/{taskId}` | Obtiene una tarea de un usuario en concreto |
| `POST` | `/admin/tasks/{userId}` | Crea una tarea para un usuario concreto |
| `DELETE` | `/admin/tasks/{userId}/{taskId}` | Elimina una tarea concreta de un usuario concreto |
| `DELETE` | `/admin/{userId}` | Elimina un usuario concreto |

## Lógica de Negocio
- Los usuarios pueden autenticarse mediante JWT
- Los usuarios con rol `USER` pueden gestionar sus propias tareas
- Los usuarios con rol `ADMIN` pueden gestionar todas las tareas de todos los usuarios y tambien a los propios usuarios
- Solo el dueño de una tarea puede modificarla o eliminarla, excepto los admins

## Excepciones
| Código | Descripción |
|--------|-------------|
| `200 OK` | Solicitud exitosa |
| `201 Created` | Recurso creado exitosamente |
| `400 Bad Request` | Error en los datos enviados |
| `401 Unauthorized` | Autenticación requerida o fallida |
| `403 Forbidden` | No tienes permisos para acceder al recurso |
| `404 Not Found` | Recurso no encontrado |
| `500 Internal Server Error` | Error inesperado en el servidor |

## Seguridad de la API
- Uso de **Spring Security** para control de acceso
- Autenticación basada en **JWT**
