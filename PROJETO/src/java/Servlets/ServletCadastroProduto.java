package Servlets;

import Bean.Categoria;
import Bean.Produto;
import DAO.JdbcCategoriaDao;
import DAO.JdbcProdutoDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCadastroProduto", urlPatterns = {"/ServletCadastroProduto"})
public class ServletCadastroProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JdbcCategoriaDao categoriaDao = new JdbcCategoriaDao();
        categoriaDao.validaCadastro(request.getParameter("categoriaproduto"));
        
        Categoria categoria = categoriaDao.search(request.getParameter("categoriaproduto"));
        
        
        Produto novoProduto = new Produto();
        novoProduto.setDescription(request.getParameter("descricao"));
        novoProduto.setPrice(Double.parseDouble(request.getParameter("precoproduto")));
        novoProduto.setCentro(Double.parseDouble(request.getParameter("precocentro")));
        novoProduto.setImage(request.getParameter("fotoproduto"));
        novoProduto.setCategory(categoria.getId());
        
        JdbcProdutoDao produto = new JdbcProdutoDao();
        produto.insert(novoProduto);

        response.sendRedirect("inicialAdm.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
