package br.fiap.NaturaSpring.post;

import br.fiap.NaturaSpring.usuario.Usuario;

import java.util.Random;

public class Post {
    private int idPost;
    private String conteudoPost;
    private int qtdLike;
    private int qtdComentario;
    private Usuario usuario;

    public Post(String conteudoPost) {
        this.idPost = geraId();
        this.conteudoPost = conteudoPost;
    }

    //método para gerar o id do post
    public int geraId(){
        Random rd = new Random();
        return this.idPost = rd.nextInt(1000000);
    }
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getConteudoPost() {
        return conteudoPost;
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
    }

    public int getQtdLike() {
        return qtdLike;
    }

    public void setQtdLike(int qtdLike) {
        this.qtdLike = qtdLike;
    }

    public int getQtdComentario() {
        return qtdComentario;
    }

    public void setQtdComentario(int qtdComentario) {
        this.qtdComentario = qtdComentario;
    }
}
