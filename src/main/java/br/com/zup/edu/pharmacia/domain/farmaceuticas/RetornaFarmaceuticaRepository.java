package br.com.zup.edu.pharmacia.domain.farmaceuticas;

import java.util.Optional;

public interface RetornaFarmaceuticaRepository {

    Optional<Farmaceutica> buscarPorId(Long id);

}
