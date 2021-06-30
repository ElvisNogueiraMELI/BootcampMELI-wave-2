package aula_01_TM;

import java.util.Scanner;

public class Exercicio03 {
	
	static Produto p1 = new Produto("Arroz", 10.99); 
	static Produto p2 = new Produto("Feijão", 14.49); 
	static Produto p3 = new Produto("Tomate", 9.99); 
	
	static Produto[] produtos = {p1,p2,p3};
	
	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		Produto[] vendaProduto = new Produto[3];
		int[] qnt = new int[3];
		double total=0.0;
		String busca;
		
		
		for(int i=0;i<3;i++) {
			System.out.println("Digite o nome do produto "+(i+1)+": ");
			busca = entrada.next();
			vendaProduto[i] = Exercicio03.buscar(busca);
			System.out.println("Digite a quantidade: ");
			qnt[i] = entrada.nextInt();
			
		}
		
		
		for(int j=0;j<3;j++) {
			System.out.println("Produto "+(j+1));
			System.out.println(vendaProduto[j].getNome());
			System.out.println("R$"+vendaProduto[j].getPreço());
			System.out.println("Quantidade: "+qnt[j]+"\n");
			total+= (qnt[j]*vendaProduto[j].getPreço());
		}
		
		System.out.println("Valor total:  R$"+total);
	
		
	}
	
	public static Produto buscar(String nome) {
		for(int i=0; i<3;i++) {
			if((produtos[i].getNome()).equalsIgnoreCase(nome)) { 
				return produtos[i];
				
			}
		}
		return null;
	}
}
