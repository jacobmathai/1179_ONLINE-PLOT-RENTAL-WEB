
/*
 ["23944","dfdfsdfsdf","fghfghfghfghfghfgh","Thiruvankulam, Kerala, India"],
["336401","17 Avenue Street","sdefasdfasd","Kerala 682302, India"],
["36512","12 B SkyLine","Address of my sweet apartment","Vivekanand Nagar, Kesavadasapuram, Thiruvananthapuram, Kerala, India"],
["733731","10th North Cross Road","Address here","Eroor South, Eroor, Ernakulam, Kerala, India"]] 
 */
var map;
var infowindow;
var bounds;
var markers = [];

$(document).ready(function(){
    initialize();
    defaultAction();
//alert("init");
});

function initialize() {
    map = new google.maps.Map(document.getElementById('map-canvas'));
    bounds = new google.maps.LatLngBounds();
    infowindow = new google.maps.InfoWindow();
}


//google.maps.event.addDomListener(window, 'load', initialize);


function defaultAction() {
    
    var plotData =  loadMapSettings();
    //  for (var i in LocationData){
    for (var i in plotData){
        //alert(plotData[i]);
        var p = plotData[i];
        
        var location =  p[3].split(",");
        var latlng = new google.maps.LatLng(location[0],location[1]);
        //alert("Latlan: " + latlng);
        
        
        var contentString = '<div class="info-box"><img src="SEARCH/photo_01_'+p[0]+'.jpg"'
        +' style="max-width:100%; margin-bottom:10px;" alt="" /><h4>'
        +p[1]+'</h4><p>'+p[2]+' </p></div>';
        
        bounds.extend(latlng);
        var marker = new google.maps.Marker({
            position: latlng,
            map: map,
            title: contentString,
            icon: 'images/pin.png'

        });
        markers.push(marker); // add to markers array
       
        //     
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent(this.title);
            infowindow.open(map, this);
        });
    }
     
    map.fitBounds(bounds);

}

$('#defaultForm #searchBtn1').click(function(){
    //initialize();
    clearMarkers();
    //alert("Click btn1");
    var plotData = loadInitSettings();
    //  for (var i in LocationData){
    for (var i in plotData){
        //alert(plotData[i]);
        var p = plotData[i];
        
        var location =  p[3].split(",");
        var latlng = new google.maps.LatLng(location[0],location[1]);
        //alert("Latlan: " + latlng);
        
        
        var contentString = '<div class="info-box"><img src="SEARCH/photo_01_'+p[0]+'.jpg"'
        +' style="max-width:100%; margin-bottom:10px;" alt="" /><h4>'
        +p[1]+'</h4><p>'+p[2]+' </p></div>';
        
        bounds.extend(latlng);
        var marker = new google.maps.Marker({
            position: latlng,
            map: map,
            title: contentString,
            icon: 'images/pin.png'

        });
        markers.push(marker); // add to markers array
       
        //     
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent(this.title);
            infowindow.open(map, this);
        });
    }
     
    map.fitBounds(bounds);

});

$('#saleForm #searchBtn2').click(function(){
    //alert("Click btn2");
    clearMarkers();
    // initialize();
    var plotData = loadSaleSettings();
   
    //  for (var i in LocationData){
    for (var i in plotData){
        //alert(plotData[i]);
        var p = plotData[i];
        
        var location =  p[3].split(",");
        var latlng = new google.maps.LatLng(location[0],location[1]);
        //alert("Latlan: " + latlng);
        
        
        var contentString = '<div class="info-box"><img src="SEARCH/photo_01_'+p[0]+'.jpg"'
        +' style="max-width:100%; margin-bottom:10px;" alt="" /><h4>'
        +p[1]+'</h4><p>'+p[2]+' </p></div>';
    
        bounds.extend(latlng);
        var marker = new google.maps.Marker({
            position: latlng,
            map: map,
            title: contentString,
            icon: 'images/pin.png'

        });
        markers.push(marker); // add to markers array
       
        //     
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent(this.title);
            infowindow.open(map, this);
        });
    }
     
    map.fitBounds(bounds);

});
$('#rentForm #searchBtn3').click(function(){
    //alert("Click btn3");
    clearMarkers();
    //initialize();
    var plotData = loadRentSettings();
    //  for (var i in LocationData){
    for (var i in plotData){
        //alert(plotData[i]);
        var p = plotData[i];
        
        var location =  p[3].split(",");
        var latlng = new google.maps.LatLng(location[0],location[1]);
        //alert("Latlan: " + latlng);
        
        
        var contentString = '<div class="info-box"><img src="SEARCH/photo_01_'+p[0]+'.jpg"'
        +' style="max-width:100%; margin-bottom:10px;" alt="" /><h4>'
        +p[1]+'</h4><p>'+p[2]+' </p></div>';
        
        bounds.extend(latlng);
        var marker = new google.maps.Marker({
            position: latlng,
            map: map,
            title: contentString,
            icon: 'images/pin.png'

        });
        
        markers.push(marker); // add to markers array
       
        //     
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent(this.title);
            infowindow.open(map, this);
        });
    }
     
    map.fitBounds(bounds);

});





