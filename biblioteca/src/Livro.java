public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;
    private StatusLivro status;

    public Livro(String titulo, String autor, String isbn, String genero, StatusLivro status){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.status = StatusLivro.DISPONIVEL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    @Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", genero=" + genero + ", status="
				+ status + "]";
	}
}