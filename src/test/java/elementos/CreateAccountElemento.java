package elementos;

import org.openqa.selenium.By;

public class CreateAccountElemento {

	private By chkTitle = By.cssSelector("input#id_gender2");
	private By txtFirstName = By.id("customer_firstname");
	private By txtLastName = By.id("customer_lastname");
	private By txtEmail = By.id("email");
	private By txtPassword = By.id("passwd");
	private By cbxDias = By.id("days");
	private By cbxMes = By.id("months");
	private By cbxAno = By.id("years");
	private By txtFirstNameAddress = By.id("firstname");
	private By txtLastNameAddress = By.id("lastname");
	private By txtAddress = By.id("address1");
	private By txtCity = By.id("city");
	private By cbxState = By.id("id_state");
	private By txtPostalCode = By.id("postcode");
	private By cbxCountry = By.id("id_country");
	private By txtMobilePhone = By.id("phone_mobile");
	private By txtAddressFuture = By.id("alias");
	private By btnRegister = By.id("submitAccount");
	
	public By getChkTitle() {
		return chkTitle;
	}
	public By getTxtFirstName() {
		return txtFirstName;
	}
	public By getTxtLastName() {
		return txtLastName;
	}
	public By getTxtEmail() {
		return txtEmail;
	}
	public By getTxtPassword() {
		return txtPassword;
	}
	public By getCbxDias() {
		return cbxDias;
	}
	public By getCbxMes() {
		return cbxMes;
	}
	public By getCbxAno() {
		return cbxAno;
	}
	public By getTxtFirstNameAddress() {
		return txtFirstNameAddress;
	}
	public By getTxtLastNameAddress() {
		return txtLastNameAddress;
	}
	public By getTxtAddress() {
		return txtAddress;
	}
	public By getTxtCity() {
		return txtCity;
	}
	public By getCbxState() {
		return cbxState;
	}
	public By getTxtPostalCode() {
		return txtPostalCode;
	}
	public By getCbxCountry() {
		return cbxCountry;
	}
	public By getTxtMobilePhone() {
		return txtMobilePhone;
	}
	public By getTxtAddressFuture() {
		return txtAddressFuture;
	}
	public By getBtnRegister() {
		return btnRegister;
	}
}
