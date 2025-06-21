package com.example.caseirinhosdamarcia.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuditoriaProdutoDTO(
        UUID id,
        UUID produtoId,
        String acao,
        String dadosAntigos,
        String dadosNovos,
        LocalDateTime dataHora,
        String usuario
) {
}
