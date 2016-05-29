<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8" />
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Cliente</title>
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
	<section>               
        <div id="container_demo" >
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="mysuperscript.php" autocomplete="on"> 
                        <h1>Cliente</h1> 
                        <p> 
                            <label for="descricao" class="uname" data-icon="u" > Descrição </label>
                            <input id="descricao" name="descricao" required="required" type="text" placeholder="Coxinha"/>

                            <table>
	                            <tr>
	                            	<td> Coxinha </td>
	                            	<td> R$ 1,00 </td>
	                            	<td> RS 90,00 </td>
	                            	<td> 80 </td>
	                            	<td> Salgado </td>
	                            </tr>

	                            <tr>
	                            	<td>Bolo</td>
	                            	<td></td>
	                            	<td></td>
	                            	<td></td>
	                            </tr>
	                        </table>    
                        </p>
                        
                        
                        <p class="login button"> 
                            <input type="submit" value="Login" /> 
                        </p>
                    </form>
                </div>
            </div>
        </div>  
    </section>
</body>
</html>