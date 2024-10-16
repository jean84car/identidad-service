# Identidad Service

Microservicio que proprociona API para el registro de usuarios

## Requisitos

- JDK 17
- Docker
- Maven


#### Construir el Proyecto

mvn clean package


### Ejecucion con Docker

#### 1. Construir la Imagen Docker

En el directorio raíz del proyecto, ejecutar el siguiente comando para crear la imagen Docker:

docker build -t identidad-service:1.0.0 .


#### 1. Ejecutar el Contenedor Docker

docker run -p 8080:8080 identidad-service:1.0.0


### Ejecutar con el .jar

java -jar target/identidad-service-0.0.1-SNAPSHOT.jar


## Script de Base de Datos

El script para crear la base de datos se encuentra en la carpeta database del proyecto con el nombre identidad.sql

