package org.uveg.locators;

import org.openqa.selenium.By;

public class LoginLocators {

    public static final By CAMPO_USERNAME = By.id("username");
    public static final By CAMPO_PASSWORD = By.id("password");
    public static final By BOTON_LOGIN = By.name("login");

    public static final By LINK_LOGOUT = By.linkText("Sign out");
    public static final By MENSAJE_ERROR = By.cssSelector(".woocommerce-error li");
}
