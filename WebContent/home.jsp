<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:include page="nav.jsp" />
	
		<c:out value="hello world"></c:out>
		
		<form action="livros" method="post">
			Nome: <input type="text" name="nome"><br>
			Autor: <input type="text" name="autor"><br>
			
			<button type="submit">Registrar</button>
		</form>
		
		<h3>Livros cadastrados</h3>
		<c:forEach items="${bookies}" var="book">
			<div>
				Titulo: ${book.nome}
				autor: ${book.autor}
			</div>
		</c:forEach>


<jsp:include page ="footer.jsp" />