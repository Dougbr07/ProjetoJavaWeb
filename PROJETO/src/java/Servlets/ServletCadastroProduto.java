/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.Produto;
import DAO.JdbcProdutoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "ServletCadastroProduto", urlPatterns = {"/ServletCadastroProduto"})
public class ServletCadastroProduto extends HttpServlet {

  

 
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
       Produto novoProduto = new Produto();
       novoProduto.setDescription(request.getParameter("descricao"));
       novoProduto.setPrice(Double.parseDouble(request.getParameter("precoproduto")));
       novoProduto.setCentro(Double.parseDouble(request.getParameter("precocentro")));
       novoProduto.setAmount(Integer.parseInt(request.getParameter("quatidade")));
       novoProduto.setImage(request.getParameter("fotoproduto"));
      
       if(request.getParameter("categoriaproduto").equals("Doce")){
            novoProduto.setCategory(1);
       }else{
            novoProduto.setCategory(2);
       }
       
      

       
       JdbcProdutoDao produto = new JdbcProdutoDao();
       produto.insert(novoProduto);
       
       response.sendRedirect("inicialAdm.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
