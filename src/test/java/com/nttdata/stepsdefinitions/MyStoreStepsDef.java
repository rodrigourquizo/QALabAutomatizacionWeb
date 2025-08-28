package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepsDef {
    private WebDriver driver;

    @Dado("que me encuentro en la página de login de mystore")
    public void que_me_encuentro_en_la_página_de_login_de_mystore() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @Cuando("inicio sesion con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesion_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.iniciar_sesion();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.submit();
        screenShot();
    }


}
