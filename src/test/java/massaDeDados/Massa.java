package massaDeDados;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Massa {

	private static Faker massa = new Faker(new Locale("pt-BR"));
	
	private static final String nome = massa.name().firstName();
	private static final String sobreNome =  massa.name().lastName();
	private static final String password = massa.number().digits(9);
	private static int diaNascimento = massa.number().numberBetween(1, 31);
	private static int mesNascimento = massa.number().numberBetween(1, 12);
	private static int anoNascimento = massa.number().numberBetween(1901, 2010);
	private static String nomeRua = massa.address().streetName();
	private static String estado = "Arkansas";
	private static String cidade = massa.address().cityName();
	private static String zipCode = massa.address().zipCode().substring(0, 5);
	private static String pais = "United state";
	private static String celular = massa.phoneNumber().cellPhone();
	private static String nomeAssinatura = massa.funnyName().name();
	private static String email = massa.internet().emailAddress();
	
	public static String nome() {
		return nome;
	}
	public static String sobrenome() {
		return sobreNome;
	}
	public static String password() {
		return password;
	}
	public static int diaNascimento() {
		return diaNascimento;
	}
	public static int mesNascimento() {
		return mesNascimento;
	}
	public static int anoNascimento() {
		return anoNascimento;
	}
	public static String nomeRua() {
		return nomeRua;
	}
	public static String estado() {
		return estado;
	}
	public static String cidade() {
		return cidade;
	}
	public static String zipCode() {
		return zipCode;
	}
	public static String pais() {
		return pais;
	}
	public static String celular() {
		return celular;
	}
	public static String nomeAssinatura() {
		return nomeAssinatura;
	}
	public static String email() {
		return email;
	}

}
