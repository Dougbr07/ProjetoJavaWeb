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
        <script  language="JavaScript" type="text/javascript">
        $(document).ready(function(){
          $("tr").click(function(){
            $(this).find('td').each(function(i) {
              $th = $("thead th")[i];
              alert(jQuery($th).text() + ": " + $(this).html());
            });                  
          });
        });
        
        
        
        function adicionar(id){
        
            valor = document.getElementById(id).value;
            valor++;
            document.getElementById(id).value = valor;
            
        }
        
        function retirar(id){
       
        valor = document.getElementById(id).value;
            
            if(valor > 0){    

                valor--;
                document.getElementById(id).value = valor;
        
            }    
        }
        function adicionar100(id){
        
            valor = document.getElementById(id).value;
            valor = parseInt(valor) + 100;
            document.getElementById(id).value = valor;
            
        }
        
        function retirar100(id){
       
        valor = document.getElementById(id).value;
            
            if(valor > 99){    

                valor = parseInt(valor) - 100;
                document.getElementById(id).value = valor;
        
            }
            
            if(valor <= 99){    


                document.getElementById(id).value = '0';
        
            }
        }
        
        </script>
    </head>
    <body>
        <%@include file="cabeçalhoCliente.jsp" %>
       
           
           <section>				
            
                  
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                   
                    <div id="wrapper">
                        
                        <div id="login" class="animate form">
                            
                           
                            
                            
                            
                            
                            
                            LISTAR PEDIDOS
                            
                            

                            
                            
                                
                                <p class="change_link">
                                    <a href="#toregister" class="to_register">NOVO PEDIDO</a>
				</p>
                                
                           
                        </div>

                        <div id="register" class="animate form">
                            <form  method="post" action="ServletFazerPedido" autocomplete="on"> 
                                <center>NOVO PEDIDO<br><br></center>
     
                                <input name="idCliente" style="display: none" value="<%=session.getAttribute("id")%>">
                           <% 
                         JdbcProdutoDao jdp = new JdbcProdutoDao();
                         ArrayList<Produto> lista = jdp.list();
                         int idCont = 0;
                         for (Produto element : lista ) {
                             idCont++;
                       %>
                           <div id="container_demo">
                               <img src="<%=element.getImage()%>"> 
                               <span id="description" style="font-size:20px;font-family: cursive"><%=element.getDescription()%></span>
                               <span id="price"><%="Preço unidade: R$ " + element.getPrice()%></span>
                               <span id="center"><%="Centro: R$ " + element.getCentro()%></span>
                               <span style="margin-left: 260px">
                               
                               <span class="buttonStyle2" onclick="retirar100(<%=element.getId()%>)">
                                   <
                               </span>
                               <span class="buttonStyle" onclick="retirar(<%=element.getId()%>)">
                                   -
                               </span>

                               <input readonly="readonly" value ="0" style="height: 10px;width: 20px;text-align: center" name="<%=element.getId()%>"id="<%=element.getId()%>"> 
                               <input type="text" style="display:none" value="<%=element.getId()%>" name="idCont<%=idCont%>">
                                <span  class="buttonStyle" onclick="adicionar(<%=element.getId()%>)">
                                   +
                               </span>
                               <span class="buttonStyle2" onclick="adicionar100(<%=element.getId()%>)">
                                   >
                               </span>
                                   
                               </span>

                           </div>
                           <br>
                         <%
                             }
                         %>     
                                <p class="login button"> 
                                <input type="submit" value="COMPRAR">
                                </p>
                                <p class="change_link">
                                    <a href="#tologin" class="to_login">VOLTAR PARA LISTA DE PEDIDOS</a>
				</p>


                        </form>
                    </div>
                </div>
						
                
             
            </section>

    </body>
</html>
