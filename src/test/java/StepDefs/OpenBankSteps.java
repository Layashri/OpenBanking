package StepDefs;


import Base.OpenBankingDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenBankSteps {

    Response prod;
    Response filtered;
    Response proDetails;
    Map<String,String> paramToPass =new HashMap<>();

    @Steps
    OpenBankingDefinition def;
    String tempVal;

    @Given("user gets all products of open banking")
    public void getProducts(){
        prod= def.getProducts();
        assertThat("Validate the call is succesfull",prod.getStatusCode(),equalTo(200));
     }

    @And("user gets all products of open banking with filter")
    public void getProductsFiltered(){
        filtered= def.getProducts(paramToPass);
        assertThat("Validate the call is succesfull",filtered.getStatusCode(),equalTo(200));
    }

    @Given("user gets the list of outages")
    public void getOutages(){
       def.getOutages();
    }
    @When("user gets particular product detail for a product")
    public void getProductdetails(){
         String getid;
         getid= prod.getBody().jsonPath().get("data.products.find{it.productId}.productId");
         proDetails=def.getProductDetail(getid);
    }
    @Then("user verifies the response is {}")
    public void verifyResponse(int status){
      assertThat("Validate last response",
              SerenityRest.lastResponse().getStatusCode(),is(status));
    }

    @And("user validates the end point retrieves only filtered data")
    public void validateFilteredData(){
        List<String> category= filtered.body().jsonPath()
                .get("data.products.findAll{it.productId}.productCategory");
       assertThat("Validate received data are filtered",category
                            ,everyItem(equalTo(tempVal)));

    }
    @And("user  sets filter {} to {}")
    public void setfilter(String param, String paramVal){
        tempVal=paramVal;
        paramToPass.put(param,tempVal);

    }
    @And("user sets invalid product id")
    public void setInvalidId(){
        proDetails=def.getProductDetail("2a3e2af9-c06b-410d-a62e-118698949");
    }

    @And("user should see error code {}")
    public void errorCodeValidation(String code){

        assertThat("Validate the call is succesfull",proDetails.getBody().jsonPath()
                                            .get("errors.code").toString(), Is.is(code));

    }

    @And("error title should be {}")
    public void errorTitleValidation(String title){
        assertThat("Validate the call is succesfull",proDetails.getBody().jsonPath()
                .get("errors.title").toString(),Is.is(title));

    }

    @And("error detail should be {}")
    public void errorDetailValidation(String detail){
        assertThat("Validate the call is succesfull",proDetails.getBody().jsonPath()
                .get("errors.detail").toString(),Is.is(detail.trim()));

    }

}
