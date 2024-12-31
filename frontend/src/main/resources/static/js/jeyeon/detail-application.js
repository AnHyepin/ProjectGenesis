
    let currentIndex = 0;
    const slides = document.querySelectorAll('.slide');
    const totalSlides = slides.length;

    function showSlide(index) {
        const slidesContainer = document.querySelector('.slides');
        currentIndex = (index + totalSlides) % totalSlides; // Handle wrap-around
        slidesContainer.style.transform = `translateX(-${currentIndex * 100}%)`;
    }

    function nextSlide() {
        showSlide(currentIndex + 1);
    }

    function prevSlide() {
        showSlide(currentIndex - 1);
    }

// Auto-slide
    let autoSlideInterval = setInterval(nextSlide, 3000);

// Pause on hover
    const slider = document.querySelector('.slider');
    slider.addEventListener('mouseover', () => clearInterval(autoSlideInterval));
    slider.addEventListener('mouseout', () => (autoSlideInterval = setInterval(nextSlide, 3000)));
