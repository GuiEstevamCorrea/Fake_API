package com.fakeapi.infra.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "ProductEntity")
@Table(name = "TB_Products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome", length = 800)
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "categoria", length = 800)
    private String categoria;

    @Column(name = "descricao", length = 800)
    private String descricao;

    @Column(name = "imagem", length = 800)
    private String imagem;

    @Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;


}
