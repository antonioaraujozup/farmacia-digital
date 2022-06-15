package br.com.zup.edu.pharmacia.adapters.persistence.farmaceuticas;

import br.com.zup.edu.pharmacia.domain.farmaceuticas.CadastraNovaFarmaceuticaRepository;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.Farmaceutica;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.RetornaFarmaceuticaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SqlFarmaceutivaAdapter implements CadastraNovaFarmaceuticaRepository, RetornaFarmaceuticaRepository {

    private final FarmaceuticaRepository repository;

    public SqlFarmaceutivaAdapter(FarmaceuticaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Farmaceutica salva(Farmaceutica farmaceutica) {
        return repository.save(farmaceutica);
    }

    @Override
    public Optional<Farmaceutica> buscarPorId(Long id) {
        return repository.findById(id);
    }

}
