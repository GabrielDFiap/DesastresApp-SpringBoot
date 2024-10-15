package br.com.fiap.alertempo.service;

import br.com.fiap.alertempo.dto.*;
import br.com.fiap.alertempo.model.Alerta;
import br.com.fiap.alertempo.repository.AlertaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlertaService {
    @Autowired
    private AlertaRepository alertaRepository;

    public AlertaExibicaoDTO criarAlerta(CadastroAlertaDTO alertaDTO) {

        Alerta alerta = new Alerta();
        BeanUtils.copyProperties(alertaDTO, alerta);

        Alerta alertaSalvo = alertaRepository.save(alerta);
        return new AlertaExibicaoDTO(alertaSalvo);
    }

    public List<AlertaExibicaoDTO> listarTodos() {
        return alertaRepository.findAll().stream().map(AlertaExibicaoDTO::new).toList();
    }
}
