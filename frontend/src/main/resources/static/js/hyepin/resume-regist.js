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

/* 학력 데이터 보내기 */
function educationSave(){

    const username = document.getElementById('username').textContent;

    // 폼 데이터 가져오기
    const educationForm = document.getElementById('education-regist');
    const formData = new FormData(educationForm);

    // 디버깅: formData 확인 (브라우저 콘솔에서 데이터 확인)
    for (let [key, value] of formData.entries()) {
        console.log(key, value);
    }

    //이름 추가
    formData.append('username', username);

    //폼데이터 보내기
    api.post('/api/resume/education', formData, {
    })
        .then(res => {
            if (res.body == '학력 저장 성공') {  // 응답의 본문은 res.data에 담김
                educationInsert();
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

function educationInsert(){
    const resumeEducationName = document.getElementById('resumeEducationName').value;
    const resumeEducationMajor = document.getElementById('resumeEducationMajor').value;
    const resumeEducationIndt = document.getElementById('resumeEducationIndt').value;
    const resumeEducationOutdt = document.getElementById('resumeEducationOutdt').value;

    // 부모 요소 찾기
    const educationListForm = document.getElementById('education-list-form');

    const sectionBox = document.createElement('div');
    sectionBox.classList.add('section_box2');

    // 내부 HTML 생성
    sectionBox.innerHTML = `
        <div class="section_box2_detail">
            <div class="section_box2_detail_info">
                <div id="education-name">${resumeEducationName}</div>
                <div id="education-dates">${resumeEducationIndt} ~ ${resumeEducationOutdt} </div>
            </div>
            <div class="section_box2_detail_modi">
                <div><i class="bi bi-pencil"></i></div>
                <button class="deleteBtn" onclick="educationDelete()">
                    <i class="bi bi-x-square"></i>
                </button>
            </div>
        </div>
        <div class="section_box2_detail2">
            <div id="education-major">${resumeEducationMajor} 전공</div>
        </div>
    `;
    // 부모 요소에 추가
    educationListForm.appendChild(sectionBox);
}

function educationDelete(){
    alert("학력 삭제");
}

/* 경력 데이터 보내기 */
function careerSave(){

    // 폼 데이터 가져오기
    const careerForm = document.getElementById('career-regist');
    const formData = new FormData(careerForm);
    //이름 추가
    const username = document.getElementById('username').textContent;
    formData.append('username', username);

    //폼데이터 보내기
    api.post('/api/resume/career', formData, {
    })
        .then(res => {
            if (res.body == '경력 저장 성공') {  // 응답의 본문은 res.data에 담김
                careerInsert();
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

function careerInsert(){
    const resumeCareerCompanyName = document.getElementById('resumeCareerCompanyName').value;
    const resumeCareerJoinDt = document.getElementById('resumeCareerJoinDt').value;
    const resumeCareerOutDt = document.getElementById('resumeCareerOutDt').value;
    const resumeCareerDepartmentName = document.getElementById('resumeCareerDepartmentName').value;
    const resumeCareerPosition = document.getElementById('resumeCareerPosition').value;
    const resumeCareerDuties = document.getElementById('resumeCareerDuties').value;

    // 부모 요소 찾기
    const careerListForm = document.getElementById('career-list-form');

    const sectionBox = document.createElement('div');
    sectionBox.classList.add('section_box2');

    // 내부 HTML 생성
    sectionBox.innerHTML = `
    <div class="section_box2_detail">
        <div class="section_box2_detail_info">
            <div>${resumeCareerCompanyName}</div>
            <div>${resumeCareerJoinDt} ~ ${resumeCareerOutDt}</div>
        </div>
        <div class="section_box2_detail_modi">
            <div><i class="bi bi-pencil"></i> </div>
            <button class="deleteBtn" onclick="careerDelete()">
                <i class="bi bi-x-square"></i>
            </button>
        </div>
    </div>
    <div class="section_box2_detail2">
        <div>${resumeCareerDuties}</div>
    </div>
            
`;
    // 부모 요소에 추가
    careerListForm.appendChild(sectionBox);

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

function portfolioSave(){
    alert("포트폴리오 저장");
}

function portfolioDelete(){
    alert("포트폴리오 삭제");
}

function resumeMyinfoSave(){
    alert("자기소개서 저장");
}

function resumeMyinfoDelete(){
    alert("자기소개서 삭제");
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

/* 기술 스택 불러오기 */
let StackList = [];
let certificateList = [];

window.onload = getList;

function getList() {
    api.get('/api/gubn/stack2nd')
        .then(data => {
            // 'body' 속성에서 배열을 추출하여 StackList에 할당
            StackList = data.body;  // body 속성의 배열을 할당
            console.log('StackList loaded:', StackList);  // 배열 확인
        })
        .catch(error => {
            console.error(error);
            alert("오류가 발생했습니다.");
        });

    api.get('/api/gubn/certificate')
        .then(data => {
            certificateList = data.body;  // body 속성의 배열을 할당
            console.log('certificateList loaded:', certificateList);  // 배열 확인
        })
        .catch(error => {
            console.error(error);
            alert("오류가 발생했습니다.");
        });
}

// 스택 검색 기능
document.getElementById('skills').addEventListener('input', function() {
    let searchTerm = this.value.trim().toLowerCase();  // 입력된 검색어

    let filteredStacks = StackList.filter(stack =>
        stack.gubnName.toLowerCase().includes(searchTerm)
    );  // 입력된 검색어가 기술 스택 이름에 포함되는지 확인
    displaySearchResults(filteredStacks);  // 결과 표시 함수 호출
});

// 스택 검색 결과 표시
function displaySearchResults(stacks) {

    document.getElementById('search-results').style.display = "block";
    const resultList = document.getElementById('result-list');
    resultList.innerHTML = '';  // 기존 검색 결과 초기화

    stacks.forEach(stack => {
        const listItem = document.createElement('li');
        listItem.innerHTML = `
            <div class="checkbox">
                <input type="checkbox" value="${stack.gubnCode}" id="${stack.gubnName}" onchange="toggleSkill(this)">
                ${stack.gubnName}
            </div>`;
        resultList.appendChild(listItem);  // 새 항목을 추가
    });
}


// 자격증 검색 기능
document.getElementById('certificateName').addEventListener('input', function() {
    let searchTerm = this.value.trim().toLowerCase();  // 입력된 검색어

    let filteredCertificate = certificateList.filter(certificate =>
        certificate.gubnName.toLowerCase().includes(searchTerm)
    );  // 입력된 검색어가 기술 스택 이름에 포함되는지 확인
    displayCertificateResults(filteredCertificate);  // 결과 표시 함수 호출
});

// 자격증 검색 결과 표시
function displayCertificateResults(certificate) {

    document.getElementById('certificate-results').style.display = "block";
    const resultList = document.getElementById('certificate-result-list');
    let listContent = '';  // 새로운 리스트 항목을 저장할 변수

    certificate.forEach(cert => {
        listContent += `
        <li data-certname="${cert.gubnName}" id="${cert.gubnName}" style="padding-bottom: 5px;" class="certificate">${cert.gubnName}</li>
    `;
    });
    resultList.innerHTML = listContent;  // 모든 항목을 한 번에 추가

    // 각 항목에 이벤트 리스너 추가
    const certificates = document.querySelectorAll('.certificate');
    certificates.forEach(cert => {
        cert.addEventListener('click', certificateAdd);  // 이벤트 리스너 등록
    });

}

function certificateAdd(event) {
    console.log(event.target);
    const certName = event.target.getAttribute('data-certname');  // data-certname 속성으로 값 가져오기
    console.log(certName);
    document.getElementById('certificateName').value = certName;  // 'certificateName'에 값 넣기
}