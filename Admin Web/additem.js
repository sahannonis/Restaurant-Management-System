var database = firebase.database();
var storage = firebase.storage();



function add(){
    
var image        = document.getElementById("urlcode").value;
var name         = document.getElementById("name").value;
var code         = document.getElementById("code").value;
var small        = document.getElementById("small").value;
var medium       = document.getElementById("medium").value;
var large        = document.getElementById("large").value;
var description  = document.getElementById("description").value;



var data = {
    imagename : image,
    name : name,
    code : code,
    small : small,
    medium : medium,
    large : large,
    description : description
}
console.log(data);
var ref = database.ref('items/pizza');

ref.push(data);
window.alert("Inserted to Database, Clear the fields");
}

function reset(){
    document.getElementById('urlcode').value = '';
    document.getElementById('name').value = '';
    document.getElementById("code").value = '';
    document.getElementById("small").value = '';
    document.getElementById("medium").value = '';
    document.getElementById("large").value = '';
    document.getElementById("description").value = '';
   }
 
   function add1(){
    
    var image1        = document.getElementById("urlcode1").value;
    var name1         = document.getElementById("name1").value;
    var code1         = document.getElementById("code1").value;
    var small1        = document.getElementById("small1").value;
 
    var large1        = document.getElementById("large1").value;
    var description1  = document.getElementById("description1").value;
    
    
    
    var data = {
        imagename : image1,
        name : name1,
        code : code1,
        small : small1,

        large : large1,
        description : description1
    }
    var selector = document.getElementById('choose');
    var value = selector[selector.selectedIndex].value;
    
    console.log(data);
    var ref = database.ref('items/'+ value + '/');
    
    ref.push(data);
    window.alert("Inserted to Database, Clear the fields");
    }
    
    function reset1(){
        document.getElementById('urlcode1').value = '';
        document.getElementById('name1').value = '';
        document.getElementById("code1").value = '';
        document.getElementById("small1").value = '';
    
        document.getElementById("large1").value = '';
        document.getElementById("description1").value = '';
       }