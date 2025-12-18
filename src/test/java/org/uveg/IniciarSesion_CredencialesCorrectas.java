package org.uveg;

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

public class IniciarSesion_CredencialesCorrectas extends Ambiente {

    private ComandosSelenium wrapper;

    @Parameters("navegador")
    @BeforeTest
    public void setUp(final String navegador) {
        WebDriver driver = iniciarNavegador(navegador);
        wrapper = new ComandosSelenium(driver);
        PasosEstandar pasos = new PasosEstandar(driver);
        pasos.navegarPaginaPrueba();
    }

    @Test(testName = "debería inciar sesión y mostrar opción de Log out")
    public void iniciarSesionCorrecto() {
        // ===== Arrange =====
        // Credenciales
        final String validUsername = "this-a-testmail@mail.com";
        final String validPassword = "Pp*7C5Ohcr8JcnQM";

        // ===== Act =====
        wrapper.escribir(LoginLocators.CAMPO_USERNAME, validUsername);
        wrapper.escribir(LoginLocators.CAMPO_PASSWORD, validPassword);
        wrapper.click(LoginLocators.BOTON_LOGIN);

        // ===== Assert =====
        boolean existeLogout = wrapper.existeElemento(LoginLocators.LINK_LOGOUT);
        Assert.assertTrue(existeLogout, "No se pudo iniciar sesión con credenciales válidas");
    }

    @AfterTest
    public void tearDown() {
        cerrarNavegador();
    }
}

