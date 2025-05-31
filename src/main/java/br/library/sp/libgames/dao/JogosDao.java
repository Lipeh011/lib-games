package br.library.sp.libgames.dao;
import br.library.sp.libgames.enumeration.Plataforma;
import br.library.sp.libgames.enumeration.Status;
import br.library.sp.libgames.model.Jogos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogosDao implements InterfaceDao<Jogos>{
    private Connection conexao;
    private String sql;
    private PreparedStatement stmt;

    public JogosDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Jogos objeto) throws SQLException {
        sql = "insert into jogos (nome, plataforma, genero, nota, desenvolvedora, `status`) values (?, ?, ?, ?, ?, ?)";

        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, objeto.getNome());
        stmt.setInt(2, objeto.getPlataforma().ordinal());
        stmt.setString(3, objeto.getGenero());
        stmt.setDouble(4, objeto.getNota());
        stmt.setString(5, objeto.getDesenvolvedora());
        stmt.setInt(6, objeto.getStatus().ordinal());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void alterar(Jogos objeto) throws SQLException {
        sql = "UPDATE jogos SET nome = ?, plataforma = ?, genero = ?, nota = ?, desenvolvedora = ?, status = ? WHERE id = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, objeto.getNome());
        stmt.setInt(2, objeto.getPlataforma().ordinal());
        stmt.setString(3, objeto.getGenero());
        stmt.setDouble(4, objeto.getNota());
        stmt.setString(5, objeto.getDesenvolvedora());
        stmt.setInt(6, objeto.getStatus().ordinal());
        stmt.setInt(7, objeto.getID());
        stmt.execute();
        stmt.close();
    }

    @Override
    public void excluir(int id) throws SQLException {
        sql = "delete from jogos where id = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }

    @Override
    public List<Jogos> listar() throws SQLException {
        sql = "SELECT * FROM jogos ORDER BY nome";
        stmt = conexao.prepareStatement(sql);
        List<Jogos> jogos = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Jogos jogo = new Jogos();
            jogo.setID(rs.getInt("id"));
            jogo.setNome(rs.getString("nome"));
            jogo.setPlataforma(Plataforma.values()[rs.getInt("plataforma")]);
            jogo.setGenero(rs.getString("genero"));
            jogo.setNota(rs.getDouble("nota"));
            jogo.setDesenvolvedora(rs.getString("desenvolvedora"));
            jogo.setStatus(Status.values()[rs.getInt("status")]);
            jogos.add(jogo);
        }
        rs.close();
        stmt.close();
        return jogos;
    }

    @Override
    public Jogos buscar(int id) throws SQLException {
        sql = "SELECT * FROM jogos WHERE id = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Jogos jogo = new Jogos();
            jogo.setID(rs.getInt("id"));
            jogo.setNome(rs.getString("nome"));
            jogo.setPlataforma(Plataforma.values()[rs.getInt("plataforma")]);
            jogo.setGenero(rs.getString("genero"));
            jogo.setNota(rs.getDouble("nota"));
            jogo.setDesenvolvedora(rs.getString("desenvolvedora"));
            jogo.setStatus(Status.values()[rs.getInt("status")]);
            rs.close();
            stmt.close();
            return jogo;
        }

        rs.close();
        stmt.close();
        return null;
    }
}
