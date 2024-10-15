package br.com.fiap.alertempo.dto;

import br.com.fiap.alertempo.model.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String name,
        String email,
        String telSms
) {
    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelSms()
        );
    }
}
