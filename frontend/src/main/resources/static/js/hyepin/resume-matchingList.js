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


//공고 목록
function positionOffer() {
    const username = document.getElementById("sessionUsername").value;

    //공고 목록 api
    api.get('/api/resume/company/application?username=' + username)
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

//모달 추가
function addModal(applyList) {

    const modal = document.getElementById('modal');
    modal.style.display = 'block';
    const modalList = document.getElementById('modalList');
    modalList.innerHTML = "";

    applyList.forEach(apply => {
        const modalBox = document.createElement('div');
        modalBox.classList.add('modalBox');

        modalBox.innerHTML = `
           <div style="display: flex; justify-content: space-between; padding: 0px 20px;">
                <div style="display: flex; gap: 20px; align-items: center;">
                    <input type="checkbox" id="checkbox1" class="applicationCheckbox" data-applicationNo="${apply.applicationNo}">
                    <div style="display: flex; flex-direction: column; justify-content: center; padding: 20px 0px;">
                        <a href="/application/detail/${apply.applicationNo}">
                        <div style="font-size: 18px; font-weight: bold; cursor: pointer;">${apply.applicationTitle}</div>
                        </a>
                    </div>
                </div>
            </div> <hr>`;
        modalList.appendChild(modalBox);  // 새 항목을 추가
    });
}

//모달창 닫기 버튼
function cancelBtn() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}

function offerComplet() {
    /*
    const selectedCheckboxes = document.querySelectorAll('.applicationCheckbox:checked');

    // 선택된 체크박스들의 applicationNo 값을 배열로 저장
    const applicationNos = [];
    selectedCheckboxes.forEach(checkbox => {
        const applicationNo = checkbox.getAttribute('data-applicationNo');
        applicationNos.push(applicationNo);
    });

    // 선택된 공고 번호가 없으면 알림
    if (applicationNos.length === 0) {
        alert('공고를 선택해주세요!');
        return;
    }

    const resumeNo = document.getElementById('resumeNo').value;
    const sessionUsername = document.getElementById('sessionUsername').value;

    const formData = new FormData();
    formData.append('resumeNo', resumeNo);
    formData.append('registId', sessionUsername);
    formData.append('applicationNos', JSON.stringify(applicationNos));

    // offer에 보내기
    api.post('/api/resume/company/offer', formData, {})
        .then(res => {
            if (res.body == '지원 성공') {
                alert("지원 성공");
            } else {
                alert("지원 실패");
            }
        })
        .catch(error => {
            console.error("오류:", error);
            alert("저장 오류");
        });
     */

    alert("포지션 제안 완료!");
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}



