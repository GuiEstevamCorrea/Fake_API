package com.fakeapi.infra.client;

import com.fakeapi.dto.ProductsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fake-api", url = "${fake-api.url:#{null}}")
public interface FakeApiClient {

    @GetMapping("/products")
    List<ProductsDto> buscaListaProdutos();
}
