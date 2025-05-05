import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Criando repositórios específicos usando o Repository genérico
        Repository<Usuario> usuarioRepository = new GenericRepositoryImpl<>();
        Repository<Produto> produtoRepository = new GenericRepositoryImpl<>();

        // Operações com o repositório de usuários
        Usuario usuario1 = new Usuario(null, "João", "joao@example.com");
        Usuario usuario2 = new Usuario(null, "Maria", "maria@example.com");
        usuarioRepository.salvar(usuario1);
        usuarioRepository.salvar(usuario2);

        Optional<Usuario> usuarioEncontrado = usuarioRepository.buscarPorId(1L);
        usuarioEncontrado.ifPresent(System.out::println);

        List<Usuario> todosUsuarios = usuarioRepository.buscarTodos();
        System.out.println("Todos os usuários: " + todosUsuarios);

        usuarioRepository.deletar(2L);
        System.out.println("Todos os usuários após deletar: " + usuarioRepository.buscarTodos());

        System.out.println("\n---");

        // Operações com o repositório de produtos
        Produto produto1 = new Produto(null, "Notebook", 1200.00);
        Produto produto2 = new Produto(null, "Mouse", 25.00);
        produtoRepository.salvar(produto1);
        produtoRepository.salvar(produto2);

        Optional<Produto> produtoEncontrado = produtoRepository.buscarPorId(2L);
        produtoEncontrado.ifPresent(System.out::println);

        List<Produto> todosProdutos = produtoRepository.buscarTodos();
        System.out.println("Todos os produtos: " + todosProdutos);

        produtoRepository.deletar(1L);
        System.out.println("Todos os produtos após deletar: " + produtoRepository.buscarTodos());
    }
}
