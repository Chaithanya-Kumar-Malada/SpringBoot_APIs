// script.js
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevents the default form submission

    // Get values from the form fields
    const phoneno = document.getElementById('phoneNumber').value;
    const password = document.getElementById('password').value;

    // Simple validation (You can replace this with real validation)
    if (phoneno === '' || password === '') {
        displayError('Please fill out all fields.');
        return;
    }

    // Example of sending data to a server (Replace URL and logic as needed)
    const loginData = {
        "phoneno": phoneno,
        "password": password
    };

    fetch('http://localhost:8080/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => response.json())
    .then(data => { console.log(data);
        
        displayError(data.message);

        // if (data.statuscode === 200) {
          
        //     displayError(data.message);  // Replace with your dashboard or landing page
        // } else {
        //     displayError('Invalid phone number or password.');
        // }
    })
    .catch(error => {
       // console.error('Error:', error);
        displayError('An error occurred while trying to log in.');
    });
});

function displayError(message) {
    const errorMessageElement = document.getElementById('error-message');
    errorMessageElement.innerHTML = message;
}
