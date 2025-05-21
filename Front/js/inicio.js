// Aguarda o carregamento completo do DOM
document.addEventListener('DOMContentLoaded', () => {
    // Seleciona elementos principais
    const playButtons = document.querySelectorAll('.play-button');
    const mainPlayButton = document.querySelector('.control-button.play');
    const navItems = document.querySelectorAll('.nav-item');
    const progressInner = document.querySelector('.progress-inner');
    const progressContainer = document.querySelector('.progress-container');
    const volumeLevel = document.querySelector('.volume-level');
    const volumeSlider = document.querySelector('.volume-slider');
    const likeButton = document.querySelector('.like-button');
    const musicCards = document.querySelectorAll('.music-card');
    const trackItems = document.querySelectorAll('.track-item');
    const waveVisualizer = document.querySelector('.wave-visualizer');
    const currentTrackInfo = document.querySelector('.current-track-info h4');
    const currentTimeDisplay = document.querySelector('.current-time');

    let progressAnimationId; // ID da animação de progresso

    // Inicializa o visualizador de ondas
    generateWaveVisualizer();

    // Adiciona eventos aos botões de play
    playButtons.forEach(button => button.addEventListener('click', togglePlay));

    // Controle principal de play/pause
    if (mainPlayButton) {
        mainPlayButton.addEventListener('click', togglePlay);
    }

    // Controle do progresso da música
    if (progressContainer) {
        progressContainer.addEventListener('click', handleProgressClick);
    }

    // Controle do volume
    if (volumeSlider) {
        volumeSlider.addEventListener('click', handleVolumeChange);
    }

    // Controle dos itens de navegação
    navItems.forEach(item => {
        item.addEventListener('click', () => {
            navItems.forEach(navItem => navItem.classList.remove('active'));
            item.classList.add('active');
        });
    });

    // Adiciona interação ao botão de like
    if (likeButton) {
        likeButton.addEventListener('click', toggleLike);
    }

    // Adiciona interação com os cards de música
    musicCards.forEach(card => {
        card.addEventListener('click', () => {
            const trackName = card.querySelector('.card-title').textContent;
            simulatePlayingTrack(trackName);
        });
    });

    // Adiciona interação com os itens da lista de músicas
    trackItems.forEach(track => {
        track.addEventListener('click', () => {
            const trackName = track.querySelector('.track-title').textContent;
            simulatePlayingTrack(trackName);
        });
    });

    // Função para alternar entre play e pause
    function togglePlay() {
        if (mainPlayButton.textContent === '▶') {
            mainPlayButton.textContent = '❚❚';
            startProgressAnimation();
        } else {
            mainPlayButton.textContent = '▶';
            stopProgressAnimation();
        }
    }

    // Função para simular a reprodução de uma música
    function simulatePlayingTrack(trackName) {
        if (currentTrackInfo) {
            currentTrackInfo.textContent = trackName;
            mainPlayButton.textContent = '❚❚'; // Símbolo de pause
            progressInner.style.width = '0%'; // Reseta a barra de progresso
            startProgressAnimation();
        }
    }

    // Função para lidar com o clique no progresso
    function handleProgressClick(e) {
        const clickPosition = e.offsetX;
        const containerWidth = progressContainer.offsetWidth;
        const percentPosition = (clickPosition / containerWidth) * 100;

        progressInner.style.width = `${percentPosition}%`;
        updateTimeDisplay(percentPosition);
    }

    // Função para lidar com a mudança de volume
    function handleVolumeChange(e) {
        const clickPosition = e.offsetX;
        const sliderWidth = volumeSlider.offsetWidth;
        const volumePercentage = (clickPosition / sliderWidth) * 100;

        volumeLevel.style.width = `${volumePercentage}%`;
    }

    // Função para alternar o estado do botão de like
    function toggleLike() {
        likeButton.classList.toggle('active');
        likeButton.style.color = likeButton.classList.contains('active') ? '#f72585' : 'var(--text-secondary)';
    }

    // Função para iniciar a animação da barra de progresso
    function startProgressAnimation() {
        stopProgressAnimation(); // Cancela qualquer animação anterior

        const startWidth = parseFloat(progressInner.style.width) || 0;
        const startTime = performance.now();
        const duration = 210000; // 3:30 em milissegundos

        function animate(currentTime) {
            const elapsed = currentTime - startTime;
            const progress = Math.min((elapsed / duration) * 100 + startWidth, 100);

            progressInner.style.width = `${progress}%`;
            updateTimeDisplay(progress);

            if (progress < 100) {
                progressAnimationId = requestAnimationFrame(animate);
            } else {
                mainPlayButton.textContent = '▶'; // Reseta para play
            }
        }

        progressAnimationId = requestAnimationFrame(animate);
    }

    // Função para parar a animação da barra de progresso
    function stopProgressAnimation() {
        if (progressAnimationId) {
            cancelAnimationFrame(progressAnimationId);
            progressAnimationId = null;
        }
    }

    // Função para atualizar o display de tempo
    function updateTimeDisplay(progressPercentage) {
        const totalTime = 210; // 3:30 em segundos
        const currentTime = Math.floor((progressPercentage / 100) * totalTime);

        const minutes = Math.floor(currentTime / 60);
        const seconds = currentTime % 60;

        if (currentTimeDisplay) {
            currentTimeDisplay.textContent = `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
        }
    }

    // Função para gerar o visualizador de ondas
    function generateWaveVisualizer() {
        if (!waveVisualizer) return;

        waveVisualizer.innerHTML = ''; // Limpa o conteúdo anterior
        for (let i = 0; i < 20; i++) {
            const waveBar = document.createElement('div');
            waveBar.classList.add('wave-bar');
            waveBar.style.height = `${Math.random() * 100}%`;
            waveVisualizer.appendChild(waveBar);
        }
    }
});