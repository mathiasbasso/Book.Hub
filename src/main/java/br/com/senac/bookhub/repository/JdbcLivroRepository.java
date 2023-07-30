package br.com.senac.bookhub.repository;

import br.com.senac.bookhub.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
public class JdbcLivroRepository implements LivroRepository {
    private Connection conexao;

    public JdbcLivroRepository() {


        String url = "jdbc:mysql://localhost:3306/biblioteca_fx";
        String usuario = "root";
        String senha = "root";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM livro");

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                livro.setAutor(rs.getString("autor"));
                livro.setPreco(rs.getDouble("preco"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    @Override
    public void adicionarLivro(Livro livro) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO livro (nome_livro, autor, preco) VALUES (?, ?, ?)");
            pstmt.setString(1, livro.getNomeLivro());
            pstmt.setString(2, livro.getAutor());
            pstmt.setDouble(3, livro.getPreco());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarLivro(Livro livro) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE livro SET nome_livro = ?, autor = ?, preco = ? WHERE id = ?");
            pstmt.setString(1, livro.getNomeLivro());
            pstmt.setString(2, livro.getAutor());
            pstmt.setDouble(3, livro.getPreco());
            pstmt.setInt(4, livro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirLivro(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("DELETE FROM livro WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Livro> pesquisarLivro(String termo) {
        List<Livro> livros = new ArrayList<>();

        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM livro WHERE nome_livro LIKE ?");
            pstmt.setString(1, "%" + termo + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNomeLivro(rs.getString("nome_livro"));
                livro.setAutor(rs.getString("autor"));
                livro.setPreco(rs.getDouble("preco"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }
}

