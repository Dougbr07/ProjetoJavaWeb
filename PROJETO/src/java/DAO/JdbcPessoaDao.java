
package DAO;

import Bean.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysingleton.MySingleton;


public class JdbcPessoaDao implements PessoaDao{
    Connection connection;
    
    public JdbcPessoaDao(){
    this.connection = MySingleton.getConnection();
    }
    
    public boolean validarCadastroLogin(Pessoa pessoa){
    
    try{
        
            String sql = "select * from customers where user_login = ?";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, pessoa.getUsuario());
            ResultSet rs = prep.executeQuery();
           
            if(rs.next()){
            
                return true;
            
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return false;
    
    }
    
    @Override
    public boolean insert(Pessoa pessoa){
    
       if(!(validarCadastroLogin(pessoa))){ 
       try{
           
         String sql = "insert into customers(fullname,cpf,user_login,password,endereco,rg,email,user_nivel,telefone) values(?,?,?,?,?,?,?,0,?)";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, pessoa.getNome());
         prep.setString(2, pessoa.getCpf());
         prep.setString(3, pessoa.getUsuario());
         prep.setString(4, pessoa.getSenha());
         prep.setString(5, pessoa.getEndereco());
         prep.setString(6, pessoa.getRg());
         prep.setString(7, pessoa.getEmail());
         prep.setString(8, pessoa.getTelefone());
         prep.executeUpdate();
         return true;


         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
     return false;  
    }
    
    @Override
    public void edit(Pessoa pessoa){
     
      try{

         String sql = "update customers set fullname = ?, cpf = ?, user_login = ?, password = ?, endereco = ?, email = ?, telefone = ?, rg = ? where id = ?";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, pessoa.getNome());
         prep.setString(2, pessoa.getCpf());
         prep.setString(3, pessoa.getUsuario());
         prep.setString(4, pessoa.getSenha());
         prep.setString(5, pessoa.getEndereco());
         prep.setString(6, pessoa.getEmail());
         prep.setString(7, pessoa.getTelefone());
         prep.setString(8, pessoa.getRg());
         prep.setString(8, pessoa.getId());
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
    
    @Override
    public void remove(int id){
      try{

       
         String sql = "delete from customers where id = ?";
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setInt(1, id);
         prep.executeUpdate();

         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         }
        
    
    
    }
    
    @Override
    public List<Pessoa> list(){
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try{
        
            String sql = "select * from customers";
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
        
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("fullname"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFoto(rs.getString("image_link"));
                pessoa.setUsuario(rs.getString("usuario"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoas.add(pessoa);

            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return pessoas;
    }
    
    @Override
    public Pessoa search(int id){
    
            Pessoa pessoa = new Pessoa();   
     
            try{
        
            String sql = "select * from customers where id = ?";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
                
                pessoa.setNome(rs.getString("fullname"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFoto(rs.getString("image_link"));
                pessoa.setUsuario(rs.getString("user_login"));
                pessoa.setSenha(rs.getString("password"));
                pessoa.setTelefone(rs.getString("telefone"));

            }
            return pessoa;
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return pessoa;
    
    
    }
    
    public boolean validar(Pessoa pessoa){

    try{
           
         String sql = "select * from customers where user_login = ? and password = ?";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, pessoa.getUsuario());
         prep.setString(2, pessoa.getSenha());
         ResultSet rs = prep.executeQuery();
         
         if(rs.next()){
         
             return true;
             
         }

         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return false;
        
    }
    
    
    
}
