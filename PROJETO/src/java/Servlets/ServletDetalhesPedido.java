/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletDetalhesPedido", urlPatterns = {"/ServletDetalhesPedido"})
public class ServletDetalhesPedido extends HttpServlet {


   



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        int idPedido = Integer.parseInt(request.getParameter("idPedidoDetalhes"));
        
        RequestDispatcher r = request.getRequestDispatcher( "detalhesPedido.jsp" );
        request.setAttribute("id", idPedido);
        r.forward( request, response );  
       
        

        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
