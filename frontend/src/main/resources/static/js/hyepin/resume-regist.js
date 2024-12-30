function submitForm() {
   const requiredFields = ['username', 'password', 'passwordCheck', 'name', 'birth', 'email', 'phone', 'zipcode', 'roadAddress', 'detailAddress'];
    for (let field of requiredFields) {
        const value = document.querySelector(`input[name='${field}']`)?.value.trim();
        if (!value) {
            alert(`필수 입력 항목을 모두 채워주세요: ${field}`);
            return;
        }
    }

    const password = document.querySelector("input[name='password']").value.trim();
    const passwordCheck = document.querySelector("input[name='passwordCheck']").value.trim();
    if (password !== passwordCheck) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    const formData = new FormData();
    const profilePicture = document.querySelector("input[name='profilePicture']").files[0];
    if (profilePicture) {
        formData.append("profilePicture", profilePicture);
    }

    const fields = ['username', 'password', 'name', 'birth', 'email', 'phone', 'zipcode', 'roadAddress', 'detailAddress', 'gender'];
    fields.forEach(field => {
        const value = document.querySelector(`input[name='${field}']`)?.value.trim();
        if (value) {
            formData.append(field, value);
        }
    });

    api.post('/api/user', formData, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    })
        .then(res => {
            if (res.body == '회원가입 성공') {
                alert("가입 성공")
                location.href = '/login';
                console.log(res)
            } else {
                alert("가입 실패")
            }
        })
        .catch(error => {
            console.error("오류:", error);
            alert("회원가입 중 오류.");
        });
}

function educationSave(){
    alert("학력 저장");
}

function educationDelete(){
    alert("학력 삭제");
}

function careerSave(){
    alert("경력 저장");
}

function careerDelete(){
    alert("경력 삭제");
}

function stackSave(){
    alert("스킬 저장");
    //db에 저장하기
}
function certificateSave(){
    alert("자격증 저장");
}

function certificateDelete(){
    alert("자격증 삭제");
}

function toggleSkill(checkbox) {
    const skillListContainer = document.querySelector('.skill-list'); // 전체 스킬 리스트 컨테이너
    const skillValue = checkbox.value;
    const skillName = checkbox.getAttribute('id');

    if (checkbox.checked) {
        // 체크박스가 선택되었을 때
        const skillDiv = document.createElement('div');
        skillDiv.className = 'input-skill-list'; // 클래스 이름 추가
        skillDiv.id = `skill-${skillValue}`; // 고유 ID 설정
        skillDiv.innerHTML = `
            <div>${skillName}</div>
            <div>| <button class="input-skill-cancle" name="${skillValue}" onclick="removeSkill('${skillValue}')">X</button></div>
        `;
        skillListContainer.appendChild(skillDiv); // 새로운 항목 추가
    } else {
        // 체크박스가 해제되었을 때
        removeSkill(skillValue);
    }
}

function removeSkill(skillValue) {
    // 해당 스킬 항목 삭제
    const skillDiv = document.getElementById(`skill-${skillValue}`);
    if (skillDiv) {
        skillDiv.remove();
    }

    // 체크박스도 해제
    const checkbox = document.querySelector(`input[type="checkbox"][value="${skillValue}"]`);
    if (checkbox) {
        checkbox.checked = false;
    }
}

function handleInput() {
    const certificateName = document.getElementById('certificateName').value;

    // 값이 비어있지 않다면 AJAX 요청을 보냄
    if (certificateName.trim() !== "") {
        fetchCertificates(certificateName); // 자격증명 검색을 위해 AJAX 요청을 보내
    } else {
        // 입력값이 비었을 경우, 결과를 초기화
        document.getElementById('certificate-result-list').innerHTML = '';
    }
}

function fetchCertificates(certificateName) {
    // AJAX로 서버에 요청
    const xhr = new XMLHttpRequest();
    xhr.open('GET', "");
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const certificates = JSON.parse(xhr.responseText); // 서버에서 받은 응답을 JSON으로 파싱
            displayCertificates(certificates); // 자격증명 목록을 화면에 표시
        }
    };
    xhr.send();
}

function displayCertificates(certificates) {
    const resultList = document.getElementById('certificate-result-list');
    resultList.innerHTML = ''; // 기존 리스트 초기화

    certificates.forEach(certificate => {
        const li = document.createElement('li');
        li.textContent = certificate.certificateName;
        resultList.appendChild(li);
    });
}
