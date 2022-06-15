package br.com.zup.edu.pharmacia.domain.categorias;

import java.util.Optional;

public interface RetornaCategoriaRepository {

    Optional<Categoria> buscarPorId(Long id);

}
