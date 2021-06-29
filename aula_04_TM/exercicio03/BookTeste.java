package aula_04_TM.exercicio03;

public class BookTeste {
	public static void main(String[] args) {
		Book book = new Book("O Hobbit", "9956445", "J. R. R. Tolkien", false);
		
		System.out.println(book);
		book.emprestar();
		System.out.println(book);
		book.emprestar();
		System.out.println(book);
		book.devolver();
		System.out.println(book);
	}
}
