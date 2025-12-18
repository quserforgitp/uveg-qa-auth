package org.uveg;

import org.openqa.selenium.WebDriver;
import org.uveg.LoginLocators;
import org.uveg.ComandosSelenium;

/*
    PasosEstandar
    -------------
    Define flujos comunes del sistema
*/
public class PasosEstandar {
    private final WebDriver driver;
    public PasosEstandar(WebDriver driver) {
        this.driver = driver;
    }

    public void navegarPaginaPrueba() {
        String PAGINA_PRUEBAS = "https://practice.automationtesting.in/my-account/";
        driver.get(PAGINA_PRUEBAS);
    }
}
