package planner.etapa1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlocoDAO {

    public static boolean cadastrar(BlocoDeNotas b) throws SQLException {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "INSERT INTO Bloco_de_Notas(titulo, corpo, dataEscrito) VALUES(?, ?, ?);";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, b.getTitulo());
            query.setString(2, b.getCorpo());
            query.setString(3, b.getDataEscrito());

            query.execute();

            conexao.desconectar();
            return true;
        } catch (SQLException se) {
            System.out.println(se);
            return false;
        }
    }

    public static List<BlocoDeNotas> listar() {
        List<BlocoDeNotas> lista = new ArrayList<BlocoDeNotas>();

        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "select * from Bloco_de_Notas;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                BlocoDeNotas b = new BlocoDeNotas();

                b.setId(resposta.getInt("id"));
                b.setTitulo(resposta.getString("titulo"));
                b.setCorpo(resposta.getString("corpo"));
                b.setDataEscrito(resposta.getString("dataEscrito"));

                lista.add(b);
            }
            conexao.desconectar();
        } catch (SQLException se) {

        }
        return lista;
    }

    public static boolean atualizar(BlocoDeNotas b) {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "update Bloco_de_Notas set titulo=?, corpo=?, dataEscrito=? where id=?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            consulta.setString(1, b.getTitulo());
            consulta.setString(2, b.getCorpo());
            consulta.setString(3, b.getDataEscrito());

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

            String sql = "DELETE FROM Bloco_de_Notas WHERE id = ?;";

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
