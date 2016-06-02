package DAO;

import Bean.Pedido;
import Bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysingleton.MySingleton;

public class JdbcPedidoDao implements PedidoDao{
    Connection connection;

    public JdbcPedidoDao() {
    this.connection = MySingleton.getConnection();
    }

    
    
    
    public int idOrder(){
      
     
    int pedido = 0;
            try{
        
            String sql = "select * from orders where id = (SELECT MAX(id) FROM orders)";
            PreparedStatement prep = connection.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
                
                pedido = rs.getInt("id");

  
            }
            return pedido;
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return pedido;
    
    
    
    
    }
    
   
    public int insert(Pedido pedido, ArrayList<Produto> produtos) {
        
        
         try{
           
         String sql = "insert into orders(datehour, total, customers_id) values(CURRENT_DATE,?,?)";
         
         PreparedStatement prep = connection.prepareStatement(sql);
         prep.setDouble(1, pedido.getPreco());
         prep.setInt(2, pedido.getId_cliente());
         prep.executeUpdate();
         
             insertProdutos(produtos);

         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
        
    }
    
    
    public void insertProdutos(ArrayList<Produto> produtos) {
    
     try{

         int idPedido = idOrder();
         for(Produto element : produtos){
         
         String sql2 = "insert into items(products_id, orders_id, quantity) values(?,?,?)";
         PreparedStatement prep = connection.prepareStatement(sql2);
         prep.setDouble(1, element.getId());
         prep.setInt(2, idPedido);
         prep.setInt(3, element.getAmount());
         prep.executeUpdate();
         
         }


         }catch(SQLException e){
                e.printStackTrace();
                 System.out.println("Oops! Ocorreu um erro inesperado!");
         } catch (Exception ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> list(int id) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        try{
        
            String sql = "select * from orders where customers_id = ?";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setDouble(1, id);
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
        
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id"));
                pedido.setDatahour(rs.getString("datehour"));
                pedido.setPreco(rs.getDouble("total"));

                pedidos.add(pedido);

            }
        
        } catch (SQLException ex) {
            Logger.getLogger(JdbcPessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return pedidos;
    }

    @Override
    public Pedido search(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Pedido pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
