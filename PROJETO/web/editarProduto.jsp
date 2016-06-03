<%@page import="Bean.Produto"%>
<%@page import="Bean.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.JdbcCategoriaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
    </head>
    <body>
        <%@include file="cabeçalhoAdm.jsp" %>
<!--        <h1> ${p.getDescription()}</h1>-->

        <section>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  method="post" action="servletEditarProduto" autocomplete="on"> 
                        <center>NOVO PRODUTO<br><br></center>
                        
                        <p> 
                            <label for="descricao" class="uname" >  Foto do Produto </label>
                            <input  id="fotoproduto" name="fotoproduto" type="file" value="${p.getImage()}"/> 
                        </p>   
                        <p> 
                            <label for="descricao" class="uname" data-icon="u" > Descrição</label>
                            <input id="descricao" name="descricao" required="required" type="text" placeholder="Coxinha" value="${p.getDescription()}"/>
                        </p>
                        <p> 
                            <label for="precoproduto" class="youpasswd" data-icon="p">  Preço do Produto </label>
                            <input id="precoproduto" name="precoproduto" required="required" type="text" placeholder="10,00" value="${p.getPrice()}"/> 
                        </p>

                        <p> 
                            <label for="precocentro" class="youpasswd" data-icon="p"> Preço Centro </label>
                            <input id="precocentro" name="precocentro" required="required" type="text" placeholder="10,5" value="${p.getCentro()}" /> 
                        </p>

                        <p> 
                            <label for="categoriaproduto" class="categoriaproduto"> Selecione a Categoria do produto </label>

                            <select id="categoriaproduto" name="categoriaproduto" required="required" type="text"> 
                                
                                <%
                                    Produto p3 = (Produto) request.getAttribute("p");
                                    JdbcCategoriaDao jdpcategory = new JdbcCategoriaDao();
                                    Categoria categoria = jdpcategory.search( p3.getCategory() );
                                %>
                                    <option ><%=categoria.getId() + "-" +categoria.getName()%></option>
                                <%
                                    ArrayList<Categoria> lists = jdpcategory.list();
                                    for (Categoria element : lists) {
                                        if(!element.getName().equals(categoria.getName())){
                                %>
                                    
                                        <option ><%=element.getId() + "-" + element.getName()%></option>
                                
                                <%
                                        }
                                    }
                                %>
                                
                            </select>
                            <!--<span type="button" value="Novo" class="buttonStyle3" onclick="setCategoria()"> Novo</span>-->
                            <input type="text" name="id" value="<%=p3.getId()%>" style="display: none">
                        </p>

                        <p class="login button"> 
                            <input type="submit" value="Salvar" /> 
                        </p>


                        <p class="change_link">                      
                            <a href="cadastroProduto.jsp" class="to_register"> VOLTAR A LISTA DE PRODUTOS </a>
                        </p>

                    </form>
                </div>
            </div>
        </section>
    </body>
</html>
