package com.adobe.aem.guides.core.servlets;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.core.models.EmployeeDetailsModel;
import com.day.cq.commons.jcr.JcrConstants;
import com.drew.lang.annotations.NotNull;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Component(service = {Servlet.class})
@SlingServletResourceTypes(
    resourceTypes = { "sling/servlet/default" },
    selectors = "EmployeeDetailsServletjava",
    extensions = "json",
    methods = HttpConstants.METHOD_GET
)


public class EmployeeDetailsServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {

        final Logger log = LoggerFactory.getLogger(this.getClass());

        Resource resource = req.getResource();
        EmployeeDetailsModel empD = resource.adaptTo(EmployeeDetailsModel.class);

        JsonObject responseJson = new JsonObject();
        Gson gson = new Gson();

        String jsonResult = null;

        if(empD != null){
            responseJson.addProperty("Employee name : ", empD.getName());
            responseJson.addProperty("Employee number: ", empD.getNumber());
            responseJson.addProperty("Employee age: ", empD.getAge());
            responseJson.addProperty("Employee designation: ", empD.getDesignation());
            responseJson.addProperty("Employee company: ", empD.getCompany());
            responseJson.addProperty(("Employee talents: "), empD.getAllTalents());
        }else responseJson.addProperty("ERROR EN EL DISPLAY","ha habido un error al crear el json del empleado");

        jsonResult = gson.toJson(responseJson);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        try {
            resp.getWriter().write(jsonResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
