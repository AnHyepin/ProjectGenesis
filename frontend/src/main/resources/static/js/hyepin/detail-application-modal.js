//이력서 목록
function getResumeList(applicationNo) {
    const username = document.getElementById("sessionUsername").value;

    api.get('/api/resume/list?username=' + username)
        .then(data => {
            // 'body' 속성에서 배열을 추출하여 StackList에 할당
            resumeList = data.body;  // body 속성의 배열을 할당
            console.log('resumeList:', resumeList);  // 배열 확인
            addModal2(resumeList, username, applicationNo);
        })
        .catch(error => {
            console.error(error);
            alert("오류가 발생했습니다.");
        });
}


//모달 추가
function addModal2(resumeList, username, applicationNo) {

    console.log("applicationNo: " + applicationNo);

    const modal = document.getElementById('modal2');
    modal.style.display = 'block';
    const modalList = document.getElementById('modalList2');
    modalList.innerHTML = "";

    resumeList.forEach(resume => {
        const modalBox = document.createElement('div');
        modalBox.classList.add('modalBox');

        modalBox.innerHTML = `
           <div style="display: flex; justify-content: space-between; padding: 0px 20px;">
                <div style="display: flex; flex-direction: column; justify-content: center; padding: 20px 0px;">
                    <a href="/resume/detail?resumeNo=${resume.resumeNo}">
                    <div style="font-size: 18px; font-weight: bold; cursor: pointer;">${resume.resumeTitle}</div>
                    </a>
                </div>
                <div style="display: flex; align-items: center;">
                    <button class="applyBtn" id="applyBtn" onclick="applyResume(${resume.resumeNo})">지원하기</button>
                </div>
            </div> <hr>`;
        modalList.appendChild(modalBox);  // 새 항목을 추가
    });
}

//모달창 닫기 버튼
function cancelBtn2() {
    const modal = document.getElementById('modal2');
    modal.style.display = 'none';
}

function applyResume(resumeNo) {
    const applicationNo = document.getElementById('applicationNo').value;
    const sessionUsername = document.getElementById('sessionUsername').value;

    const formData = new FormData();
    formData.append('resumeNo', resumeNo);
    formData.append('applicationNo', applicationNo);
    formData.append('registId', sessionUsername);

    api.post('/api/resume/apply', formData, {})
        .then(res => {
            if (res.body == '지원 성공') {  // 응답의 본문은 res.data에 담김
                alert("지원 성공");
            } else {
                alert("지원 실패");
            }
        })
        .catch(error => {
            console.error("오류:", error);
            alert("저장 오류");
        });

    alert(resumeNo + '번 이력서 지원 완료');
    const modal = document.getElementById('modal2');
    modal.style.display = 'none';
}