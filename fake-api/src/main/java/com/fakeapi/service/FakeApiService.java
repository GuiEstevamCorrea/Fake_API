package com.fakeapi.service;

import com.fakeapi.dto.ProductsDto;
import com.fakeapi.infra.client.FakeApiClient;
import com.fakeapi.service.converter.ProdutoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;
    private final ProdutoConverter converter;
    private final ProductService service;

    public List<ProductsDto> buscaProdutos(){
        try {
            List<ProductsDto> dto =  client.buscaListaProdutos();
            dto.forEach(produto -> {
                Boolean retorno = service.existsPorNome(produto.getNome());
                if (retorno.equals(false)){
                    service.salvaProduto(converter.toEntity(produto));
                }
            }
            );
            return service.buscaTodosProdutos();
        } catch (Exception e) {
        throw new RuntimeException("Erro ao buscar e gravar produto no banco de dados");
        }
    }
}
