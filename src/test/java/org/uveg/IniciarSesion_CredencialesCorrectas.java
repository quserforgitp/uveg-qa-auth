package org.uveg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class IniciarSesion_CredencialesCorrectas extends Ambiente {

    private WebDriver driver;
    private ComandosSelenium wrapper;

    @Parameters("navegador")
    @BeforeTest
    public void setUp(final String navegador) {
        driver = iniciarNavegador(navegador);
        wrapper = new ComandosSelenium(driver);
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @Test(testName = "debería inciar sesión y mostrar opción de Log out")
    public void iniciarSesionCorrecto() {
        // ===== Arrange =====
        // Credenciales
        final String validUsername = "this-a-testmail@mail.com";
        final String validPassword = "Pp*7C5Ohcr8JcnQM";
        // Localizadores de Elementos de la página
        By campoUsername = By.id("username");
        By campoPassword = By.id("password");
        By botonLogin = By.name("login");
        By linkCerrarSesion = By.linkText("Sign out");

        // ===== Act =====
        wrapper.escribir(campoUsername, validUsername);
        wrapper.escribir(campoPassword, validPassword);
        wrapper.click(botonLogin);

        // ===== Assert =====
        boolean existeLogout = wrapper.existeElemento(linkCerrarSesion);
        Assert.assertTrue(existeLogout, "No se pudo iniciar sesión con credenciales válidas");
    }

    @AfterTest
    public void tearDown() {
        cerrarNavegador();
    }
}

