package com.fakeapi.service;

import com.fakeapi.dto.ProductsDto;
import com.fakeapi.infra.entities.ProductEntity;
import com.fakeapi.infra.repository.ProductRepository;
import com.fakeapi.service.converter.ProdutoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProdutoConverter converter;

    public ProductEntity salvaProduto(ProductEntity entity){
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Produto");
        }
    }

    public ProductsDto salvaProdutoDto(ProductsDto dto){
        try {
            ProductEntity entity = converter.toEntity(dto);
            return converter.toDto(repository.save(entity));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Produto");
        }
    }

    public List<ProductsDto> buscaTodosProdutos() {
        try {
            return converter.toListDto(repository.findAll());
        }catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os produtos", e);
        }
    }

    public ProductsDto buscaProdutoPorNome(String nome) {
        try {
            ProductEntity produto = repository.findByNome(nome);
            if (Objects.isNull(produto)) {
                throw new UnsupportedOperationException("Não foram encontrados produtos com o nome " + nome);
            }
            return converter.toDto(produto);
        }catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar produto por nome = %s", nome), e);
        }
    }

    public void deletaProduto(String nome){
        try {
            repository.deleteByNome(nome);
        } catch (Exception e){
            throw  new RuntimeException(format("Erro ao deletar produto por nome", nome), e);
        }
    }


    public Boolean existsPorNome(String nome){
        try {
            return repository.existByNome(nome);
        } catch (Exception e){
            throw  new RuntimeException(format("Erro ao buscar produto por nome", nome), e);
        }
    }

    public ProductsDto updateProduto(String id, ProductsDto dto){
        try {
            ProductEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não existe no banco de dados"));
            salvaProduto(converter.toEntityUpdate(entity, dto, id));
            return converter.toDto(repository.findByNome(entity.getNome()));
        } catch (Exception e){
            throw  new RuntimeException(format("Erro ao atualizar produto"), e);
        }
    }
}
