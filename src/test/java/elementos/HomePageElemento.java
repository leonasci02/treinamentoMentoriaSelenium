package elementos;

import org.openqa.selenium.By;

public class HomePageElemento {

	private By btnSignIn = By.cssSelector("a.login");
	private By menu = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']");

	public By getBtnSignIn() {
		return btnSignIn;
	}
	
	public By getMenu() {
		return menu;
	}
	
}
