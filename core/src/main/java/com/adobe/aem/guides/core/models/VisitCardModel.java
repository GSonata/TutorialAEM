package com.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class VisitCardModel {
    
    @ValueMapValue
    private String titulo;
    
    @ValueMapValue
    private String text;
    
    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String bannerAlt;

    //GETTERS

    public String getTitulo() {
        return titulo.toUpperCase();
    }

    public String getText() {
        return text;
    }

    public String getFileReference() {
        return fileReference;
    }

    public String getBannerAlt() {
        return bannerAlt;
    }

    
}
    