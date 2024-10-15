package br.com.fiap.alertempo.dto;

import br.com.fiap.alertempo.model.Alerta;
import java.util.Date;

public record AlertaExibicaoDTO(
        Long alertaId,
        Long desastreId,
        Date data,
        String mensagem,
        String localizacao
) {
    public AlertaExibicaoDTO(Alerta alerta) {
        this(
            alerta.getAlertaId(),
            alerta.getDesastreId(),
            alerta.getData(),
            alerta.getMensagem(),
            alerta.getLocalizacao()
        );
    }
}
