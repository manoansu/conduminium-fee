package pt.amane.condominium_fee.services;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;

import pt.amane.condominium_fee.model.StatusTitulo;
import pt.amane.condominium_fee.model.Titulo;
import pt.amane.condominium_fee.repositories.TituloRepository;
import pt.amane.condominium_fee.repositories.filter.TituloFilter;
import pt.amane.condominium_fee.services.exception.DataResourceAccessException;

@Service
public class CadastroTituloService {

    @Autowired
    private TituloRepository repository;

    public void salvar(Titulo titulo) {
        try {
            repository.save(titulo);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
    }

    public void excluir(Long codigo) {
        repository.deleteById(codigo);
    }

    public String receber(Long codigo) {
        Optional<Titulo> tituloOptional = repository.findById(codigo);
        Titulo titulo = tituloOptional.orElseThrow(() -> new DataResourceAccessException("Código não encontrado: " + codigo + Titulo.class.getName()));
        titulo.setStatus(StatusTitulo.RECEBIDO);
        repository.save(titulo);

        return StatusTitulo.RECEBIDO.getDescricao();
    }

    public List<Titulo> filtrar(TituloFilter filtro) {
        String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
        return repository.findByDescricaoContaining(descricao);
    }

}