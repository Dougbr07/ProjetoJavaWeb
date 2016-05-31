package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.Pessoa;
import DAO.JdbcPessoaDao;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/ServletCadastro"})
public class ServletCadastro extends HttpServlet {


 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       Pessoa novaPessoa = new Pessoa();
       novaPessoa.setNome(request.getParameter("nome"));
       novaPessoa.setCpf(request.getParameter("cpf"));
       novaPessoa.setUsuario(request.getParameter("usuario"));
       novaPessoa.setSenha(request.getParameter("senha"));
       novaPessoa.setRg(request.getParameter("rg"));
       novaPessoa.setEmail(request.getParameter("email"));
       novaPessoa.setEndereco(request.getParameter("endereco"));
        novaPessoa.setTelefone(request.getParameter("telefone"));
       
       JdbcPessoaDao pessoa = new JdbcPessoaDao();
       boolean validarCadastro = pessoa.insert(novaPessoa);
       int validar = 2;
       
       if(validarCadastro){
        RequestDispatcher r = request.getRequestDispatcher( "index.jsp" );
        request.setAttribute("pessoa", novaPessoa);
        r.forward( request, response );  
       }else{
        RequestDispatcher r = request.getRequestDispatcher( "index.jsp" );
        request.setAttribute("validar", validar);
        r.forward( request, response );
       
       
       }
        
    }



}
