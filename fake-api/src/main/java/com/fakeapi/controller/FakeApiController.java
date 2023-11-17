package com.fakeapi.controller;

import com.fakeapi.dto.ProductsDto;
import com.fakeapi.infra.entities.ProductEntity;
import com.fakeapi.service.FakeApiService;
import com.fakeapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeApiController {

    private final FakeApiService service;
    private final ProductService produtoService;

    @Operation(summary = "Busca produtos da API e Salvar", method ="POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductsDto>> salvaProdutosApi(){
        return ResponseEntity.ok(service.buscaProdutos());
    }

    @Operation(summary = "Salva novos produtos", method ="POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @PostMapping("/")
    public ResponseEntity<ProductsDto> salvaProdutos(@RequestBody ProductsDto dto){

        return ResponseEntity.ok(produtoService.salvaProdutoDto(dto));
    }

    @Operation(summary = "Fazer update de novos produtos", method ="PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @PutMapping("/")
    public ResponseEntity<ProductsDto> updateProdutos(@RequestParam ("id") String id, @RequestBody ProductsDto dto){

        return ResponseEntity.ok(produtoService.updateProduto(id, dto));
    }

    @Operation(summary = "Deleta produtos", method ="DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar os produtos"),
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> deletaProduto(@RequestParam ("nome") String nome){
        produtoService.deletaProduto(nome);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os produtos", method ="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductsDto>> buscaTodosProdutos(){

        return ResponseEntity.ok(produtoService.buscaTodosProdutos());
    }

    @Operation(summary = "Busca produto por nome", method ="GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @GetMapping("/{nome}")
    public ResponseEntity<ProductsDto> buscaProdutoPorNome(@PathVariable ("nome") String nome){

        return ResponseEntity.ok(produtoService.buscaProdutoPorNome(nome));
    }






}