# Pipeline CI/CD y Automatización Android

Este repositorio contiene los laboratorios de CI/CD (Post 1) y Automatización de Publicación (Post 2).

## Post-Contenido 1: CI/CD con GitHub Actions

### Flujo del Pipeline
1.  **Lint y Pruebas Unitarias**: Análisis estático y tests.
2.  **Quality Gate**: Falla si la cobertura JaCoCo < 60%.
3.  **Build Firmado**: APK de release generado con secretos.
4.  **Distribución**: Subida a Firebase App Distribution.

### Secrets Requeridos (Post 1)
*   `KEYSTORE_BASE64`, `KEYSTORE_PASS`, `KEY_ALIAS`, `KEY_PASS`, `FIREBASE_APP_ID`, `FIREBASE_TOKEN`.

---

## Post-Contenido 2: Automatización con Fastlane

### Flujo de Publicación
1.  **Fastlane**: Automatización de subida a Google Play (`internal`, `production`).
2.  **Feature Flag**: Implementación de Firebase Remote Config para activar/desactivar la nueva pantalla de inicio.
3.  **Conventional Commits**: Uso de `feat:`, `fix:`, `chore:` para el historial de cambios.

### Secrets Adicionales (Post 2)
*   `PLAY_CREDENTIALS_BASE64`: JSON de Google Play API en Base64.

### Lanes de Fastlane
*   `beta`: Compila y sube a Internal Testing.
*   `production`: Sube a producción con rollout del 5%.
*   `promote_to_beta`: Promueve el build de internal a beta.

---

## Checkpoints

### Post 1 - Checkpoint 1: Pipeline Básico
> **[CAPTURA_CHECKPOINT_1_AQUÍ]**

### Post 1 - Checkpoint 2: Build y Distribución
> **[CAPTURA_CHECKPOINT_2_AQUÍ]**

### Post 1 - Checkpoint 3: Quality Gate
> **[CAPTURA_CHECKPOINT_3_AQUÍ]**

### Post 2 - Checkpoint 1: Fastlane Configurado
> **[CAPTURA_CHECKPOINT_1_FASTLANE]**

### Post 2 - Checkpoint 2: Feature Flag
> **[CAPTURA_CHECKPOINT_2_FIREBASE_CONFIG]**

### Post 2 - Checkpoint 3: Versionamiento y Documentación
> **[CAPTURA_CHECKPOINT_3_PIPELINE_FASTLANE]**
