import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciamentoLivros biblioteca = new GerenciamentoLivros();
        String opcao;

        do {
            System.out.println("\nMenu da biblioteca:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Atualizar status do livro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
      
                    Livro livro = new Livro(titulo, autor, isbn, genero, null);
                    biblioteca.adicionarLivro(livro);
                    System.out.println("Livro adicionado com sucesso.");
                    break;

                case "2":
                    biblioteca.listarLivros();
                    break;

                case "3":
                    System.out.print("Digite o ISBN do livro a ser atualizado: ");
                    String isbnParaAtualizar = scanner.nextLine();

                    try {
                        Livro livroParaAtualizar = biblioteca.encontrarLivroPorIsbn(isbnParaAtualizar);
                        if (livroParaAtualizar == null) {
                            throw new LivroNaoEncontradoException("Livro com ISBN " + isbnParaAtualizar + "não encontrado.");
                        }

                        boolean statusAtualizado = false;
                        while (!statusAtualizado) {
                            System.out.print("Novo status (disponivel, emprestado, danificado): ");
                            String novoStatusStr = scanner.nextLine();
                            
                            try {
                                StatusLivro novoStatus = StatusLivro.valueOf(novoStatusStr.toUpperCase());
                                biblioteca.atualizarStatus(isbnParaAtualizar, novoStatus);
                                statusAtualizado = true; 
                            } catch (IllegalArgumentException e) {
                                System.out.println("Status inválido: " + novoStatusStr);
                            }
                        }
                    } catch (LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case "4":
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (!opcao.equals("4"));

        scanner.close();
    }
}