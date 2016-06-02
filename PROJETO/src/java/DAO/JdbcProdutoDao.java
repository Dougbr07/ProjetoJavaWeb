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
        
            String sql = "SELECT COUNT (*) AS QTDE FROM products";
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
           
         String sql = "insert into products(description,price,centro,amount, image_link, categories_id) values(?,?,?,?,?,?)";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, produto.getDescription());
         prep.setDouble(2, produto.getPrice());
         prep.setDouble(3, produto.getCentro());
         prep.setDouble(4, produto.getAmount());
         prep.setString(5, produto.getImage());
         prep.setInt(6, produto.getCategory());

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

       
         String sql = "delete from products where id_pessoa = ?";
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setInt(1, id);
         prep.executeUpdate();

         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         }
        
        
    }

    @Override
    public ArrayList<Produto> list() {
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try{
        
            String sql = "select * from products";
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
        
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescription(rs.getString("description"));
                produto.setPrice(rs.getDouble("price"));
                produto.setCentro(rs.getDouble("centro"));
                produto.setAmount(rs.getInt("amount"));
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
                
                produto.setDescription(rs.getString("description"));
                produto.setCentro(rs.getDouble("price"));
                produto.setPrice(rs.getDouble("centro"));
                produto.setAmount(rs.getInt("amount"));
                produto.setImage(rs.getString("image_link"));
  
            }
            return produto;
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return produto;
        
        
    }

    @Override
    public void edit(Produto produti) {
        
         try{

         String sql = "update products set description = ?, price = ?, centro = ?, amount = ?, image_link = ?, categories_id = ? where id_produto = ?";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, null);

         int update = prep.executeUpdate();
         
         if(update <= 0){
             throw new Exception("Nenhum dado foi inserido !!!");
         }else{
             prep.close();
             prep = null;
         }

         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
