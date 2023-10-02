import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatizarRegistroOpencart {
    public static void main(String[] args) {
        // Configura la ubicación del controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "ruta/al/controlador/chromedriver");

        // Inicializa el navegador Chrome
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://opencart.abstracta.us/");

            //Given que abro la página de Opencart

            //When hago clic en el enlace "My Account"
            WebElement myAccountButton = driver.findElement(By.className("dropdown-toggle"));
            myAccountButton.click();

            //And hago clic en el enlace "Register"
            WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
            registerLink.click();

            //And completo el formulario de registro con los siguientes datos:
            WebElement firstNameField = driver.findElement(By.id("input-firstname"));
            firstNameField.sendKeys("TuNombre");

            WebElement lastNameField = driver.findElement(By.id("input-lastname"));
            lastNameField.sendKeys("TuApellido");

            WebElement emailField = driver.findElement(By.id("input-email"));
            emailField.sendKeys("tucorreo@example.com");

            WebElement telephoneField = driver.findElement(By.id("input-telephone"));
            telephoneField.sendKeys("1234567890");

            WebElement passwordField = driver.findElement(By.id("input-password"));
            passwordField.sendKeys("TuContraseña");

            WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
            confirmPasswordField.sendKeys("TuContraseña");

            //And acepto los términos y condiciones de privacidad
            WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));
            privacyPolicyCheckbox.click();

            //And hago clic en el botón "Continue"
            WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit'][value='Continue']"));
            continueButton.click();

            //Then veo el mensaje de confirmación "Your Account Has Been Created!" en la pantalla
            WebElement confirmationMessage = driver.findElement(By.xpath("//div[@id='content']/h1"));
            String messageText = confirmationMessage.getText();

            // Verifica si el mensaje de confirmación es el esperado
            if (messageText.contains("Your Account Has Been Created!")) {
                System.out.println("La creación de la cuenta fue exitosa.");
            } else {
                System.out.println("La creación de la cuenta no fue exitosa.");
            }
        } finally {
            // Cierra el navegador
            driver.quit();
        }
    }
}
