
function bookmarkToggle(button){
    //likeDto 형식으로 폼데이터 만들어서 likeController에 보내면 됨
    const username = document.getElementById("sessionUsername").value;
    const likeCode = 'S';
    const likeId = document.getElementById("resumeNo").value;

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
                const resumeNo = button.getAttribute('data-resume-no');
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


function confirmToP(applicationNo, resumeNo, element) {
    if (confirm('합격 처리 하시겠습니까?')) {
        P(applicationNo, resumeNo);
        element.closest('div').style.display = 'none';  // 부모 div를 숨김
        element.parentElement.parentElement.style.display = 'none';
        hideHrByResumeNo(resumeNo);
    } else {
        console.log('작업이 취소되었습니다.');
    }
}

function confirmToF(applicationNo, resumeNo, element) {
    if (confirm('불합격 처리 하시겠습니까?')) {
        F(applicationNo, resumeNo);
        element.closest('div').style.display = 'none';  // 부모 div를 숨김
        element.parentElement.parentElement.style.display = 'none';
        hideHrByResumeNo(resumeNo);
    } else {
        console.log('작업이 취소되었습니다.');
    }
}

function P(applicationNo, resumeNo) {
    const jsonData = {
        'applicationNo' : applicationNo,
        'resumeNo' : resumeNo,
        'passCode' : "P"
    }

    //제이슨 보내기
    api.post('/api/resume/company/application/update', jsonData, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
}


function F(applicationNo, resumeNo){
    const jsonData = {
        'applicationNo' : applicationNo,
        'resumeNo' : resumeNo,
        'passCode' : "F"
    }

    //제이슨 보내기
    api.post('/api/resume/company/application/update', jsonData, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
}

function hideHrByResumeNo(resumeNo) {
    const hrElement = document.getElementById('hr-' + resumeNo);
    if (hrElement) {
        hrElement.style.display = 'none';
    }
}