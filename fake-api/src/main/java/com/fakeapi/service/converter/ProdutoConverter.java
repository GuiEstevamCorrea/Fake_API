package com.fakeapi.service.converter;

import com.fakeapi.dto.ProductsDto;
import com.fakeapi.infra.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ProdutoConverter {

    public ProductEntity toEntity(ProductsDto dto){
        return  ProductEntity.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .imagem(dto.getImagem())
                .dataInclusao(LocalDateTime.now())
                .build();
    }

    public ProductEntity toEntityUpdate(ProductEntity entity, ProductsDto dto, String id){
        return  ProductEntity.builder()
                .id(id)
                .nome(dto.getNome() != null ? dto.getNome() : entity.getNome())
                .categoria(dto.getCategoria() != null ? dto.getCategoria() : entity.getCategoria())
                .descricao(dto.getDescricao() != null ? dto.getDescricao() : entity.getDescricao())
                .preco(dto.getPreco() != null ? dto.getPreco() : entity.getPreco())
                .imagem(dto.getImagem() != null ? dto.getImagem() : entity.getImagem())
                .dataInclusao(entity.getDataInclusao())
                .dataAtualizacao(LocalDateTime.now())
                .build();
    }

    public ProductsDto toDto(ProductEntity entity){
        return ProductsDto.builder()
                .entityId(entity.getId())
                .nome(entity.getNome())
                .categoria(entity.getCategoria())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .imagem(entity.getImagem())
                .build();
    }

    public List<ProductsDto> toListDto(List<ProductEntity> entityList){
       return entityList.stream().map(this::toDto).toList();
    }
}
