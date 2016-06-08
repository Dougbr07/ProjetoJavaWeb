
package DAO;

import Bean.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
           
         String sql = "insert into customers(fullname,cpf,user_login,password,endereco,rg,email,user_nivel,telefone,image_link) values(?,?,?,?,?,?,?,0,?,?)";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, pessoa.getNome());
         prep.setString(2, pessoa.getCpf());
         prep.setString(3, pessoa.getUsuario());
         prep.setString(4, pessoa.getSenha());
         prep.setString(5, pessoa.getEndereco());
         prep.setString(6, pessoa.getRg());
         prep.setString(7, pessoa.getEmail());
         prep.setString(8, pessoa.getTelefone());
         prep.setString(9, "images\\"+pessoa.getFoto());
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

         String sql = "update customers set fullname = ?, cpf = ?, user_login = ?, password = ?, endereco = ?, email = ?, telefone = ?, rg = ?, image_link = ? where id = ? ";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setString(1, pessoa.getNome());
         prep.setString(2, pessoa.getCpf());
         prep.setString(3, pessoa.getUsuario());
         prep.setString(4, pessoa.getSenha());
         prep.setString(5, pessoa.getEndereco());
         prep.setString(6, pessoa.getEmail());
         prep.setString(7, pessoa.getTelefone());
         prep.setString(8, pessoa.getRg());
         prep.setString(9, "images\\"+pessoa.getFoto());
         prep.setInt(10, pessoa.getId());
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
    public ArrayList<Pessoa> list(){
        
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        
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
                pessoa.setUsuario(rs.getString("user_login"));
                pessoa.setSenha(rs.getString("password"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setUser_nivel(rs.getInt("user_nivel"));
                pessoas.add(pessoa);

            }
        
        
        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
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
                
                pessoa.setId(rs.getInt("id"));
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
    
    public Pessoa validar(Pessoa pessoa){
        Pessoa pessoa1 = new Pessoa();
        try{
           
            String sql = "select * from customers where user_login = ? and password = ?";

            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, pessoa.getUsuario());
            prep.setString(2, pessoa.getSenha());
            ResultSet rs = prep.executeQuery();

            if(rs.next()){
                pessoa1.setUsuario(rs.getString("fullname"));
                pessoa1.setId(rs.getInt("id"));
                pessoa1.setUser_nivel(rs.getInt("user_nivel"));
                return pessoa1;
            }

            }catch(SQLException e){
                   e.printStackTrace();
                    System.out.println("Oops! Ocorreu um erro inesperado!");
            } catch (Exception ex) {
               Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        return pessoa1;
        
    }
    
    
    
}
