package br.fiap.NaturaSpring.usuario;

import br.fiap.NaturaSpring.comentario.Comentario;
import br.fiap.NaturaSpring.post.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Usuario {
    private int usuarioId;
    private String nomeUsuario;
    private String dataNasc;
    private String nickname;
    private String biografia;
    private int qtdSeguidores;
    private int qtdSeguindo;
    private int qtdPost;
    private int nivelNatura;
    private int cpf;
    private String email;
    private String telefone;
    private String senha;

    List<Comentario> comentarios = new ArrayList<>();
    public Usuario(String nomeUsuario, String dataNasc, String nickname, String biografia, int nivelNatura, int cpf, String email, String telefone, String senha) {
        this.usuarioId = geraId();
        this.nomeUsuario = nomeUsuario;
        this.dataNasc = dataNasc;
        this.nickname = nickname;
        this.biografia = biografia;
        this.qtdSeguidores = 0;
        this.qtdSeguindo = 0;
        this.qtdPost = 0;
        this.nivelNatura = nivelNatura;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    //método para gerar o id do usuário
    public int geraId() {
        Random rd = new Random();
        return this.usuarioId = rd.nextInt(1000000);
    }

    public void seguir(List<Usuario> usuarios, String resposta) {
        for (Usuario u : usuarios) {
            if (resposta.equals(u.getNomeUsuario())) {
                u.setQtdSeguidores(u.getQtdSeguidores() + 1);
                System.out.println("Seguiu com suceddo!");
                System.out.println("Usuário: " + resposta + " | qtd de seguidores: " + u.getQtdSeguidores());
            }
        }
    }

    public void deixaDeseguir(List<Usuario> usuarios, String resposta) {
        for (Usuario u : usuarios) {
            if (resposta.equals(u.getNomeUsuario())) {
                u.setQtdSeguidores(u.getQtdSeguidores() - 1);
                System.out.println("Deixou de seguir!");
                System.out.println("Usuário: " + resposta + " | qtd de seguidores: " + u.getQtdSeguidores());
            }
        }
    }

    public void insereComentario(Post post, String conteudoComentario) {
        Comentario comentario = new Comentario(conteudoComentario, this, post);
        post.getComentarios().add(comentario);
    }


    public void curtePost(List<Post> posts) {

        for (Post p : posts) {
            p.setQtdLikes(p.getQtdLikes()+1);
        }

    }


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getQtdSeguidores() {
        return qtdSeguidores;
    }

    public void setQtdSeguidores(int qtdSeguidores) {
        this.qtdSeguidores = qtdSeguidores;
    }

    public int getQtdSeguindo() {
        return qtdSeguindo;
    }

    public void setQtdSeguindo(int qtdSeguindo) {
        this.qtdSeguindo = qtdSeguindo;
    }

    public int getQtdPost() {
        return qtdPost;
    }

    public void setQtdPost(int qtdPost) {
        this.qtdPost = qtdPost;
    }

    public int getNivelNatura() {
        return nivelNatura;
    }

    public void setNivelNatura(int nivelNatura) {
        this.nivelNatura = nivelNatura;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
