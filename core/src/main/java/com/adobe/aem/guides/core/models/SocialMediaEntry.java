package com.adobe.aem.guides.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SocialMediaEntry {

    @SlingObject
    private Resource currentResource;

    @ValueMapValue
    private String username;

    @ValueMapValue
    private String platform;

    public String getUsername() {
        return username == null ? StringUtils.EMPTY : "@" + username;    
    }

    public String getPlatformIcon() {
        String platformResult = "";
        switch (platform.toLowerCase()) {
            case "x":
                platformResult = "https://img.freepik.com/vector-gratis/nuevo-diseno-icono-x-logotipo-twitter-2023_1017-45418.jpg";
                break;
            case "linkedin":
                platformResult = "https://cdn-icons-png.flaticon.com/512/174/174857.png";
                break;
            case "facebook":
                platformResult = "https://cdn-icons-png.flaticon.com/256/124/124010.png";
                break;
            case "github":
                platformResult = "https://cdn-icons-png.flaticon.com/512/25/25231.png";
                break;
            default:
                break;
        }
        return platformResult;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPathResource() {
        return currentResource != null ? currentResource.getPath() : StringUtils.EMPTY;
    }

}
