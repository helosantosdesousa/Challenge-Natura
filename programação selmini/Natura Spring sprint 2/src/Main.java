import br.fiap.NaturaSpring.curtida.Curtida;
import br.fiap.NaturaSpring.post.Post;
import br.fiap.NaturaSpring.usuario.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        Usuario usuarios[] = new Usuario[2]; //aqui tem que fazer um controle pra adicionar um novo usuário kkkk... (vetor dinãmico?)
        Post posts[] = new Post[2];

        int resp = 0;
        do {
            System.out.println("---------- NATURA SPRING ----------");
            System.out.println("O que deseja fazer?");
            System.out.println("0 - Sair\n1 - Cadastrar usuário \n2 - Fazer post");
            resp = e.nextInt();

            switch (resp) {
                case 1:
                    for (int i = 0; i < usuarios.length; i++) {
                        System.out.println("Inserir nome de usuário");
                        String nomeUsuario = e.next();
                        System.out.println("Inserir data de nascimento");
                        String dataNasc = e.next();
                        System.out.println("Inserir nickname");
                        String nickname = e.next();
                        System.out.println("Inserir biografia");
                        String biografia = e.next();
                        System.out.println("Inserir nível natura");
                        int nivelNatura = e.nextInt();
                        System.out.println("Inserir CPF");
                        int cpf = e.nextInt();
                        System.out.println("Inserir e-mail");
                        String email = e.next();
                        System.out.println("Inserir telefone");
                        String telefone = e.next();

                        //criar um novo usuário
                        usuarios[i] = new Usuario(nomeUsuario, dataNasc, nickname, biografia, nivelNatura, cpf, email, telefone);
                    }
                    break;
                case 2:
                    for (int i = 0; i < posts.length; i++) {
                        System.out.println("Inserir o conteúdo do post (texto): ");
                        String conteudo = e.next();
                        posts[i] = new Post(conteudo);
                    }
                    break;

            }
        } while (resp != 0);
        // Curtida curtida = new Curtida();

        for (int i = 0; i < usuarios.length; i++) {
            System.out.println("nome de usuario: " + usuarios[i].getNomeUsuario());
            System.out.println("id do usuario: " + usuarios[i].getUsuarioId());
        }
        //for dev <3
    /*public static void printarUsuarios(Usuario usuarios[]){
        for (int i = 0; i < usuarios.length; i++) {
            System.out.println("nome de usuario: " + usuarios[i].getNomeUsuario());
            System.out.println("id do usuario: " + usuarios[i].getUsuarioId());
        }
    }*/
    }
}
