package planner.etapa1;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static boolean ValidarUsuario(Usuario user) {
        ResultSet resposta = null;

        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "SELECT * FROM Usuario WHERE login = ? AND senha = ?";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, user.getLogin());
            query.setString(2, user.getSenha());

            resposta = query.executeQuery();

            if (resposta.next()) {
                System.out.println("Usuário encontrado");

                Usuario usuarioEncontrado = new Usuario();
                usuarioEncontrado.setLogin(resposta.getString("login"));
                usuarioEncontrado.setSenha(resposta.getString("senha"));

                conexao.desconectar();
                return true;
            } else {
                System.out.println("Nenhum usuario encontrado");
            }

        } catch (SQLException se) {
            System.out.println(se);
            return false;
        }

        return false;
    }
}
