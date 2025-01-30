package com.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.annotation.PostConstruct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GoogleMapsModel {

    @ValueMapValue
    private String location;

    private String lat;
    private String lng;

    @PostConstruct
    protected void init() {
        if (location != null && !location.isEmpty()) {
            extractCoordinates(location);
        }
    }

    private void extractCoordinates(String url) {
        // Regex for extracting latitude & longitude from Google Maps link
        Pattern pattern = Pattern.compile("@([-\\d.]+),([-\\d.]+)");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            lat = matcher.group(1);
            lng = matcher.group(2);
        } else {
            lat = "40.4168"; // Default Madrid
            lng = "-3.7038";
        }
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
