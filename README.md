# Automatización CI/CD, Publicación y Operación en Android

## Autor

**Nombre:** Jhoseth Esneider Rozo Carrillo  
**Código:** 02230131027  
**Programa:** Ingeniería de Sistemas  
**Unidad:** Unidad 10 – CI/CD, Publicación y Operación  
**Actividad:** Post-Contenido 2  
**Fecha:** 16/05/2026

---

# Descripción del Proyecto

Este proyecto implementa un flujo completo de automatización CI/CD para una aplicación Android utilizando GitHub Actions, Fastlane y Firebase Remote Config.

La solución permite:

- Ejecutar pruebas automáticas y análisis de cobertura
- Generar builds automáticamente
- Automatizar distribución beta con Fastlane
- Configurar lanes de publicación
- Implementar feature flags con Firebase Remote Config
- Aplicar versionamiento mediante Conventional Commits
- Integrar despliegue automatizado desde GitHub Actions

El objetivo principal es simular un entorno real de integración y entrega continua utilizado en equipos profesionales de desarrollo móvil.

---

# Objetivo

Implementar un pipeline CI/CD funcional que permita:

- Automatizar pruebas y generación de builds Android
- Configurar Fastlane para automatizar publicación
- Gestionar distribución beta mediante lanes
- Integrar Firebase Remote Config
- Habilitar feature flags en producción
- Aplicar versionamiento basado en Conventional Commits
- Ejecutar despliegues automáticos desde GitHub Actions

---

# Tecnologías Utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- GitHub Actions
- Fastlane
- Firebase Remote Config
- Firebase App Distribution
- JaCoCo
- JUnit
- Gradle
- Ruby + Bundler

---

# Prerrequisitos

Antes de ejecutar el proyecto se requiere:

- Android Studio actualizado
- JDK 17
- Ruby 3.0+
- Bundler instalado
- Cuenta Firebase
- Git instalado
- Proyecto Android funcional
- GitHub Actions habilitado

Comandos utilizados:

```bash
ruby --version
bundle --version
java -version
```

---

# Estructura del Proyecto

```text
app/
 ├── src/
 ├── build/
 └── build.gradle.kts

fastlane/
 ├── Appfile
 └── Fastfile

.github/
 └── workflows/
      └── android-ci.yml

gradle/
```

---

# Configuración de Fastlane

## Instalación

Inicialización del entorno:

```bash
bundle init
```

Configuración del Gemfile:

```ruby
source "https://rubygems.org"

gem "fastlane"
gem "fastlane-plugin-firebase_app_distribution"
```

Instalación de dependencias:

```bash
bundle install
```

Inicialización de Fastlane:

```bash
bundle exec fastlane init
```

---

# Configuración del Appfile

Archivo:

```ruby
json_key_file("fastlane/google-play-credentials.json")
package_name("com.universidad.pipelineci_cd")
```

---

# Seguridad de Credenciales

Los archivos sensibles fueron excluidos del repositorio:

```gitignore
release-key.jks
fastlane/google-play-credentials.json
```

---

# Configuración del Fastfile

Se implementaron las 3 lanes solicitadas por la actividad.

## Lane Beta

```ruby
lane :beta do
```

Función:

- Genera bundle release
- Firma automáticamente
- Ejecuta distribución beta

---

## Lane Production

```ruby
lane :production do
```

Función:

- Genera build release
- Configura staged rollout
- Prepara despliegue de producción

---

## Lane Promote_to_beta

```ruby
lane :promote_to_beta do
```

Función:

- Promueve builds entre tracks

---

# Workflow de GitHub Actions

El pipeline automatiza:

1. Checkout del proyecto
2. Configuración Java
3. Configuración Ruby
4. Instalación de dependencias
5. Ejecución de pruebas
6. Generación de reporte JaCoCo
7. Validación de cobertura
8. Ejecución de Fastlane

---

# Pipeline CI/CD

## Flujo implementado

```text
Commit
   ↓
GitHub Actions
   ↓
Pruebas Automáticas
   ↓
JaCoCo Coverage
   ↓
Fastlane
   ↓
Build Release
   ↓
Distribución Beta
   ↓
Firebase Remote Config
```

---

# Cobertura de Código con JaCoCo

Se configuró JaCoCo para medir cobertura de pruebas unitarias.

Configuración principal:

```kotlin
jacoco {
    toolVersion = "0.8.11"
}
```

---

# Pruebas Unitarias

