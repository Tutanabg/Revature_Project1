document.addEventListener('DOMContentLoaded', function() {

  
  // Use buttons to toggle between views
  document.querySelector('#inbox').addEventListener('click', ()=> load_mailbox('inbox'));
  document.querySelector('#sent').addEventListener('click', () => load_mailbox('sent'));
  document.querySelector('#compose').addEventListener('click', compose_email);
  document.querySelector('#btnbtn').addEventListener('click', send_email);
  // By default, load the inbox
  // load_mailbox('inbox');
});

function compose_email() {

  // Show compose view and hide other views
  document.querySelector('#emails-view').style.display = 'none';
  document.querySelector('#compose-view').style.display = 'block';
  

  // Clear out composition fields
  document.querySelector('#compose-recipients').value = '';
  document.querySelector('#compose-subject').value = '';
  document.querySelector('#compose-body').value = '';
}

function send_email() {

  const from = document.querySelector('#compose-sender').value;
  const to = document.querySelector('#compose-recipients').value;
  const subject = document.querySelector('#compose-subject').value;
  const body = document.querySelector('#compose-body').value;
  fetch('http://localhost:7007/emails', {
      method: 'POST',
      body: JSON.stringify({
        em_from: from,
        em_recipients: to,
        em_subject: subject,
        em_body: body,
      }),
    })
    .then(response => response.json())
    .then(result => {
        console.log(result);
        alert("Message Sent Successfully!!!")
         });     
         }

  
         
function load_mailbox(mailbox) {
  const id4 = document.getElementById("idInput").value;
//   // Show the mailbox and hide other views
  document.querySelector('#emails-view').style.display = 'block';
  document.querySelector('#compose-view').style.display = 'none';
  

//   // Show the mailbox name
  document.querySelector('#emails-view').innerHTML = `<h3>${mailbox.charAt(0).toUpperCase() + mailbox.slice(1)}</h3>`;
 if (mailbox == 'sent'){
fetch(`http://localhost:7007/emails/${id4}`)
.then(response => response.json())
.then(emails => {
	console.log(emails);
  var card = document.createElement('div');
  card.className = 'md';
   card.innerHTML =`   <div><span Style="font-weight: bold">To:</span> ${emails.em_to}</div>
  <div><span Style="font-weight: bold">Subject:</span>${emails.em_subject}</div>
  <br>
  <div><span Style="font-weight: bold">Body:</span>${emails.em_body}</div>
  <br></br>`
  document.querySelector("#emails-view").appendChild(card); 

});
}
if( mailbox == 'inbox'){
  
fetch(`http://localhost:7007/emails/${id4}`)
.then(response => response.json())
.then(emails => {
	console.log(emails);
  
  var card = document.createElement('div');
  card.className = 'md';
   card.innerHTML =`   <div><span Style="font-weight: bold">From:</span> ${emails.em_from}</div>
  <div><span Style="font-weight: bold">Subject:</span>${emails.em_subject}</div>
  <br>
  <div><span Style="font-weight: bold">Body:</span>${emails.em_body}</div>
  <br></br>`
  document.querySelector("#emails-view").appendChild(card);   
  card.addEventListener('click', () => {   
});
});
}
}





