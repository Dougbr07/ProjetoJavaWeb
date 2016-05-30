

<%@page import="Bean.Pessoa"%>
<%@page import="DAO.JdbcPessoaDao"%>
<%@page import="DAO.PessoaDao"%>
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
                    
                     function voltar(){
        
                     
                         location.href="inicialAdm.jsp"


                     }
                    
                    
                </script>

    </head>
    <body>
        
        <%
        
        JdbcPessoaDao p = new JdbcPessoaDao();
        Pessoa p1 = new Pessoa();
        int id = Integer.parseInt(session.getAttribute("id").toString());
        p1 = p.search(id);

        %>
        
        
        
        

            <br><br>
            <section>				
                <div id="container_demo" >
                   
              
                    <div id="wrapper">
                       
                        
                        <div id="login" class="animate form">
                            <form  method="post"action="ServletLogin" autocomplete="on"> 
                              
                                 <h1> Editar Usuario </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Nome Completo</label>
                                    <input id="usernamesignup" name="nome" value="<%=p1.getNome()%>" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > E-mail</label>
                                    <input id="emailsignup" name="email" value="<%=p1.getEmail()%>" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="cpfsigin" class="youpasswd" data-icon=">"> Cpf </label>
                                    <input id="cpfsigin" name="cpf" value="<%=p1.getCpf()%>" required="required" type="text" placeholder="453.862.861-25"/>
                                </p>
                                <p> 
                                    <label for="rgsigin" class="youpasswd" data-icon=">"> Rg </label>
                                    <input id="passwordsignup" name="rg" value="<%=p1.getRg()%>" required="required" type="text" placeholder="25452-5"/>
                                </p>
                                <p> 
                                    <label for="enderecosigin" class="youpasswd" data-icon=">"> Endereço </label>
                                    <input id="passwordsignup" name="endereco" value="<%=p1.getEndereco()%>" required="required" type="password" placeholder="Rua C, n.82"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="u"> Usuario </label>
                                    <input id="passwordsignup" name="usuario" value="<%=p1.getUsuario()%>" required="required" type="text" placeholder="usuario1"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Senha </label>
                                    <input id="passwordsignup" name="senha" value="<%=p1.getSenha()%>" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                   
                                <p class="signin button"> 
									<input type="submit" value="Editar"/> 
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
