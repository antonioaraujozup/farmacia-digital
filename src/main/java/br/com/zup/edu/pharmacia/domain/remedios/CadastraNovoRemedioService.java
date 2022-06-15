package br.com.zup.edu.pharmacia.domain.remedios;

import br.com.zup.edu.pharmacia.domain.categorias.RetornaCategoriaRepository;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.RetornaFarmaceuticaRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastraNovoRemedioService {

    private final RetornaFarmaceuticaRepository retornaFarmaceuticaRepository;
    private final RetornaCategoriaRepository retornaCategoriaRepository;
    private final CadastraNovoRemedioRepository cadastraNovoRemedioRepository;

    public CadastraNovoRemedioService(RetornaFarmaceuticaRepository retornaFarmaceuticaRepository, RetornaCategoriaRepository retornaCategoriaRepository, CadastraNovoRemedioRepository cadastraNovoRemedioRepository) {
        this.retornaFarmaceuticaRepository = retornaFarmaceuticaRepository;
        this.retornaCategoriaRepository = retornaCategoriaRepository;
        this.cadastraNovoRemedioRepository = cadastraNovoRemedioRepository;
    }

    public Remedio cadastrar(DadosRemedio dadosRemedio) {
        Remedio remedio = dadosRemedio.toModel(retornaFarmaceuticaRepository, retornaCategoriaRepository);

        return cadastraNovoRemedioRepository.salvar(remedio);
    }

}
