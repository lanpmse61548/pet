<!--  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

</body>
</html>
-->

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<body>

<div ng-app="myApp" ng-controller="myCtrl"> 

<div style="height:100px;width:100%;background-color:red "></div>


<table>
    <tr>
       
        <th> Name</th>
        <th>Staff</th>
    </tr>
    <tr ng-repeat="tour in myWelcome">
        
        <td> <input ng-model="tour.tourname"></td>
        <td>{{tour.price}}</td>
    </tr>
</table>


<button ng-click="myFunc()">OK</button>



</div>


<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	
	 $scope.myWelcome ='lol'; 
     var a = 12;
  
  
     
     
     
  $http({
	  method: 'GET',
	  url: 'http://localhost:8080/petproject/name'
	}).then(function successCallback(response) {
		$scope.myWelcome =response.data;
		
		
	
		  
		
		
	  }, function errorCallback(response) {
		  console.log(response);
	  });
  
  
  $scope.myFunc = function() {
	  $http({
		  method: 'GET',
		  url: 'http://localhost:8080/petproject/param?id='+a
		}).then(function successCallback(response) {
			
			
		  }, function errorCallback(response) {
			  console.log(response);
		  });  };
  
	
  
});
</script>

</body>
</html>
