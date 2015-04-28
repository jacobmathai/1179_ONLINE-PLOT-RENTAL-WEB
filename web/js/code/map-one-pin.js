var geoLocation;
var exactLocation;
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();

var map;
var marker;
var geocoder;
var lat;
var lng;

function initialize() {
    geocoder = new google.maps.Geocoder();
    var mapOptions = {
        center : new google.maps.LatLng(10.52764, 76.21443),
        zoom : 8,
        mapTypeId : google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map-canvas-one-pin"), mapOptions);
    google.maps.event.addListener(map, 'click', function(event) {
        //setMarker(event.latLng, map);
    });
}

function setMarker(location, map) {
    //alert("Location: " + location);
    var latlng = "" + location;
    var latlngarr = latlng.split(', ');
    lat = latlngarr[0].substring(1, latlngarr[0].length);
    lng = latlngarr[1].substring(0, latlngarr[1].length - 1);
    //	alert(lat + "," + lng);
    geoLocation = lat + "," + lng;
    if (marker) {
        marker.setMap(null);
    }
    var latlng = new google.maps.LatLng(lat, lng);
    geocoder.geocode({
        'latLng' : latlng
    }, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[0]) {
                map.setZoom(11);
                marker = new google.maps.Marker({
                    position : latlng,
                    map : map,
                    animation : google.maps.Animation.DROP
                });
                // alert(results[0].address_components[0].long_name);
                //$("#location").value = results[0].address_components[0].long_name;
                // $("#username").val= results;
                // 					$("#taskForm #location").val(
                // 							results[0].address_components[0].long_name);
                $("#taskForm #location").val(
                    results[0].address_components[0].long_name);
                exactLocation = results[0].formatted_address;
            } else {
                alert('No results found');
            }
        } else {
            alert('Geocoder failed due to: ' + status);
        }
    });
}

google.maps.event.addDomListener(window, 'load', initialize);