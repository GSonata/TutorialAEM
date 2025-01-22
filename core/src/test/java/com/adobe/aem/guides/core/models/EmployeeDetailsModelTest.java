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
public class EmployeeDetailsModelTest {

    private final AemContext aemContext = new AemContext();
    private final String json_Path = "/components/employeeDetails/EmployeeDetails.json";
    private final String jsonName = "/component";
    private final String jsonResolver = "/component/data";
    
    EmployeeDetailsModel employeeDetailsModel;
    
    @BeforeEach 
    void setUp() throws Exception{
        aemContext.addModelsForClasses(EmployeeDetailsModel.class);
        aemContext.load().json(json_Path,jsonName);
        Resource resource = aemContext.resourceResolver().getResource(jsonResolver);
        employeeDetailsModel = aemContext.getService(ModelFactory.class).createModel(resource, EmployeeDetailsModel.class);
    }

    @Test
    void testGetName(){
        String nameTest = "Name esperado";
        String nameTry =employeeDetailsModel.getName();
        //Depuramos los nombres para que ignoren problemas
        nameTest = nameTest.toLowerCase().trim();
        nameTry = nameTry.toLowerCase().trim();
        assertEquals(nameTest, nameTry);
    }

    
    @Test
    void testGetAge(){
        int ageTest = 18;
        int ageTry = employeeDetailsModel.getAge();
        assertEquals(ageTest, ageTry);
    }

    
    @Test
    void testGetCompany(){
        String companyTest = "Company esperado";
        String companyTry =employeeDetailsModel.getCompany();
        //Depuramos los nombres para que ignoren problemas
        companyTest = companyTest.toLowerCase().trim();
        companyTry = companyTry.toLowerCase().trim();
        assertEquals(companyTest, companyTry);
    }

    
    @Test
    void testGetNumber(){
        String numberTest = "Number esperado";
        String numberTry =employeeDetailsModel.getNumber();
        //Depuramos los nombres para que ignoren problemas
        numberTest = numberTest.toLowerCase().trim();
        numberTry = numberTry.toLowerCase().trim();
        assertEquals(numberTest, numberTry);
    }
    
    @Test
    void testGetDesignation(){
        String designationTest = "Designation esperado";
        String designationTry =employeeDetailsModel.getDesignation();
        //Depuramos los nombres para que ignoren problemas
        designationTest = designationTest.toLowerCase().trim();
        designationTry = designationTry.toLowerCase().trim();
        assertEquals(designationTest, designationTry);
    }

    @Test
    void testGetTalents(){
       String talentTest = "CSS";
       String talentTry = employeeDetailsModel.getTalentList().get(1).getTalent();
       assertEquals(talentTest, talentTry);
    }
}
