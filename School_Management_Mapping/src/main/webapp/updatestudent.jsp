<%@page import="java.io.PrintWriter"%>
<%@page import="mapping.entity.Student"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("samal");
	EntityManager em = emf.createEntityManager();
	Student t = em.find(Student.class, id1);
	
	%>

	<form action="updatestu" method="post">
		id: <input type="text" value="<%=t.getId()%>" name="id">
		name: <input type="text" value="<%=t.getName()%>" name="name">
		stream: <input type="text" value="<%=t.getStream()%>" name="stream">
		fees: <input type="text" value="<%=t.getFees()%>"name="fees">
		<input type="submit">
	</form>

</body>
</html>