// Remove the transition class
const square = document.querySelector('.square');
square.classList.remove('animate__animated', 'animate__bounceOutLeft');

// Create the observer, same as before:
const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            square.classList.add('animate__animated', 'animate__bounceOutLeft');
            return;
        }

        square.classList.remove('animate__animated', 'animate__bounceOutLeft');
    });
});

observer.observe(document.querySelector('.square-wrapper'));
