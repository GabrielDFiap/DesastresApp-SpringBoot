package br.com.fiap.alertempo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_alertas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Alerta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ALERTAS"
    )
    @SequenceGenerator(
            name = "SEQ_ALERTAS",
            sequenceName = "SEQ_ALERTAS",
            allocationSize = 1
    )
    @Column(name = "ID_ALERTA", nullable = false)
    private Long alertaId;

    @Column(name = "ID_DESASTRE")
    private Long desastreId;

    @Column(name = "DATA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "MENSAGEM", nullable = false)
    private String mensagem;

    @Column(name = "LOCALIZACAO", nullable = false)
    private String localizacao;

    public Long getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(Long alertaId) {
        this.alertaId = alertaId;
    }

    public Long getDesastreId() {
        return desastreId;
    }

    public void setDesastreId(Long desastreId) {
        this.desastreId = desastreId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
