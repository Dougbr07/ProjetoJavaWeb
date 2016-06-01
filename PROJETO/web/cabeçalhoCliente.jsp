<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language= "JavaScript">

          function telaInicial(){

              location.href="inicialCliente.jsp";

           }

          function editarUsuario(){

              location.href="editarUsuarioCliente.jsp"


           }

          function novoPedido(){

              location.href="novoPedido.jsp";

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
                <h1> Area do Cliente </h1> 
                <p class="signin button"> 
                    <input type="button" onclick="telaInicial()" value="TELA INICIAL"/> 
                    <input type="button" onclick="editarUsuario()" value="EDITAR USUARIO"/> 
                    <input type="button" onclick="novoPedido()" value="PEDIDOS"/> 
                    <input type="button" onclick="sair()" value="SAIR"/>
                </p>
            </div>
        </section>
    </body>
</html>
