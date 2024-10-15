package br.com.fiap.alertempo.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CadastroAlertaDTO(
        Long alertaId,

        Long desastreId,

        @NotBlank(message = "O campo DATA é obrigatório!")
        Date data,

        @NotBlank(message = "O campo MENSAGEM é obrigatório!")
        String mensagem,

        @NotBlank(message = "O campo LOCALIZACAO é obrigatório!")
        String localizacao
) {
}
