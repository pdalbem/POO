package service;

import data.dao.DoacaoDAO;
import data.dao.DoadorDAO;
import model.Doacao;
import model.Doador;
import model.Sexo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DoacaoService {
    private final DoacaoDAO doacaoDAO;
    private final DoadorDAO doadorDAO;

    public DoacaoService(DoacaoDAO doacaoDAO, DoadorDAO doadorDAO) {
        this.doacaoDAO = doacaoDAO;
        this.doadorDAO = doadorDAO;
    }

    public Doacao cadastrar(Doacao doacao) {
        if (doacao == null)
            throw new IllegalArgumentException("A doação não pode ser nula");

        Doador doador = doacao.getDoador();

        if (doador.getId() <= 0)
            throw new IllegalStateException("Doador precisa ser cadastrado primeiro");

        LocalDate dataDoacao = doacao.getDataDoacao();
        long idade =  ChronoUnit.YEARS.between(doador.getDataNascimento(), dataDoacao);
        if (idade < 16 || idade > 69)
            throw new IllegalStateException("O doador deve ter entre 16 e 69 anos");

        if (doador.getPeso() < 50)
            throw new IllegalStateException("O doador deve pesar no mínimo 50 kg");

        if (doador.getDataUltimaDoacao() != null) {
            long dias = ChronoUnit.DAYS.between(doador.getDataUltimaDoacao(), dataDoacao);
            int intervalo = doador.getSexo() == Sexo.MASCULINO ? 60 : 90;

            if (dias < intervalo)
                throw new IllegalStateException("É necessário o intervalo mínimo de " + intervalo + " dias entre doações");
        }

        Doacao doacaoSalva = doacaoDAO.save(doacao);

        // atualiza dataUltimaDoacao no BD (tabela doador) via doadorDAO
        doador.setDataUltimaDoacao(dataDoacao);
        doadorDAO.update(doador);

        return doacaoSalva;
    }

    public List<Doacao> buscarTodos() {
        return doacaoDAO.findAll();
    }

    public List<Doacao> buscarPorDoador(Doador doador) {
        if (doador == null)
            throw new IllegalArgumentException("O doador não pode ser nulo");

        if (doador.getId() <= 0)
            throw new IllegalStateException("O doador deve estar cadastrado");

        return doacaoDAO.findByDoador(doador);
    }
}