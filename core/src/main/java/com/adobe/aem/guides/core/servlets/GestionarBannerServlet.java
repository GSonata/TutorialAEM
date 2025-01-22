package com.adobe.aem.guides.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.adobe.aem.guides.core.models.CabeceraModel;
import com.adobe.aem.guides.core.services.CodificardorCesarService;
import com.drew.lang.annotations.NotNull;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class, property = {
        ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES + "=" + "practica/components/cabecera",
        ServletResolverConstants.SLING_SERVLET_EXTENSIONS + "=" + "json",
        ServletResolverConstants.SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET
})
public class GestionarBannerServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(final SlingHttpServletRequest request, @NotNull final SlingHttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Resource resource = request.getResource();

        if (resource != null) {

            CabeceraModel model = resource.adaptTo(CabeceraModel.class);

            if (model != null) {
                String titulo = model.getTitulo();
                int cifrado = model.getCifrado();

                String newTitulo = CodificardorCesarService.getCesarCode(titulo, cifrado);

                try {
                    response.getWriter().write("{\"Titulo Cifrado\": \"" + (newTitulo != null ? newTitulo : "No title found") + "\"} \n");
                    response.getWriter().write("{\"Fuerza de cifrado\": \"" + cifrado + "\" } \n");
                    response.getWriter().write("{\"Titulo sin cifrar \": \"" + titulo + "\\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        }
    }
}