package testes;

import paginas.AutenticacaoPagina;
import paginas.HomePagePagina;

class HomePageTeste{

	private HomePagePagina home = new HomePagePagina();
	private AutenticacaoPagina aut = new AutenticacaoPagina();
	

	void iniciaCargaDeTeste() {
		home.inicializador();
		home.urlDoSite("http://automationpractice.com/index.php");
	}

	void criarUmaConta() {
		home.clicarSignIn();
		aut.preencherAutenticacao();
	}

	void finalizarTestes() {
		//home.fecharChrome();
	}
}
