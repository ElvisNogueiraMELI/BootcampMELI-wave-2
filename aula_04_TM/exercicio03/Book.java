package aula_04_TM.exercicio03;


public class Book {
	private String titulo, isbn, autor;
	private boolean statusEmprestimo;
	
	
	public Book() {
		
	}

	public Book(String titulo, String isbn, String autor, boolean statusEmprestimo) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.statusEmprestimo = statusEmprestimo;
	}
	
	public void emprestar() {
		if(statusEmprestimo) {
			System.out.println("Livro já está emprestado");
		}else {
			statusEmprestimo = true;
		}
	}
	
	public void devolver() {
		if(statusEmprestimo) {
			statusEmprestimo = false;			
		}else {
			System.out.println("Livro não está emprestado");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
	public boolean isStatusEmprestimo() {
		return statusEmprestimo;
	}

	public void setStatusEmprestimo(boolean statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}

	//Ao mudar o nome do metodo toString a IDE aponta que o Override deve ser removido e aponta o erro
	
	@Override
	public String toString() {		
		return titulo+", "+autor+", ISBN: "+isbn+". "+ (statusEmprestimo?"Emprestado":"Disponível");
	}
	
}
