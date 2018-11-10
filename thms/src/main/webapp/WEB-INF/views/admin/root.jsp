<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<jsp:useBean id="now" class="java.util.Date" />
<c:set var="tomorrow"
	value="<%=new Date(new Date().getTime() + 60 * 60 * 24 * 1000)%>" />

<fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd" />
<fmt:formatDate var="tomorrow" value="${tomorrow}" pattern="yyyy-MM-dd" />

<section id="admin-body">
	<section id="section-right" class="card">
		<ul class="list-group">

			<sec:authorize access="hasRole('THMSA')">

				<li class="list-group-item"><a href="<c:url value="/admin"/>">
						Dashboard</a></li>

				<li class="list-group-item text-success"><a
					href="<c:url value="/receptionPatientVisits"/>?from=${currentDate}&to=${tomorrow}">
						Reception</a></li>

				<li class="list-group-item"><a
					href="<c:url value="/patientVisits"/>?from=${currentDate}&to=${tomorrow}">
						Patient Visits</a></li>
			</sec:authorize>
			<li class="list-group-item"><a
				href="<c:url value="/patientVisits/course"/>?to=${currentDate}">
					Has Course</a></li>




		</ul>
	</section>

	<section id="main-content">

		<tiles:insertAttribute name="adminBody" />

	</section>

</section>