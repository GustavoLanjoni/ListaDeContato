package contatoJava;

public class Contato {
	
	private String nome;
	private String telefone;
	private String email;
	
	//Construtor
	public Contato(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	
	//Getters
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	
	//Método toString para exibir o contato de forma legivel 
	
	@Override
	public String toString() {
		return "Contato [nome =  " +  " " + nome + " " + " , telefone = " + " " 
	+ telefone + " " + ", email = " + " " + email + "]";
	}
	
	
	

}
