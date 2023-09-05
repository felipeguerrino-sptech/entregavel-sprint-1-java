package school.sptech;

import java.util.List;

public class Usuario {

    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Sua senha foi alterada.");
    }

    public static Boolean autenticarUsuario(List<Usuario> listaUsuarios, String nome, String senha) {

        for (Usuario usuario :
                listaUsuarios) {
            String nomeUsuario = usuario.getNome();
            String senhaUsuario = usuario.getSenha();

            if (nomeUsuario.equals(nome) && senhaUsuario.equals(senha)) {
                return true;
            }

        }
        return false;
    }

    public static Integer getUsuarioId(List<Usuario> listaUsuarios, String nome, String senha) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario u = listaUsuarios.get(i);
            if(u.getNome().equals(nome) && u.getSenha().equals(senha)) {
                return i;
            }
        }
        return -1;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}
