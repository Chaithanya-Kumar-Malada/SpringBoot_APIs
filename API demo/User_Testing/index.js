document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById('loginForm');
    const registerForm = document.getElementById('registerForm');
    const resetForm = document.getElementById('resetForm');

    if(loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const phoneno = document.getElementById('phone').value;
            const password = document.getElementById('password').value;

            fetch('http://localhost:8080/user/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ phoneno, password })
            })
            .then(response => response.text())
            .then(response => {

                console.log('Login message:', response);

                document.getElementById("errormsg").innerHTML=response;

                // if (data.success) {
                
                //     document.getElementById("errormsg").innerHTML=data.message;

                //     // Handle successful login
                //     console.log('Login successful:', data);
                //     // Redirect to another page or perform other actions
                // } else {
                //     // Handle login failure
                //     console.log('Login failed:', data.message);
                //     // Show error message to the user
                // }
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    }



   if(registerForm) {
        registerForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const name = document.getElementById('name').value;
            const phoneno = document.getElementById('phone').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            fetch('http://localhost:8080/user/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name, phoneno, email, password })
            })
            .then(response => response.text())
            .then(data => {

                console.log(data);

                // if (data.success) {
                //     // Handle successful registration
                //     console.log('Registration successful:', data);
                //     // Redirect to another page or perform other actions
                // } else {
                //     // Handle registration failure
                //     console.log('Registration failed:', data.message);
                //     // Show error message to the user
                // }
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    }


    if (resetForm) {
        resetForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const email = document.getElementById('email').value;
            console.log(`Reset Password for Email: ${email}`);
            // Add reset password logic here
        });
    }
});
