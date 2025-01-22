package com.adobe.aem.guides.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/executeWorkflow")
public class ExecuteWorkflow extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(ExecuteWorkflow.class);

    private static final String WORKFLOW_MODEL_PATH = "/var/workflow/models/lanzar-contenido";
    private static final String WORKFLOW_DATA_TYPE = "JCR_PATH";

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse response) throws IOException {

        String status = "Workflow ejecutado con éxito";
        String payload = "";

        try {
            if (req.getRequestParameter("page") != null) {
                payload = req.getRequestParameter("page").getString();
            }

            if (StringUtils.isNotBlank(payload)) {
                final ResourceResolver resourceResolver = req.getResourceResolver();
                WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);

                if (workflowSession != null) {
                    WorkflowModel workflowModel = workflowSession.getModel(WORKFLOW_MODEL_PATH);
                    WorkflowData workflowData = workflowSession.newWorkflowData(WORKFLOW_DATA_TYPE, payload);

                    workflowSession.startWorkflow(workflowModel, workflowData);

                    log.info("Workflow started for payload: {}", payload);
                } else {
                    log.error("WorkflowSession is null, cannot start workflow.");
                    status = "Error: WorkflowSession is null.";
                }
            } else {
                log.warn("Invalid or empty payload received.");
                status = "Error: Invalid or empty payload.";
            }
        } catch (Exception e) {
            log.error("Error al ejecutar el workflow", e);
            status = "Error al ejecutar el workflow.";
        }

        response.setContentType("application/json");
        response.getWriter().write("{\"Status\":\"" + status + "\"}");
    }
}
