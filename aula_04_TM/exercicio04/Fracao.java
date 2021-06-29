package aula_04_TM.exercicio04;

public class Fracao {
	
	public static void somar(String a, int b) {
		double doubleA =stringFracaoToDouble(a);
		System.out.println(doubleA+b);
	}
	
	public static void somar(String a, String b) {
		double doubleA =stringFracaoToDouble(a);
		double doubleB =stringFracaoToDouble(b);
		System.out.println(doubleA+doubleB);
	}
	
	public static void somar(int a, String b) {
		double doubleB =stringFracaoToDouble(b);
		System.out.println(a+doubleB);
	}
	
	public static void subtrair(String a, int b) {
		double doubleA =stringFracaoToDouble(a);
		System.out.println(doubleA-b);
	}
	
	public static void subtrair(String a, String b) {
		double doubleA =stringFracaoToDouble(a);
		double doubleB =stringFracaoToDouble(b);
		System.out.println(doubleA-doubleB);
	}
	
	public static void subtrair(int a, String b) {
		double doubleB =stringFracaoToDouble(b);
		System.out.println(a-doubleB);
	}
	
	public static void dividir(String a, int b) {
		double doubleA =stringFracaoToDouble(a);
		System.out.println(doubleA/b);
	}
	
	public static void dividir(String a, String b) {
		double doubleA =stringFracaoToDouble(a);
		double doubleB =stringFracaoToDouble(b);
		System.out.println(doubleA/doubleB);
	}
	
	public static void dividir(int a, String b) {
		double doubleB =stringFracaoToDouble(b);
		System.out.println(a/doubleB);
	}
	
	public static void multiplicar(String a, int b) {
		double doubleA =stringFracaoToDouble(a);
		System.out.println(doubleA*b);
	}
	
	public static void multiplicar(String a, String b) {
		double doubleA =stringFracaoToDouble(a);
		double doubleB =stringFracaoToDouble(b);
		System.out.println(doubleA*doubleB);
	}
	
	public static void multiplicar(int a, String b) {
		double doubleB =stringFracaoToDouble(b);
		System.out.println(a*doubleB);
	}
	
	public static double stringFracaoToDouble(String fracao) {
		String[] elemetos = fracao.split("/");
		Double[] elementosDouble = new Double[2];
		for(int i=0;i<2;i++) {
			elementosDouble[i]=Double.parseDouble(elemetos[i]);
		}		
		return elementosDouble[0]/elementosDouble[1];
	}
	
}
