<%@page import="javafx.print.Printer"%>
<%@page import="DAO.JdbcPedidoDao"%>
<%@page import="Bean.Pedido"%>
<%@page import="DAO.JdbcPessoaDao"%>
<%@page import="Bean.Pessoa"%>
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
        
    </head>
    

    
    <%

        int idPedido = Integer.parseInt(request.getAttribute("id").toString());
        Pedido pedido = new Pedido();
        JdbcPedidoDao pedidoDao = new JdbcPedidoDao();
        pedido = pedidoDao.search(idPedido);
        
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        produtos = pedidoDao.listaDeProdutosPedido(idPedido);
        
        
    %>
    
    
    <body>
        <%@include file="cabeçalhoCliente.jsp" %>
        <div id="wrapper">
           
           
            <div id="login" class="animate form conteudo">
                <center>DETALHES DO PEDIDO</center><BR>
                <form class="animate form">
                

                    
                    
                    
                    
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
                       
                        <td><span class="estiloLetra">NV. ACESSO: </span>Cliente</td>
                   
                    </tr> 
                              
                </table>  
                        <br><br>
                        <table>
                            
                            <tr>
                                
                                <td><span class="estiloLetra">ID PEDIDO:</span><%=" "+pedido.getId_pedido()%></td>
                                
                                <td style="width: 300px"><span style="margin-left: 10%"class="estiloLetra">DATA PEDIDO:</span><%=" "+pedido.getDatahour()%></td>
                                
                            </tr>
                            
                        </table>
                                <br><br>
                        <table class="altrowstable" id="alternatecolor">
                            <tr><td>QUANTIDADE</td><td>PRODUTO</td></tr>
                           
                                
                                <%
                                for(Produto element : produtos){
                              
                                    %>
                                <tr>
                                <td>
                                <%=element.getAmount()%>
                                </td>
                                
                             
                           
                           
                             
                                <td style=" width: 100%">
                                <%= element.getDescription()%>   
                                </td>
                             
                                </tr>
                              
                                <% 
                                }
                                
                                %>
   
                        </table>
                
                     <br>
                     <span style="margin-left: 0"><span class="estiloLetra">TOTAL DO PEDIDO:</span><%=" "+"R$: "+pedido.getPreco()%></span>
                </form>
            </div>
                
        </div>
    </body>
</html>
