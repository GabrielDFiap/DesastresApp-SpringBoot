package br.com.fiap.alertempo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tbl_desastres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Desastre {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_DESASTRES"
    )
    @SequenceGenerator(
            name = "SEQ_DESASTRES",
            sequenceName = "SEQ_DESASTRES",
            allocationSize = 1
    )
    @Column(name = "ID_DESASTRE")
    private Long desastreId;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "NIVEL", nullable = false)
    private Integer nivel;

    @Column(name = "TIPO", nullable = false)
    private Integer tipo;

    public Long getDesastreId() {
        return desastreId;
    }

    public void setDesastreId(Long desastreId) {
        this.desastreId = desastreId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
