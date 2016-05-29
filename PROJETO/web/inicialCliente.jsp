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
            
                location.href="inicialCliente.jsp"
            
             }
             
            function detalhesPedido(){
            
                location.href="inicialCliente.jsp"
            
             }
             
            function novoPedido(){
            
                location.href="inicialCliente.jsp"
            
             }
             
             
             
          </script>
                
                
                
                
    </head>
    
    <%
    
    if(session.getAttribute("id") == null){
    
    RequestDispatcher r = request.getRequestDispatcher( "index.jsp" );
    r.forward( request, response );  
    
    }
        
        
        
        
    Pessoa pCliente = new Pessoa();
    String nivel;
    JdbcPessoaDao p = new JdbcPessoaDao();
    String idCliente = session.getAttribute("id").toString();
    pCliente = p.search(Integer.parseInt(idCliente));
    if(pCliente.getUser_nivel() > 0){
    nivel = "Administrador";
    }else{
    nivel = "Cliente";
    }
    
    
    

    
    %>
    

    <body>
        
        
        <br><br>
            <section>				

                    <div id="wrapper">
                       
                             <h1> Area do Cliente </h1> 

                                    <p class="signin button"> 
				    
                                     <input type="button" onclick="telaInicial()" value="TELA INICIAL"/> 
                                     <input type="button" onclick="detalhesPedido()" value="DETALHES DE PEDIDO"/> 
                                     <input type="button" onclick="novoPedido()" value="NOVO PEDIDO"/> 
                                   
     
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
                
                        
               
                    
                    
                    
                
            </section>
        
        
        
        
        
        
        
        
        
    </body>
</html>
