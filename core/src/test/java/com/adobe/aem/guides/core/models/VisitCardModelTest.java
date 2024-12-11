package com.adobe.aem.guides.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class VisitCardModelTest {

    private final AemContext aemContext = new AemContext();
    VisitCardModel vcm;

    @BeforeEach
    void setUp() throws Exception {
        aemContext.addModelsForClasses(VisitCardModel.class);
        aemContext.load().json("/components/visitCard/visitCard.json", "/component");
        Resource resource = aemContext.resourceResolver().getResource("/component/data");
        vcm = aemContext.getService(ModelFactory.class).createModel(resource, VisitCardModel.class);
    }

    @Test
    void testgetTitulo() {
        String titleTest = "Titulo ejemplo";
        String titleTry = vcm.getTitulo();
        assertEquals(titleTest.toLowerCase(), titleTry.toLowerCase());
    }

    @Test
    void testgetText() {
        String titleText = "Texto ejemplo";
        String textTry = vcm.getText();
        assertEquals(titleText, textTry);
    }

    @Test
    void testGetBannerAlt() {
        String altText = "Texto Alternativo";
        String altTry = vcm.getBannerAlt();
        assertEquals(altText, altTry);
    }

    @Test 
    void correctExtensionTest(){
        String[] correctExtensions = {".jpg",".png",".jpeg",".gif", ".tiff", ".svg"};
        String extensionTry = vcm.getFileReference();

        // Separamos el extensionTry para comprobar cual es el nombre del archivo y la extension
        String[] extensionTryArray = extensionTry.split("/");
        String fileName = extensionTryArray[extensionTryArray.length - 1];
        String extension = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(extension);

        assertTrue(Arrays.asList(correctExtensions).contains(extension));
}
}
