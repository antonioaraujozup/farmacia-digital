package br.com.zup.edu.pharmacia.application.remedios;

import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import br.com.zup.edu.pharmacia.domain.categorias.RetornaCategoriaRepository;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.Farmaceutica;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.RetornaFarmaceuticaRepository;
import br.com.zup.edu.pharmacia.domain.remedios.DadosRemedio;
import br.com.zup.edu.pharmacia.domain.remedios.Remedio;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CadastraNovoRemedioRequest implements DadosRemedio {

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFabricacao;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;

    @NotNull
    @Positive
    private Long farmaceuticaId;

    @NotNull
    @Positive
    private Long categoriaId;

    public CadastraNovoRemedioRequest(String nome, LocalDate dataFabricacao, LocalDate dataValidade, Long farmaceuticaId, Long categoriaId) {
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.farmaceuticaId = farmaceuticaId;
        this.categoriaId = categoriaId;
    }

    public CadastraNovoRemedioRequest() {
    }

    @Override
    public Remedio toModel(RetornaFarmaceuticaRepository retornaFarmaceuticaRepository, RetornaCategoriaRepository retornaCategoriaRepository) {
        Farmaceutica farmaceutica = retornaFarmaceuticaRepository.buscarPorId(farmaceuticaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Farmacêutica não encontrada"));

        Categoria categoria = retornaCategoriaRepository.buscarPorId(categoriaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Categoria não encontrada"));

        return new Remedio(nome,dataFabricacao,dataValidade,farmaceutica,categoria);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public Long getFarmaceuticaId() {
        return farmaceuticaId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

}
