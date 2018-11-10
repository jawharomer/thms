function getAddingCourseAttend(id) {
	console.log("getAddingCourseAttend->fired");
	console.log("id=" + id);
	$.ajax({
		url : $$ContextURL + '/patientVisits/' + id + '/attends/add',
		type : 'GET',
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

function deleteCourseAttend(id, courseAttendId) {
	console.log("deleteCourseAttend->fired");
	console.log("id=" + id);
	console.log("courseAttendId=" + courseAttendId);

	$.when(cusConfirm()).done(
			function() {
				$.ajax({
					url : $$ContextURL + '/patientVisits/' + id
							+ '/attends/delete/' + courseAttendId,
					type : 'POST',
					success : function(response) {
						$("#modal-body").html(response);
						$("#modal").modal("show");
					},
					error : function(response) {
						$("#modal-body").html(response.responseText);
						$("#modal").modal("show");
					}
				});
			});

}