Se implementaron pruebas sobre:

- Calculator
- Operaciones matemáticas
- Casos positivos
- Casos negativos
- Validaciones de división

---

# Resultado de Cobertura

Cobertura alcanzada:

- Calculator → 95%
- Cobertura general → superior al mínimo requerido

El pipeline valida automáticamente que la cobertura sea mayor al 60%.

---

# Firebase Remote Config

Se integró Firebase Remote Config para manejar feature flags dinámicamente.

Dependencias utilizadas:

```kotlin
implementation(platform("com.google.firebase:firebase-bom:33.9.0"))
implementation("com.google.firebase:firebase-config")
implementation("com.google.firebase:firebase-analytics")
```

---

# Feature Flag Implementado

Parámetro configurado:

```text
new_home_screen_enabled
```

Valor por defecto:

```text
false
```

---

# Implementación en MainViewModel

```kotlin
remoteConfig.setDefaultsAsync(
    mapOf("new_home_screen_enabled" to false)
)
```

---

# Funcionamiento del Feature Flag

## Cuando el flag es false

La aplicación muestra:

```text
LegacyHomeScreen
```

## Cuando el flag es true

La aplicación muestra:

```text
NewHomeScreen
```

---

# Conventional Commits

Se implementó versionamiento utilizando Conventional Commits.

Archivo:

```text
.commitlintrc.json
```

Configuración:

```json
{
  "extends": ["@commitlint/config-conventional"],
  "rules": {
    "subject-max-length": [2, "always", 72],
    "body-max-line-length": [0, "always", 100]
  }
}
```

---

# Tipos de Commit Utilizados

## feat

Agrega nuevas funcionalidades.

Ejemplo:

```text
feat: agregar integración de fastlane
```

Impacto:

```text
MINOR
```

---

## fix

Corrige errores.

Ejemplo:

```text
fix: corregir configuración de jacoco
```

Impacto:

```text
PATCH
```

---

## feat! o BREAKING CHANGE

Introduce cambios incompatibles.

Impacto:

```text
MAJOR
```

---

# Evidencias del Proyecto

Las evidencias se encuentran en la carpeta:

```text
/evidencias/
```

---

# Checkpoint 1 — Fastlane Configurado

✔ Directorio fastlane/ creado correctamente  
✔ Appfile configurado  
✔ Fastfile funcional  
✔ Lanes beta, production y promote_to_beta implementadas  
✔ Gemfile.lock incluido en el repositorio  
✔ Archivos sensibles excluidos con .gitignore

---

# Checkpoint 2 — Feature Flag Implementado

✔ Firebase Remote Config integrado  
✔ Proyecto compila sin errores  
✔ Feature flag configurado  
✔ Navegación condicionada por flag  
✔ Parámetro creado en Firebase

---

# Checkpoint 3 — Versionamiento y Documentación

✔ Conventional Commits implementados  
✔ README documenta flujo completo  
✔ Pipeline ejecutando Fastlane correctamente  
✔ Commits usando convención semántica

---

# Decisiones de Diseño

## Uso de GitHub Actions

Permite automatizar integración continua directamente desde GitHub.

---

## Uso de Fastlane

Facilita automatización de builds y despliegues Android.

---

## Uso de Firebase Remote Config

Permite activar funcionalidades sin publicar nuevas versiones.

---

## Uso de Conventional Commits

Facilita versionamiento semántico y automatización futura de changelogs.

---

# Comandos Utilizados

## Ejecutar pruebas

```bash
./gradlew testDebugUnitTest
```

---

## Generar reporte JaCoCo

```bash
./gradlew jacocoTestReport
```

---

## Ejecutar Fastlane beta

```bash
bundle exec fastlane beta
```

---

## Ver lanes disponibles

```bash
bundle exec fastlane lanes
```

---

# Repositorio

```bash
git clone https://github.com/jerc31/Rozo-post2_u10.git
```

## Capturas del Proyecto

Las siguientes evidencias se encuentran en la carpeta `/evidencias/`:

## Directorio de Fastlane

![fastlane](evidencias/captura_dir_fastlane.png)

## Archivo gemfile_lock generado

![gemfile_lock](evidencias/captura_gemfile_lock.png)

## Lanes de fastlanes

![lanes](evidencias/captura_lanes_fastlanes.png)

## Flag de la app en ejecución

![falg](evidencias/captura_app_flag.png)

## Pipeline de github actions extioso

![actions](evidencias/captura_actions_exitoso.png)
