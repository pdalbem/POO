import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericRepositoryImpl<T extends Entity> implements Repository<T> {
    private final Map<Long, T> entidades = new HashMap<>();
    private Long proximoId = 1L;

    @Override
    public Optional<T> buscarPorId(Long id) {
        return Optional.ofNullable(entidades.get(id));
    }

    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(entidades.values());
    }

    @Override
    public void salvar(T entidade) {
        if (entidade.getId() == null) {
            entidade.setId(proximoId++);
        }
        entidades.put(entidade.getId(), entidade);
    }

    @Override
    public void deletar(Long id) {
        entidades.remove(id);
    }
}