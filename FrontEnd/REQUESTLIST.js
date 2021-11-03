
document.addEventListener('DOMContentLoaded', function() {
// Use buttons to toggle between views


document.querySelector("#request").addEventListener('click', getRequest);

document.querySelector("#rimb").addEventListener('click', changeimb);
     
document.querySelector("#Supervisor").addEventListener('click', Supervisor);
     
document.querySelector("#DepartmentHead").addEventListener('click', DepartmentHead);

document.querySelector("#BCA").addEventListener('click', BCA);

document.querySelector("#SupervisorD").addEventListener('click', SupervisorD);

document.querySelector("#DepartmentHeadD").addEventListener('click', DepartmentHeadD);
document.querySelector("#BCAD").addEventListener('click', BCAD);

document.querySelector("#SupervisorI").addEventListener('click', SupervisorI);

document.querySelector("#DepartmentHeadI").addEventListener('click', DepartmentHeadI);

document.querySelector("#BCAI").addEventListener('click', BCAI);


});


function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}



async function getRequest() {
  const id = document.getElementById("idInput").value;
  const url = `http://localhost:7005/request/${id}`;
  const httpResponse = await fetch(url);
  const body = await httpResponse.json();
  console.log(body);

  // function sleep(ms) {
  //   return new Promise(resolve => setTimeout(resolve, ms));
  // }
  
  // async function delayedApproval() {
  //   await sleep(10000);
  //   document.querySelector("#informationS").innerHTML = "Approved by Supervisor";
  //   await sleep(10000);
  //   document.querySelector("#informationD").innerHTML = "Approved by Department Head";
  //   await sleep(10000);
  //   alert("Email Will be Sent to BC Supervisor!!!");
  // }
  
  
  // delayedApproval();
  // document.querySelector("#informationS").innerHTML = "";

  document.querySelector('#employee_id').innerHTML = "Request Submited by: " + body.employee_id.e_name;
  // document.querySelector('#urgency').innerHTML = "Request's Urgency: " + body.urgency;
  document.querySelector('#date').innerHTML = "Request Date: " + body.date;
  document.querySelector('#time').innerHTML = "Request Time: " + body.time;
  document.querySelector('#location').innerHTML = "Event Location: " + body.location;
  document.querySelector('#description').innerHTML = "Event Description: " + body.description;
  document.querySelector('#events').innerHTML = "Event Type: " + body.event_type.events;
  document.querySelector('#grades').innerHTML = "Class Grade: " + body.grading_format.class_grade;
  document.querySelector('#grades2').innerHTML = "Presentation: " + body.grading_format.presentation;
  document.querySelector('#event_start_date').innerHTML = "Event Start Date: " + body.event_start_date;
  document.querySelector('#requested_cost').innerHTML = "Requested Imbursement Cost: " + body.requested_cost;
  
  document.querySelector('#event_reimb_cost').innerHTML =  "Approved Reimbursement Cost: " + body.event_reimb_cost;
  document.querySelector('#approved_by_ds').innerHTML = "Approved by Direct Supervisor?: " + body.approved_by_ds;
  document.querySelector('#approved_by_dh').innerHTML = "Approved by Department Head?: " + body.approved_by_dh;
  document.querySelector('#approved_by_bca').innerHTML = "Approved by Benefit Coordinator?: " + body.approved_by_bca;

  

  var eventtime = new Date(body.event_start_date);
  var currentDateObj = new Date();
  var numberOfMlSeconds = currentDateObj.getTime();
  var addMlSeconds = 14*24*60*60*1000;
  var newDateObj = new Date(numberOfMlSeconds + addMlSeconds);

  console.log(newDateObj);
  

  if(eventtime < newDateObj){
    document.querySelector('#urgency').innerHTML = "Request's Urgency: Urgent";
    document.querySelector('#urgency').style.color = "red";
    document.querySelector('#urgency').style.fontWeight = "bold";
    } else{
      document.querySelector('#urgency').innerHTML = "Request's Urgency: Not Urgent";
      document.querySelector('#urgency').style.color = "black";
    }

   if (body.attached_document == null){
     document.querySelector('#additional_attached_document').innerHTML = "This Request needs additional Document";
     document.querySelector('#additional_attached_document').style.color = red;
     } else {document.querySelector('#attached_document').innerHTML = "Attached Document: " + body.attached_document;
  }




}






