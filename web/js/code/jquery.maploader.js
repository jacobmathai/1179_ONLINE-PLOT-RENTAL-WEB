// This example adds a search box to a map, using the Google Place Autocomplete
// feature. People can enter geographical searches. The search box will return a
// pick list containing a mix of places and predicted search terms.

function initialize() {
	var markers = [];
	 geocoder = new google.maps.Geocoder();
	 //var markers = [];
  var map = new google.maps.Map(document.getElementById('mapDiv'), {
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });

  var defaultBounds = new google.maps.LatLngBounds(
      new google.maps.LatLng(9.966395,76.293958),  //-33.8902, 151.1759
      new google.maps.LatLng(9.934395,76.313958)); //-33.8474, 151.2631
  map.fitBounds(defaultBounds);

  // Create the search box and link it to the UI element.
  var input = /** @type {HTMLInputElement} */(
      document.getElementById('pac-input'));
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  var searchBox = new google.maps.places.SearchBox(
    /** @type {HTMLInputElement} */(input));

  // [START region_getplaces]
  // Listen for the event fired when the user selects an item from the
  // pick list. Retrieve the matching places for that item.
  google.maps.event.addListener(searchBox, 'places_changed', function() {
    var places = searchBox.getPlaces();

    if (places.length == 0) {
      return;
    }
    for (var i = 0, marker; marker = markers[i]; i++) {
      marker.setMap(null);
    }

    // For each place, get the icon, place name, and location.
    markers = [];
    var bounds = new google.maps.LatLngBounds();
    for (var i = 0, place; place = places[i]; i++) {
      var image = {
        url: place.icon,
        size: new google.maps.Size(71, 71),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 34),
        scaledSize: new google.maps.Size(25, 25)
      };

      // Create a marker for each place.
      var marker = new google.maps.Marker({
        map: map,
        icon: image,
        title: place.name,
        position: place.geometry.location
      });

      markers.push(marker);

      bounds.extend(place.geometry.location);
    }

    map.fitBounds(bounds);
  });
  // [END region_getplaces]

  // Bias the SearchBox results towards places that are within the bounds of the
  // current map's viewport.
  google.maps.event.addListener(map, 'bounds_changed', function() {
    var bounds = map.getBounds();
    searchBox.setBounds(bounds);
  });
  
  //Get Location when click any point on the map
  google.maps.event.addListener(map, 'click', function(event) {
	 var geocoder = new google.maps.Geocoder();
      setMarker(event.latLng, map, geocoder, markers);
  });

  
}
var marker;
function setMarker(location,map,geocoder,markers){
	
	//alert(location + " " + map + " " + geocoder + " " + markers);
	
	 var latlng = "" + location;
     var latlngarr = latlng.split(', ');
     var lat  = latlngarr[0].substring(1, latlngarr[0].length);
     var lng   = latlngarr[1].substring(0, latlngarr[1].length-1);
    

     
     if(marker){    
         marker.setMap(null);
     }
     
     var latlng = new google.maps.LatLng(lat, lng);
     geocoder.geocode({'latLng': latlng}, function(results, status) {
         if (status == google.maps.GeocoderStatus.OK) {
             if (results[1]) {
                 map.setZoom(11);
                 marker = new google.maps.Marker({
                     position: latlng,
                     map: map,
                     animation: google.maps.Animation.DROP
                 });
                 document.getElementById("location").value = results[1].formatted_address;
                // document.getElementById("location").value = results[0].address_components[0].long_name;
                 map.panTo(latlng);
             } else {
                 alert('No results found');
             }
         } else {
             alert('Geocoder failed due to: ' + status);
         }
     });
	
}

google.maps.event.addDomListener(window, 'load', initialize);
