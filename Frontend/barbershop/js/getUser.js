const username = document.getElementById('username').value;

    const response = fetch('http://localhost:8080/getuser')

    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log('FETCH RESPONSE: 200');
        username.textContent = `Welcome, ${data.name}`;
    })