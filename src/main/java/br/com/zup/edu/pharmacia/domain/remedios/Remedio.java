package br.com.zup.edu.pharmacia.domain.remedios;

import br.com.zup.edu.pharmacia.domain.categorias.Categoria;
import br.com.zup.edu.pharmacia.domain.farmaceuticas.Farmaceutica;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataFabricacao;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @ManyToOne(optional = false)
    private Farmaceutica farmaceutica;

    @ManyToOne(optional = false)
    private Categoria categoria;

    public Remedio(String nome, LocalDate dataFabricacao, LocalDate dataValidade, Farmaceutica farmaceutica, Categoria categoria) {
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.farmaceutica = farmaceutica;
        this.categoria = categoria;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Remedio() {
    }

    public Long getId() {
        return id;
    }

}