async function changeimb() {
  const id4 = document.getElementById("idInput").value;
  // const url = `http://localhost:7004/request/${id4}`;
  // const httpResponse = await fetch(url);
  // const body2 = await httpResponse.json();
  // console.log(body2);

  fetch(`http://localhost:7007/request/${id4}`)
  .then(response => response.json())
  .then(body2 => {
    //  console.log(body2.event_type.events);
    
  
  

  const cost = document.getElementById("change_reimb").value;
  let pending = 0;
  let given = 0;
  let current = new Date();
  let cDate =  current.getMonth()+1;
  let TotalImbursementAvailable;
  let uni = "University Courses";
  let semi = "Seminars";
  let cerp = "Certification Preparation Classes";
  let cer = "Certification";
  let cer2 = "Certifications";
  let tec = "Technical Training";
  let oth = "Other";
  let bod = body2.event_type.events;
  // console.log(bod.toUpperCase());
  // console.log(uni.toUpperCase());
  if(bod.toUpperCase() == (uni.toUpperCase() || cer2.toUpperCase())){
    given = cost * 0.8;
  }else if(bod.toUpperCase() == semi.toUpperCase()){
    given = cost * 0.6;
  }else if(bod.toUpperCase() == cerp.toUpperCase()){
    given = cost * 0.75;
  }else if(bod.toUpperCase() == cer.toUpperCase()){
    given = cost ;
  }else if(bod.toUpperCase() == tec.toUpperCase()){
    given = cost * 0.9;
  }else if(bod.toUpperCase() == oth.toUpperCase()){
    given = cost * 0.3;
  }else{
    given = 0;
  }

  
  //  console.log(body2.employee_id.e_name);

 fetch(`http://localhost:7005/request/${id4}`, {
    method: "PUT",
    body: JSON.stringify({
      id: body2.id,
      employee_id: body2.employee_id.e_name,
            urgency: body2.urgency,
            date: body2.date,
            time: body2.time,
            location: body2.location,
            event_type: body2.event_type,
            description: body2.description,
            event_start_date: body2.event_start_date,
            requested_cost: body2.cost,
            attached_document: body2.attached_document, 
            grading_format: body2.grading_format,
            event_reimb_cost: given,
            approved_by_ds: body2.approved_by_ds,
            approved_by_dh: body2.approved_by_dh,
            bca_id: body2.bca_id,
            approved_by_bca: body2.approved_by_bca,
    }),
  });

 
  document.querySelector('#event_reimb_cost').innerHTML =  "Approved Reimbursement Cost: " +  given;
  


  if(cDate == 01 || cDate == 1){
    TotalImbursementAvailable = 1000;
  } else{
    TotalImbursementAvailable = 1000 -(given + pending);
  }
});
  
}






function Supervisor(){
  document.querySelector("#SupervisorI").style.backgroundColor = "white";
  document.querySelector("#SupervisorD").style.backgroundColor = "white";
  document.querySelector("#Supervisor").style.backgroundColor = "green";
  document.querySelector("#informationS").innerHTML = "Approved by Supervisor";
 
  }


function DepartmentHead(){
  document.querySelector("#DepartmentHeadI").style.backgroundColor = "white";
  document.querySelector("#DepartmentHeadD").style.backgroundColor = "white";
  document.querySelector("#DepartmentHead").style.backgroundColor = "green";
  document.querySelector("#informationD").innerHTML = "Approved by Department Head";
  }


function BCA(){
  document.querySelector("#BCAI").style.backgroundColor = "white";
  document.querySelector("#BCAD").style.backgroundColor = "white";
  document.querySelector("#BCA").style.backgroundColor = "green";
  document.querySelector("#informationB").innerHTML = "Approved by BCA";
  }


function SupervisorD(){
  document.querySelector("#SupervisorI").style.backgroundColor = "white";
  document.querySelector("#Supervisor").style.backgroundColor = "white";
  document.querySelector("#SupervisorD").style.backgroundColor = "red";
  document.querySelector("#informationS").innerHTML = "Denied by Supervisor";
  alert("Send Email to Employee");
  }


function DepartmentHeadD(){
  document.querySelector("#DepartmentHeadI").style.backgroundColor = "white";
  document.querySelector("#DepartmentHead").style.backgroundColor = "white";
  document.querySelector("#DepartmentHeadD").style.backgroundColor = "red";
  document.querySelector("#informationD").innerHTML = "Denied by Department Head";
  alert("Send Email to Employee");
  }


function BCAD(){
  document.querySelector("#BCAI").style.backgroundColor = "white";
  document.querySelector("#BCA").style.backgroundColor = "white";
  document.querySelector("#BCAD").style.backgroundColor = "red";
  document.querySelector("#informationB").innerHTML = "Denied by BCA";
  alert("Send Email to Employee");
  }


