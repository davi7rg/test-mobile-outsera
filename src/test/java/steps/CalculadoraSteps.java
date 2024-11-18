package steps;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import pages.CalculadoraPage;
import utils.DriverFactory;

public class CalculadoraSteps {

    private AppiumDriver driver = DriverFactory.getDriver();
    private CalculadoraPage calculatorPage = new CalculadoraPage(driver);

    @Dado("eu abro o aplicativo")
    public void iOpenTheCalculatorApp() {
        ExtentReportManager.setTest("Calculator Operations");
        ExtentReportManager.log("Opening Calculator App");
        ExtentReportManager.logScreenshot(driver, "Calculator App Opened");
        // App is launched automatically through DriverFactory
    }

    @Quando("escolho a {string} depois informo os {string} e {string}")
    public void iPerformOperation(String operacao, String num1, String num2) {
        calculatorPage.enterNumber(num1);
        ExtentReportManager.logScreenshot(driver, "Numero 1: " + num1);
        switch (operacao.toLowerCase()) {
            case "adicao":
                calculatorPage.pressAdd();
                ExtentReportManager.logScreenshot(driver, "Adição selecionado");
                break;
            case "subtracao":
                calculatorPage.pressSubtract();
                ExtentReportManager.logScreenshot(driver, "Subtracao selecionado");
                break;
            case "multiplicacao":
                calculatorPage.pressMultiply();
                ExtentReportManager.logScreenshot(driver, "Multiplicação selecionado");
                break;
            case "divisao":
                calculatorPage.pressDivide();
                ExtentReportManager.logScreenshot(driver, "Divisão selecionado");
                break;
        }
        calculatorPage.enterNumber(num2);
        ExtentReportManager.logScreenshot(driver, "Numero 2: " + num2);
        calculatorPage.pressEquals();
    }

    @Entao("o resultado esperado é mostrado corretamente {string}")
    public void theResultShouldBe(String expectedResult) {
        ExtentReportManager.log("Resultado esperado = " + expectedResult + ", Atual = " + actualResult);
        ExtentReportManager.logScreenshot(driver, "Resultado do teste");
        Assert.assertEquals(expectedResult, calculatorPage.getResult());
    }
}
