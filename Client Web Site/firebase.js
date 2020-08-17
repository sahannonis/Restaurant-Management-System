var database = firebase.database();
var ref = database.ref('items/pizza');

ref.on('value',gotData,errData);


function gotData(data){

    /*var lists= selectAll('.list');
    for(var i=0; i< lists.length; i++ ){
        lists[i].remove();
    }*/

    console.log(data.val());
    var pizza = data.val();
    var keys = Object.keys(pizza);
    //console.log(keys);
    for (var i = 0;i<keys.length; i++){
        var k = keys[i]
        var name = pizza[k].name;
        var description = pizza[k].description;
        var small = pizza[k].small;
        var medium = pizza[k].medium;
        var large = pizza[k].large;
        var url = pizza[k].imagename ;

        var h = document.createElement("h3");
        var desc = document.createElement("p");
        var para = document.createElement("p");
        
        
        

        h.innerHTML = name ;
        desc.innerHTML= description;
        para.innerHTML = "Small:"+small+" LKR"+"<br>"+"Medium: "+medium+" LKR"+"<br>"+"Large: "+large+" LKR";
      
        document.getElementById("object"+i).appendChild(h);
        document.getElementById("desc"+i).appendChild(desc);
        document.getElementById("para"+i).appendChild(para);
        var img = document.getElementById("img"+i);
       
        img.src = url;
        img.url =url;

       
        
    }
}

function errData(err){
    console.log("Error!");
    console.log(err);
}


// for drinks menu


var dref = database.ref('items/Drinks');
dref.on('value',gotData1,errData1);

function gotData1(data){
  
    console.log(data.val());
    var Drinks = data.val();
    var keys1 = Object.keys(Drinks);
    //console.log(keys);
    for (var i = 0;i<keys1.length; i++){
        var k1= keys1[i]
        var dname = Drinks[k1].name;
        var ddescription = Drinks[k1].description;
        var dsmall = Drinks[k1].small;
        
        var dlarge = Drinks[k1].large;
        var durl = Drinks[k1].imagename ;

        var h2 = document.createElement("h3");

        h2.innerHTML = dname;
        
       var para2 = document.createElement("p");
       var desc2=document.createElement("p");
       desc2.innerHTML=ddescription;
       
 
        
        
       para2.innerHTML ="Small:"+dsmall+" LKR"+"<br>"+"Large: "+dlarge+" LKR";
       document.getElementById("para2"+i).appendChild(para2);
       document.getElementById("desc2"+i).appendChild(desc2);
       document.getElementById("object2"+i).appendChild(h2);
       
       var img1 = document.getElementById("img2"+i);
       img1.src = durl;
       img1.url =durl;
        
    }

}


function errData1(err){
    console.log("Error!");
    console.log(err);
}

//for desserts tab

var dref = database.ref('items/Dessert');
dref.on('value',gotData2,errData2);

function gotData2(data){
  
    console.log(data.val());
    var Dessert = data.val();
    var keys2 = Object.keys(Dessert);
    //console.log(keys);
    for (var i = 0;i<keys2.length; i++){
        var k2= keys2[i]
        var desname = Dessert[k2].name;
        var desdescription = Dessert[k2].description;
        var dessmall = Dessert[k2].small;
        
        var deslarge = Dessert[k2].large;
        var desurl = Dessert[k2].imagename ;

        var h3 = document.createElement("h3");

        h3.innerHTML = desname;
        
       var para3 = document.createElement("p");
       var desc3=document.createElement("p");
       desc3.innerHTML=desdescription;
 
       para3.innerHTML ="Small:"+dessmall+" LKR"+"<br>"+"Large: "+deslarge+" LKR";
       document.getElementById("para3"+i).appendChild(para3);
       document.getElementById("desc3"+i).appendChild(desc3);
       document.getElementById("object3"+i).appendChild(h3);
       
       var img3 = document.getElementById("img3"+i);
       img3.src = desurl;
       img3.url =desurl;
        
    }

}


function errData2(err){
    console.log("Error!");
    console.log(err);
}

//for pasta tab

var dref = database.ref('items/Pasta');
dref.on('value',gotData3,errData3);

function gotData3(data){
  
    console.log(data.val());
    var Pasta = data.val();
    var keys3 = Object.keys(Pasta);
    //console.log(keys);
    for (var i = 0;i<keys3.length; i++){
        var k3= keys3[i]
        var pastaname = Pasta[k3].name;
        var pastadescription = Pasta[k3].description;
        var pastasmall = Pasta[k3].small;
        
        var pastalarge = Pasta[k3].large;
        var pastaurl = Pasta[k3].imagename ;

        var h4 = document.createElement("h3");

        h4.innerHTML = pastaname;
        
       var para4 = document.createElement("p");
       var desc4=document.createElement("p");
       desc4.innerHTML=pastadescription;
 
       para4.innerHTML ="Small:"+pastasmall+" LKR"+"<br>"+"Large: "+pastalarge+" LKR";
       document.getElementById("para4"+i).appendChild(para4);
       document.getElementById("desc4"+i).appendChild(desc4);
       document.getElementById("object4"+i).appendChild(h4);
       
       var img4 = document.getElementById("img4"+i);
       img4.src = pastaurl;
       img4.url =pastaurl;
        
    }

}


function errData3(err){
    console.log("Error!");
    console.log(err);
}


