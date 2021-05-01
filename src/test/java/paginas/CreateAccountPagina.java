package paginas;

import static massaDeDados.Massa.anoNascimento;
import static massaDeDados.Massa.celular;
import static massaDeDados.Massa.cidade;
import static massaDeDados.Massa.diaNascimento;
import static massaDeDados.Massa.estado;
import static massaDeDados.Massa.mesNascimento;
import static massaDeDados.Massa.nome;
import static massaDeDados.Massa.nomeAssinatura;
import static massaDeDados.Massa.nomeRua;
import static massaDeDados.Massa.password;
import static massaDeDados.Massa.sobrenome;
import static massaDeDados.Massa.zipCode;

import org.junit.Assert;

import core.BaseSelenium;
import elementos.CreateAccountElemento;

public class CreateAccountPagina extends BaseSelenium{

	private CreateAccountElemento campo = new CreateAccountElemento();

	public void criarConta() {
		System.out.println("Preenchendo os campos de cadastro.");
		informacoesPessoal();
		informacoesEndereco();
		registrarCadastro();
	}
	
	private void informacoesPessoal() {
		escolherTitle();
		preencherNome(nome(), sobrenome());
		validarEmail();
		preencherPassword(password());
		preencherDataNascimento(diaNascimento(), mesNascimento(), anoNascimento());
	}
	
	private void informacoesEndereco() {
		System.out.println("Preenchendo o bloco de endereço.");
		preencherNomeEndereco(nome(), sobrenome());
		preencherLogradouro(nomeRua(), cidade(), estado(), zipCode());
		telefoneEassinatura(celular(), nomeAssinatura());
	}
	
	private void escolherTitle() {
		esperarSerVisivel(campo.getChkTitle());
		clicar(campo.getChkTitle());
	}
	
	private void preencherNome(String nome, String sobreNome) {
		escreverNoCampo(campo.getTxtFirstName(), nome);
		escreverNoCampo(campo.getTxtLastName(), sobreNome);
	}
	
	private void validarEmail() {
		String valor = extrairAtributo(campo.getTxtEmail(), "value");
		System.out.println("O texto que contém no campo é: " + valor );
		Assert.assertTrue(valor.length() > 1);
		Assert.assertNotNull(valor);
	}
	
	private void preencherPassword(String password) {
		escreverNoCampo(campo.getTxtPassword(), password);
	}
	
	private void preencherDataNascimento(int dia, int mes, int ano) {
		comboBoxPorValor(campo.getCbxDias(), String.valueOf(dia));
		comboBoxPorValor(campo.getCbxMes(), String.valueOf(mes));
		comboBoxPorValor(campo.getCbxAno(), String.valueOf(ano));
	}
	
	private void preencherNomeEndereco(String nome, String sobreNome) {
		escreverNoCampo(campo.getTxtFirstNameAddress(), nome);
		escreverNoCampo(campo.getTxtLastNameAddress(), sobreNome);
	}
	
	private void preencherLogradouro(String rua, String cidade, String estado, String postal) {
		escreverNoCampo(campo.getTxtAddress(), rua);
		escreverNoCampo(campo.getTxtCity(), cidade);
		comboBoxPorTexto(campo.getCbxState(), estado);
		escreverNoCampo(campo.getTxtPostalCode(), postal);
	}
	
	private void telefoneEassinatura(String telefone, String endFuturo) {
		escreverNoCampo(campo.getTxtMobilePhone(), telefone);
		escreverNoCampo(campo.getTxtAddressFuture(), endFuturo);
	}
	
	private void registrarCadastro() {
		esperarElementoSerClicavel(campo.getBtnRegister());
		clicar(campo.getBtnRegister());
	}
	
}
