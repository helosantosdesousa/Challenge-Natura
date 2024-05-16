package br.fiap.NaturaSpring.comentario;

import br.fiap.NaturaSpring.post.Post;
import br.fiap.NaturaSpring.usuario.Usuario;

public class Comentario {
    String conteudoComentario;
    Usuario usuario;
    Post post;

    public Comentario(String conteudoComentario, Usuario usuario, Post post) {
        this.conteudoComentario = conteudoComentario;
        this.usuario = usuario;
        this.post = post;
    }

    public String getConteudoComentario() {
        return conteudoComentario;
    }

    public void setConteudoComentario(String conteudoComentario) {
        this.conteudoComentario = conteudoComentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
