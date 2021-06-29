package aula_01_TM;

import java.util.Arrays;

public class Exercicio01 {
	public static void main(String[] args) {
		Integer[] array = {52, 10, 85, 1324, 1, 13, 62, 30, 12, 127};
		int pos=0;

		
		Arrays.sort(array);
		
		System.out.print("Ordem crescente: ");
		for(int num:array) {
			System.out.print(num+ " ");
		}
		
		System.out.print("\nOrdem decrescente: ");
		for(int i=array.length-1;i>=0;i--) {
			System.out.print(array[i]+ " ");
		}
	}

}
