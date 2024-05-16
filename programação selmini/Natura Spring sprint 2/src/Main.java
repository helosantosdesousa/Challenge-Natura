import br.fiap.NaturaSpring.curtida.Curtida;
import br.fiap.NaturaSpring.post.Post;
import br.fiap.NaturaSpring.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//tem que fazer verificacoes pra ver se os dados de entrada sao validos!!!
//perfumaria: colocar login e senha na hora de fazer post (só se der tempo)
public class Main {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        List<Post> posts = new ArrayList<>();

       /* Usuario usuarios[] = new Usuario[2]; //aqui tem que fazer um controle pra adicionar um novo usuário kkkk... (vetor dinãmico?)
        Post posts[] = new Post[2];*/

        int resp = 0;
        do {
            System.out.println("---------- NATURA SPRING ----------");
            System.out.println("O que deseja fazer?");
            System.out.println("0 - Sair\n1 - Cadastrar usuário \n2 - Fazer post\n3 - Visualizar timeline");
            resp = e.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("Inserir nome de usuário");
                    String nomeUsuario = e.next();
                    e.nextLine();
                    System.out.println("Inserir data de nascimento");
                    String dataNasc = e.next();
                    e.nextLine();
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
                    String email = e.next();
                    System.out.println("Inserir telefone");
                    String telefone = e.next();

                    //criar um novo usuário

                    Usuario usuario = new Usuario(nomeUsuario, dataNasc, nickname, biografia, nivelNatura, cpf, email, telefone);
                    usuarios.add(usuario);

                    break;
                case 2:
                    System.out.println("Inserir o nome de usuário em que o post vai ser feito");
                    String pesquisa = e.next();
                    e.nextLine();

                    //procurar usuario no array de usuarios
                    Usuario usuarioEncontrado = null;
                    for (Usuario u : usuarios) {
                        if (pesquisa.equals(u.getNomeUsuario())) {
                            usuarioEncontrado = u;

                            if (usuarioEncontrado != null) {
                                System.out.println("Inserir conteúdo do post");
                                String conteudo = e.nextLine();
                                Post post = new Post(conteudo, usuarioEncontrado);
                                posts.add(post);
                            } else {
                                System.out.println("Usuário não encontrado.");
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println("---------- TIMELINE -------------");
            }
        } while (resp != 0);

                    /*for (int i = 0; i < usuarios.length; i++) {
                        System.out.println("nome de usuario: " + usuarios[i].getNomeUsuario());
                        System.out.println("id do usuario: " + usuarios[i].getUsuarioId());
                    }*/
        for (Post p : posts) {
            System.out.println("conteúdo: " + p.getConteudoPost());
            System.out.println("autor: " + p.getUsuario().getNomeUsuario());
        }

    }


}

// Curtida curtida = new Curtida();


//for dev <3
    /*public static void printarUsuarios(Usuario usuarios[]){
        for (int i = 0; i < usuarios.length; i++) {
            System.out.println("nome de usuario: " + usuarios[i].getNomeUsuario());
            System.out.println("id do usuario: " + usuarios[i].getUsuarioId());
        }
    }*/

