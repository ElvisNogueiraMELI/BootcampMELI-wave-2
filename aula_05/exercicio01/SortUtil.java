package aula_05.exercicio01;

public class SortUtil {
	public static<T> Precedente<T>[] sort(Precedente arr[]){
		int n = arr.length;  
        Precedente temp;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1].precedeA(arr[j]) > 0){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
		return arr;
	}
}
