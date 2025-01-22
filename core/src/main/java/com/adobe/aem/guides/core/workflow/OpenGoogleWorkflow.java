package com.adobe.aem.guides.core.workflow;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import java.awt.Desktop;
import java.net.URI;

@Component(service = WorkflowProcess.class, immediate = true, property = {
        "process.label=Open Google Page Workflow Step",
        Constants.SERVICE_VENDOR+"=PMorente",
        Constants.SERVICE_DESCRIPTION + "=Paso de Workflow customizado (Abre google.com)"
})
public class OpenGoogleWorkflow implements WorkflowProcess {

    @Override
    public void execute(WorkItem workitem, WorkflowSession workflowSession, MetaDataMap metaDataMap) {
        try {
            String url = "https://www.google.com";

            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}