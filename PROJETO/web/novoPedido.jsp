<%@page import="Bean.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.JdbcProdutoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
        <script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
        <script>
        $(document).ready(function(){
          $("tr").click(function(){
            $(this).find('td').each(function(i) {
              $th = $("thead th")[i];
              alert(jQuery($th).text() + ": " + $(this).html());
            });                  
          });
        });
        </script>
    </head>
    <body>
        <%@include file="cabeçalhoCliente.jsp" %>
        <div id="wrapper">
            <% 
            JdbcProdutoDao jdp = new JdbcProdutoDao();
            ArrayList<Produto> lista = jdp.list();
                for (Produto element : lista ) {
                %>
                    <div id="container_demo">
                        <img src="<%=element.getImage()%>"> 
                        <span id="description"><%=element.getDescription()%></span>
                        <span id="price"><%="Preço: R$ " + element.getPrice()%></span>
                        <span id="center"><%="Centro: R$ " + element.getCentro()%></span>
                        <a href="#">Comprar</a>
                    </div>
                    <br>
                <%
                }
                %>
        </div>
    </body>
</html>
