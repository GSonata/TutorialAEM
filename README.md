# Proyecto de prácticas AEM // Accenture

Proyecto de práctica en la que estoy desarrollando el conocimiento de las distintas partes de un proyecto de AEM.

> [!NOTE]
> Cualquier adición o corrección es bienvenida.
>
> 
 ## FUNCIONALIDADES

- **Componentes**:
  - **Banner Customizado de Redes Sociales:** permite añadir nombre de usuario así como plataforma(LinkdedIN, GitHub, Facebook, X). Cada entrada tiene css personalizado
  - **Mapa Insertado v1 **: componente que despliega un componente de mapa customizable, añadiendo URL de Google MAPS del dialogo lo muestra utilizando APIs de Leaflet y OpenStreetMaps
    -  _Para el v2 se pretende añadir funcionalidad para elegir la ubicación del mapa desde el dialogo de AEM._

   
- **JavaScript y Sling**:
  - **Añadida la funcionalidad de un newPageWizard Customizado, en este aparece un nombre generado aleatoriament en conjunto con la ruta de creación de la nueva página.**
    
- **Workflow**:
  - **Añadidos componentes workflow customizados, desplegados en la página, funcionan.**
  - **Añadido componente customizado, abre https://google.com al ser ejecutado.**
  - **Añadido Servlet que ejecuta el workflow sin tener que añadir un launcher al proceso.**

 ## Futuro proyecto:

Extraer el servicio del newPageWizard en un archivo .jar/.zip para que se pueda transladar entre instancias locales de AEM. 
Componente complejo para añadir un componente Mapa de Google de forma interactiva con el dialogo de AEM.

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
