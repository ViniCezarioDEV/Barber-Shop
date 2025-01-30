document.getElementById('scheduleForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // Impede o envio padrão do formulário

    // Coleta os dados do formulário
    const userId = document.getElementById('userId').value;
    const professionalId = document.getElementById('professionalId').value;
    const serviceId = document.getElementById('barberServiceId').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;

    // Monta o objeto ScheduleDTO
    const scheduleDTO = {
        user: { userId: parseInt(userId) },
        professional: { professionalId: parseInt(professionalId) },
        barberService: { barberServiceId: parseInt(serviceId) },
        date: date,
        time: time
    };

    try {
        // Envia a requisição POST para o backend
        const response = await fetch('http://localhost:8080/schedules/book', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(scheduleDTO)
        });

        // Verifica se a requisição foi bem-sucedida
        if (response.ok) {
            const message = await response.text();
            document.getElementById('responseMessage').textContent = message;
        } else {
            const error = await response.text();
            document.getElementById('responseMessage').textContent = JSON.parse(error).message;
        }
    } catch (error) {
        document.getElementById('responseMessage').textContent = `Erro na requisição: ${error.message}`;
    }
});