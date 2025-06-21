package com.example.caseirinhosdamarcia.controllers;

import com.example.caseirinhosdamarcia.dtos.AuditoriaProdutoDTO;
import com.example.caseirinhosdamarcia.mappers.AuditoriaProdutoMapper;
import com.example.caseirinhosdamarcia.repositories.AuditoriaProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaProdutoController {
    private final AuditoriaProdutoRepository auditoriaProdutoRepository;
    private final AuditoriaProdutoMapper auditoriaProdutoMapper;

    public AuditoriaProdutoController(AuditoriaProdutoRepository auditoriaProdutoRepository,
                                      AuditoriaProdutoMapper auditoriaProdutoMapper) {
        this.auditoriaProdutoRepository = auditoriaProdutoRepository;
        this.auditoriaProdutoMapper = auditoriaProdutoMapper;
    }

    @GetMapping
    public Page<AuditoriaProdutoDTO> getAllLogs(Pageable pageable) {
        return auditoriaProdutoRepository.findAll(pageable).map(auditoriaProdutoMapper::toDTO);
    }

    @GetMapping("/produto/{produtoId}")
    public Page<AuditoriaProdutoDTO> getLogsByProduto(@PathVariable UUID produtoId, Pageable pageable) {
        return auditoriaProdutoRepository.findByProdutoId(produtoId, pageable).map(auditoriaProdutoMapper::toDTO);
    }
}
