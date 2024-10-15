package br.com.fiap.alertempo.controller;

import br.com.fiap.alertempo.dto.CadastroDesastreDTO;
import br.com.fiap.alertempo.dto.DesastreExibicaoDTO;
import br.com.fiap.alertempo.service.DesastreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesastreController {
    @Autowired
    private DesastreService desastreService;

    @PostMapping("/desastres")
    @ResponseStatus(HttpStatus.CREATED)
    public DesastreExibicaoDTO criarDesastre(@RequestBody CadastroDesastreDTO desastres) {
        return desastreService.criarDesastre(desastres);
    }

    @GetMapping("/desastres")
    @ResponseStatus(HttpStatus.OK)
    public List<DesastreExibicaoDTO> listarTodos() {
        return desastreService.listarTodos();
    }

    @GetMapping("/desastres/{desastreId}")
    @ResponseStatus(HttpStatus.OK)
    public DesastreExibicaoDTO buscarPorId(@PathVariable Long desastreId) {
        return desastreService.buscarPorId(desastreId);
    }

    @PutMapping("/desastres")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DesastreExibicaoDTO> atualizar(@RequestBody CadastroDesastreDTO desastreDTO) {
        try {
            DesastreExibicaoDTO desastreExibicaoDTO = desastreService.atualizar(desastreDTO);
            return ResponseEntity.ok(desastreExibicaoDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/desastres/{desastreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long desastreId) {
        desastreService.deletar(desastreId);
    }
}