function SupervisorI(){
  document.querySelector("#SupervisorD").style.backgroundColor = "white";
  document.querySelector("#Supervisor").style.backgroundColor = "white";
  document.querySelector("#SupervisorI").style.backgroundColor = "yellow";
  document.querySelector("#informationS").innerHTML = "Additional Information Requested by Supervisor";
     }


function DepartmentHeadI(){
  document.querySelector("#DepartmentHeadD").style.backgroundColor = "white";
  document.querySelector("#DepartmentHead").style.backgroundColor = "white";
  document.querySelector("#DepartmentHeadI").style.backgroundColor = "yellow";
  document.querySelector("#informationD").innerHTML = "Additional Information Requested by Department Head";
  }


function BCAI(){
  document.querySelector("#BCAD").style.backgroundColor = "white";
  document.querySelector("#BCA").style.backgroundColor = "white";
  document.querySelector("#BCAI").style.backgroundColor = "yellow";
  document.querySelector("#informationB").innerHTML = "Additional Information Requested by BCA";
  }







 document.querySelector("#Supervisor1").addEventListener('click', approve1);

  async function approve1() {
  const id2 = document.getElementById("idInput").value;
  const url = `http://localhost:7005/request/${id2}`;
  const httpResponse =  await fetch(url);
  const body =  await httpResponse.json();
  // console.log(body);

  
 fetch(`http://localhost:7005/request/${id2}`, {
    method: "PUT",
    body: JSON.stringify({
            id: body.id,
            employee_id: body.employee_id,
            urgency: body.urgency,
            date: body.date,
            time: body.time,
            location: body.location,
            event_type: body.event_type,
            description: body.description,
            event_start_date: body.event_start_date,
            requested_cost: body.cost,
            attached_document: body.attached_document, 
            grading_format: body.grading_format,
            event_reimb_cost: body.event_reimb_cost,
            approved_by_ds: true,
            approved_by_dh: body.approved_by_dh,
            bca_id: body.bca_id,
            approved_by_bca: body.approved_by_bca,
    }),
  });
  document.querySelector("#approved_by_ds").innerHTML = "APPROVED BY DIRECT SUPERVISOR?:  TRUE";
}




  document.querySelector("#DepartmentHead1").addEventListener('click', approve2);
 
   async function approve2() {
  const id3 = document.getElementById("idInput").value;
  const url = `http://localhost:7005/request/${id3}`;
  const httpResponse = await fetch(url);
  const body1 = await httpResponse.json();
  // console.log(body1);

  
 fetch(`http://localhost:7005/request/${id3}`, {
    method: "PUT",
    body: JSON.stringify({
            id: body1.id,
            employee_id: body1.employee_id,
            urgency: body1.urgency,
            date: body1.date,
            time: body1.time,
            location: body1.location,
            event_type: body1.event_type,
            description: body1.description,
            event_start_date: body1.event_start_date,
            requested_cost: body1.cost,
            attached_document: body1.attached_document, 
            grading_format: body1.grading_format,
            event_reimb_cost: body1.event_reimb_cost,
            approved_by_ds: body1.approved_by_ds,
            approved_by_dh: true,
            bca_id: body1.bca_id,
            approved_by_bca: body1.approved_by_bca,
    }),
  });
  document.querySelector("#approved_by_dh").innerHTML = "APPROVED BY DEPARTMENT HEAD?:  TRUE";
}





  document.querySelector("#BCA1").addEventListener('click', approve3);

  async function approve3() {
  const id4 = document.getElementById("idInput").value;
  const url = `http://localhost:7005/request/${id4}`;
  const httpResponse = await fetch(url);
  const body2 = await httpResponse.json();
  // console.log(body2);


 fetch(`http://localhost:7005/request/${id4}`, {
    method: "PUT",
    body: JSON.stringify({
            id: body2.id,
            employee_id: body2.employee_id,
            urgency: body2.urgency,
            date: body2.date,
            time: body2.time,
            location: body2.location,
            event_type: body2.event_type,
            description: body2.description,
            event_start_date: body2.event_start_date,
            requested_cost: body2.cost,
            attached_document: body2.attached_document, 
            grading_format: body2.grading_format,
            event_reimb_cost: body2.event_reimb_cost,
            approved_by_ds: body2.approved_by_ds,
            approved_by_dh: body2.approved_by_dh,
            bca_id: body2.bca_id,
            approved_by_bca: true,
    }),
  });
  document.querySelector("#approved_by_bca").innerHTML = "APPROVED BY BENEFIT COORDINATOR?: TRUE";
}












