package java.org.example.pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CreateAccountSteps {
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;

    @Given("El usuario se encuentra en la pagina de inicio")
    public void el_usuario_se_encuentra_en_la_pagina_de_inicio() {
        homePage = new HomePage(driver);
        homePage.open();
    }

    @When("El usuario clickea en \"My Account\"")
    public void el_usuario_clickea_en_my_account() {
        homePage.clickMyAccount();
    }

    @And("El usuario clickea en \"Register\"")
    public void el_usuario_clickea_en_register() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickRegister();
    }

    @And("El usuario completa el formulario de registro con estos datos:")
    public void el_usuario_completa_el_formulario_de_registro_con_estos_datos(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> userData = data.get(0);
        registerPage = new RegisterPage(driver);
        registerPage.fillRegistrationForm(
                userData.get("Nombre"),
                userData.get("Apellido"),
                userData.get("Correo Electrónico"),
                userData.get("Teléfono"),
                userData.get("Contraseña"),
                userData.get("Confirmar Contraseña")
        );
    }

    @And("El usuario acepta Politica de Privacidad")
    public void el_usuario_acepta_politica_de_privacidad() {
        registerPage.agreePrivacyPolicy();
    }

    @And("El usuario presiona en \"Continuar\"")
    public void el_usuario_presiona_en_continuar() {
        registerPage.clickContinue();
    }

    @Then("Se muestra un mensaje de exito que contiene {string}")
    public void se_muestra_un_mensaje_de_exito_que_contiene(String expectedMessage) {
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String successMessage = accountCreatedPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains(expectedMessage));
    }

    @After
    public void tearDown() {
    }
}