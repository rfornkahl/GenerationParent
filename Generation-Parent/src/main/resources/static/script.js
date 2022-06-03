let appName = "Generation-X Parent";

 function sendEmail(){
         Email.send({
            Host: "smtp.gmail.com",
            Username: "genparentcontact@gmail.com",
            Password: "T1h9e8b6urbs",
            To : "genparentcontact@gmail.com",
            From : document.getElementByID("email").value,
            Subject : "Email from Generation Parent User: " + document.getElementByID("name").value,
            Body : "Name: " + document.getElementById("name").value +
            "<br> Email: " + document.getElementById("email").value +
            "<br> Message: " + document.getElementById("message").value}).then(
        message => alert("Your message has been received. You will receive a response within 24 to 48 business hours. Thank you for using Generation Parent.")
    );}
