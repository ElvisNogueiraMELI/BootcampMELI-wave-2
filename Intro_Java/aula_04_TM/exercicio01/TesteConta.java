package aula_04_TM.exercicio01;

import java.math.BigDecimal;

public class TesteConta {
	public static void main(String[] args) {
		ContaCorrente c = new ContaCorrente(new BigDecimal(5000), 12345, 123, "Elvis");
		ContaCorrente c2 = new ContaCorrente(new BigDecimal(0), 12346, 123, "Lana");
		System.out.println(c);
		c.saque(new BigDecimal(600));
		System.out.println(c);
		c.deposito(new BigDecimal(100));
		System.out.println(c);
		c.transferir(new BigDecimal(500), c2);
		System.out.println(c);
		System.out.println(c2);
		c2.devolucao(new BigDecimal(500), c);
		System.out.println(c);
		System.out.println(c2);
	}
}
