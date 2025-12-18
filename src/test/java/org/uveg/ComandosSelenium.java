package org.uveg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComandosSelenium {

    private final WebDriver driver;

    public ComandosSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement encontrarElemento(By locator) {
        return driver.findElement(locator);
    }

    public void escribir(By locator, String texto) {
        WebElement elemento = encontrarElemento(locator);
        elemento.clear();
        elemento.sendKeys(texto);
    }

    public void click(By locator) {
        encontrarElemento(locator).click();
    }

    public boolean existeElemento(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public String obtenerTexto(By locator) {
        return encontrarElemento(locator).getText();
    }
}
