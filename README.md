
# ParkingM3

Proyecto de gestión de parking que combina una API REST desarrollada en Spring Boot con un cliente gráfico en Java Swing para interactuar con la API.

---

## Descripción

Este proyecto forma parte de la práctica de la UF6 - Persistencia del módulo M3 Programación II.

Consiste en:

- **Backend:** API REST desarrollada con Spring Boot, que gestiona un parking con una base de datos MySQL.
- **Frontend:** Cliente gráfico en Java que consume la API para mostrar el estado del parking y permitir reservar o liberar plazas.

---

## Tecnologías usadas

- Java 11+
- Spring Boot
- MySQL (gestionado mediante XAMPP)
- Java Swing (NetBeans para el cliente gráfico)
- HTTP para comunicación cliente-API (JSON)

---

## Repositorios

- Cliente gráfico (Java Swing): [https://github.com/ivansimmer/ParkingM3](https://github.com/ivansimmer/ParkingM3)  
- API REST (Spring Boot): [https://github.com/zjonkg/ParkingMonlauAPI.git](https://github.com/zjonkg/ParkingMonlauAPI.git)

---

## Instrucciones para ejecutar el proyecto

### 1. Configuración de la base de datos MySQL

- Inicia los servicios **Apache** y **MySQL** desde el panel de control de XAMPP.
- Accede a `phpMyAdmin` y crea una base de datos llamada `parking`.
- La creación de las tablas y datos iniciales se realiza automáticamente al ejecutar la API, gracias al script `data.sql` ubicado en `src/main/resources` del proyecto API.

### 2. Ejecutar la API REST (Backend)

- Clona el repositorio de la API:  
  ```bash
  git clone https://github.com/zjonkg/ParkingMonlauAPI.git
  ```
- Abre el proyecto con un IDE compatible, por ejemplo IntelliJ IDEA.
- Espera a que se descarguen las dependencias.
- Ejecuta la clase principal `ParkingMonlauApiApplication`.
- La API quedará disponible en:  
  ```
  http://localhost:1311/api/
  ```
  (El puerto puede cambiar según la configuración en `application.properties`).

### 3. Ejecutar el cliente gráfico (Frontend)

- Clona el repositorio del cliente:  
  ```bash
  git clone https://github.com/ivansimmer/ParkingM3.git
  ```
- Abre el proyecto en NetBeans.
- Navega hasta `src/view/gui` y ejecuta la clase `JFrameHome`.

---

## Funcionalidades del cliente gráfico

- **Vista principal (`JFrameHome`):**  
  Muestra las plazas del parking con colores:  
  - Verde: plazas libres  
  - Rojo: plazas ocupadas  
  Cada plaza muestra su número.

- **Reservar plaza (`JFrameAsignarPlaza`):**  
  Permite aparcar un vehículo introduciendo matrícula, color y tipo (AUTO, MOTO, CAMIONETA).  
  Se realiza una petición POST a la API para reservar una plaza disponible para el tipo de vehículo.

- **Liberar plaza (`JFrameLiberarPlaza`):**  
  Permite retirar un vehículo introduciendo el ID del ticket recibido al aparcar.  
  Se realiza una petición POST a la API para liberar la plaza y calcular el coste del aparcamiento según el tipo de vehículo y tiempo.

---

## Detalles técnicos

- Comunicación cliente-API mediante HTTP y JSON.
- Endpoints principales de la API:  
  - `GET /api/parking/plazas` — Obtener estado de todas las plazas  
  - `POST /api/parking/reservar` — Reservar plaza con datos del vehículo  
  - `POST /api/parking/liberar/{ticketId}` — Liberar plaza por ticket ID

---

## Equipo

- Jon Kevin Goncalves  
- Iván Simmer

---

## Notas adicionales

- Es necesario tener XAMPP instalado y configurado para la base de datos.
- El proyecto está pensado para ejecutarse localmente.
- Para ampliar o modificar la funcionalidad, se recomienda conocer Spring Boot y desarrollo en Java Swing.

---

Si necesitas ayuda o quieres contribuir, no dudes en abrir un issue o un pull request.

---
