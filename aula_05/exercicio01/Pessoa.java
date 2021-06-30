package aula_05.exercicio01;

public class Pessoa implements Precedente<Pessoa>{
	private String nome, cpf;

	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	@Override
	public int precedeA(Pessoa p) {
		return this.cpf.compareTo(p.getCpf());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome+":"+this.cpf;
	}

}
