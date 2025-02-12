package planner.etapa1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LembretesDAO {

    public static boolean cadastrar(Lembretes l) throws SQLException {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "INSERT INTO Lembretes(titulo, descricao, data) VALUES(?, ?, ?);";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, l.getTitulo());
            query.setString(2, l.getDescricao());
            query.setString(3, l.getData());

            query.execute();

            conexao.desconectar();
            return true;
        } catch (SQLException se) {
            System.out.println(se);
            return false;
        }
    }

    public static List<Lembretes> listar() {
        List<Lembretes> lista = new ArrayList<Lembretes>();

        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "select * from Lembretes;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                Lembretes l = new Lembretes();

                l.setId(resposta.getInt("id"));
                l.setTitulo(resposta.getString("titulo"));
                l.setDescricao(resposta.getString("descricao"));
                l.setData(resposta.getString("data"));

                lista.add(l);
            }
            conexao.desconectar();
        } catch (SQLException se) {

        }
        return lista;
    }

    public static boolean atualizar(Lembretes l) {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "update Contatos set titulo=?, descricao=?, data=? where id=?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            consulta.setString(1, l.getTitulo());
            consulta.setString(2, l.getDescricao());
            consulta.setString(3, l.getData());

            consulta.execute();
            conexao.desconectar();
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

    public static boolean excluir(int id) {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "DELETE FROM Lembretes WHERE id = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            consulta.setInt(1, id);

            consulta.execute();

            conexao.desconectar();
            return true;
        } catch (SQLException se) {
            return false;
        }
    }

}
