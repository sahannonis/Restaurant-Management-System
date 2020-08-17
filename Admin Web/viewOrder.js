var database = firebase.database();

var refs = database.ref('Cart');
refs.on('value',gotDa,errDa);

function gotDa(data){
console.log(data.val());

var node = data.val();
var nodekey = Object.keys(node);

for (var x = 0;x<nodekey.length; x++){
  var nkey = nodekey[x];
var ref = database.ref('Cart/'+nkey+'');
ref.on('value',gotData,errData);
var total = 0;
function gotData(data){
    console.log(data.val());
   var item = data.val();
   
   var keys = Object.keys(item);
   console.log(keys);
   for (var i = 0;i<keys.length; i++){
     var k = keys[i];

if(item[k].name != null && item[k].price != null){
      var name = item[k].name;
      var price = item[k].price;
    console.log(name);
    console.log(price);
    total = total + parseInt(price);
  }
else if(item[k].type != null){
  var type = item[k].type;
  console.log(type);
}   

    
    
    }
   console.log(total);
   }
}
}

function errDa(err){
    console.log("Error!");
    console.log(err);
}

function errData(err){
    console.log("Error!");
    console.log(err);
}