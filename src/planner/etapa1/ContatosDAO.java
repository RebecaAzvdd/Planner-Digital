package planner.etapa1;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ContatosDAO {

    public static boolean cadastrar(Contatos c) throws SQLException {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "INSERT INTO Contatos(nome, telefone, email) VALUES(?, ?, ?);";
            PreparedStatement query = conexao.getConexao().prepareStatement(sql);
            query.setString(1, c.getNome());
            query.setString(2, c.getTelefone());
            query.setString(3, c.getEmail());

            query.execute();

            conexao.desconectar();
            return true;
        } catch (SQLException se) {
            System.out.println(se);
            return false;
        }
    }

    public static List<Contatos> listar(){
        List<Contatos> lista = new ArrayList<Contatos>();

        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();

            String sql = "select * from Contatos;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                Contatos c = new Contatos();

                c.setId(resposta.getInt("id"));
                c.setNome(resposta.getString("nome"));
                c.setTelefone(resposta.getString("telefone"));
                c.setEmail(resposta.getString("email"));

                lista.add(c);
            }
            conexao.desconectar();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return lista;
    }

    public static boolean atualizar(Contatos c) {
        try {
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            String sql = "update Contatos set nome=?, telefone=?, email=? where id=?;";
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, c.getNome());
            consulta.setString(2, c.getTelefone());
            consulta.setString(3, c.getEmail());
            
            consulta.execute();
            conexao.desconectar();
            return true;
        }catch(SQLException se){
            return false;
        }
    }
    public static boolean excluir(int id){
        try{
            ConexaoJDBC conexao = new ConexaoJDBC();
            conexao.conectar();
            
            String sql = "DELETE FROM Contatos WHERE id = ?;";
            
            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            consulta.setInt(1, id);

            consulta.execute();

            conexao.desconectar();
            return true;
        }catch(SQLException se){
            return false; 
        }
    }
}
