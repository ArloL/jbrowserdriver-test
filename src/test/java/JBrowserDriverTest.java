import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;

public class JBrowserDriverTest {

	@Test
	public void testMerkur() throws Exception {
		WebElement element;
		boolean log = true;
		long timeout = 30L;
		JBrowserDriver driver = new JBrowserDriver(Settings.builder()
		    .logJavascript(log).logTrace(log).logWire(log).build());
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		driver
		    .get("http://www.herbrand-online.de/merkur/Merkur.html?locale=en");
		wait.until(visibilityOfElementLocated(xpath("//span[text()='Home']")));

		System.out.println("find about us tab");
		element = wait.until(
		    visibilityOfElementLocated(xpath("//span[text()='About us']")));
		System.out.println("switch to about us");
		element.click();

		System.out.println("find homepage tab");
		element = wait
		    .until(visibilityOfElementLocated(xpath("//span[text()='Home']")));
		System.out.println("switch to homepage");
		element.click();

		System.out.println("done");
	}

}
