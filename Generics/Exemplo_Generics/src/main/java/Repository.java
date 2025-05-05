import java.util.List;
import java.util.Optional;

public interface Repository<T extends Entity> {
    Optional<T> buscarPorId(Long id);
    List<T> buscarTodos();
    void salvar(T entidade);
    void deletar(Long id);
}