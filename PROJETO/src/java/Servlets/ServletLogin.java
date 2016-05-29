package Servlets;

import Bean.Pessoa;
import DAO.JdbcPessoaDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       Pessoa novaPessoa = new Pessoa();
       novaPessoa.setUsuario(request.getParameter("usuario"));
       novaPessoa.setSenha(request.getParameter("senha"));
       
       JdbcPessoaDao pessoaDao = new JdbcPessoaDao();
       Pessoa pessoaLogada = new Pessoa();
       pessoaLogada = pessoaDao.validar(novaPessoa);
       int erro = 1;
        
       if(pessoaLogada.getUsuario() instanceof String){
       
            HttpSession session = request.getSession();
            session.setAttribute("usuario", pessoaLogada.getUsuario());
            session.setAttribute("id", pessoaLogada.getId());
            session.setAttribute("nivel", pessoaLogada.getUser_nivel());
            session.setMaxInactiveInterval(10*60);
            
            if(pessoaLogada.getUser_nivel() > 0){
                response.sendRedirect("incialAdm.jsp");
            }else{
                response.sendRedirect("inicialCliente.jsp");
            }

            
       }else{
       
            RequestDispatcher r = request.getRequestDispatcher( "index.jsp" );
            request.setAttribute("validar", erro);
            r.forward( request, response );  
       }
       
    }

  
 

}
