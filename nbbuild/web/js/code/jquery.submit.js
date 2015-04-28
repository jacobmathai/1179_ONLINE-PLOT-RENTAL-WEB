/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function checkProof(){
    // 13/6456/2011
    $("#submitForm #proof_msg").hide();
    var proofType = document.getElementById('submitForm')['proof'].value;
    var proof =  document.getElementById('proof_id').value;
    if(proofType == 'license'){
        var section =  proof.split("/");
        if(proof.length <= 0){
            $("#submitForm #proof_msg").show().html('<p class="error">Driver licence is required. Please enter your licence number.</p>');
            return false;
        } else {
            if(section[0].length == 2 && section[1].length == 4 && section[2].length == 4){
                if(isDigit(section[0]) && isDigit(section[1])&& isDigit(section[2])){
                    $("#submitForm #proof_msg").hide();
                } else {
                    //alert("Digits only");
                    $("#submitForm #proof_msg").show().html('<p class="error">Invalid format. Please enter valid licence number, eg 11/4512/2014.</p>');
                    return false;
                }
            } else {
                //alert("Mismatch sections");
                $("#submitForm #proof_msg").show().html('<p class="error">Invalid format. Please enter valid licence number, eg 11/4512/2014.</p>');
                return false;
            }
                
        }
    } else if(proofType == 'aadar') {
        if(proof.length <= 0){
            $("#submitForm #proof_msg").show().html('<p class="error">Adhaar number is required. Please enter your Adhaar number.</p>');
            return false;
        } else if(!isDigit(proof)){
            // alert("require digits on;y");
            $("#submitForm #proof_msg").show().html('<p class="error">Invalid format. Please enter valid adhaar number.</p>');
            return false;
        } else if(proof.length != 12) {
            //alert("Leght no met properly");
            $("#submitForm #proof_msg").show().html('<p class="error">Invalid format. Please enter valid 12 digit adhaar number.</p>');
            return false;
        } else if(proof.length == 12) {
            $("#submitForm #proof_msg").hide();
        }
    } else if(proofType == 'voter_id') {
        if(proof.length <= 0){
            $("#submitForm #proof_msg").show().html('<p class="error">Voter Id is required. Please enter your Voter Id.</p>');
            return false;
        } else if(proof.length != 10){
            //alert("Leght no met properly");
            $("#submitForm #proof_msg").show().html('<p class="error">Invalid format. Please enter valid (3 letter & 7 digit) Voter Id.</p>');
            return false;
        }else if(proof.length == 10) {
            var letterOne =    proof.substr(0, 1);
            var letterTwo =    proof.substr(1, 1);
            var letterThree =    proof.substr(2,1);
            var secondSection =    proof.substr(3, 10);
            //alert(letterOne + "-" + letterTwo + "-" + letterThree + " " + secondSection);
                            
            if(!isDigit(letterOne) && !isDigit(letterTwo) && !isDigit(letterThree) && isDigit(secondSection)){
                $("#submitForm #proof_msg").hide();
            } else {
                //alert("require digits only");
                $("#submitForm #proof_msg").show().html('<p class="error">Invalid format. Please enter valid Voter Id, eg KLN4512684.</p>');
                return false;
            }
        }
    }
}
      
$(function(){

    $('#submitForm').validate({
        rules: {
            prop_title:{
                required: true,
                minlength: 5
                        
            },
            location: {
                required: true                            
            },
            prop_image: {
                required: true                                    
            },
            prop_type: {
                required: true                                    
            },
            city: {
                required: true                                    
            },
            pub_location: {
                required: true                                    
            },
            distance: {
                required: true                                    
            },
            address: {
                required: true,
                minlength: 10
            },
            description: {
                required: true,
                minlength: 10 
            },
            area: {
                required: true                                    
            },
            rate: {
                required: true,
                minlength:3
            },
            bedrooms: {
                required: true,
                digits:true,
                maxlegth:1
            },
            bathrooms: {
                required: true,
                digits:true,
                maxlegth:1
            },
            contract_type: {
                required: true                                    
            },
            photo1: {
                required: true                                    
            },
            photo2: {
                required: true                                    
            },
            photo3: {
                required: true                                    
            },
            video: {
                required: true                                    
            }
                    
        },
        messages: {
            prop_title:{
                required: "Please enter a Tiltle",
                minlength: "Property name must be consist of at least 5 characters"
                            
            },
            location:{
                required: "Location is required. Please your click location on map."
            },
            prop_image:{
                required: "Property image is required. Please browse image of your property."
            },
            prop_type:{
                required: "Property type is required. Please chose the given Property types."
            },
            city:{
                required: "City name is required. Please enter city name."
            },
            pub_location:{
                required: "Public location is required. Please enter nearest public location."
            },
            distance:{
                required: "Distance is required. Please enter distance to public location."
            },
            address:{
                required: "Address is required. Please enter the address.",
                minlength: "Property address must be consist of at least 10 characters"
            },
            description:{
                required: "Description is required. Please enter the plot description.",
                minlength: "Plot description must be consist of at least 10 characters"
            },
            rate: {
                required: "Price is required. Please enter the Property rate.",
                minlength: "Property price must be consist of at least 3 digits."
                       
            },
            area:{
                required: "Area is required. Please enter the area in sqft."
                     
            },
            bedrooms:{
                required: "Bedrooms is required. Please enter the no of bedrooms",
                digits:"Bedrooms field must be consist of digits only."
            },
            bathrooms:{
                required: "Bathroom is required. Please enter the no of bedrooms",
                digits:"Bathroom field must be consist of digits only."
            },
            contract_type:{
                required: "Contract type is required. Please chose the given Contract types."
            },
            photo1:{
                required: "Photo1 is required. Please browse image of your property."
            },
            photo2:{
                required: "Photo2 is required. Please browse image of your property."
            },
            photo3:{
                required: "Photo3 is required. Please browse image of your property."
            },
            video:{
                required: "Video is required. Please browse video of your property."
            } 
        }
    });

});
    
        
        
$(function() {
    setTimeout(function() {
        $("#msg").fadeOut(1500);
    }, 5000)

});