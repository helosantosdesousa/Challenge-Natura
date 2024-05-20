package br.fiap.NaturaSpring.curtida;

import br.fiap.NaturaSpring.post.Post;
import br.fiap.NaturaSpring.usuario.Usuario;
import br.fiap.NaturaSpring.usuario.UsuarioAtual;

public class Curtida {
    private Usuario usuario;

    public Curtida(Usuario usuario) {
        this.usuario = usuario;
    }

    public void curtePost(Post post){
        post.setQtdLikes(post.getQtdLikes()+1);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
