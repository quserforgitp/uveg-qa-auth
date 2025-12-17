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

public class IniciarSesion_CorreoIncorrecto {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @Test(testName = "debería mostrar mensaje de error")
    public void iniciarSesionCorreoIncorrecto() {
        // ===== Arrange =====
        // Credenciales
        final String invalidUsername = "this-92ddmail@mail.com";
        final String validPassword = "Pp*7C5Ohcr8JcnQM";

        final String textoEsperado = "Error: A user could not be found with this email address.";
        // Elementos de la página
        WebElement campoUsername = driver.findElement(By.id("username"));
        WebElement campoPassword = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.name("login"));

        // ===== Act =====
        campoUsername.sendKeys(invalidUsername);
        campoPassword.sendKeys(validPassword);
        botonLogin.click();

        // ===== Assert =====
        // Se muestra el mensaje de error
        boolean existeMensajeError = !driver.findElements(By.cssSelector(".woocommerce-error li")).isEmpty();
        Assert.assertTrue(existeMensajeError, "No apareció el mensaje de error al introducir un correo inválido");

        // El mensaje de error tiene el texto esperado
        WebElement mensajeError = driver.findElement(By.cssSelector(".woocommerce-error li"));
        final String textoReal = mensajeError.getText();
        Assert.assertEquals(textoReal, textoEsperado, "El mensaje de error no tenía el texto esperado");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

