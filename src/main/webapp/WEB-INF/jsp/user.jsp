<html>
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		function getUserData(){
			id = $( "#userid" ).val();
			username = $( "#username" ).val();
			passwd = $( "#password" ).val();
			status = $( "#status" ).val();

			data = {"id":id,"username":username,"password":passwd,"status":status};
			return JSON.stringify(data);
		}

		function setUserData(user){
			//console.log("set user data:"+data)
			//user = JSON.parse(data);
			$( "#userid" ).val(user.id);
			$( "#username" ).val(user.username);
			$( "#password" ).val(user.password);
			$( "#status" ).val(user.status);
		}

		$.ajaxSetup({
		    beforeSend: function(xhr) {
			    var token = $("meta[name='_csrf']").attr("content");
			    var header = $("meta[name='_csrf_header']").attr("content");
		        xhr.setRequestHeader(header, token);
		    }
		});
		
		$('#getBtn').click(function() {
			console.log("getBtn click");
			var sendData = getUserData();
			console.log("getBtn sendData"+sendData);
			$.ajax({
				url : 'user', //Your api url
				type : 'GET', //type is any HTTP method
				//contentType : 'application/json, charset=utf-8',
				data : 'data='+$( "#userid" ).val(), //Data as js object
				dataType: 'json',
				success : function(data){setUserData(data);}
			})
			;
		});

		$('#postBtn').click(function() {
			console.log("getBtn click");
			var sendData = getUserData();
			console.log("getBtn sendData"+sendData);
			$.ajax({
				url : 'user', //Your api url
				type : 'POST', //type is any HTTP method
				contentType : 'application/json',
				data : sendData, //Data as js object
				dataType: 'json',
				success : function(data){
					console.log("insert data:"+JSON.stringify(data));
					setUserData(data);
					}
			})
			;
		});

		$('#putBtn').click(function() {
			console.log("getBtn click");
			var sendData = getUserData();
			console.log("putBtn sendData"+sendData);
			$.ajax({
				url : 'user', //Your api url
				type : 'PUT', //type is any HTTP method
				contentType : 'application/json',
				data : sendData, //Data as js object
				dataType: 'json',
				success : function(data){
					console.log("update data:"+JSON.stringify(data));
					}
			})
			;
		});

		$('#delBtn').click(function() {
			console.log("delBtn click");
			var sendData = getUserData();
			console.log("getBtn sendData"+sendData);
			$.ajax({
				url : 'user', //Your api url
				type : 'DELETE', //type is any HTTP method
				contentType : 'application/json',
				data : sendData, //Data as js object
				dataType: 'json',
				success : function(data){
					console.log("delete data:"+JSON.stringify(data));
					}
			})
			;
		});
		
	});
</script>
</head>
<body>
	<h2>You are welcome!</h2>
	<form>
		<table>
			<tr>
				<td>User ID</td>
				<td><input id="userid" type="text" name="userid"></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input id="username" type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input id="password" type="password" name="password"></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><select name="status" id="status">
						<option value="Activated">Activated</option>
						<option value="Deactivated">Deactivated</option>
				</select></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><button type="button" id="getBtn">GET</button></td>
				<td><button type="button" id="postBtn">POST</button></td>
				<td><button type="button" id="putBtn">PUT</button></td>
				<td><button type="button" id="delBtn">DELETE</button></td>
			</tr>
		</table>
	</form>
</body>
</html>