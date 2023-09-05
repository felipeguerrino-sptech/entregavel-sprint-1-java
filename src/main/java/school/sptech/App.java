package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerOpc = new Scanner(System.in);
        List<Usuario> listaUsuarios =  new ArrayList<>() {{
            add(new Usuario("admin", "123"));
            add(new Usuario("felipe.guerrino", "#Gf1234567890"));
            add(new Usuario("jp.santos", "#JP123980713"));
            add(new Usuario("marcelo.rocha", "@marceloRocha"));
            add(new Usuario("bruno.fernandes", "FerNand3sBrun0"));
        }};

        String nome, senha;

        Boolean sair = false;
        Boolean isAutenticado = false;
        Usuario usuarioAtual = new Usuario("", "");
        Integer usuarioAtualId = -1;

        do {

            while(!isAutenticado) {
                System.out.println("Faça login:");

                System.out.print("Nome: ");
                nome = scanner.nextLine();
                System.out.print("Senha: ");
                senha = scanner.nextLine();

                if(Usuario.autenticarUsuario(listaUsuarios, nome, senha)) {
                    System.out.println("Logado com sucesso!");
                    isAutenticado = true;
                    usuarioAtualId = Usuario.getUsuarioId(listaUsuarios, nome, senha);
                    usuarioAtual = listaUsuarios.get(usuarioAtualId);
                }
            }


            System.out.printf("""
                    Olá %s!
                    
                    O que deseja fazer?
                    
                    1 - Mudar senha
                    2 - Trocar de usuário
                    3 - Adicionar novo usuário
                    0 - Sair
                    
                    """, usuarioAtual.getNome());

            Integer opcao = scannerOpc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Mudar senha");
                    System.out.println("Digite sua nova senha:");
                    String novaSenha = scanner.nextLine();
                    System.out.println("Confirme a senha:");
                    String novaSenha2 = scanner.nextLine();

                    if(novaSenha.equals(novaSenha2)) {
                        listaUsuarios.remove(usuarioAtual);
                        usuarioAtual.alterarSenha(novaSenha);
                        listaUsuarios.add(usuarioAtualId, usuarioAtual);
                    }
                    break;
                case 2:
                    System.out.println("Trocar de usuário");
                    isAutenticado = false;
                    break;
                case 3:
                    System.out.println("Adicionar novo usuário");
                    System.out.print("Nome de usuário: ");
                    String nomeNovoUsario = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaNovoUsuario = scanner.nextLine();
                    System.out.print("Confirme a senha: ");
                    String senhaNovoUsuario2 = scanner.nextLine();

                    if(senhaNovoUsuario.equals(senhaNovoUsuario2)) {
                        listaUsuarios.add(new Usuario(nomeNovoUsario, senhaNovoUsuario));
                        System.out.printf("Usuário %s adicionado!\n", nomeNovoUsario);
                    }
                    continue;
                case 0:
                    sair = true;
                    break;
            }

        } while(!sair);
    }
}