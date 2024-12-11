package com.adobe.aem.guides.core.models;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class EmployeeDetailsModel {

    @ValueMapValue
    private String name;

    @ValueMapValue
    private int age;

    @ValueMapValue
    private String number;

    @ValueMapValue
    private String company;

    @ValueMapValue
    private String designation;

    @ChildResource
    private List<EmployeeTalentList> talentList;

    public String getCompanyStyle() {
        String definedStyle = "";
        switch (this.getCompany()) {
            case "BSoccer":
                definedStyle = "employee-background-component-bsoccer";
                break;
            case "Accenture":
                definedStyle = "employee-background-component-accenture";
                break;
            case "NTT Data":
                definedStyle = "employee-background-component-ntt";
                break;
            default:
                break;
        }
        return definedStyle;
    }

    public String getAllTalents() {
        List<EmployeeTalentList> talentos = getTalentList();
        return talentos.stream().map(EmployeeTalentList::getTalent).collect(Collectors.joining(", "));
    }

    // GETTER SECTION
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }

    public String getDesignation() {
        return designation;
    }

    public List<EmployeeTalentList> getTalentList() {
        return talentList;
    }

}
