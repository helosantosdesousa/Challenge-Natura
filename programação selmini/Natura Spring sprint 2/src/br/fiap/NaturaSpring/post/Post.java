package br.fiap.NaturaSpring.post;

import br.fiap.NaturaSpring.comentario.Comentario;
import br.fiap.NaturaSpring.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int qtdLikes;
    private String conteudoPost;
    private Usuario usuario;
    private List<Comentario> comentarios = new ArrayList<>();

    public Post(String conteudoPost, Usuario usuario) {
        this.conteudoPost = conteudoPost;
        this.usuario = usuario;
    }

    public String getConteudoPost() {
        return conteudoPost;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getQtdLikes() {
        return qtdLikes;
    }

    public void setQtdLikes(int qtdLikes) {
        this.qtdLikes = qtdLikes;
    }
}
