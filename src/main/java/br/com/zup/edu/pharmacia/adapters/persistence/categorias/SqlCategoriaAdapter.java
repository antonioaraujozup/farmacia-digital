package br.com.zup.edu.pharmacia.adapters.persistence.categorias;

import br.com.zup.edu.pharmacia.domain.categorias.CadastraNovaCategoriaRepository;
import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import br.com.zup.edu.pharmacia.domain.categorias.RetornaCategoriaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SqlCategoriaAdapter implements CadastraNovaCategoriaRepository, RetornaCategoriaRepository {

    private final CategoriaRepository repository;

    public SqlCategoriaAdapter(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria salva(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
