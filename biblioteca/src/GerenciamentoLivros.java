import java.util.ArrayList;
import java.util.List;

public class GerenciamentoLivros {
    private List<Livro> livros;
    
    public GerenciamentoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponivel. ");
        } else {
            for (Livro livro: livros) {
                System.out.println(livro);
            }
        }
    }

    public Livro encontrarLivroPorIsbn(String isbn) {
        for (Livro livro: livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public void atualizarStatus(String isbn, StatusLivro status) throws LivroNaoEncontradoException {
        Livro livro = encontrarLivroPorIsbn(isbn);
        if (livro != null) {
            livro.setStatus(status);
            System.out.println("Status atualizado com sucesso! ");
        } else {
            throw new LivroNaoEncontradoException("Livro com ISBN não encontrado! ");
        }
    }
    
}
