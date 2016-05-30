<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script language= "JavaScript">

            function telaInicial() {

                location.href = "inicialAdm.jsp"

            }

            function editarUsuario() {

                location.href = "editarUsuarioAdm.jsp"

            }

            function novoProduto() {

                location.href = "cadastroProduto.jsp"
            }
            
            function sair() {

                location.href = "index.jsp"
            }

        </script>
        
    </head>
    <body>
        <br><br>
        <section>				
            <div id="wrapper">
                <h1> Area do Administrador </h1> 
                <p class="signin button"> 
                    <input type="button" onclick="telaInicial()" value="TELA INICIAL"/> 
                    <input type="button" onclick="editarUsuario()" value="EDITAR USUARIO"/> 
                    <input type="button" onclick="novoProduto()" value="PRODUTOS"/>
                    <input type="button" onclick="sair()" value="SAIR"/>                    
                </p>
            </div>
        </section>
    </body>
</html>
