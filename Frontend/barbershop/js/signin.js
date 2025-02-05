document.getElementById('signinForm').addEventListener('submit', async function (event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const signInDTO = {
        email: email,
        password: password
    };


    try {
        const response = await fetch('http://localhost:8080/auth/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(signInDTO)
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
