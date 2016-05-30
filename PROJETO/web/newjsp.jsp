<%
// require_once "conexao/connectDB.php";
// $mysql = new conexao;
// $id_aula;
//
// $result = $mysql -> DBSelect('materia.nome, aula.id_aula, aula.data_aula, aula.descricao, aula.exercicio, aula.material, aula.descricao, aula.assunto ',
//         'aula', 
//         ' INNER JOIN materia ON materia.id_materia = aula.id_materia');
// 
// foreach ($result as $key) {
//   $id_aula = $key['id_aula'];
   out.print("<tr>");
   out.print( "<td> <form action='deleteaula.php' method='get' accept-charset='utf-8'> "
              + "<input type='image' src='images/icon-excluir.png' width='40px' height='36px' name='apagar' value='$id_aula'/>"
              + "</form> "
              + "<form action='cadastroAula.php' method='get'>"
              + "<input type='image' src='images/icon-alterar.png' width='40px' height='36px' name='alterar' value='$id_aula' class='submitAlterar' onclick='preencherCampos(value)'/>"
              + "</form>"
              + "</td>");
   
           
out.print("<td>" + "valter" + " ");
out.print("<td>" +"seila"+ " "); //nome da materia que vem da tabela materia
out.print("<td>" +"jomais"+ " ");
out.print("<td>"+"dasdasd"+" ");
out.print("<td>" +"lauber"+ " ");
out.print("<td>" +"asdasd"+ " ");
out.print("</tr>");

 //}
%>