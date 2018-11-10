<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div>
	<div class="py-2">
		<h3>Patient Visits-Dr. ${doctor.fullName}</h3>
	</div>

	<div>
		<form action="<c:url value="/receptionPatientVisits"/>">
			<table>
				<tr>
					<td class="text-left">From</td>
					<td><input readonly="readonly" class="form-control" id="from"
						name="from"
						value="<fmt:formatDate pattern = "yyyy-MM-dd"  
         value = "${from}" />" /></td>
				</tr>

				<tr>
					<td class="text-left">To</td>
					<td><input readonly="readonly" class="form-control" id="to"
						name="to"
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
				<th>VID</th>
				<th>PID</th>
				<th>Full Name</th>
				<th>Phone</th>
				<th>Visit Case</th>
				<th>Total Price</th>
				<th class="cus-not-export">F</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${receptionPatientVisits}" var="item">
				<tr>
					<td>${item.id }</td>
					<td>${item.patient.id}</td>
					<td>${item.patient.fullName}</td>
					<td>${item.patient.phone}</td>
					<td>${item.visitCase}</td>
					<td>${item.totalPrice}</td>
					<td><a
						href="<c:url value="/patients/edit/"/>${item.patient.id}"
						class="btn btn-sm btn-warning"> <i class="fa fa-edit"></i>
					</a> <a
						href="<c:url value="/patientVisits/add/patient/"/>${item.patient.id}"
						class="btn btn-sm btn-info"> <i class="fa fa-ticket"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>