package aula_05.exercicio01;

public class App {

	public static void main(String[] args) {
		Precedente[] pessoas = new Pessoa[5];
		pessoas[0] = new Pessoa("Elvis", "111.111.111-11");
		pessoas[1] = new Pessoa("Rhamys", "111.111.111-15");
		pessoas[2] = new Pessoa("Vitor", "111.111.111-10");
		pessoas[3] = new Pessoa("Ygor", "111.111.111-14");
		pessoas[4] = new Pessoa("Ulisses", "111.111.111-13");
		
		pessoas = SortUtil.sort(pessoas);
		
		for(Precedente p : pessoas) {
			System.out.println(p);
		}
		
		Precedente[] celulares = new Celular[5];
		celulares[0] = new Celular("99999998","Elvis");
		celulares[1] = new Celular("99999997","Rhamys");
		celulares[2] = new Celular("99999996","Vitor");
		celulares[3] = new Celular("99999995","Ygor");
		celulares[4] = new Celular("99999994","Ulisses");
		
		SortUtil.sort(celulares);
		
		for(Precedente c : celulares) {
			System.out.println(c);
		}
		
		
	}

}
