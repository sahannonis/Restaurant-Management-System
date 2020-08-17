

var database = firebase.database();

var ref = database.ref('items/pizza');
ref.on('value',gotData);


function gotData(data){
    console.log(data.val());
   pizza = data.val();
   keys = Object.keys(pizza);
   console.log(keys);

}
function delnode(){
    var name = document.getElementById("name").value;  
    var k = keys[name-1];
    var ref = firebase.database().ref("items/pizza/" + k);
     ref.remove();
 }