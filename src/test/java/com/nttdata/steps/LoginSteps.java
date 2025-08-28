package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */

    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(MyStorePage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.loginButton));

    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(MyStorePage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón iniciar sesion
     */
    public void iniciar_sesion(){
        this.driver.findElement(MyStorePage.iniciarsesionButton).click();
    }

    public void submit(){
        this.driver.findElement(MyStorePage.loginButton).click();
    }

}
