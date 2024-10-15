package br.com.fiap.alertempo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioDTO(
        Long usuarioId,

        @NotBlank(message = "O campo NOME é obrigatório!")
        String nome,

        @NotBlank(message = "O campo EMAIL é obrigatório!")
        @Email()
        String email,

        @NotBlank(message = "O campo TELSMS é obrigatório!")
        @Size(max = 15, message = "O telefone deve ter no maximo 15 caracteres!")
        String telSms
) {

}
