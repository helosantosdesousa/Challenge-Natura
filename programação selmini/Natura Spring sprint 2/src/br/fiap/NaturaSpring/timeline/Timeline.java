package br.fiap.NaturaSpring.timeline;

import br.fiap.NaturaSpring.comentario.Comentario;
import br.fiap.NaturaSpring.post.Post;
import br.fiap.NaturaSpring.usuario.Usuario;
import br.fiap.NaturaSpring.usuario.UsuarioAtual;

import java.util.ArrayList;
import java.util.List;

public class Timeline {
    List<Usuario> usuarios = new ArrayList<>();
    List<Post> posts = new ArrayList<>();
    private List<Comentario> comentarios;

    public void exibePost(List<Post> posts) {
        for (Post p : posts) {
            System.out.println("@" + p.getUsuario().getNomeUsuario());
            System.out.println(p.getConteudoPost());
            exibeComentarios(p);
        }
    }


    public void exibeComentarios(Post post) {
        System.out.println("------------- COMENTÁRIOS ----------------");
        if (post.getComentarios().isEmpty()) {
            System.out.println("Sem comentários.");
        } else {
            for (Comentario c : post.getComentarios()) {
                System.out.println("@" + c.getUsuario().getNomeUsuario() + ": " + c.getConteudoComentario());
            }
        }
        System.out.println("-----------------------------------------------");
    }




 /*   public void exibeComentarios(Post post) {
        for (Comentario c : comentarios) {
            System.out.println("------------- COMENTÁRIOS ----------------");
            if (c.getPost().equals(post)) {
                System.out.println("@" + c.getUsuario().getNomeUsuario() + ": " + c.getConteudoComentario());
            }
        }
        System.out.println("-----------------------------------------------");
    }*/


    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comentario> getComentarios() {
        List<Comentario> comentarios = null;
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
