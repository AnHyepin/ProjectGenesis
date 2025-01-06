

function bookmarkToggle(button){
    //likeDto 형식으로 폼데이터 만들어서 likeController에 보내면 됨
    const username = document.getElementById("sessionUsername").value;
    const likeCode = 'S';
    const likeId = button.dataset.applicationNo;

    console.log(username);
    console.log(likeCode);
    console.log(likeId);

    const jsonData = {
        'username' : username,
        'likeCode' : likeCode,
        'likeId' : likeId
    }

    //제이슨 보내기
    api.post('/api/likes/toggle', jsonData, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(res => {
            if (res.body == '성공') {  // 응답의 본문은 res.data에 담김
                const applicationNo = button.getAttribute('data-application-no');
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