function loadMapSettings(){
    var output =  dhtmlxAjax.getSync("MapLoadingAjaxServlet");
    var data =  output.xmlDoc.responseText;
    console.log("Defaulr data: " + data);
    var jsonArray = JSON.parse(data);
    return jsonArray;
}


function loadInitSettings(){
    
    var propType =  $('#defaultForm #propertyType').val();
    var city =  $('#defaultForm #location').val();
    var price =  $('#defaultForm #charge').val();
    var beds =  $('#defaultForm #beds').val();
    var baths =  $('#defaultForm #baths').val();
    var area =  $('#defaultForm #area').val();
    var type = 'All';
 
   
    //alert("Price: " + price + " city: " + city + " pro: " + propType + " Bed: " + beds + " Baths: " + baths + " Area: " + area);
    var param = '?propType='+propType+'&city='+city+'&price='+price+'&beds='+beds+'&baths='+baths+'&area='+area+'&type='+type;
    var output =  dhtmlxAjax.getSync("DetailedMapLoadingServlet"+param);
    var data =  output.xmlDoc.responseText;
    
    var jsonArray = JSON.parse(data);
    return jsonArray;
}
function loadSaleSettings(){
    var propType =  $('#saleForm #propertyType2').val();
    var city =  $('#saleForm #location2').val();
    var price =  $('#saleForm #price').val();
    var beds =  $('#saleForm #beds2').val();
    var baths =  $('#saleForm #baths2').val();
    var area =  $('#saleForm #area2').val();
    var type = 'For_Sale';
 
   
    //alert("Price: " + price + " city: " + city + " pro: " + propType + " Bed: " + beds + " Baths: " + baths + " Area: " + area);
    var param = '?propType='+propType+'&city='+city+'&price='+price+'&beds='+beds+'&baths='+baths+'&area='+area+'&type='+type;
    var output =  dhtmlxAjax.getSync("DetailedMapLoadingServlet"+param);
    var data =  output.xmlDoc.responseText;
    
    var jsonArray = JSON.parse(data);
    console.log("Sale Value: " + data);
    return jsonArray;
}

function loadRentSettings(){
    var propType =  $('#rentForm #propertyType3').val();
    var city =  $('#rentForm #location3').val();
    var price =  $('#saleForm #price').val();
    var beds =  $('#rentForm #beds3').val();
    var baths =  $('#rentForm #baths3').val();
    var area =  $('#rentForm #area3').val();
    var type = 'For_Rent';
 
    //alert(downPrice + " " + maxPrice + " city: " + city + " pro: " + propType + " Bed: " + beds + " Baths: " + baths + " Area: " + area);alert(downPrice + " " + maxPrice + " city: " + city + " pro: " + propType + " Bed: " + beds + " Baths: " + baths + " Area: " + area);
    var param = '?propType='+propType+'&city='+city+'&price='+price+'&beds='
    +beds+'&baths='+baths+'&area='+area+'&type='+type;
    var output =  dhtmlxAjax.getSync("DetailedMapLoadingServlet"+param);
    var data =  output.xmlDoc.responseText;
    console.log("Rent Value: " + data);
    var jsonArray = JSON.parse(data);
    return jsonArray;
}


// Sets the map on all markers in the array.
function setAllMap(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

// Removes the markers from the map, but keeps them in the array.
function clearMarkers() {
    setAllMap(null);
}
