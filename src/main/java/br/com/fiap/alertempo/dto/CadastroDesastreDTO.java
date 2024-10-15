package br.com.fiap.alertempo.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public record CadastroDesastreDTO(
        Long desastreId,
        @NotBlank(message = "O campo DESCRICAO é obrigatório!")
        String descricao,
        @NotBlank(message = "O campo DATA é obrigatório!")
        Date data,
        @NotBlank(message = "O campo NIVEL é obrigatório!")
        Integer nivel,
        @NotBlank(message = "O campo TIPO é obrigatório!")
        Integer tipo
) {
}
