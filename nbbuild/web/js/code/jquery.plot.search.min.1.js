/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    
    var defaultForm =  $('#defaultForm');
    var saleForm =  $('#saleForm');
    var rentForm =  $('#rentForm');
   
   
    defaultForm.setAttribute("action", 'DefualtSearchServlet');
    saleForm.setAttribute("action", 'SaleSearchServlet');
    rentForm.setAttribute("action", 'RentSearchServlet');
    

});

$("#building_btn").click(function(){
    alert("hai building_btn");
    
    var defaultForm =  $('#defaultForm');
    var saleForm =  $('#saleForm');
    var rentForm =  $('#rentForm');
    
    defaultForm.setAttribute("action", 'DefaultPlotServlet');
    saleForm.setAttribute("action", 'SaleSearchServlet');
    rentForm.setAttribute("action", 'RentSearchServlet');
});

$("#plot_btn").click(function(){
    //alert("hai plot_btn");
    
    var defaultForm =  $('#defaultForm');
    var saleForm =  $('#saleForm');
    var rentForm =  $('#rentForm');
    
    defaultForm.setAttribute("action", 'DefaultPlotServlet');
    saleForm.setAttribute("action", 'SaleSearchServlet');
    rentForm.setAttribute("action", 'RentSearchServlet');
});

//function setPlotProperty(){
//    alert("Select Plot Button");
//    defaultForm.setAttribute("action", 'DefaultPlotServlet');
//    saleForm.setAttribute("action", 'SaleSearchServlet');
//    rentForm.setAttribute("action", 'RentSearchServlet');
//}
function setBuilingProperty(){
    var param = "?type=building";
    defaultForm.setAttribute("action", 'DefualtSearchServlet'+param);
    saleForm.setAttribute("action", 'SaleSearchServlet'+param);
    rentForm.setAttribute("action", 'RentSearchServlet'+param);
}