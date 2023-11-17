package com.fakeapi.infra.repository;

import com.fakeapi.infra.entities.ProductEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM ProductEntity p WHERE p.nome = :nome")
    boolean existByNome(@Param("nome") String nome);

    ProductEntity findByNome(String nome);

    void deleteByNome(String nome);

}
