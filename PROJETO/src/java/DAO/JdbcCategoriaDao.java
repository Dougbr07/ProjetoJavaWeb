package DAO;

import Bean.Categoria;
import Bean.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mysingleton.MySingleton;

public class JdbcCategoriaDao implements CategoriaDao {

    Connection connection;

    public JdbcCategoriaDao() {
        this.connection = MySingleton.getConnection();
    }

    @Override
    public int insert(Categoria categoria) {
        try {

            String sql = "insert into categories(name) values(?)";

            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, categoria.getName());
            prep.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Oops! Ocorreu um erro inesperado!" + e);
        }
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public ArrayList<Categoria> list() {
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {

            String sql = "select * from categories";
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setName(rs.getString("name"));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }

        return categorias;
    }

    @Override
    public Pedido search(int id) {
        return null;
    }

    public Categoria search(String name) {
        Categoria categoria = new Categoria();
        try {
            String sql = "select * from categories where name like ? ";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, name);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                categoria.setId(rs.getInt("id"));
                categoria.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }
        return categoria;
    }

    @Override
    public void edit(Categoria categoria) {

    }

    public void validaCadastro(String name) {

        try {
            String sql = "select * from categories where name like ? ";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, name);
            ResultSet rs = prep.executeQuery();

            if (!rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setName(name);
                JdbcCategoriaDao jdbccategoria = new JdbcCategoriaDao();
                jdbccategoria.insert(categoria);
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }
    }

}
