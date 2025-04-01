# API Automation - Java/ Rest assured 

Este proyecto fue desarrollado como práctica de automatización de servicios **REST** utilizando **Java**.

El objetivo es realizar **consultas GET y POST** sobre diferentes APIs públicas, verificando sus respuestas y estructuras. Es un ejemplo simple pero funcional de cómo automatizar pruebas de APIs.

## 🚀 Tecnologías y herramientas

- Java
- REST Assured
- Maven
- Testng
- IntelliJ IDEA

## 📡 APIs utilizadas

### 🔭 NASA API
- Se utiliza una **petición GET** para obtener una foto del día (`Astronomy Picture of the Day`).
- URL base: [https://api.nasa.gov/](https://api.nasa.gov/)
- Parámetros como `api_key` son manejados dentro del código o `.env` si aplicás buenas prácticas.

### 👤 ReqRes API
- Se utiliza una **petición POST** para simular la creación de un usuario.
- URL base: [https://reqres.in/](https://reqres.in/)
- Se automatiza el envío de datos JSON y se verifica la respuesta del servidor.

## 📁 Estructura del proyecto

```bash
📦 src
 ┣ 📂 main
 ┃ ┗ 📂 java
 ┃   ┗ 📜 ... (código principal)
 ┣ 📂 test
 ┃ ┗ 📜 ... (clases de prueba automatizadas)
┣ 📄 pom.xml
