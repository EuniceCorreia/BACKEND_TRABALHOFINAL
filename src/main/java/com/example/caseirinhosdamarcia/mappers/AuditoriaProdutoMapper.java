package com.example.caseirinhosdamarcia.mappers;

import com.example.caseirinhosdamarcia.dtos.AuditoriaProdutoDTO;
import com.example.caseirinhosdamarcia.entities.AuditoriaProduto;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaProdutoMapper {
    public AuditoriaProdutoDTO toDTO(AuditoriaProduto auditoriaProduto) {
        return new AuditoriaProdutoDTO(
                auditoriaProduto.getId(),
                auditoriaProduto.getProdutoId(),
                auditoriaProduto.getAcao(),
                auditoriaProduto.getDadosAntigos(),
                auditoriaProduto.getDadosNovos(),
                auditoriaProduto.getDataHora(),
                auditoriaProduto.getUsuario()
        );
    }

    public AuditoriaProduto toEntity(AuditoriaProdutoDTO auditoriaProdutoDTO) {
        AuditoriaProduto auditoriaProduto = new AuditoriaProduto();
        auditoriaProduto.setId(auditoriaProdutoDTO.id());
        auditoriaProduto.setProdutoId(auditoriaProdutoDTO.produtoId());
        auditoriaProduto.setAcao(auditoriaProdutoDTO.acao());
        auditoriaProduto.setDadosAntigos(auditoriaProdutoDTO.dadosAntigos());
        auditoriaProduto.setDadosNovos(auditoriaProdutoDTO.dadosNovos());
        auditoriaProduto.setDataHora(auditoriaProdutoDTO.dataHora());
        auditoriaProduto.setUsuario(auditoriaProdutoDTO.usuario());
        return auditoriaProduto;
    }
}
