package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {
    // 1) Botón del header para ir a la página de login
    public static final By iniciarsesionButton = By.cssSelector("a[href*='/iniciar-sesion'], #_desktop_user_info a");

    // 2) Campo usuario (email)
    public static final By userInput = By.id("field-email");

    // 3) Campo contraseña (password)
    public static final By passInput = By.id("field-password");

    // 4) Botón enviar / iniciar sesión
    public static final By loginButton = By.id("submit-login");

}
