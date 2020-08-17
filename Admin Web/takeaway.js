
var database = firebase.database();


var ref = database.ref('Order/Take-away');
ref.on('value',gotData,errData);

function gotData(data){
    console.log(data.val());
   var item = data.val();
   
   var keys = Object.keys(item);
   console.log(keys);
   for (var i = 0;i<keys.length; i++){
     var k = keys[i];
     if(item[k].Name != null && item[k].Quantity){
      var name = item[k].Name;
      
      var quantity = item[k].Quantity;
       
    console.log(name);
    console.log(quantity);
    }
      else if (item[k].Code !=null && item[k].Date !=null){
         var code = item[k].Code;
         var Dates = item[k].Date;
          console.log(code);
         console.log(Dates);
      }     
    }
   }
function errData(err){
    console.log("Error!");
    console.log(err);
}