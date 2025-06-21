package com.example.caseirinhosdamarcia.controllers;

import com.example.caseirinhosdamarcia.dtos.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.example.caseirinhosdamarcia.services.ProdutoService;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public Page<ProdutoDTO> getAllProduto(Pageable pageable) {
        return produtoService.getAllProduto(pageable);
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProdutoById(@PathVariable UUID id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public ProdutoDTO createProduto(@RequestBody ProdutoDTO produtoDTO, String usuario) {
        return produtoService.createProduto(produtoDTO, usuario);
    }

    @PutMapping("/{id}")
    public ProdutoDTO updateProduto(@PathVariable UUID id, @RequestBody ProdutoDTO produtoDTO, String usuario){
        return produtoService.updateProduto(id, produtoDTO, usuario);
    }

    @DeleteMapping("/{id}")
    public ProdutoDTO deleteProduto(@PathVariable UUID id, String usuario) {
        return produtoService.deleteProduto(id, usuario);
    }
}
