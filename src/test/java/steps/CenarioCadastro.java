package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import massaDeDados.Massa;
import paginas.AutenticacaoPagina;
import paginas.CreateAccountPagina;
import paginas.HomePagePagina;

public class CenarioCadastro {

	private HomePagePagina home = new HomePagePagina();
	private AutenticacaoPagina aut = new AutenticacaoPagina();
	private CreateAccountPagina conta = new CreateAccountPagina();

	@Before
	public void iniciaCargaDeTeste() {
		home.inicializador();
	}

	@Dado("que acesse o e-commerce")
	public void acessarEcommerce() {
		home.urlDoSite("http://automationpractice.com/index.php");
	}

	@Dado("opto por selecionar SignIn")
	public void selecionarSignIn() {
		home.clicarSignIn();
	}

	@Dado("preencher um novo email")
	public void preencherEmail() {
		aut.informarEmail(Massa.email());
	}

	@Quando("selecionar create an account")
	public void criarUmaNovaConta() {
		aut.createAccount();
	}

	@Quando("opto por preencher os campos de cadastro")
	public void preencherUmaNovaConta() {
		conta.criarConta();
	}

	@Então("o sistema deve realizar o cadastro com sucesso")
	public void validarCadastro() {

	}

	@Dado("opto por selecionar o menu {string} -> {string}")
	public void menu(String menu, String subMenu) {
		home.acessaMenu(menu, subMenu);
	}

	@Quando("apresentar a tela do menu")
	public void apresentarATelaDoMenu() {

	}

	@Então("o sistema mostrará os itens")
	public void oSistemaMostraráOsItens() {

	}

	/**
	 * 
	 */

	@Quando("preencher o email e senha")
	public void preencherEmailSenha() {

	}


	@Quando("opto por selecionar a opção {string}")
	public void optoPorSelecionarAOpção(String string) {

	}

	@Então("o sistema apresenta as informações de endereço cadastrado")
	public void oSistemaApresentaAsInformaçõesDeEndereçoCadastrado() {

	}

	@After
	void finalizarTestes() {
		home.fecharChrome();
	}
}
