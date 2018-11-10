<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<div>
	<div class="py-2">
		<h3>Patient Visit Attends</h3>

		<table class="table table-bordered">
			<tr>
				<td>Full Name</td>
				<td>${patientVisit.patient.fullName}</td>
			</tr>
			<tr>
				<td>Course From</td>
				<td>${patientVisit.from}</td>
			</tr>
			<tr>
				<td>Course To</td>
				<td>${patientVisit.to}</td>
			</tr>
		</table>
	</div>

	<div>
		<h5 class="text-info">Course Attends</h5>
		<button class="btn btn-success btn-sm"
			onclick="getAddingCourseAttend(${patientVisit.id})">
			<i class="fa fa-plus"></i>
		</button>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Time</th>
					<th>Note</th>
					<th>F</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${patientVisit.courseAttends}" var="item">
					<tr>
						<td><fmt:formatDate value="${item.time }"
								pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td class="cus-note-td" title="${item.note}">${item.note}</td>
						<td>
							<button class="btn btn-danger btn-sm"
								onclick="deleteCourseAttend(${patientVisit.id},${item.id})">
								<i class="fa fa-plus"></i>
							</button>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>