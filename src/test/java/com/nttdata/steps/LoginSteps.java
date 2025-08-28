package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.util.List;

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



    public void go_categoria_subcategoria(String categoria, String subcategoria){

        Assertions.assertEquals("Clothes",categoria );
        Assertions.assertEquals("Men", subcategoria);
        this.driver.findElement(MyStorePage.categoryButton).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.subcategoryButton));
        this.driver.findElement(MyStorePage.subcategoryButton).click();

    }

    public void click_product(){
        this.driver.findElement(MyStorePage.fisrtproduct).click();
    }

    public void llenar_numero_items(){
        this.driver.findElement(MyStorePage.numberInput).sendKeys(Keys.END, Keys.BACK_SPACE, "2");
    }

    public void añadir_carrito(){
        this.driver.findElement(MyStorePage.addtocart).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.purchaseconfirmation));
    }

    public String get_confirmacion_producto(){
        return this.driver.findElement(MyStorePage.purchaseconfirmation).getText();

    }

    public String get_monto() {
        return this.driver.findElement(MyStorePage.monto).getText();
    }

    public void finalizarcompra() {
        this.driver.findElement(MyStorePage.endpurchase).click();
    }

    public String get_pagina_carrito_titulo() {
        return this.driver.findElement(MyStorePage.cart_title).getText();
    }

    public String get_monto_final() {
        return this.driver.findElement(MyStorePage.monto_final).getText();
    }
}
