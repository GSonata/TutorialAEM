# 🚀 Proyecto de Prácticas AEM // Accenture  

📌 **Proyecto de práctica en el que estoy desarrollando el conocimiento de las distintas partes de un proyecto de AEM.**  

> ℹ️ **Cualquier adición o corrección es bienvenida.**  

## ✨ FUNCIONALIDADES  

- **🧩 Componentes:**  
  - **📢 Banner Customizado de Redes Sociales:** permite añadir nombre de usuario así como plataforma (LinkedIn, GitHub, Facebook, X). Cada entrada tiene CSS personalizado.  
  - **🗺️ Mapa Insertado v1:** despliega un componente de mapa customizable, añadiendo la URL de Google Maps desde el diálogo y mostrándolo utilizando APIs de **Leaflet** y **OpenStreetMaps**.  
    - 🔜 _Para el v2 se pretende añadir funcionalidad para elegir la ubicación del mapa desde el diálogo de AEM._  

- **💻 JavaScript y Sling:**  
  - ✅ Añadida la funcionalidad de un **NewPageWizard Customizado**, en el que aparece un nombre generado aleatoriamente en conjunto con la ruta de creación de la nueva página.  

- **⚙️ Workflow:**  
  - ✅ Añadidos componentes **Workflow customizados**, desplegados en la página, funcionando correctamente.  
  - ✅ Añadido componente customizado que abre [Google](https://google.com) al ser ejecutado.  
  - ✅ Añadido **Servlet** que ejecuta el workflow sin necesidad de añadir un launcher al proceso.  

---

## 🔮 Futuro Proyecto  

- 📦 Extraer el servicio del **NewPageWizard** en un archivo `.jar`/`.zip` para que se pueda trasladar entre instancias locales de AEM.  
- 🌍 Componente complejo para añadir un **Mapa de Google** de forma interactiva con el diálogo de AEM.  
- 🌙 Desarrollar funcionalidad para cambiar entre **modo oscuro / modo claro**.  
- 🖼️ Componente de **carrusel de imágenes**, añadidas por el usuario.  

---

## 🏗️ Módulos  

Las principales partes de la plantilla son:  

- **📂 `core`** → Paquete Java con la funcionalidad central: servicios OSGi, escuchadores, planificadores, servlets y filtros.  
- **🧪 `it.tests`** → Pruebas de integración basadas en Java.  
- **🎨 `ui.apps`** → Contiene las partes del proyecto en `/apps` (y `/etc`), incluyendo **clientlibs** de JS y CSS, componentes y plantillas.  
- **📝 `ui.content`** → Contiene contenido de ejemplo utilizando los componentes de `ui.apps`.  
- **⚙️ `ui.config`** → Contiene configuraciones OSGi específicas del proyecto.  
- **🌐 `ui.frontend`** → Mecanismo opcional de compilación para frontend (Angular, React o Webpack).  
- **🖥️ `ui.tests`** → Pruebas de UI basadas en Selenium.  
- **📦 `all`** → Un único paquete que agrupa todos los módulos compilados y dependencias.  
- **🔍 `analyse`** → Realiza análisis del proyecto para validar antes de desplegar en AEMaaCS.  

---

## 🛠️ Cómo Compilar  

Para compilar todos los módulos, ejecuta en la raíz del proyecto con Maven 3:  

```bash
mvn clean install

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
