<%@page import="Bean.Pessoa"%>
<%@page import="DAO.JdbcPessoaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script language= "JavaScript">

            function telaInicial() {

                location.href = "inicialAdm.jsp"

            }

            function listaClientes() {

                location.href = "listaClientes.jsp"

            }

            function novoProduto() {

                location.href = "cadastroProduto.jsp"
            }
            
            function sair() {

                location.href = "index.jsp"
            }

        </script>
         <%

            if (session.getAttribute("id") == null) {

                RequestDispatcher r = request.getRequestDispatcher("index.jsp");
                r.forward(request, response);

            }

            JdbcPessoaDao p = new JdbcPessoaDao();
            Pessoa pCliente = new Pessoa();
            String idCliente = session.getAttribute("id").toString();
            pCliente = p.search(Integer.parseInt(idCliente));
            


    %> 
    </head>
    <body>
        <br><br>
        <section>				
            <div id="wrapper">
                <h1> Area do Administrador </h1> 
                <p class="signin button"> 
                    <input type="button" onclick="telaInicial()" value="TELA INICIAL"/> 
                    <input type="button" onclick="listaClientes()" value="CLIENTES"/> 
                    <input type="button" onclick="novoProduto()" value="PRODUTOS"/>
                    <input type="button" onclick="sair()" value="SAIR"/>                    
                </p>
            </div>
        </section>
    </body>
</html>
