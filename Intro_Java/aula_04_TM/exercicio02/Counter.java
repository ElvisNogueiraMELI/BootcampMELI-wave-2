package aula_04_TM.exercicio02;

public class Counter {
	private int valor;

	public Counter(int valor) {
		super();
		this.valor = valor;
	}

	public Counter() {
		super();
	}
	
	public Counter(Counter c) {
		this.valor=c.valor;
	}

	
	public void aumentar() {
		this.valor++;
	}
	
	public void diminuir() {
		this.valor--;
	}
	
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

}
