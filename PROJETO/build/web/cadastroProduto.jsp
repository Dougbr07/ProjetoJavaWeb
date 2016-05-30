<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
            <title>Administrador</title>
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
        
        
        <section>				
                <div id="container_demo" >
                  
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                   
                    <div id="wrapper">
                        
                        <div id="login" class="animate form">
                            

                            
                            LISTA DE PRODUTOS EM TABELA
                            
                                
                                <p class="change_link">
                                    <a href="#toregister" class="to_register">NOVO PRODUTO</a>
				</p>
                                
                           
                        </div>

                        <div id="register" class="animate form">
                            <form  method="post" action="ServletCadastro" autocomplete="on"> 
                                <center>NOVO PRODUTO</center>
                            <p> 
                                <label for="descricao" class="uname" data-icon="u" > Descrição </label>
                                <input id="descricao" name="descricao" required="required" type="text" placeholder="Coxinha"/>
                            </p>
                            <p> 
                                <label for="precoproduto" class="youpasswd" data-icon="p"> Preço do Produto </label>
                                <input id="precoproduto" name="precoproduto" required="required" type="text" placeholder="10,00" /> 
                            </p>
                            
                            <p> 
                                <label for="precocentro" class="youpasswd" data-icon="p"> Preço Centro </label>
                                <input id="precocentro" name="precocentro" required="required" type="text" placeholder="10,5" /> 
                            </p>

                            <p> 
                                <label for="quantidadeproduto" class="quantidadeproduto" data-icon="p"> Quantidade Produto </label>
                                <input id="precocentro" name="precocentro" required="required" type="text" placeholder="10,50" /> 
                            </p>

                            <p> 
                                <label for="fotoproduto" class="fotoproduto" data-icon="p"> Foto do Produto </label>
                                <input id="fotoproduto" name="fotoproduto" required="required" type="text" placeholder="Adicione uma foto para o produto" /> 
                            </p>

                            <p> 
                                <label for="categoriaproduto" class="categoriaproduto"> Selecione a Categoria do produto </label>

                                <select id="categoriaproduto" name="categoriaproduto" required="required" type="text" placeholder="Adicione uma foto para o produto"> 
                                    <option>Doce</option>
                                    <option>Salgado</option>
                                </select>
                            </p>
                            
                            <p class="login button"> 
                                <input type="submit" value="Cadastrar" /> 
                            </p>
                           
                            <p class="change_link">                      
                                <a href="#tologin" class="to_register"> VOLTAR A LISTA DE PRODUTOS </a>
                            </p>
                        </form>
                    </div>
                                
                          
                        </div>
						
                    </div>
                </div>  
            </section>
        
  
        
        
    </body>
</html>
