package org.uveg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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

public class IniciarSesion_CorreoIncorrecto extends Ambiente {

    private WebDriver driver;
    private ComandosSelenium wrapper;

    @Parameters("navegador")
    @BeforeTest
    public void setUp(final String navegador) {
        driver = iniciarNavegador(navegador);
        wrapper = new ComandosSelenium(driver);
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @Test(testName = "debería mostrar mensaje de error")
    public void iniciarSesionCorreoIncorrecto() {
        // ===== Arrange =====
        // Credenciales
        final String invalidUsername = "this-92ddmail@mail.com";
        final String validPassword = "Pp*7C5Ohcr8JcnQM";
        // Localizadores de Elementos de la página
        By campoUsername = By.id("username");
        By campoPassword = By.id("password");
        By botonLogin = By.name("login");
        By mensajeError = By.cssSelector(".woocommerce-error li");

        final String textoEsperado = "Error: A user could not be found with this email address.";

        // ===== Act =====
        wrapper.escribir(LoginLocators.CAMPO_USERNAME, invalidUsername);
        wrapper.escribir(LoginLocators.CAMPO_PASSWORD, validPassword);
        wrapper.click(LoginLocators.BOTON_LOGIN);

        // ===== Assert =====
        // Se muestra el mensaje de error
        boolean existeMensajeError = wrapper.existeElemento(LoginLocators.MENSAJE_ERROR);
        Assert.assertTrue(existeMensajeError, "No apareció el mensaje de error al introducir un correo inválido");

        // El mensaje de error tiene el texto esperado
        final String textoReal = wrapper.obtenerTexto(LoginLocators.MENSAJE_ERROR);
        Assert.assertEquals(textoReal, textoEsperado, "El mensaje de error no tenía el texto esperado");
    }

    @AfterTest
    public void tearDown() {
        cerrarNavegador();
    }
}

