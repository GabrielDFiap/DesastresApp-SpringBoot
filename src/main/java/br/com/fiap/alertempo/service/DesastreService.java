package br.com.fiap.alertempo.service;

import br.com.fiap.alertempo.dto.CadastroDesastreDTO;
import br.com.fiap.alertempo.dto.DesastreExibicaoDTO;
import br.com.fiap.alertempo.exception.ItemNaoEncontradoException;
import br.com.fiap.alertempo.model.Desastre;
import br.com.fiap.alertempo.repository.DesastreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesastreService {

    @Autowired
    private DesastreRepository desastreRepository;

    public DesastreExibicaoDTO criarDesastre(CadastroDesastreDTO desastreDTO) {

        Desastre desastre = new Desastre();
        BeanUtils.copyProperties(desastreDTO, desastre);

        Desastre desastreSalvo = desastreRepository.save(desastre);
        return new DesastreExibicaoDTO(desastreSalvo);
    }

    public DesastreExibicaoDTO buscarPorId(Long id) {
        Optional<Desastre> desastreOptional = desastreRepository.findById(id);

        if(desastreOptional.isPresent()) {
            return new DesastreExibicaoDTO(desastreOptional.get());
        } else {
            throw new ItemNaoEncontradoException("Desastre não encontrado...");
        }
    }

    public List<DesastreExibicaoDTO> listarTodos() {
        return desastreRepository.findAll().stream().map(DesastreExibicaoDTO::new).toList();
    }

    public DesastreExibicaoDTO atualizar(CadastroDesastreDTO desastreDTO) {
        Optional<Desastre> desastreOptional = desastreRepository.findById(desastreDTO.desastreId());

        if(desastreOptional.isPresent()) {
            Desastre desastre = new Desastre();
            BeanUtils.copyProperties(desastreDTO, desastre);

            return new DesastreExibicaoDTO(desastreRepository.save(desastre));
        } else {
            throw new ItemNaoEncontradoException("Desastre não encontrado...");
        }
    }

    public void deletar(Long id) {
        Optional<Desastre> desastreOptional = desastreRepository.findById(id);

        if(desastreOptional.isPresent()) {
            desastreRepository.delete(desastreOptional.get());
        } else {
            throw new ItemNaoEncontradoException("Desastre não encontrado...");
        }
    }
}