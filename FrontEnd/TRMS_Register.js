document.addEventListener('DOMContentLoaded', function() {

   document.querySelector('#Register').addEventListener('click', register);

});

function register() {
  let supervisor = {
    "id": 3,
    "s_name": "Mike"
  };
let grade = {
  "id": 1,
  "presentation": "No",
  "class_grade": "Fail"
}

let department = {
  "id": 1,
  "d_name": "Transport"
}

  
    

  var name = document.querySelector('#name').value;
  var address = document.querySelector('#address').value;
  var username = document.querySelector('#username').value;
  var password = document.querySelector('#password').value;
 
  var title = document.querySelector('#title').value;
  
  var email = document.querySelector('#email').value;
  

 
  
  
    fetch('http://localhost:7004/employee', {
      method: 'POST',
      body: JSON.stringify({
        e_name: name,
        e_address: address,
        e_username: username,
        e_password: password,
        e_supervisor: supervisor,
        e_grade: grade,
        e_department: department,
        e_title: title,
        e_email: email,
      }),
    })
    .then(response => response.json())
    .then(result => {
        console.log(result);
         });
        
      
   
  }


            
        



  


