$(document).ready(function() {
			console.log("ready!");

			$("#customer-table-container").hide();
			
			$("form").submit(function(event) {
				event.preventDefault();

//				var data = JSON.stringify($(this).serializeArray());
				console.log($(this).serialize());

				$.ajax({
					type : "POST",
					url : "/api/customer/save",
					data : $(this).serialize(),
					success : function(data) {
						console.log("SUCCESS");
						// alert(data);
						console.log(data);
						readCustomers();
					},
					error : function(data) {
						console.log("ERROR");
						alert(data.val());
						console.log(data);
					}
				});
			});

			function readCustomers() {
				$.ajax({
					type : "GET",
					url : "/api/customer/all",
					// data : $(this).serialize(),
					success : function(data) {
						console.log("SUCCESS All");
						// alert(data);
						console.log(data);
						var trHTML = '<tr>' + '<th>Name</th>'
								+ '<th>Email</th>' + '<th>Phone</th>'
								+ '<th>Address</th>' + '<th>Gender</th>'
								+ '<th>Branch</th>' + '</tr>';
						$.each(data, function(i, item) {

							trHTML += '<tr>' + '<td>' + item.name + '</td>'
									+ '<td>' + item.email + '</td>' + '<td>'
									+ item.phone + '</td>' + '<td>'
									+ item.address + '</td>' + '<td>'
									+ item.gender + '</td>' + '<td>'
									+ item.branch + '</td>' + '</tr>';
						});
						console.log(trHTML)
						$('#customer-table').html(trHTML);
						$("#customer-table-container").show();
					},
					error : function(data) {
						console.log("ERROR");
						alert(data);
						console.log(data);
					}
				});
			}
		});