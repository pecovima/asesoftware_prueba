# Proyecto Spring Boot-Asesoftware CarCenter

Este es un proyecto basado en Spring Boot para la gestión de un sistema de mantenimiento de vehículos. A continuación, se proporciona una descripción general del proyecto, instrucciones de instalación y uso.

## Descripción

El proyecto es una aplicación RESTful construida con Spring Boot que permite la gestión de mantenimientos de vehículos, incluyendo la creación de facturas, seguimiento de mantenimientos y administración de clientes, mecánicos y repuestos.

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior


## Instalación

1. **Clonar el repositorio**

    ```bash
    git clone https://github.com/pecovima/asesoftware_prueba.git
    cd tu-repositorio
    ```

2. **Configurar el entorno**

   Crea un archivo `application.properties` en `src/main/resources/` con las siguientes configuraciones:

    ```properties
     spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
     spring.datasource.username=SYSTEM
     spring.datasource.password=victor
     spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
    ```

3. **Construir el proyecto**

   Ejecuta el siguiente comando para compilar el proyecto:

    ```bash
    mvn clean install
    ```

## Ejecución

Para ejecutar la aplicación, usa el siguiente comando:

```bash
mvn spring-boot:run
