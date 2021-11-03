

 
 var attempt = 3; // Variable to count number of attempts.
 // Below function Executes on click of login button.
 async function validate(){
  var employeeid = document.querySelector('#employeeId').value;
  var username = document.querySelector('#username').value;
  var password = document.querySelector('#password').value;
 
  const url = `http://localhost:7004/employee/${employeeid}`;

      const httpResponse = await fetch(url);
      const body = await httpResponse.json();
      console.log(body);

 if ( username == body.e_username && password == body.e_password){
 alert ("Login successfully");
 window.location = "EMPLOYEE_PAGE.html"; // Redirecting to other page.
 return false;
 }
 else{
 attempt --;// Decrementing by one.
 alert("You have left "+attempt+" attempt;");
 // Disabling fields after 3 attempts.
 if( attempt == 0){
  document.querySelector('#username').disabled = true;
  document.querySelector('#password').disabled = true;
  document.querySelector('#Login').disabled = true;
 return false;
 }
 }
}
 

 
 
  
       
     
  
 


           
       



 


