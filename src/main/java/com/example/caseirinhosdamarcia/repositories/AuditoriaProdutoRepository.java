package com.example.caseirinhosdamarcia.repositories;

import com.example.caseirinhosdamarcia.entities.AuditoriaProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditoriaProdutoRepository extends JpaRepository<AuditoriaProduto, UUID> {
    Page<AuditoriaProduto> findByProdutoId(UUID produtoId, Pageable pageable);
}
