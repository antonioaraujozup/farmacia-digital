package br.com.zup.edu.pharmacia.domain.remedios;

import br.com.zup.edu.pharmacia.domain.categorias.RetornaCategoriaRepository;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.RetornaFarmaceuticaRepository;

public interface DadosRemedio {

    Remedio toModel(RetornaFarmaceuticaRepository retornaFarmaceuticaRepository, RetornaCategoriaRepository retornaCategoriaRepository);

}
