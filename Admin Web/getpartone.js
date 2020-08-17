var database = firebase.database();
var ref = database.ref('items/pizza');
ref.on('value',gotData,errData);




function gotData(data){
    console.log(data.val());
   var pizza = data.val();
   var keys = Object.keys(pizza);
   console.log(keys);
   for (var i = 0;i<keys.length; i++){
       var k = keys[i];
       var name = pizza[k].name;
       var description = pizza[k].description;
       var small = pizza[k].small;
       var medium = pizza[k].medium;
       var large = pizza[k].large;

       var para = document.createElement("P");
  para.innerHTML = name + ','+ description +','+small +','+ medium +','+ large;
  document.getElementById("myDIV").appendChild(para);
   }


}


function errData(err){
    console.log("Error!");
    console.log(err);
}