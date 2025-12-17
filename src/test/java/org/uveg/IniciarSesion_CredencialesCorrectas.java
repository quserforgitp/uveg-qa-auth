package org.uveg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
    Universidad: Universidad Virtual del Estado de Guanajuato
    Estudiante: Helios Barrera Hernández
    Matrícula: 24004923
    Asesora: Gabriela Garibay Mendoza
    Módulo: Calidad y pruebas de software v2
    Reto: Reto 5. Automatización de una pantalla login
    Fecha: 17/12/2025
*/

public class IniciarSesion_CredencialesCorrectas {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @Test(testName = "debería inciar sesión y mostrar opción de Log out")
    public void iniciarSesionCorrecto() {
        // ===== Arrange =====
        // Credenciales
        final String validUsername = "this-a-testmail@mail.com";
        final String validPassword = "Pp*7C5Ohcr8JcnQM";
        // Elementos de la página
        WebElement campoUsername = driver.findElement(By.id("username"));
        WebElement campoPassword = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.name("login"));

        // ===== Act =====
        campoUsername.sendKeys(validUsername);
        campoPassword.sendKeys(validPassword);
        botonLogin.click();

        // ===== Assert =====
        boolean existeLogout = !driver.findElements(By.linkText("Sign out")).isEmpty();
        Assert.assertTrue(existeLogout, "No se pudo iniciar sesión con credenciales válidas");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

