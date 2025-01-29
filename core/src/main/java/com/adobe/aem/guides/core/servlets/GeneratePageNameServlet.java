package com.adobe.aem.guides.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.UUID;

@Component(
    service = Servlet.class,
    property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/generate-page-name"
    }
)
public class GeneratePageNameServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

        String currentPath = request.getParameter("path");
        if (currentPath == null || currentPath.isEmpty()) {
            currentPath = "default-path"; 
        }

        // Limpiar caracteres especiales en la ruta
        String sanitizedPath = currentPath.replaceAll("[^a-zA-Z0-9/]", "-").replaceAll("/$", "");
        String lastPart = sanitizedPath.substring(sanitizedPath.lastIndexOf("/") + 1);

        // Generar un identificador único aleatorio
        String randomIdentifier = UUID.randomUUID().toString().substring(0, 8);

        // Crear el nombre final
        String generatedName = lastPart + "-" + randomIdentifier;

        // Enviar el resultado como JSON
        response.setContentType("application/json");
        response.getWriter().write("{\"generatedName\": \"" + generatedName + "\"}");
    }
}
