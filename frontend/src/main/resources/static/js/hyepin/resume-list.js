//포지션 제안 받기로 변경
function position(resumeNo){
    //이력서 번호로 db에 update (POST)
    const formData = new FormData();
    formData.append('resumeNo', resumeNo);

    //폼데이터 보내기
    api.post('/api/resume/positionUpdate', formData, {
    })
        .then(res => {
            if (res.body == '포지션 제안받기 성공') {  // 응답의 본문은 res.data에 담김
                alert("포지션 제안을 받습니다.");
                const button = document.querySelector(`button[onclick="position(${resumeNo})"]`);
                button.style.backgroundColor = "gainsboro";
                button.style.border = "1px solid gainsboro";
                button.style.cursor = "default";
            } else {
                alert("저장 실패");
            }
        })
        .catch(error => {
            console.error("오류:", error);
            alert("저장 오류");
        });

}

//입사지원 목록
function applyManagement(resumeNo){
    //이력서 번호로 db에서 입사지원 목록 찾기 (GET)
    api.get('/api/resume/applyList?resumeNo=' + resumeNo)
        .then(data => {
            // 'body' 속성에서 배열을 추출하여 StackList에 할당
            applyList = data.body;  // body 속성의 배열을 할당
            console.log('applyList:', applyList);  // 배열 확인
            addModal(applyList);
        })
        .catch(error => {
            console.error(error);
            alert("오류가 발생했습니다.");
        });
}

//이력서 수정하기
function modiBtn(resumeNo){
    alert(resumeNo + "번 이력서 수정");
}

//아력서 삭제하기
function deleteBtn(resumeNo){
    alert(resumeNo + "번 이력서 삭제");
}

//모달 추가
function addModal(applyList){
    const modal = document.getElementById('modal');
    modal.style.display = 'block';
    const modalList = document.getElementById('modalList');
    modalList.innerHTML = "";
    applyList.forEach(apply => {
        const modalBox = document.createElement('div');
        modalBox.classList.add('modalBox');

        //버튼 / 심사현황 생성
        let applyStatusGbnCode = '';
        let buttonHtml = '';
        if (apply.applyStatusGbnCode === 'H') {
            buttonHtml = `<button class="cancelApplication" onclick="cancelApplication(${apply.applicationNo})">지원취소</button>`;
            applyStatusGbnCode = `<div id="H">진행중</div>`;
        } else if (apply.applyStatusGbnCode === 'P') {
            buttonHtml = '<button class="noCancelApplication"  style="cursor: default; ">취소불가</button>';
            applyStatusGbnCode = `<div id="P" style="margin-right: 10px;">합격</div>`;
        }else if (apply.applyStatusGbnCode === 'F') {
            buttonHtml = '<button class="noCancelApplication"  style="cursor: default; ">취소불가</button>';
            applyStatusGbnCode = `<div id="F">불합격</div>`;
        }

        modalBox.innerHTML = `
                   <div style="display: flex; justify-content: space-between;">
                        <div style="display: flex; flex-direction: column; justify-content: center; padding: 20px;">
                            <div style="font-size: 18px; cursor: pointer;" onclick="applycation(${apply.applicationNo})">${apply.applicationTitle}</div>
                            <div style="font-size: 14px; color: #929292">(주) ${apply.companyName}</div>
                        </div>
                        <div style="display: flex; justify-content: space-between; gap:20px; align-items: center;">
                            ${applyStatusGbnCode}
                             ${buttonHtml}
                        </div>
                    </div> <hr>`;
        modalList.appendChild(modalBox);  // 새 항목을 추가
    });
}

//모달창에서 공고번호로 공고 상세페이지로 가기
function applycation(applicationNo){
    console.log("공고번호: " + applicationNo);
}

//모달창에서 공고번호로 지원취소하기
function cancelApplication(applicationNo){
    alert('지원 취소');
}

//모달창 닫기 버튼
function cancelBtn(){
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}