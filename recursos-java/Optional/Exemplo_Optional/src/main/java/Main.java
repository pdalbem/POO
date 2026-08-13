import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Especialidade cardiologia = new Especialidade("Cardiologia");
        Especialidade dermatologia = new Especialidade("Dermatologia");

        Medico medico1 = new Medico("123","Dra. Ana", cardiologia);
        Medico medico2 = new Medico("456","Dr. Carlos", dermatologia);
        Medico medico3 = new Medico("789","Dra. Maria", cardiologia);

        MedicoRepositorio repositorio = new MedicoRepositorio();
        repositorio.adicionarMedico(medico1, medico2,medico3);

        // Buscar médico por nome (existente)
        Optional<Medico> medicoEncontradoNome = repositorio.buscarPorNome("Dra. Ana");
        if (medicoEncontradoNome.isPresent()) {
            System.out.println("Médico encontrado por nome: " + medicoEncontradoNome.get().getNome() + " (" + medicoEncontradoNome.get().getEspecialidade().getDescricao() + ")");
        } else {
            System.out.println("Médico não encontrado com o nome especificado.");
        }

        // Buscar médico por nome (inexistente)
        Optional<Medico> medicoNaoEncontradoNome = repositorio.buscarPorNome("Dr. José");
        if (medicoNaoEncontradoNome.isPresent()) {
            System.out.println("Médico encontrado por nome: " + medicoNaoEncontradoNome.get().getNome());
        } else {
            System.out.println("Médico não encontrado com o nome especificado.");
        }

        System.out.println("\n---");

        // Buscar médico por CRM
        Optional<Medico> medicoEncontradoCRM = repositorio.buscarPorCRM("123");
        if (medicoEncontradoCRM.isPresent()) {
            System.out.println("Médico encontrado por CRM: " + medicoEncontradoCRM.get().getNome());
        } else {
            System.out.println("Médico não encontrado com o CRM especificado.");
        }
    }
}