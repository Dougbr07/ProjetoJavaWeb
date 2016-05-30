/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.Pessoa;
import DAO.JdbcPessoaDao;
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
@WebServlet(name = "ServletEditarUsuario", urlPatterns = {"/ServletEditarUsuario"})
public class ServletEditarUsuario extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       Pessoa novaPessoa = new Pessoa();
       novaPessoa.setId(Integer.parseInt(request.getParameter("id")));
       novaPessoa.setNome(request.getParameter("nome"));
       novaPessoa.setCpf(request.getParameter("cpf"));
       novaPessoa.setUsuario(request.getParameter("usuario"));
       novaPessoa.setSenha(request.getParameter("senha"));
       novaPessoa.setRg(request.getParameter("rg"));
       novaPessoa.setEmail(request.getParameter("email"));
       novaPessoa.setEndereco(request.getParameter("endereco"));
        novaPessoa.setTelefone(request.getParameter("telefone"));
       
       JdbcPessoaDao pessoa = new JdbcPessoaDao();
       pessoa.edit(novaPessoa);
       

       response.sendRedirect("inicialCliente.jsp");
          
        
        
        
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
