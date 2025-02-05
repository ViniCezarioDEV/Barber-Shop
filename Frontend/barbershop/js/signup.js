document.getElementById('signupForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    const signUpDTO = {
        name: name,
        lastName: lastName,
        email: email,
        password: password
    };

    if (password !== confirmPassword) {
        document.getElementById('responseMessage').textContent = "Password don't match, please check";
    }

    try {
        const response = await fetch('http://localhost:8080/auth/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(signUpDTO)
        });

        if (response.ok) {
            const message = await response.text();
            // document.getElementById('responseMessage').textContent = message;
            window.location.href = 'home.html';
        } else {
            const error = await response.text();
            document.getElementById('responseMessage').textContent = JSON.parse(error).message;
        }
    } catch (error) {
        document.getElementById('responseMessage').textContent = `Error on request: ${error.message}`;
    }
});
