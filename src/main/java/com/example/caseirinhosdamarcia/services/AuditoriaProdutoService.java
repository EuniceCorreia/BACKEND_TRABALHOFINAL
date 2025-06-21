package com.example.caseirinhosdamarcia.services;

import com.example.caseirinhosdamarcia.dtos.AuditoriaProdutoDTO;
import com.example.caseirinhosdamarcia.entities.*;
import com.example.caseirinhosdamarcia.mappers.AuditoriaProdutoMapper;
import com.example.caseirinhosdamarcia.repositories.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuditoriaProdutoService {
    private final AuditoriaProdutoRepository auditoriaProdutoRepository;
    private final ObjectMapper objectMapper;
    private final AuditoriaProdutoMapper auditoriaProdutoMapper;

    public AuditoriaProdutoService(AuditoriaProdutoRepository auditoriaProdutoRepository,
                            ObjectMapper objectMapper,
                            AuditoriaProdutoMapper auditoriaProdutoMapper) {
        this.auditoriaProdutoRepository = auditoriaProdutoRepository;
        this.objectMapper = objectMapper;
        this.auditoriaProdutoMapper = auditoriaProdutoMapper;
    }

    public void registrarAuditoria(UUID produtoId, Object dadosAntigos, Object dadosNovos,
                                   String acao, String usuario) {
        AuditoriaProduto auditoria = new AuditoriaProduto();
        auditoria.setProdutoId(produtoId);
        auditoria.setAcao(acao);

        try {
            auditoria.setDadosAntigos(objectMapper.writeValueAsString(dadosAntigos));
            auditoria.setDadosNovos(dadosNovos != null ? objectMapper.writeValueAsString(dadosNovos) : null);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter dados para auditoria", e);
        }

        auditoria.setDataHora(LocalDateTime.now());
        auditoria.setUsuario(usuario);

        auditoriaProdutoRepository.save(auditoria);
    }

    public Page<AuditoriaProdutoDTO> buscarHistoricoProduto(UUID produtoId, Pageable pageable) {
        return auditoriaProdutoRepository.findByProdutoId(produtoId, pageable)
                .map(auditoriaProdutoMapper::toDTO);
    }
}
