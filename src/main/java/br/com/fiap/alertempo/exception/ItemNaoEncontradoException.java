package br.com.fiap.alertempo.exception;

public class ItemNaoEncontradoException extends RuntimeException{
    public ItemNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
