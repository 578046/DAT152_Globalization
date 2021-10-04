<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="dat152-libs" prefix="dat152"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kaffekopper AS Home</title>
</head>
<body>
	<p><jsp:include page="chooseLanguage.jsp" /></p>
	<fmt:bundle basename="no.hvl.dat152.target.apptext">
  		<h1><fmt:message key="company" /></h1>
  		<br />
  		<img src="KaffekopperAS.PNG" width="250"> </img>
  		<br />
  		<br />
		<a><fmt:message key="welcome" /></a><a href="store"><fmt:message key="products" /></a> 
		<br />
		<a href="cart"><fmt:message key="cart"/></a>
	</fmt:bundle>
	<br />
	<dat152:copyright since="2021">HVL</dat152:copyright>

</body>
</html>