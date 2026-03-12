# Serenity E2E Automation

Este proyecto es el marco de automatización End-to-End (E2E) construido para garantizar la calidad del software utilizando **Serenity BDD**.

## Arquitectura y Diseño

El proyecto está diseñado bajo el patrón **POM (Page Object Model)**. Esto nos permite separar la lógica de las automatizaciones de los localizadores de la interfaz gráfica, impulsando de esta forma la mantenibilidad y reutilización del código.

## Requisitos Previos

Para ejecutar y compilar este proyecto asegúrate de contar con las siguientes herramientas en tu entorno local:

- **Java**: Versión 17 o superior.
- **Gradle**: Recomendado utilizar el Wrapper de Gradle incluido (`gradlew`).

## Ejecución de Pruebas

Para correr todo el set de pruebas, abre tu terminal en la raíz del proyecto y ejecuta el siguiente comando:

```bash
./gradlew clean test
```

*(En Windows, si usas la consola de comandos, puedes ejecutar simplemente `gradlew clean test` sin el `./`).*

## Reportes de Ejecución

Serenity BDD genera reportes muy completos, visuales y vivos, que documentan el comportamiento de la aplicación junto a los resultados de las pruebas.

Inmediatamente después de cada ejecución, puedes visualizar el reporte abriendo el archivo HTML generado en tu navegador predeterminado:

- **Ruta del reporte:** `target/site/serenity/index.html`
