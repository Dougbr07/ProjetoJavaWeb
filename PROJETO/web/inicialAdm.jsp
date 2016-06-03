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
    </head>
    <body>
        <%@include file="cabeçalhoAdm.jsp" %>
   
        
    <br>
             <div id="wrapper">
                       
                        
                        <div id="login" class="animate form">
                            <form  method="post"action="ServletEditarUsuario" autocomplete="on"> 
                              
                              <table width="100%">
                             
                    <tr style=" height:30px">
                        <td><span class="estiloLetra">NOME:</span> <%= pCliente.getNome() %></td>
                        
                        <td><span class="estiloLetra">CPF: </span> <%= pCliente.getCpf() %></td> 
                        
                    </tr>
                    
                    <tr style=" height:30px">
                        <td><span class="estiloLetra">RG: </span><%= pCliente.getRg() %></td>
                        
                        <td><span class="estiloLetra">E-MAIL: </span><%= pCliente.getEmail() %></td>
                       
                    </tr> 

                    <tr style=" height:30px">
                        <td><span class="estiloLetra">ENDEREÇO:</span> <%= pCliente.getEndereco() %></td>
                        
                        <td><span class="estiloLetra">TELEFONE:</span> <%= pCliente.getTelefone() %></td>
                        
                    </tr> 
                    <tr style=" height:30px">
                        <td><span class="estiloLetra">USUARIO:</span> <%= pCliente.getUsuario() %></td>
                       
                        <td><span class="estiloLetra">NV. ACESSO: </span>Administrador</td>
                   
                    </tr> 
                              
                </table>  
                              <p class="change_link">                      
                                <a href="editarUsuarioAdm.jsp" class="to_register"> EDITAR USUARIO </a>
                            </p>
                            </form>
                        </div>

                        
                       
						
                    </div>
               
   
    
    
    
    </body>
</html>
