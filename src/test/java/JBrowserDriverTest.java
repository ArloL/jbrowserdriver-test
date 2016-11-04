import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;

public class JBrowserDriverTest {

	public static String containingClass(String className) {
		return "contains(concat(' ', normalize-space(@class), ' '), ' " + className + " ')";
	}

	public static By byForTabBarItemContainingText(String text) {
		return xpath("//div[" + containingClass("gwt-TabBarItem") + "]//span[contains(text(), '" + text + "')]");
	}

	@Test
	public void testMerkur() throws Exception {
		WebElement element;
		JBrowserDriver driver = new JBrowserDriver(
				Settings.builder().logJavascript(true).logTrace(true).logWire(true).build());
		WebDriverWait wait = new WebDriverWait(driver, 30L);
		driver.get("http://www.herbrand-online.de/merkur/Merkur.html?locale=en");
		wait.until(visibilityOfElementLocated(byForTabBarItemContainingText("Home")));

		System.out.println("find about us tab");
		element = wait.until(visibilityOfElementLocated(byForTabBarItemContainingText("About us")));
		System.out.println("switch to about us");
		element.click();

		System.out.println("find homepage tab");
		element = wait.until(visibilityOfElementLocated(byForTabBarItemContainingText("Home")));
		System.out.println("switch to homepage");
		element.click();

		System.out.println("done");
	}

}
