package br.com.fiap.alertempo.controller;

import br.com.fiap.alertempo.dto.AlertaExibicaoDTO;
import br.com.fiap.alertempo.dto.CadastroAlertaDTO;
import br.com.fiap.alertempo.dto.DesastreExibicaoDTO;
import br.com.fiap.alertempo.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlertaController {
    @Autowired
    private AlertaService alertaService;

    @PostMapping("/alertas")
    @ResponseStatus(HttpStatus.CREATED)
    public AlertaExibicaoDTO criarAlerta(@RequestBody CadastroAlertaDTO alertaDTO) {
        return alertaService.criarAlerta(alertaDTO);
    }
    @GetMapping("/alertas")
    @ResponseStatus(HttpStatus.OK)
    public List<AlertaExibicaoDTO> listarTodos() {
        return alertaService.listarTodos();
    }
}
