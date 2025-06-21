package com.example.caseirinhosdamarcia.services;

import com.example.caseirinhosdamarcia.dtos.ProdutoDTO;
import com.example.caseirinhosdamarcia.entities.Produto;
import com.example.caseirinhosdamarcia.mappers.ProdutoMapper;
import com.example.caseirinhosdamarcia.repositories.ProdutoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoMapper produtoMapper;
    private final ProdutoRepository produtoRepository;
    private final AuditoriaProdutoService auditoriaProdutoService;
    private final ObjectMapper objectMapper;

    public ProdutoService(ProdutoMapper produtoMapper,
                          ProdutoRepository produtoRepository,
                          AuditoriaProdutoService auditoriaProdutoService,
                          ObjectMapper objectMapper) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
        this.auditoriaProdutoService = auditoriaProdutoService;
        this.objectMapper = objectMapper;
    }

    public Page<ProdutoDTO> getAllProduto(Pageable pageable) {
        Page<Produto> produtoList = produtoRepository.findAll(pageable);
        return produtoList.map(produtoMapper::toDTO);
    }

    public ProdutoDTO getProdutoById(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado!")
        );
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO createProduto(ProdutoDTO produtoDTO, String usuario) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produtoRepository.save(produto);

        auditoriaProdutoService.registrarAuditoria(
                produto.getId_produto(),
                null,
                produtoDTO,
                "CREATE",
                usuario
        );
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO updateProduto(UUID id, ProdutoDTO produtoDTO, String usuario) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não existe")
        );
        produto.setTitle(produtoDTO.title());
        produto.setPeso(produtoDTO.peso());
        produto.setPrice(produtoDTO.price());
        produto.setType(produtoDTO.type());
        produto.setDescricaoModal(produtoDTO.descricaoModal());
        produto.setImage(produtoDTO.image());
        produtoRepository.save(produto);

        auditoriaProdutoService.registrarAuditoria(
                produto.getId_produto(),
                null,
                produtoDTO,
                "UPDATE",
                usuario
        );
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO deleteProduto(UUID id, String usuario) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não encontrado!"));

        String dadosAntigos;
        try {
            dadosAntigos = objectMapper.writeValueAsString(produtoMapper.toDTO(produto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter dados do produto para auditoria", e);
        }

        produtoRepository.delete(produto);

        auditoriaProdutoService.registrarAuditoria(
                produto.getId_produto(),
                null,
                dadosAntigos,
                "DELETE",
                usuario
        );
        return produtoMapper.toDTO(produto);
    }
}
