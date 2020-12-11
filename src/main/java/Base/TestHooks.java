package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class TestHooks {

    private EnvironmentVariables env;

    @Before
    public void intTest(){
        setTheStage(new OnlineCast());
    }

   public void closeTest(){
        System.out.println("Execution Completed");
   }


}
