
    
document.addEventListener('DOMContentLoaded', function() {

// Use buttons to toggle between views
      document.querySelector('#submit').addEventListener('click', request);
     
    });

function request() {
      let event = {
        "id": 1,
        "events": "University Courses"
    };
    let grade = {
      "id": 3,
      "presentation": "Yes",
      "class_grade": "Pass"
    };
    
        
    let bca = {
      "id":1,
      "name":"Paul"
    };

     let employee = {
      "id": 9,
      "e_name": "Mike",
      "e_address": "home",
      "e_username": "user",
      "e_password": "password",
      "e_supervisor": {
          "id": 2,
          "s_name": "David"
      },
      "e_title": "title",
      "e_grade": {
          "id": 1,
          "presentation": "Yes",
          "class_grade": "Pass"
      },
      "e_department": {
          "id": 1,
          "d_name": "TransportB"
      },
      "e_email": "email"
  };
   
      
        
      
      var date = document.querySelector('#date').value;
      var time = document.querySelector('#time').value;
      var urgency = document.querySelector('#urgency').value;
      var location = document.querySelector('#location').value;
      var description = document.querySelector('#description').value;
      var cost = document.querySelector('#cost').value;
      var start = document.querySelector('#event_start').value;
      var attached_document = document.querySelector('#attached_document').value;
      
    
     
      
      
        fetch('http://localhost:7005/request', {
          method: 'POST',
          body: JSON.stringify({
            employee_id: employee,
            urgency: urgency,
            date: date,
            time: time,
            location: location,
            event_type: event,
            description: description,
            event_start_date: start,
            requested_cost: cost,
            attached_document: attached_document, 
            grading_format: grade,
            event_reimb_cost: 0,
            approved_by_ds: false,
            approved_by_dh: false,
            bca_id: bca,
            approved_by_bca: false,
          }),
        })
        .then(response => response.json())
        .then(result => {
            alert("Request Submitted!!!");
             });
            
          
       
      }
    