package com.adobe.aem.guides.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CabeceraModel {
    
    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String titulo;

    @ValueMapValue
    private String imagenReference;

    @ValueMapValue
    private String textoboton;

    @ValueMapValue
    private String linkboton;

    @ValueMapValue
    private String targetoption;

    @ValueMapValue
    private int cifrado;

    public String getTitulo() {
        return titulo;
    }

    public String getImagenReference() {
        return imagenReference;
    }

    public String getTextoboton() {
        return textoboton;
    }

    public String getLinkboton() {
        return linkboton;
    }

    public String getTargetoption() {
        return targetoption;
    }

    public int getCifrado() {
        return cifrado;
    }

    public String getPathResource(){
        return currentResource != null ? currentResource.getPath() : StringUtils.EMPTY;
    }
}
