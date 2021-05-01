package paginas;

import core.BaseSelenium;
import elementos.AutenticacaoElemento;

public class AutenticacaoPagina  extends BaseSelenium{
	
	private AutenticacaoElemento campoAut = new AutenticacaoElemento();
	
	public void preencherAutenticacao() {
		
		clicar(campoAut.getBtnCreate());
	}

	public void informarEmail(String email) {
		esperarSerVisivel(campoAut.getTxtEmail());
		escreverNoCampo(campoAut.getTxtEmail(), email);
	}
	
	public void createAccount() {
		esperarElementoSerClicavel(campoAut.getBtnCreate());
		clicar(campoAut.getBtnCreate());
	}
	
}
