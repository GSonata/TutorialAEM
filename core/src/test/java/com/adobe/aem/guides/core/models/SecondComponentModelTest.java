package com.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class SecondComponentModelTest {

    private final AemContext aemContext = new AemContext();
    SecondComponentModel secondComponentModel;

    @BeforeEach
    void setUp() throws Exception {
        aemContext.addModelsForClasses(SecondComponentModel.class);
        aemContext.load().json("/components/secondComponent/SecondComponentModel.json", "/component");
        Resource resource = aemContext.resourceResolver().getResource("/component/data");
        secondComponentModel = aemContext.getService(ModelFactory.class).createModel(resource, SecondComponentModel.class);
    }

    @Test
    void testGetTitle(){
        String expected = "Titulo esperado";
        String actualTitle = secondComponentModel.getTitle();
        assertEquals(expected, actualTitle);
    }

    
    @Test
    void testGetText(){
        String expected = "Texto esperado";
        String actualText = secondComponentModel.getText();
        assertEquals(expected, actualText);
    }

    
    @Test
    void testGetEyebrow(){
        String expected = "Eyebrow esperado";
        String actualEyebrow = secondComponentModel.getEyebrow();
        assertEquals(expected, actualEyebrow);
    }

    @Test
    void testGetHeader(){
        String expected = "Header esperado";
        String actualHeader = secondComponentModel.getHeader();
        assertEquals(expected, actualHeader);
    }

}
