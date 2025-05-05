import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MedicoRepositorio {
    private List<Medico> medicos = new ArrayList<>();

    public void adicionarMedico(Medico... medico) {
        Collections.addAll(medicos,medico);
    }

    public Optional<Medico> buscarPorNome(String nome) {
        for (Medico medico : medicos) {
            if (medico.getNome().equals(nome)) {
                return Optional.of(medico);
            }
        }
        return Optional.empty();
    }

    public Optional<Medico> buscarPorCRM(String CRM) {
        for (Medico medico : medicos) {
            if (medico.getCRM().equals(CRM)) {
                return Optional.of(medico);
            }
        }
        return Optional.empty();
    }


    // ... outros métodos de busca ...
}