package br.com.zup.edu.pharmacia.adapters.persistence.remedios;

import br.com.zup.edu.pharmacia.domain.remedios.CadastraNovoRemedioRepository;
import br.com.zup.edu.pharmacia.domain.remedios.Remedio;
import org.springframework.stereotype.Component;

@Component
public class SqlRemedioAdapter implements CadastraNovoRemedioRepository {

    private final RemedioRepository repository;

    public SqlRemedioAdapter(RemedioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Remedio salvar(Remedio remedio) {
        return repository.save(remedio);
    }

}
