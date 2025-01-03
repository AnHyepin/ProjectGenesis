function handleClick(event) {
    const clickedId = event.target.id;

    const menuItems = document.querySelectorAll('.menu p');
    menuItems.forEach(item => item.classList.remove('active'));
    event.target.classList.add('active');

    // localStorage에 클릭한 메뉴의 id 값을 저장
    localStorage.setItem('activeMenu', clickedId);

    if (clickedId === 'recruitment') {
        window.location.href = '';
        alert('채용공고');
    } else if (clickedId === 'applicationManagement') {
        window.location.href = '';
        alert('공고 관리');
    } else if (clickedId === 'matching') {
        window.location.href = '';
        alert('매칭리스트');
    } else if (clickedId === 'support') {
        window.location.href = '';
        alert('고객센터');
    }
}

window.onload = function () {
    const activeMenu = localStorage.getItem('activeMenu');
    if (activeMenu) {
        const activeItem = document.getElementById(activeMenu);
        if (activeItem) {
            activeItem.classList.add('active');
        }
    }
};

function secondHandleClick(event) {
    const clickedId = event.target.id;
    localStorage.setItem('activeMenu', 'applicationManagement');
}

