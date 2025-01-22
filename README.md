Plantilla de Proyecto AEM
Esta es una plantilla de proyecto para aplicaciones basadas en AEM. Está destinada como un conjunto de ejemplos de mejores prácticas, así como un posible punto de partida para desarrollar tu propia funcionalidad.

Módulos
Las principales partes de la plantilla son:

core: Paquete Java que contiene toda la funcionalidad central, como servicios OSGi, escuchadores o planificadores, así como el código Java relacionado con los componentes, como servlets o filtros de solicitud.
it.tests: Pruebas de integración basadas en Java.
ui.apps: Contiene las partes del proyecto /apps (y /etc), es decir, clientlibs de JS y CSS, componentes y plantillas.
ui.content: Contiene contenido de ejemplo utilizando los componentes de ui.apps.
ui.config: Contiene configuraciones OSGi específicas para el modo de ejecución del proyecto.
ui.frontend: Un mecanismo opcional de compilación dedicado al frontend (Angular, React o un proyecto general de Webpack).
ui.tests: Pruebas de UI basadas en Selenium.
all: Un único paquete de contenido que agrupa todos los módulos compilados (paquetes de contenido y bundles), incluidas las dependencias de los proveedores.
analyse: Este módulo realiza análisis del proyecto para proporcionar validación adicional antes de desplegar en AEMaaCS.
Cómo compilar
Para compilar todos los módulos, ejecuta el siguiente comando en el directorio raíz del proyecto con Maven 3:

bash
Copiar
Editar
mvn clean install
Para compilar todos los módulos y desplegar el paquete all a una instancia local de AEM, ejecuta:

bash
Copiar
Editar
mvn clean install -PautoInstallSinglePackage
O para desplegar en una instancia de publicación, ejecuta:

bash
Copiar
Editar
mvn clean install -PautoInstallSinglePackagePublish
O alternativamente:

bash
Copiar
Editar
mvn clean install -PautoInstallSinglePackage -Daem.port=4503
O para desplegar solo el bundle al autor, ejecuta:

bash
Copiar
Editar
mvn clean install -PautoInstallBundle
O para desplegar solo un paquete de contenido, ejecuta en el directorio del sub-módulo (por ejemplo, ui.apps):

bash
Copiar
Editar
mvn clean install -PautoInstallPackage
Pruebas
Existen tres niveles de pruebas contenidas en el proyecto:

Pruebas unitarias
Estas muestran la prueba clásica de unidad del código contenido en el bundle. Para probar:

bash
Copiar
Editar
mvn clean test
Pruebas de integración
Estas permiten ejecutar pruebas de integración que ejercen las capacidades de AEM mediante llamadas HTTP a su API. Para ejecutar las pruebas de integración, usa:

bash
Copiar
Editar
mvn clean verify -Plocal
Las clases de prueba deben guardarse en el directorio src/main/java (o cualquiera de sus subdirectorios), y deben estar contenidas en archivos que coincidan con el patrón *IT.java.

La configuración proporciona valores predeterminados sensatos para una instalación local típica de AEM. Si deseas apuntar las pruebas de integración a diferentes instancias de autor y publicación de AEM, puedes usar las siguientes propiedades del sistema a través del flag -D de Maven.

Propiedad	Descripción	Valor por defecto
it.author.url	URL de la instancia de autor	http://localhost:4502
it.author.user	Usuario administrador para la instancia de autor	admin
it.author.password	Contraseña del usuario administrador para la instancia de autor	admin
it.publish.url	URL de la instancia de publicación	http://localhost:4503
it.publish.user	Usuario administrador para la instancia de publicación	admin
it.publish.password	Contraseña del usuario administrador para la instancia de publicación	admin
Las pruebas de integración en esta plantilla utilizan los AEM Testing Clients y muestran algunas mejores prácticas recomendadas para ser puestas en uso al escribir pruebas de integración para AEM.

Análisis Estático
El módulo analyse realiza análisis estáticos sobre el proyecto para su despliegue en AEMaaCS. Este análisis se ejecuta automáticamente al ejecutar:

bash
Copiar
Editar
mvn clean install
desde el directorio raíz del proyecto. Más información sobre este análisis y cómo configurarlo puede encontrarse aquí: https://github.com/adobe/aemanalyser-maven-plugin

Pruebas de UI
Estas pruebas se encargan de probar la capa de UI de tu aplicación AEM utilizando la tecnología Selenium.

Para ejecutarlas localmente:

bash
Copiar
Editar
mvn clean verify -Pui-tests-local-execution
Este comando por defecto requiere:

Una instancia de autor de AEM disponible en http://localhost:4502 (con el proyecto completo construido y desplegado sobre ella, consulta la sección Cómo compilar más arriba).
El navegador Chrome instalado en la ubicación predeterminada.
Consulta el archivo README en el módulo ui.tests para más detalles.

ClientLibs
El módulo frontend se pone a disposición mediante un AEM ClientLib. Al ejecutar el script de compilación de NPM, la app se construye y el paquete aem-clientlib-generator toma el resultado de la compilación y lo transforma en una ClientLib.

Una ClientLib consistirá en los siguientes archivos y directorios:

css/: Archivos CSS que pueden ser solicitados en el HTML.
css.txt (informa a AEM del orden y nombres de los archivos en css/ para que puedan ser combinados).
js/: Archivos JavaScript que pueden ser solicitados en el HTML.
js.txt (informa a AEM del orden y nombres de los archivos en js/ para que puedan ser combinados).
resources/: Mapas de origen, trozos de código no relacionados con los puntos de entrada (resultados de dividir el código), activos estáticos (por ejemplo, iconos), etc.
Configuración de Maven
El proyecto viene con el repositorio automático de Adobe configurado. Para configurar el repositorio en tus ajustes de Maven, consulta:

Configurar el repositorio de Maven de Adobe
