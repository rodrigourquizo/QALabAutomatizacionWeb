package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepsDef {
    private WebDriver driver;

    @Dado("estoy en la página de la tienda")
    public void que_me_encuentro_en_la_página_de_login_de_mystore() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @Cuando("me logueo con mi usuario: {string} y clave: {string}")
    public void inicio_sesion_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.iniciar_sesion();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.submit();
        //coloco este assertion para validar que nos logueamos correctamente y no estamos en la pagina de login
        //ya que la pagina te permite interactuar sin necesidad de loguearte
        Assertions.assertFalse(driver.getCurrentUrl().contains("https://qalab.bensg.com/store/pe/iniciar-sesion"));
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.go_categoria_subcategoria(arg0,arg1);

    }

    @Y("agrego 2 unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito() {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.click_product();
        loginsteps.llenar_numero_items();
        loginsteps.añadir_carrito();

    }

    @Entonces("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        LoginSteps loginsteps = new LoginSteps(driver);
        String text = loginsteps.get_confirmacion_producto();
        Assertions.assertEquals("\uE876Producto añadido correctamente a su carrito de compra", text);

    }

    @Y("valido en el popup que el monto sea calculado correctamente")
    public void validoEnElPopupQueElMontoSeaCalculadoCorrectamente() {
        LoginSteps loginsteps = new LoginSteps(driver);
        String monto = loginsteps.get_monto();
        Assertions.assertEquals("S/ 38.24",monto);

    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        LoginSteps loginsteps = new LoginSteps(driver);
        loginsteps.finalizarcompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        LoginSteps loginsteps = new LoginSteps(driver);
        String text = loginsteps.get_pagina_carrito_titulo();
        Assertions.assertEquals("CARRITO", text);

    }

    @Y("vuelvo a validar el calculo de precios del carrito")
    public void vuelvoAValidarElCalculoDePreciosDelCarrito() {
        LoginSteps loginsteps = new LoginSteps(driver);
        String monto = loginsteps.get_monto_final();
        Assertions.assertEquals("S/ 38.24", monto);
    }
}
