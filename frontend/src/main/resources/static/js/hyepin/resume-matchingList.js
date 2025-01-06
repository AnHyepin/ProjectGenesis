function toggleSelectAll(selectAllCheckbox) {
    const checkboxes = document.querySelectorAll('.resume-checkbox'); // 개별 체크박스들
    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAllCheckbox.checked; // 전체선택 체크박스 상태로 동기화
    });
}

function bookmarkToggle(button){
    //likeDto 형식으로 폼데이터 만들어서 likeController에 보내면 됨
    const resumeNo = button.dataset.resume;
    const username = document.getElementById("sessionUsername").value;
    const likeCode = 'S';

    console.log(username);

    console.log(button)
    console.log("asdfsafsadfsafjsdalkfj")
    console.log(likeCode);
    console.log(resumeNo);

    const jsonData = {
        'username' : username,
        'likeCode' : likeCode,
        'likeId' : resumeNo
    }

    //제이슨 보내기
    api.post('/api/likes/toggle', jsonData, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(res => {
            if (res.body == '성공') {  // 응답의 본문은 res.data에 담김
                if (button.value === '♡') {
                    button.value = '♥';
                } else {
                    button.value = '♡';
                }
                alert("저장 성공");
            } else {
                alert("저장 실패");
            }
        })
        .catch(error => {
            console.error("오류:", error);
            alert("저장 오류");
        });
}