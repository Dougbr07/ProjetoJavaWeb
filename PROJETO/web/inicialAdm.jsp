<%-- 
    Document   : inicialCliente
    Created on : 28/05/2016, 18:46:30
    Author     : Douglas
--%>

<%@page import="Bean.Pessoa"%>
<%@page import="DAO.JdbcPessoaDao"%>
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
          
                
          <script language= "JavaScript">
           
            function telaInicial(){
            
                location.href="inicialAdm.jsp"
            
             }
             
            function detalhesPedido(){
            
                location.href="inicialAdm.jsp"
            
             }
             
            function novoPedido(){
            
                location.href="inicialAdm.jsp"
            
             }
             
             
             
          </script>
                
             
                
                
    </head>
    <body>
        
        
        <%
    
    if(session.getAttribute("id") == null){
    
    RequestDispatcher r = request.getRequestDispatcher( "index.jsp" );
    r.forward( request, response );  
    
    
    }
    
    JdbcPessoaDao p = new JdbcPessoaDao();
    Pessoa pCliente = new Pessoa();
    String idCliente = session.getAttribute("id").toString();
    String nivel;
    pCliente = p.search(Integer.parseInt(idCliente));
    if(pCliente.getUser_nivel() > 0){
    nivel = "Administrador";
    }else{
    nivel = "Cliente";
    }
    
    
    

    
    %> 
        
        <br><br>
        <section>				
            <div id="container_demo" >

                <div id="wrapper">

                         <h1> Area do Administrador  </h1> 

                                <p class="signin button"> 

                                 <input type="button" onclick="telaInicial()" value="TELA INICIAL"/> 
                                 <input type="button" onclick="detalhesPedido()" value="CATEGORIAS"/> 
                                 <input type="button" onclick="novoPedido()" value="PRODUTOS"/>
                                 <input type="button" onclick="novoPedido()" value="SAIR"/>


                                </p>
                                 <div>

                                    <table width="100%" border="1">


                                       <tr>
                                        <td>Nome:</td>
                                        <td><%= pCliente.getNome() %></td> 

                                        <td>Cpf:</td>
                                        <td><%= pCliente.getCpf() %></td>

                                      </tr>

                                      <tr>
                                        <td>Rg:</td>
                                        <td><%= pCliente.getRg() %></td>
                                        <td>Email:</td>
                                        <td><%= pCliente.getEmail() %></td>

                                      </tr> 

                                      <tr>
                                        <td>Endereço:</td>
                                        <td><%= pCliente.getEndereco() %></td>
                                        <td>Telefone:</td>
                                        <td><%= pCliente.getTelefone() %></td>
                                      </tr> 
                                      <tr>
                                        <td>Usuario:</td>
                                        <td><%= pCliente.getUsuario() %></td>
                                        <td>Nivel de Acesso:</td>
                                        <td><%= nivel %></td>
                                      </tr>  




                                    </table>

                                </div>
                    </div>
            </div>
        </section>
    </body>
</html>
