/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$().ready(function() {
	getEmployees();

	loadMap();
	//loadMsg();

});

function loadMsg(){
	//alert("MSG");
	//setTimeout('loadMsg()', 3000);
}

var marker, i;
var map, jsonObj;
var markerJSONObj;
var userList;


function loadMap() {
	$.getJSON("OnDutyListServlet", function(data) {
		// 
		var str = JSON.stringify(data);
		jsonObj = JSON.parse(str);
		$.ajax({
			type : 'GET',// GET Or POST
			url : "DutyEmployeeServlet",
			cache : false, // get fresh copy of details.html instead of
			// cahced one

			success : function(response, textStatus, jqXHR) {
				response = jqXHR.responseText;
				if (response == "") {

				} else {
					userList = response.split("&");

					map = new google.maps.Map(document.getElementById('map'), {
						zoom : 8,
						center : new google.maps.LatLng(9.931233, 76.267304),
						mapTypeId : google.maps.MapTypeId.ROADMAP
					});

					var infowindow = new google.maps.InfoWindow();
					markerJSONObj = new Object();
					
					for (i = 0; i < userList.length; i++) {

						if (userList[i] == 0 || userList[i] == undefined) {
						} else {
							var myLatLng = new google.maps.LatLng(
									jsonObj[userList[i]].split(',')[0],
									jsonObj[userList[i]].split(',')[1]);
							marker = new google.maps.Marker({
								position : myLatLng,
								map : map,
								title : userList[i]
							});
							markerJSONObj[userList[i]] = marker;
							google.maps.event.addListener(marker, 'click',
									(function(marker, i) {
										return function() {
											infowindow.setContent(userList[i]);
											infowindow.open(map, marker);
										};
									})(marker, i));
						}
					}

				}

			}

		});

	});
	
	setTimeout('loadMap()', 60000);

}

function getEmployees() {

	$.ajax({
		type : 'GET',// GET Or POST
		url : "DutyEmployeeServlet",
		cache : false, // get fresh copy of details.html instead of
		// cahced one

		success : function(response, textStatus, jqXHR) {
			response = jqXHR.responseText;
			if (response == "") {

			} else {
				var users = response.split("&");

				var ul = document.getElementById('empLink');
				for (var i = 0; i < users.length; i++) {
					var li = document.createElement('li');
					li.setAttribute('data-filter', 'websites')
					var child = document.createElement('label');
					var anchor = document.createElement('a');
					anchor.id = users[i];
					// anchor.setAttribute('onClick', linkFunction);
					var node = document.createTextNode(users[i]);
					anchor.appendChild(node);

					anchor.onclick = function(e) {
						var empId = $(this).text();
						// alert("EmpId: " + empId);
						getDirection(empId);
						return false;
					};

					child.appendChild(anchor);
					li.appendChild(child);
					ul.appendChild(li);
				}

			}
		}
	});

}

function getDirection(empName) {
	

	
	var preMarker = markerJSONObj[empName];
	
	if (preMarker.getAnimation() != null) {
		preMarker.setAnimation(null);
	} else {
		preMarker.setAnimation(google.maps.Animation.BOUNCE);
	}
	

}

// <!-- onClick="getLink()" -->
function getAllData() {

	getEmployees();
}
