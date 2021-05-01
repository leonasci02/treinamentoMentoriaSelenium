package core;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSelenium {

	private static String chromeAgent = "webdriver.chrome.driver";
	private static String caminhoDriver = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "navegador" + File.separator + "chromedriver";
	private static WebDriver driver;
	Wait<WebDriver> wait;

	public void clicar(By elemento) {
		procurar(elemento).click();
	}
	
	public void clicar(WebElement elemento) {
		elemento.click();
	}

	public void inicializador() {
		if (driver == null) {
			iniciaChrome();
		}
	}

	public void fecharChrome() {
		driver.quit();
	}

	public WebElement fluentWait(By elemento) {
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		
		return wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return procurar(elemento);
			}
		});
	}

	public WebElement aguardaElementoDinamico(By elemento) {
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
	}

	public Boolean aguardaElementoDinamicoPorTexto(By elemento, String texto) {
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);

		return wait.until(ExpectedConditions.textToBePresentInElementLocated(elemento, texto));
	}
	
	public void moverParaElemento(WebElement elemento) {
		Actions act = new Actions(driver);
		act.moveToElement(elemento).build().perform();
	}
	
	public void moverParaElemento(By elemento) {
		Actions act = new Actions(driver);
		act.moveToElement(procurar(elemento)).build().perform();
	}

	public WebElement esperarSerVisivel(By elemento) {
		return new WebDriverWait(driver, Duration.ofMinutes(10))
				.until(ExpectedConditions.presenceOfElementLocated(elemento));
	}

	public WebElement esperarElementoExistir(By elemento) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(procurar(elemento)));
	}
	
	public Boolean esperarElementoSelect(By elemento) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeSelected(procurar(elemento)));
	}

	public WebElement esperarElementoSerClicavel(By elemento) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(procurar(elemento)));
	}
	
	public Boolean esperarSelect(By elemento) {
		return new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeSelected(procurar(elemento)));
	}
	
	public static void iniciaChrome() {
		System.setProperty(chromeAgent, caminhoDriver);
		driver = new ChromeDriver();
	}

	public void escreverNoCampo(By elemento, String textoParaSerDigitado) {
		procurar(elemento).sendKeys(textoParaSerDigitado);
	}

	public String extrairTextoDoElemento(By elemento) {
		return procurar(elemento).getText();
	}

	public String extrairAtributo(By elemento, String atributo) {
		return procurar(elemento).getAttribute(atributo);
	}
	
	public void comboBoxPorTexto(By elemento, String itemDoCombo) {
		comboBox(elemento).selectByVisibleText(itemDoCombo);
	}

	public void comboBoxPorValor(By elemento, String valorDaOpcao) {
		comboBox(elemento).selectByValue(valorDaOpcao);
	}

	public void comboBoxPorIndex(By elemento, int indexDoCombo) {
		comboBox(elemento).selectByIndex(indexDoCombo);
	}
	
	public Boolean existe(By elemento) {
		try {
			return !driver.findElements(elemento).isEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	public void urlDoSite(String urlDoSite) {
		navegador().to(urlDoSite);
	}

	public void botaoVoltarDoNavegador() {
		navegador().back();
	}

	public WebElement procurar(By elemento) {
		return driver.findElement(elemento);
	}

	private Select comboBox(By elemento) {
		return new Select(procurar(elemento));
	}

	private Navigation navegador() {
		return driver.navigate();
	}
}
