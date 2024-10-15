package br.com.fiap.alertempo.dto;

import br.com.fiap.alertempo.model.Desastre;
import java.util.Date;

public record DesastreExibicaoDTO(
        Long desastreId,
        String descricao,
        Date data,
        Integer nivel,
        Integer tipo

) {
    public DesastreExibicaoDTO(Desastre desastre) {
        this(
        desastre.getDesastreId(),
        desastre.getDescricao(),
        desastre.getData(),
        desastre.getNivel(),
        desastre.getTipo()
        );
    }
}
