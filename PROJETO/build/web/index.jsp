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
       
                <script>
                    
                  function validar(){
                   
                   if(${validar} === 1){
                        alert("Login ou Senha Errados");   
                   }
                   
                   if(${validar} === 2){
                       
                       alert("Login já cadastrado !!!");
                   }   
                } 
                
                </script>
                
    </head>
        <%
        
            session.invalidate();
        
        %>
    <body onload="validar()">
            <br><br>
            <section>				
               
                  
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  method="post"action="ServletLogin" autocomplete="on"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Usuario </label>
                                    <input id="username" name="usuario" required="required" type="text" placeholder="usuario"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Senha </label>
                                    <input id="password" name="senha" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>

                                <p class="login button"> 
                                    <input type="submit" value="Entrar" /> 
				</p>
                               
                                
                                <p class="change_link">
                                    Não é cliente ?
                                    <a href="#toregister" class="to_register">Cadastre-se</a>
				</p>
                                
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  method="post" action="ServletCadastro" autocomplete="on"> 
                                <h1> Cadastro de Cliente </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Nome Completo</label>
                                    <input id="usernamesignup" name="nome" required="required" type="text" placeholder="João da Silva" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > E-mail</label>
                                    <input id="emailsignup" name="email" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="cpfsigin" class="youpasswd" data-icon="c"> Cpf </label>
                                    <input id="cpfsigin" name="cpf" required="required" type="text" placeholder="453.862.861-25"/>
                                </p>
                                <p> 
                                    <label for="rgsigin" class="youpasswd" data-icon="r"> Rg </label>
                                    <input id="passwordsignup" name="rg" required="required" type="text" placeholder="25452-5"/>
                                </p>
                                <p> 
                                    <label for="enderecosigin" class="youpasswd" data-icon="e"> Endereço </label>
                                    <input id="passwordsignup" name="endereco" required="required" type="text" placeholder="Rua C, n.82"/>
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="youpasswd" data-icon="f"> Telefone </label>
                                    <input id="passwordsignup" name="telefone" required="required" type="text" placeholder="(xx)xxxx-xxxx"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="u"> Usuario </label>
                                    <input id="passwordsignup" name="usuario" required="required" type="text" placeholder="usuario1"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Senha </label>
                                    <input id="passwordsignup" name="senha" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                   
                                <p class="signin button"> 
				
                                    <input type="submit" value="Cadastrar"/> 
                                                                       
				</p>
                                <p class="change_link">  
                                    
						Já é cliente ?
                                                
				<a href="#tologin" class="to_register"> Faça o Login </a>
				</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        
    </body>
</html>
