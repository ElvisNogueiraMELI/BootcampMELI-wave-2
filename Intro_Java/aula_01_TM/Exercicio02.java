package aula_01_TM;

public class Exercicio02 {
	public static void main(String[] args) {
		double empresaXValor = 1.13;
		double empresaYValor = 18.4;
		int ano=2021;
		
		System.out.println("Empresa X - 01/01/"+ano+" - Valor da empresa: "+String.format("%.2f", empresaXValor)+"m");
		System.out.println("Empresa Y - 01/01/"+ano+" - Valor da empresa: "+String.format("%.2f", empresaYValor)+"m\n");
			
		while (empresaXValor<empresaYValor) {
			ano++;
			empresaXValor += (empresaXValor*1.48);
			empresaYValor += (empresaYValor*0.32);
			System.out.println("Empresa X - 01/01/"+ano+" - Valor da empresa: "+String.format("%.2f", empresaXValor)+"m");
			System.out.println("Empresa Y - 01/01/"+ano+" - Valor da empresa: "+String.format("%.2f", empresaYValor)+"m\n");
		}
	}
}
