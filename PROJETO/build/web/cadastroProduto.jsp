<%-- 
    Document   : cadastroProduto
    Created on : 28/05/2016, 13:17:00
    Author     : Douglas
--%>

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
        

            <br><br>
            <section>				
                <div id="container_demo" >
                   
              
                    <div id="wrapper">
                       
                        
                        <div id="login" class="animate form">
                            <form  method="post"action="ServletCadastrarProduto" autocomplete="on"> 
                              
                                 <h1> Cadastrar Produto </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" >Descrição</label>
                                    <input id="usernamesignup" name="desc" required="required" type="text" placeholder="Coxinha" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" > Preço por Unidade</label>
                                    <input id="emailsignup" name="preco" required="required" type="text" placeholder="10,00"/> 
                                </p>
                                <p> 
                                    <label for="cpfsigin" class="youpasswd" > Centro </label>
                                    <input id="cpfsigin" name="centro" required="required" type="text" placeholder=""/>
                                </p>
                                <p> 
                                    <label for="rgsigin" class="youpasswd" > Tipo </label>
                                    <select>
                                     <option  value="salgado">SALGADO</option>
                                     <option value="doce">DOCE</option>

                                    </select>
                                </p>
                   
                                
                                <p class="signin button"> 
				<input type="submit" value="Cadastrar"/> 
				</p>
                                
                                <p class="change_link">  
									
				<a href="#tologin" onclick="voltar()"> Voltar para pagina principal</a>
				</p>
                                
                                
                                
                            </form>
                        </div>

                        
                       
						
                    </div>
                </div>  
            </section>
       
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
