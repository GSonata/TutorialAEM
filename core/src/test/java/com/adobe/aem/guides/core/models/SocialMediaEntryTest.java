package com.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.sling.models.factory.ModelFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
public class SocialMediaEntryTest {

    private final AemContext aemContext = new AemContext();
    SocialMediaEntry scm;

    @BeforeEach
    void setUp() throws Exception {
        aemContext.addModelsForClasses(SocialMediaEntry.class);
        aemContext.load().json("/components/socialMediaEntry/SocialMediaEntry.json", "/component");
        Resource resource = aemContext.resourceResolver().getResource("/component/data");
        scm = aemContext.getService(ModelFactory.class).createModel(resource, SocialMediaEntry.class);
    }

    @Test
    void testgetUsername() {
        String usernameTest = "@username";
        String usernameTry = scm.getUsername();
        assertEquals(usernameTest.toLowerCase(), usernameTry.toLowerCase());
    }

    @Test
    void testgetPlaform(){
        String platformTest = "x";
        String platformTry = scm.getPlatform();
        assertEquals(platformTest.toLowerCase(), platformTry.toLowerCase());
    }
    
}
