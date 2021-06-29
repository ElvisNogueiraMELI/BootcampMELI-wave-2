package aula_04_TM.exercicio02;

public class CounterTeste {
	public static void main(String[] args) {
		Counter c = new Counter();
		System.out.println(c.getValor());
		c.aumentar();
		System.out.println(c.getValor());
		c.diminuir();
		System.out.println(c.getValor());
		c.aumentar();
		c.aumentar();
		c.aumentar();
		c.aumentar();
		System.out.println(c.getValor());
		
	}
}
