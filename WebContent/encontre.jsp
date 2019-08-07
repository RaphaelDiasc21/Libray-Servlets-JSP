<jsp:include page="nav.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<form action="encontre" method="post">
	Nome do livro: <input type="text" name="nome">
	
	<button type="submit">Encontre</button>
</form>

<c:if test="${book != null}">
${book.nome}
<div>
	livro: <c:out value="${book.nome}" />
	Autor: <c:out value="${book.autor}" />
</div>
</c:if>
<jsp:include page ="footer.jsp" />