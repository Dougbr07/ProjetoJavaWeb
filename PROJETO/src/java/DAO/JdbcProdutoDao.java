/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysingleton.MySingleton;

/**
 *
 * @author Douglas
 */
public class JdbcProdutoDao implements ProdutoDao{
    Connection connection;

    public JdbcProdutoDao() {
        this.connection = MySingleton.getConnection();
    }
    
    
    public int numeroDeProdutos(){
    
    
    int num = 0;
            try{
        
            String sql = "SELECT COUNT (*) AS QTDE FROM products where status = true";
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
                
                num = rs.getInt("qtde");

  
            }
            return num;
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return num;
    
    
    
    }

    @Override
    public boolean insert(Produto produto) {
       
        try{
           
         String sql = "insert into products(description,price,centro,image_link, categories_id,status) values(?,?,?,?,?,true)";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, produto.getDescription());
         prep.setDouble(2, produto.getPrice());
         prep.setDouble(3, produto.getCentro());
         prep.setString(4, "images\\"+produto.getImage());
         prep.setInt(5, produto.getCategory());

         prep.executeUpdate();
         return true;


         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void remove(int id) {
        
         try{

       
         String sql = "update products set status = false where id = ?";
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setInt(1, id);
         prep.executeUpdate();

         }catch(SQLException e){
                 System.out.println("Oops! Ocorreu um erro inesperado!" + e);
         }
        
        
    }

    @Override
    public ArrayList<Produto> list() {
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try{
        
            String sql = "select * from products where status = true";
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
        
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescription(rs.getString("description"));
                produto.setPrice(rs.getDouble("price"));
                produto.setCentro(rs.getDouble("centro"));
                produto.setImage(rs.getString("image_link"));
                produto.setCategory(rs.getInt("categories_id"));
                produtos.add(produto);

            }
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return produtos;
        
    }

    @Override
    public Produto search(int id) {
        
        Produto produto = new Produto();   
     
            try{
        
            String sql = "select * from products where id = ?";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
                produto.setId(rs.getInt("id"));
                produto.setDescription(rs.getString("description"));
                produto.setCentro(rs.getDouble("centro"));
                produto.setPrice(rs.getDouble("price"));
                produto.setImage(rs.getString("image_link"));
                produto.setCategory(rs.getInt("categories_id"));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return produto;
        
        
    }

    @Override
    public void edit(Produto produto) {
        
         try{

         String sql = "update products set description = ?, price = ?, centro = ?, image_link = ?, categories_id = ? where id = ?";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, produto.getDescription());
         prep.setDouble(2, produto.getPrice());
         prep.setDouble(3, produto.getCentro());
         prep.setString(4, "images\\"+produto.getImage());
         prep.setInt(5, produto.getCategory());
         prep.setInt(6, produto.getId());
         
        int update = prep.executeUpdate();
         
         if(update <= 0){
             throw new Exception("Nenhum dado foi inserido !!!");
         }else{
             prep.close();
             prep = null;
         }

         }catch(SQLException e){
                 System.out.println("Oops! Ocorreu um erro inesperado!" + e);
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
