<%@ page import="java.util.Date"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="add-course-attend-container">
	<sf:form id="add-course-attend-form" commandName="courseAttend"
		onsubmit="addCourseAttend(event)">
		<table class="w-100">
			<tbody>
				<tr>
					<td>Note</td>
					<td><sf:input cssClass="form-control form-control-sm"
							path="note" /></td>
					<td><sf:errors path="note" /></td>
				</tr>

				<tr>
					<td>
						<button class="btn btn-sm  btn-success">
							<i class="fa fa-plus"></i>
						</button>
					</td>

				</tr>

			</tbody>

		</table>


	</sf:form>

</div>


<script>
	function addCourseAttend(event) {
		event.preventDefault();
		console.log("addCourseAttend->fired");
		var data = $("#add-course-attend-form").serializeJSON();
		console.log("data=", data);
		$.ajax({
			type : "POST",
			url : "<c:url value="/patientVisits/${id}/attends/add"/>",
			data : JSON.stringify(data),
			contentType : "application/json",
			success : function(response) {
				$("#modal-body").html(response);
				$("#modal").modal("show");
			},
			error : function(response) {
				$("#modal-body").html(response.responseText);
				$("#modal").modal("show");
			}
		});
	}
</script>