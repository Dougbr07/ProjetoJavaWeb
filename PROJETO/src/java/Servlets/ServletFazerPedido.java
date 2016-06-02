/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.Pedido;
import Bean.Produto;
import DAO.JdbcPedidoDao;
import DAO.JdbcProdutoDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "ServletFazerPedido", urlPatterns = {"/ServletFazerPedido"})
public class ServletFazerPedido extends HttpServlet {

    

   
  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JdbcProdutoDao p = new JdbcProdutoDao();
        ArrayList<Produto> produtos = new ArrayList();
        Pedido pedido = new Pedido();
        int numeroProdutos = p.numeroDeProdutos();
        double totalPedido = 0;
        
        for(int i = 1 ; i <= numeroProdutos ; i++){
            String idCount = "idCont"+i;
            String idProduto = request.getParameter(idCount);
            
                if(!(request.getParameter(idProduto).equals("0"))){
               
                
                Produto procurarProduto = new Produto();
                JdbcProdutoDao p1 = new JdbcProdutoDao();
                procurarProduto =  p1.search(Integer.parseInt(idProduto));
                String qtdProduto = request.getParameter(idProduto);
                double valorUni = procurarProduto.getPrice();
                double valorCentro = procurarProduto.getCentro();
                
                if(qtdProduto.length() > 2){
                
                      String valorQuebrado[];
                      valorQuebrado = qtdProduto.split("");
                      String unidades;
                      String centro = "";
                    
                      unidades = valorQuebrado[valorQuebrado.length-2] + valorQuebrado[valorQuebrado.length-1];
                      
                     
                      for(int a =0; a <= valorQuebrado.length-3;a++){

                      centro += valorQuebrado[a];

                      }
                      
                      totalPedido = (Integer.parseInt(unidades)*valorUni) + (Integer.parseInt(centro)*valorCentro);
                    
                
                }else{

                    totalPedido += Integer.parseInt(qtdProduto)*valorUni;

                }
                
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(idProduto));
                produto.setAmount(Integer.parseInt(qtdProduto));                
                produtos.add(produto);
                                
                }   

        }
        
        
        pedido.setId_cliente(Integer.parseInt(request.getParameter("idCliente")));
        pedido.setPreco(totalPedido);
        JdbcPedidoDao pedidoDao = new JdbcPedidoDao();
        pedidoDao.insert(pedido, produtos);
        
        
        RequestDispatcher r = request.getRequestDispatcher( "inicialCliente.jsp" );
        request.setAttribute("validarPedido", totalPedido);
        r.forward( request, response );  
        
        
    }

 
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
