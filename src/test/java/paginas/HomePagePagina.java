package paginas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseSelenium;
import elementos.HomePageElemento;

public class HomePagePagina extends BaseSelenium {

	private HomePageElemento campoHome = new HomePageElemento();

	public void clicarSignIn() {
		if (existe(campoHome.getBtnSignIn())) {
			clicar(campoHome.getBtnSignIn());			
		}else {

		}
	}

	public void acessaMenu(String menu, String subMenu) {
		WebElement wMenu = procurar(campoHome.getMenu());
		List<WebElement> lMenu = wMenu.findElements(By.xpath("./li"));
		for (WebElement itensMenu : lMenu) {
			String item = itensMenu.findElement(By.tagName("a")).getText();
			System.out.println("O item do menu: " + item);
			if (menu.equalsIgnoreCase(item)) {
				moverParaElemento(itensMenu);
				WebElement wMenuNivel = itensMenu.findElement(By.xpath(".//ul[contains(@class,'submenu-container')]"));
				List<WebElement> itemSubMenu = wMenuNivel.findElements(By.xpath("./li"));
				for (WebElement subMenus : itemSubMenu) {
					String wSubMenu = subMenus.findElement(By.tagName("a")).getText();
					System.out.println("O item do subMennu:  " + wSubMenu);
					if (subMenu.equalsIgnoreCase(wSubMenu)) {
						clicar(subMenus);
						break;
					}
				}
				break;
			}
		}
	}
}
