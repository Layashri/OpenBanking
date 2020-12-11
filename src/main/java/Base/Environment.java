package Base;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Environment {


    public static EnvironmentVariables getEnvVariables(){
        return SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public static EnvironmentSpecificConfiguration getEnvConfig(){

        return EnvironmentSpecificConfiguration.from(SystemEnvironmentVariables.createEnvironmentVariables());
    }
}
