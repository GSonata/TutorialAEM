package com.adobe.aem.guides.core.workflow;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.adobe.granite.workflow.exec.WorkItem;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;

import javax.jcr.Node;

@Component(
    service = WorkflowProcess.class,
    property = {
        Constants.SERVICE_DESCRIPTION + "=Generate Page Name Step",
        "process.label=Generar Nombre de la pagina"
    }
)
public class GeneratePageNameStep implements WorkflowProcess {

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) {
        try {
            // Get the ResourceResolver
            ResourceResolver resolver = workflowSession.adaptTo(ResourceResolver.class);

            // Get the payload (path of the page being created)
            String payload = (String) workItem.getWorkflowData().getPayload();

            // Get the JCR Node for the page
            Node pageNode = resolver.getResource(payload).adaptTo(Node.class);

            if (pageNode != null) {
                // Generate a custom name (example: append timestamp)
                String generatedName = "page-" + System.currentTimeMillis();

                // Set the name and title properties
                if (pageNode.hasProperty("jcr:title")) {
                    pageNode.setProperty("jcr:title", "Custom Title: " + generatedName);
                }
                pageNode.setProperty("name", generatedName);

                // Save changes
                resolver.commit();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error generating page name", e);
        }
    }
}
