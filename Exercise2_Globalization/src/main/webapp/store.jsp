<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="dat152-libs" prefix="dat152"%>
    
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store</title>
</head>
<body>
	<p><jsp:include page="chooseLanguage.jsp" /></p>
	
	<fmt:bundle basename="no.hvl.dat152.target.products" >
	
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
			<fmt:message key="products" />
		</h1>
		<form method="post" action="store">
		<ul style="list-style: none;">
			<li style="display: inline;">
				<fmt:bundle basename="no.hvl.dat152.target.products">
					<h3><fmt:message key="kanyeMug" /></h3>
					<fmt:message key="kanyeMugDesc" />
				</fmt:bundle>
				<p>${sign} ${kanyeMugPrice}</p> 
				<button type="submit" name="${i1.pno}" value="product${i1.pno}">purchase</button>
				<button type="submit" name="remove${i1.pno}" value="product${i1.pno}">remove</button>
				<h3><fmt:message key="amount_basket" /></h3><h3>${p0Value}</h3>	
				<br />
				<img src="${i1.imageFile}" width="200"></img>
				
			</li>
			<li style="">
				<fmt:bundle basename="no.hvl.dat152.target.products">
					<h3><fmt:message key="prescriptionMug" /></h3>
					<fmt:message key="prescriptionMugDesc" />
				</fmt:bundle>
				<p>${sign} ${prescriptionMugPrice}</p> 
				<button type="submit" name="${i2.pno}" value="product${i2.pno}">purchase</button> 
				<button type="submit" name="remove${i2.pno}" value="product${i2.pno}">remove</button>
				<h3><fmt:message key="amount_basket" /></h3><h3>${p1Value}</h3> 			
				<br />
				<img src="${i2.imageFile}" width="200"></img>
			</li>
		</ul>
		</form>
		<a href="home"><fmt:message key="home"/></a>
		<br />
		<a href="cart"><fmt:message key="cart"/></a>
	</fmt:bundle>
	<br />
	<dat152:copyright since="2021">HVL</dat152:copyright>
	
</body>
</html>