package Servlets;

import Bean.Produto;
import DAO.JdbcProdutoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletEditarProduto", urlPatterns = {"/servletEditarProduto"})
public class servletEditarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JdbcProdutoDao jdbcprodutodao = new JdbcProdutoDao();
        Produto produto = jdbcprodutodao.search(Integer.parseInt(request.getParameter("id")));

        request.setAttribute("p", produto);
        RequestDispatcher r = request.getRequestDispatcher("editarProduto.jsp");
        r.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(request.getParameter("id")));
        produto.setDescription(request.getParameter("descricao"));
        produto.setPrice(Double.parseDouble(request.getParameter("precoproduto")));
        produto.setCentro(Double.parseDouble(request.getParameter("precocentro")));
        produto.setImage(request.getParameter("fotoproduto"));
        //produto.setCategory(Integer.parseInt(request.getParameter("categoriaproduto")));
        
        JdbcProdutoDao jdbcProdutoDao = new JdbcProdutoDao();
        jdbcProdutoDao.edit(produto);
        
        response.sendRedirect("cadastroProduto.jsp");
    }

}
