package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {
    //boton del header para ir a la página de login
    public static final By iniciarsesionButton = By.cssSelector("a[href*='/iniciar-sesion'], #_desktop_user_info a");

    //campo usuario
    public static final By userInput = By.id("field-email");

    //campo contraseña
    public static final By passInput = By.id("field-password");

    //boton iniciar sesión
    public static final By loginButton = By.id("submit-login");

    //navegar a categoria y subcategoria
    public static final By categoryButton = By.cssSelector("a.dropdown-item[href*='/3-clothes'][data-depth='0']");

    public static final By subcategoryButton = By.cssSelector("#left-column .category-sub-menu a[href$='/4-men']");

    //añadir al carrito
    public static final By fisrtproduct = By.cssSelector("a[href='https://qalab.bensg.com/store/pe/men/1-1-hummingbird-printed-t-shirt.html#/1-tamano-s/8-color-blanco']");

    public static final By numberInput = By.id("quantity_wanted");

    public static final By addtocart = By.cssSelector("button[data-button-action='add-to-cart']");
    //confirmar compra
    public static final By purchaseconfirmation = By.id("myModalLabel");

    //validar monto
    public static By monto = By.cssSelector("span.value");

    //finalizar compra
    public static By endpurchase = By.cssSelector("a.btn.btn-primary[href*='/carrito?action=show']");
    public static By cart_title = By.cssSelector("h1.h1");

    public static By monto_final = By.cssSelector("span.product-price > strong");

}
