package br.com.fiap.alertempo.service;

import br.com.fiap.alertempo.dto.UsuarioExibicaoDTO;
import br.com.fiap.alertempo.exception.ItemNaoEncontradoException;
import br.com.fiap.alertempo.model.Usuario;
import br.com.fiap.alertempo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    public UsuarioExibicaoDTO buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDTO(usuarioOptional.get());
        } else {
            throw new ItemNaoEncontradoException("Usuario não encontrado...");
        }
    }

    public List<UsuarioExibicaoDTO> listarTodos() {
        return usuarioRepository.findAll().stream().map(UsuarioExibicaoDTO::new).toList();
    }

    public Usuario atualizar(Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getUsuarioId());

        if(usuarioOptional.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            throw new ItemNaoEncontradoException("Usuario não encontrado...");
        }
    }

    public void deletar(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
        } else {
            throw new ItemNaoEncontradoException("Usuario não encontrado...");
        }
    }
}
