package aula_05.exercicio01;

public class Celular implements Precedente<Celular> {
	private String numero, holder;
	
	
	
	
	public Celular() {
		super();
	}




	public Celular(String numero, String holder) {
		super();
		this.numero = numero;
		this.holder = holder;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public String getHolder() {
		return holder;
	}




	public void setHolder(String holder) {
		this.holder = holder;
	}




	@Override
	public int precedeA(Celular t) {
		// TODO Auto-generated method stub
		return this.holder.compareTo(t.holder);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.holder+":"+this.numero;	}
	
	
}
