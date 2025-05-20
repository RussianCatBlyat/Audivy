// Função para atualizar a saudação baseada na hora do dia
function updateGreeting() {
    const hour = new Date().getHours();
    const greeting = document.querySelector('.greeting');
    
    if (hour >= 5 && hour < 12) {
        greeting.textContent = 'Bom dia';
    } else if (hour >= 12 && hour < 18) {
        greeting.textContent = 'Boa tarde';
    } else {
        greeting.textContent = 'Boa noite';
    }
}

// Atualiza a saudação quando a página carrega
document.addEventListener('DOMContentLoaded', function() {
    // Atualiza a saudação
    updateGreeting();
    
    // Simula a interação com os botões de reprodução
    document.querySelectorAll('.card').forEach(card => {
        card.addEventListener('click', function() {
            // Aqui você poderia implementar a lógica de reprodução
            console.log('Reproduzindo playlist:', this.querySelector('.card-title').textContent);
        });
    });


// Simula o clique no botão de play/pause
const playPauseButton = document.querySelector('.play-pause');
playPauseButton.addEventListener('click', function() {
    if (this.textContent === '▶') {
        this.textContent = '⏸️';
    } else {
        this.textContent = '▶';
    }
    
});
});