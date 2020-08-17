var database = firebase.database();
var storage = firebase.storage();

var textInput = document.getElementById('urlcode');

function handleFileSelect(e) {
    var file = e.target.files[0];
    // Get a reference to the location where we'll store our photos
    var storageRef = storage.ref().child('pizza');
    
    // Get a reference to store file at photos/<FILENAME>.jpg
    var photoRef = storageRef.child(file.name);
    // Upload file to Firebase Storage
    var uploadTask = photoRef.put(file);
    uploadTask.on('state_changed', null, null, function() {
      // When the image has successfully uploaded, we get its download URL
    var downloadUrl = uploadTask.snapshot.getDownloadURL;
      // Set the download URL to the message box, so that the user can send it to the database
    photoRef.getDownloadURL().then(function(url) {
        
        textInput.value = url;
        image = url;
        window.alert(image);
})
      
    });
  }
  file.addEventListener('change', handleFileSelect, false);
  
  function pop(){
    /* Get the text field */
  var copyText = document.getElementById("urlcode");

  /* Select the text field */
  copyText.select();

  /* Copy the text inside the text field */
  document.execCommand("copy");

}
  