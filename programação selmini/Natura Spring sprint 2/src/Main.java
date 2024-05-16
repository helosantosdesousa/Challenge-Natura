import br.fiap.NaturaSpring.comentario.Comentario;
import br.fiap.NaturaSpring.curtida.Curtida;
import br.fiap.NaturaSpring.post.Post;
import br.fiap.NaturaSpring.usuario.Usuario;
import br.fiap.NaturaSpring.usuario.UsuarioAtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        List<Comentario> comentarios = new ArrayList<>();
        UsuarioAtual usuarioAtual = null;

        boolean logado = false;
        String resposta;
        int resp = 0;
        do {
            System.out.println("---------- NATURA SPRING ----------");
            System.out.println("O que deseja fazer?");
            System.out.println("0 - SAIR\n1 - Criar conta\n2 - Logar em uma conta\n3 - Fazer post\n4 - Visualizar timeline" +
                    "\n5 - Seguir um usuário\n6 - Deixar de seguir algum usuário\n7 - DESLOGAR" +
                    "\n10 - user atual");
            resp = e.nextInt();
            e.nextLine();

            switch (resp) {
                case 1:
                    System.out.println("Inserir nome de usuário");
                    String nomeUsuario = e.nextLine();
                    System.out.println("Inserir data de nascimento");
                    String dataNasc = e.nextLine();
                    System.out.println("Inserir nickname");
                    String nickname = e.nextLine();
                    System.out.println("Inserir biografia");
                    String biografia = e.nextLine();
                    System.out.println("Inserir nível natura");
                    int nivelNatura = e.nextInt();
                    e.nextLine();
                    System.out.println("Inserir CPF");
                    int cpf = e.nextInt();
                    e.nextLine();
                    System.out.println("Inserir e-mail");
                    String email = e.nextLine();
                    System.out.println("Inserir telefone");
                    String telefone = e.nextLine();
                    System.out.println("Inserir senha");
                    String senha = e.nextLine();

                    // Criar um novo usuário
                    Usuario usuario = new Usuario(nomeUsuario, dataNasc, nickname, biografia, nivelNatura, cpf, email, telefone, senha);
                    usuarios.add(usuario);
                    break;

                // Logar em alguma conta
                case 2:
                    System.out.println("Nome de usuário: ");
                    nomeUsuario = e.nextLine();
                    System.out.println("Senha: ");
                    senha = e.nextLine();

                    for (Usuario u : usuarios) {
                        if (nomeUsuario.equals(u.getNomeUsuario()) && senha.equals(u.getSenha())) {
                            System.out.println("Logou!");
                            logado = true;
                            usuarioAtual = new UsuarioAtual(u.getNomeUsuario(), u.getDataNasc(), u.getNickname(), u.getBiografia(),
                                    u.getNivelNatura(), u.getUsuarioId(), u.getEmail(), u.getTelefone(), u.getSenha());
                            break;
                        }
                    }
                    if (!logado) {
                        System.out.println("Senha incorreta ou usuário inexistente!");
                    }
                    break;

                // Fazer um post
                case 3:
                    if (verificaLogin(logado)) {
                        System.out.println("Inserir o conteúdo do post");
                        String conteudo = e.nextLine();
                        Post post = new Post(conteudo, usuarioAtual);
                        posts.add(post);
                        System.out.println("Post criado com sucesso!");
                    }

                    break;

                case 4:
                    if (verificaLogin(logado)) {
                        System.out.println("---------- TIMELINE -------------");
                        System.out.println("Você está logado como: " + usuarioAtual.getNomeUsuario());
                        for (Post p : posts) {
                            System.out.println("@" + p.getUsuario().getNomeUsuario());
                            System.out.println(p.getConteudoPost());
                            System.out.println("Curtidas: " + p.getQtdLike());

                            System.out.println("Deseja curtir o post? s/n");
                            char r = e.next().charAt(0);
                            e.nextLine();

                            if (r == 's') {
                                p.setQtdLike(p.getQtdLike() + 1);
                            }
                            System.out.println("Curtidas: " + p.getQtdLike());

                            System.out.println("Deseja comentar no post? s/n");
                            r = e.next().charAt(0);
                            e.nextLine();
                            if (r == 's') {
                                System.out.println("Inserir comentário:");
                                String conteudoComentario = e.nextLine();
                                Comentario comentario = new Comentario(conteudoComentario, usuarioAtual, p );
                                comentarios.add(comentario);
                                System.out.println("Comentário adicionado com sucesso!");

                            }
                            //printar os comentários
                            for (Comentario c: comentarios) {
                                System.out.println("------------- COMENTÁRIOS ----------------");
                                System.out.println("@" + c.getUsuario().getNomeUsuario());
                                System.out.println(c.getConteudoComentario());
                                System.out.println("-----------------------------------------------");
                            }
                        }
                    }
                    break;
                case 5:
                    if (verificaLogin(logado)){
                        System.out.println("Insira o usuário que deseja seguir");
                        resposta = e.next();
                        e.nextLine();
                        for (Usuario u: usuarios ) {
                            if(resposta.equals(u.getNomeUsuario())){
                                u.setQdSeguidores(u.getQdSeguidores()+1);
                            }
                        }
                    }

                    break;
                case 6:
                    if (verificaLogin(logado)){
                        System.out.println("Insira o usuário que deseja deixar de seguir");
                        resposta = e.next();
                        e.nextLine();
                        for (Usuario u: usuarios ) {
                            if(resposta.equals(u.getNomeUsuario())){
                                u.setQdSeguidores(u.getQdSeguidores()-1);
                            }
                        }
                    }
                    break;
                case 7:
                    logado = false;
                    usuarioAtual = null;
                    System.out.println("deslogado com sucesso");
                    break;

                case 10:
                    if (usuarioAtual == null) {
                        System.out.println("Nenhum usuário logado.");
                    } else {
                        System.out.println("Usuário atual: " + usuarioAtual.getNomeUsuario());
                    }
                    break;
                default:
                    if (resp!=0){
                        System.out.println("Opção inválida.");
                    }
                    break;
            }
        } while (resp != 0);
    }
    public static boolean verificaLogin(boolean logado){
        if (!logado){
            System.out.println("Você deve estar logado para realizar esta ação");
            return false;
        }
        return true;
    }
}

