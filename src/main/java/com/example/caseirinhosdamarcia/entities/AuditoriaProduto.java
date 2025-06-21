package com.example.caseirinhosdamarcia.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "auditoria_produto")
public class AuditoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "produto_id")
    private UUID produtoId;

    @Column(name = "acao")
    private String acao; // "CREATE", "UPDATE", "DELETE"

    @Column(name = "dados_antigos", columnDefinition = "TEXT")
    private String dadosAntigos;

    @Column(name = "dados_novos", columnDefinition = "TEXT")
    private String dadosNovos;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "usuario")
    private String usuario;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(UUID produtoId) {
        this.produtoId = produtoId;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getDadosAntigos() {
        return dadosAntigos;
    }

    public void setDadosAntigos(String dadosAntigos) {
        this.dadosAntigos = dadosAntigos;
    }

    public String getDadosNovos() {
        return dadosNovos;
    }

    public void setDadosNovos(String dadosNovos) {
        this.dadosNovos = dadosNovos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getters e Setters
    // Construtores
}
