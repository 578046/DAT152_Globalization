<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="dat152-libs" prefix="dat152"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<p><jsp:include page="chooseLanguage.jsp" /></p>

	<fmt:bundle basename="no.hvl.dat152.target.products">

		<fmt:bundle basename="no.hvl.dat152.target.apptext">
			<script>
			<fmt:message key="money_multiplier" var="times"/>
			<fmt:message key="money_sign" var="sign"/>
		</script>
		</fmt:bundle>
		<script>
		
			<fmt:message key="kanyeMugPrice"  var="kanyeMugPrice"/>
			<fmt:message key="prescriptionMugPrice"  var="prescriptionMugPrice"/>
			
			let times = ${times}
			let sign = ${sign}
			let kanyeMugPrice = ${kanyeMugPrice}
			let prescriptionMugPrice = ${prescriptionMugPrice}
			console.log(bmp)
		</script>

	</fmt:bundle>
	
	
	<fmt:bundle basename="no.hvl.dat152.target.apptext">
	<h1>
		<fmt:message key="cart" />
	</h1>
	<br />
	<table>
		<tr>
			<th><fmt:message key="name"></fmt:message></th>
			<th><fmt:message key="short_description"></fmt:message></th>
			<th><fmt:message key="price"></fmt:message></th>
			<th><fmt:message key="quantity"></fmt:message></th>
			<th><fmt:message key="total"></fmt:message></th>
		</tr>

	</fmt:bundle>
		<tr>

			<fmt:bundle basename="no.hvl.dat152.target.products">
				<td><fmt:message key="kanyeMug" /></td>
				<td><dat152:shorttext maxchars="20">
						<fmt:message key="kanyeMugDesc" />
					</dat152:shorttext></td>
			</fmt:bundle>

			<td>${sign} ${kanyeMugPrice}</td>
			<td>${p0Value}</td>
			<td>${sign} ${p0Value*kanyeMugPrice}</td>
		</tr>

		<tr>

			<fmt:bundle basename="no.hvl.dat152.target.products">
				<td><fmt:message key="prescriptionMug" /></td>
				<td><dat152:shorttext maxchars="20">
						<fmt:message key="prescriptionMugDesc" />
					</dat152:shorttext></td>
			</fmt:bundle>

			<td>${sign} ${prescriptionMugPrice}</td>
			<td>${p1Value}</td>
			<td>${sign} ${p1Value*prescriptionMugPrice}</td>
		</tr>
	</table>
	<br />

	<br />

	<fmt:bundle basename="no.hvl.dat152.target.apptext">
	<a href="store"><fmt:message key="products" /></a>
	<br />
	<a href="home"><fmt:message key="home" /></a>
	</fmt:bundle>
	<br />
	<dat152:copyright since="2021">HVL</dat152:copyright>

</body>
</html>