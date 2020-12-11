package Base;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.List;
import java.util.Map;

import static Base.Environment.getEnvConfig;
import static Base.Environment.getEnvVariables;
import static TestEndpoints.Endpts.*;
import static io.restassured.config.DecoderConfig.decoderConfig;

public class OpenBankingDefinition {

    public Response getProducts(){
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.config().decoderConfig(decoderConfig().useNoWrapForInflateDecoding(true));

        return SerenityRest.given()
                .baseUri(getEnvConfig().getProperty("base.url"))
                .header("x-v",5,"x-min-v",3)
                .get(Product.path());
    }


    public Response getProducts(Map<String,String> specs){
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.config().decoderConfig(decoderConfig().useNoWrapForInflateDecoding(true));

        return SerenityRest.given()
                .baseUri(getEnvConfig().getProperty("base.url"))
                .header("x-v",5,"x-min-v",3)
                .params(specs)
                .get(Product.path());
    }

    public Response getProductDetail(String id){
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.config().decoderConfig(decoderConfig().useNoWrapForInflateDecoding(true));

        return SerenityRest.given()
                .baseUri(getEnvConfig().getProperty("base.url"))
                .header("x-v","5","x-min-v","3")
                .pathParam("productID",id)
                .get(ProductDetails.path());
    }
    public Response getOutages(){
        SerenityRest.useRelaxedHTTPSValidation();
        SerenityRest.config().decoderConfig(decoderConfig().useNoWrapForInflateDecoding(true));

        return SerenityRest.given()
                .baseUri(getEnvConfig().getProperty("base.url"))
                .header("x-v","5","x-min-v","1")
                .get(Outages.path());
    }

}
