<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div>
	<div class="py-2">
		<h3>Patient Visits</h3>
	</div>

	<div>
		<form action="<c:url value="/patientVisits" />">
			<table>
				<tr>
					<td class="text-left">From</td>
					<td><input readonly class="form-control" id="from" name="from"
						value="<fmt:formatDate pattern = "yyyy-MM-dd"  
         value = "${from}" />" /></td>
				</tr>

				<tr>
					<td class="text-left">To</td>
					<td><input readonly class="form-control" id="to" name="to"
						value="<fmt:formatDate pattern = "yyyy-MM-dd"  
         value = "${to}" />" /></td>
				</tr>
				<tr>
					<td><input class="btn btn-outline-info" type="submit"
						value="View" /></td>
				</tr>
			</table>
		</form>


	</div>

	<hr>


	<table id="patients-table" class="display nowrap">
		<thead>
			<tr>
				<th>#</th>
				<th>FullName</th>
				<th>Case</th>
				<th>Time</th>
				<th>From</th>
				<th>To</th>
				<th>F</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${patientVisits}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.patient.fullName}</td>
					<td>${item.visitCase}</td>
					<td><fmt:formatDate value="${item.time}"
							pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${item.from}</td>
					<td>${item.to}</td>
					<td>
						<div>
							<a class="btn btn-sm btn-warning"
								href="<c:url value="/patientVisits/edit/"/>${item.id}"> <i
								class="fa fa-edit"></i>
							</a>

						</div>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>