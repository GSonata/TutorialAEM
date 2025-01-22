package com.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
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
    