package elementos;

import org.openqa.selenium.By;

public class AutenticacaoElemento {
	
	private By txtEmail = By.cssSelector("input#email_create");
	private By btnCreate = By.cssSelector("button#SubmitCreate");
	
	public By getTxtEmail() {
		return txtEmail;
	}
	public By getBtnCreate() {
		return btnCreate;
	}
	
}
