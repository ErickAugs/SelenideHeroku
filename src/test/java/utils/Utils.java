package utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.screenshot;
import static hooks.GeneralHooks.scenario;

public class Utils {

    @Attachment("Evidencia")
    public static byte[] salvarEvidencia(){
        final byte[] screenshot =((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
        return screenshot(OutputType.BYTES);
    }
}
