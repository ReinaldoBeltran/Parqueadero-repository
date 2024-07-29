# Estructura del Código

El proyecto sigue una arquitectura en capas típica de Spring Boot, organizada en los siguientes paquetes:

## com.example.nelumbo

Paquete raíz del proyecto que contiene la clase principal para iniciar la aplicación Spring Boot.

- **NelumboApplication.java**: Clase principal que inicia la aplicación.

## com.example.nelumbo.config

Contiene la configuración de seguridad y utilidades relacionadas con JWT.

- **JwtAuthenticationFilter.java**: Filtro para manejar la autenticación JWT.
- **JwtAuthorizationFilter.java**: Filtro para manejar la autorización JWT.
- **JwtUtil.java**: Utilidad para generar y validar tokens JWT.
- **SecurityConfig.java**: Configuración de seguridad de Spring Security.

## com.example.nelumbo.controller

Contiene los controladores REST que manejan las solicitudes HTTP.

- **AuthController.java**: Controlador para la autenticación de usuarios (login, registro, logout).
- **EmailController.java**: Controlador para la simulación de envío de correos.
- **ParqueaderoController.java**: Controlador para manejar los parqueaderos y sus indicadores.
- **VehiculoController.java**: Controlador para manejar el registro de ingreso y salida de vehículos.

## com.example.nelumbo.model

Contiene las entidades JPA que representan las tablas en la base de datos.

- **Parqueadero.java**: Entidad que representa un parqueadero.
- **User.java**: Entidad que representa un usuario.
- **Vehiculo.java**: Entidad que representa un vehículo.

## com.example.nelumbo.repository

Contiene los repositorios JPA que proporcionan operaciones CRUD sobre las entidades.

- **ParqueaderoRepository.java**: Repositorio para la entidad `Parqueadero`.
- **UserRepository.java**: Repositorio para la entidad `User`.
- **VehiculoRepository.java**: Repositorio para la entidad `Vehiculo`.

## com.example.nelumbo.service

Contiene los servicios que implementan la lógica de negocio.

- **EmailService.java**: Servicio para la simulación de envío de correos.
- **ParqueaderoService.java**: Servicio para manejar la lógica de los parqueaderos y sus indicadores.
- **UserService.java**: Servicio para manejar la lógica de usuarios.
- **VehiculoService.java**: Servicio para manejar la lógica de registro de ingreso y salida de vehículos.
