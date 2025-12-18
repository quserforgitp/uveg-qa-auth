package org.uveg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ambiente {

    private WebDriver driver;

    public WebDriver iniciarNavegador(String navegador) {
        switch (navegador.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Navegador no soportado: " + navegador);
        }

        driver.manage().window().maximize();

        return driver;
    }

    /**
     * Cierra navegador de forma segura
     */
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null; // limpiar la referencia
        }
    }
}