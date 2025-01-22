package com.adobe.aem.guides.core.workflow;

import javax.jcr.Session;
import javax.jcr.Node;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(
    service = WorkflowProcess.class,
    immediate = true,
    property = {
        "process.label=Custom Workflow Logger",
        Constants.SERVICE_VENDOR + "=PMorente",
        Constants.SERVICE_DESCRIPTION + "= Paso customizado que loggea las opciones de dialogo"
    }
)
public class CustomWorkflow implements WorkflowProcess {
    private static final Logger log = LoggerFactory.getLogger("custom.workflow.logger");

    @Override
    public void execute(WorkItem workitem, WorkflowSession workflowSession, MetaDataMap processArgument) {
        log.info("------------------EJECUTANDO CustomWorkflow-----------------");

        WorkflowData workflowData = workitem.getWorkflowData();
        try {
            if ("JCR_PATH".equals(workflowData.getPayloadType())) {
                Session session = workflowSession.adaptTo(Session.class);
                String path = workflowData.getPayload().toString() + "/jcr:content";
                Node node = (Node) session.getItem(path);
                log.info("Node: " + node.getName());

                String brand = processArgument.get("BRAND", "");
                boolean multinational = processArgument.get("MULTINATIONAL", false);
                log.info("Brand: " + brand + " | Multinational: " + multinational);

                String[] countries = processArgument.get("COUNTRIES", new String[] {});
                for (String country : countries) {
                    log.info("Country: " + country);
                }
            }
        } catch (Exception e) {
            log.error("Error in workflow execution: ", e);
        }
    }
}
