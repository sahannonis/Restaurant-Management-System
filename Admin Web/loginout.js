function login(){

    var userEmail = document.getElementById("email_field").value;
    var userPass = document.getElementById("password_field").value;
  
    firebase.auth().signInWithEmailAndPassword(userEmail, userPass).then(user => {
        // Sign in success
        window.location = 'index.html';
    }).catch(error => {
        console.error(error);
    })
  
  }
  
  function logout(){
    firebase.auth().signOut();
    window.location = 'login.html';
  }
  