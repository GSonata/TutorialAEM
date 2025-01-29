# Proyecto de prácticas AEM // Accenture

Proyecto de práctica en la que estoy desarrollando el conocimiento de las distintas partes de un proyecto de AEM.

> [!NOTE]
> Cualquier adición o corrección es bienvenida.
>
> 
 ## Actualizaciones

- **Workflow**:
  - **Añadidos componentes workflow customizados, desplegados en la página, funcionan.**
  - **Añadido componente customizado, abre https://google.com al ser ejecutado.**
  - **Añadido Servlet que ejecuta el workflow sin tener que añadir un launcher al proceso.**

 ## Futuro proyecto:

Busco añadir un workflow que añada automaticamente el nombre de la pagina al crear la misma

## Módulos

Las principales partes de la plantilla son:

- **`core`**: Paquete Java que contiene toda la funcionalidad central, como servicios OSGi, escuchadores o planificadores, así como el código Java relacionado con los componentes, como servlets o filtros de solicitud.
- **`it.tests`**: Pruebas de integración basadas en Java.
- **`ui.apps`**: Contiene las partes del proyecto `/apps` (y `/etc`), es decir, clientlibs de JS y CSS, componentes y plantillas.
- **`ui.content`**: Contiene contenido de ejemplo utilizando los componentes de `ui.apps`.
- **`ui.config`**: Contiene configuraciones OSGi específicas para el modo de ejecución del proyecto.
- **`ui.frontend`**: Un mecanismo opcional de compilación dedicado al frontend (Angular, React o un proyecto general de Webpack).
- **`ui.tests`**: Pruebas de UI basadas en Selenium.
- **`all`**: Un único paquete de contenido que agrupa todos los módulos compilados (paquetes de contenido y bundles), incluidas las dependencias de los proveedores.
- **`analyse`**: Este módulo realiza análisis del proyecto para proporcionar validación adicional antes de desplegar en AEMaaCS.

## Cómo compilar

Para compilar todos los módulos, ejecuta el siguiente comando en el directorio raíz del proyecto con Maven 3:

```bash
mvn clean install
```

Para compilar todos los módulos y desplegar el paquete all a una instancia local de AEM, ejecuta:

```
bash
mvn clean install -PautoInstallSinglePackage
```

O para desplegar en una instancia de publicación, ejecuta:

```bash
mvn clean install -PautoInstallSinglePackagePublish
```
O para desplegar solo un paquete de contenido, ejecuta en el directorio del sub-módulo (por ejemplo, ui.apps):

```bash
mvn clean install -PautoInstallPackage
```
