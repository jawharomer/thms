<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">
	var jsonPatientVisit = '${jsonPatientVisit}';
	var jsonExaminations = '<spring:escapeBody  javaScriptEscape="true">${jsonExaminations}</spring:escapeBody>';
</script>

<div id="add-patient-visit-contaner" ng-app="addPatientVisit"
	ng-controller="addPatientVisit" ng-init="init()">
	<h3 class="text-success">Add Patient Visit</h3>
	<table>
		<tr>
			<td>Patient</td>

			<td>{{patientVisit.patient.fullName}} <a
				href="<c:url value="/patients/edit/"/>{{patientVisit.patient.id}} "
				class="btn btn-sm btn-warning"> <i class="fa fa-edit"></i>
			</a>
			</td>
		</tr>
	</table>

	<table id="add-patient-visit-table" class="table table-bordered"
		ng-form name="form">
		<tr>
			<td>Visit Case</td>
			<td><label> Physical therapy <input required
					type="radio" ng-model="patientVisit.visitCase"
					value="Physical therapy" name="visitCase">
			</label> <label> Hydro therapy <input required type="radio"
					ng-model="patientVisit.visitCase" value="Hydro therapy"
					name="visitCase">
			</label> <label> Physical&Hydro therapy <input required type="radio"
					ng-model="patientVisit.visitCase" value="Physical&Hydro therapy"
					name="visitCase">
			</label></td>
		</tr>
		<tr>
			<td>Course From</td>
			<td><input required id="from" readonly="readonly"
				class="form-control form-control-sm" ng-model="patientVisit.from"
				name="from"></td>
		</tr>

		<tr>
			<td>Course To</td>
			<td><input required id="to" readonly="readonly"
				class="form-control form-control-sm" ng-model="patientVisit.to"
				name="to"></td>
		</tr>

		<tr>
			<td>Note</td>
			<td><input class="form-control form-control-sm"
				ng-model="patientVisit.note"></td>
		</tr>


	</table>


	<div>
		<h5 class="text-info">Examination</h5>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Result</th>
					<th>Note</th>
					<th>F</th>
				</tr>
				<tr ng-form name="examinationForm">
					<th><input id="examination-name"
						ng-model="newExamination.name" required name="name"
						class="form-control form-control-sm"></th>
					<th><input ng-model="newExamination.result" required
						name="result" class="form-control form-control-sm"></th>

					<th><input ng-model="newExamination.note"
						class="form-control form-control-sm"></th>
					<th>
						<button ng-disabled="examinationForm.$invalid"
							class="btn btn-sm btn-success rounded-circle"
							ng-click="addExamination()">
							<i class="fa fa-plus"></i>
						</button>
					</th>
				</tr>

			</thead>
			<tbody>
				<tr ng-repeat="item in patientVisit.examinations">
					<td>{{item.name}}</td>
					<td>{{item.result}}</td>
					<td class="cus-note-td" title="{{item.note}}">{{item.note}}</td>
					<td>
						<button class="btn btn-sm btn-danger rounded-circle"
							ng-click="deleteExamination(item.id)">
							<i class="fa fa-times"></i>
						</button>
					</td>
				</tr>
			</tbody>
		</table>

	</div>


	<div>
		<h5 class="text-info">Couse Attends</h5>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Time</th>
					<th>Note</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="item in patientVisit.courseAttends">
					<td>{{item.time|date:'yyyy-MM-dd hh:mm:ss'}}</td>
					<td class="cus-note-td" title="{{item.note}}">{{item.note}}</td>
				</tr>
			</tbody>
		</table>
	</div>

	<button class="btn btn-success" ng-click="save()"
		ng-disabled="form.$invalid">
		<i class="fa fa-save"></i>
	</button>

</div>
