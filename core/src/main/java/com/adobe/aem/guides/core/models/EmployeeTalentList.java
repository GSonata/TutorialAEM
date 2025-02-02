package com.adobe.aem.guides.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class EmployeeTalentList {
    
    @ValueMapValue
    private String talent;

    public String getTalent() {
        return talent;
    }

}
