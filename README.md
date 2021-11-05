TRMS
TRMS or Tuition Reimbursement Management System is a full-stack web application that allows employees to submit requests for reimbursements for courses, events, and certifications. These requests can then be approved or rejected by the employee's direct supervisor, department head, and a benefits coordinator while the employee is able to track the status of their requests.

Technologies Used
Back-end: Java, SQL, Hibernate
Middle-tier: Javalin
Front-end: JavaScript, HTML, CSS, AJAX
Testing: Selenium, Cucumber, JUnit 4


Sample
1. End Points:
   http://localhost:7004/employee/2       //Used to retrieve employee 
    http://localhost:7004/employee         // endpoint used to create employee
    http://localhost:7004/employee/9    // endpoint used to update employee
2. ER Diagram 

 ![ER_MODEL](https://user-images.githubusercontent.com/66039997/140571702-6e607f55-719d-498d-965c-af9644635a45.JPG)



    
3. HTML for to Submit Request

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="TRMS_FORM.css">
  <title>TRMS Form</title>
  
</head>
<body>
  <center>
    <h1>For Reimbursements Request Fill out This Form</h1>
  </center>
 


<a href="REQUESTLIST.html">Click here to view submitted requests</a>
  
  <div class="container">
    <div class="row">
     <div class="col-md-6">
      <div class="card">
       <div class="box"> 
   
    <input type="text" class="text-muted" id="date" name="date" placeholder="Date">
    <input type="text" class="text-muted" id="time" name="time" placeholder="Time">
    <input type="text" class="text-muted" id="urgency" name="urgency" placeholder="urgency">
    <input type="text" class="text-muted" id="location" name="location" placeholder="Location">
    <input type="text" class="text-muted" id="description" name="description"  placeholder="Description">
    <input type="text" class="text-muted" id="cost" name="cost" placeholder="Cost">
    <input type="text" class="text-muted" id="event_start" name="event_start" placeholder="event_start">
    <input type="text" class="text-muted" id="attached_document" name="attached_document" placeholder="attached_document">
    
  <br>
  <br>
    <label for="myfile" class="text-muted">Select a file:</label>
    <input type="file" id="myfile" class="text-muted" name="myfile">
       
    <input type="submit" class="text-muted" name="submit" value="Submit" id="submit">
    
  </div>       
</div>
</div>
</div>
</div>
   

</body>
<script src="./TRMS.js"></script>
</html>





