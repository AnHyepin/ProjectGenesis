/* 학력 데이터 보내기 */
function educationSave(){

    const resumeEducationGbnCode = document.getElementById("resumeEducationGbnCode").value;
    const resumeEducationName = document.getElementById("resumeEducationName").value;
    const resumeEducationIndt = document.getElementById("resumeEducationIndt").value;
    const resumeEducationOutdt = document.getElementById("resumeEducationOutdt").value;
    if(resumeEducationGbnCode === "" || resumeEducationGbnCode === '학력 구분 선택' ||
        resumeEducationGbnCode === '학력 구분 선택' || resumeEducationName.trim() === "" ||
        resumeEducationIndt.trim() === "" || resumeEducationOutdt.trim() === ""){
        alert("필수 항목을 입력하세요.")
    }else{
        const username = document.getElementById('username').textContent;

        // 폼 데이터 가져오기
        const educationForm = document.getElementById('education-regist');
        const formData = new FormData(educationForm);

        // 디버깅: formData 확인 (브라우저 콘솔에서 데이터 확인)
        for (let [key, value] of formData.entries()) {
            console.log(key, value);
        }

        var checkbox = document.getElementById("resumeEducationTransferYn");
        var hiddenInput = document.getElementById("hiddenInput");
        checkbox.addEventListener("change", function() {
            // 체크박스가 체크되었으면 hiddenInput 값을 "Y"로 변경, 아니면 "N"으로 변경
            if (checkbox.checked) {
                hiddenInput.value = "Y";
            } else {
                hiddenInput.value = "N";
            }
        });

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
            <div id="education-major">${resumeEducationMajor}</div>
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

    const resumeCareerCompanyName = document.getElementById('resumeCareerCompanyName').value;
    const resumeCareerJoinDt = document.getElementById('resumeCareerJoinDt').value;
    const resumeCareerOutDt = document.getElementById('resumeCareerOutDt').value;
    const resumeCareerJob = document.getElementById('resumeCareerJob').value;

    if(resumeCareerCompanyName.trim() === "" || resumeCareerJoinDt.trim() === "" ||
        resumeCareerOutDt.trim() === "" ||  resumeCareerJob.trim() === ""){
        alert("필수 항목을 입력하세요.");
    }else{
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
        <div style="white-space: pre-wrap;">${resumeCareerDuties}</div>
    </div>
            
`;
    // 부모 요소에 추가
    careerListForm.appendChild(sectionBox);

}

function careerDelete(){
    alert("경력 삭제");
}

//스택 저장
function stackSave(){
    // 폼 데이터 가져오기
    const skillListForm = document.getElementById('skill-list-form');
    const formData = new FormData(skillListForm);
    //이름 추가
    const username = document.getElementById('username').textContent;
    formData.append('username', username);

    //폼데이터 보내기
    api.post('/api/resume/skill', formData, {
    })
        .then(res => {
            if (res.body == '스택 저장 성공') {  // 응답의 본문은 res.data에 담김
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

//자격증 저장
function certificateSave(){

    const certificateName = document.getElementById('certificateName').value;
    const certificatePlace = document.getElementById('certificatePlace').value;
    const certificateGbnCd = document.getElementById('certificateGbnCd').value;
    const certificateDt = document.getElementById('certificateDt').value;

    if(certificateName.trim() === "" || certificatePlace.trim() === "" ||
        certificateGbnCd.trim() === "" || certificateDt.trim() === "") {
        alert("필수 항목을 입력하세요.");
    }else{
        // 폼 데이터 가져오기
        const certificateForm = document.getElementById('certificate-regist');
        const formData = new FormData(certificateForm);
        //이름 추가
        const username = document.getElementById('username').textContent;
        formData.append('username', username);

        //폼데이터 보내기
        api.post('/api/resume/certificate', formData, {
        })
            .then(res => {
                if (res.body == '자격증 저장 성공') {  // 응답의 본문은 res.data에 담김
                    certificateInsert();
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
}

//자격증 추가
function certificateInsert(){

    const certificateName = document.getElementById('certificateName').value;
    const certificatePlace = document.getElementById('certificatePlace').value;
    const certificateDt = document.getElementById('certificateDt').value;

    // 부모 요소 찾기
    const certificateListForm = document.getElementById('certificate-list-form');

    const sectionBox = document.createElement('div');
    sectionBox.classList.add('section_box2');

    // 내부 HTML 생성
    sectionBox.innerHTML = `
            <div class="section_box2_detail">
            <div class="section_box2_detail_info">
                <div class="certificate-detail">
                    <div>${certificateName} <span>| ${certificateDt}</span></div>
                </div>
            </div>
            <div class="section_box2_detail_modi">
                <div><i class="bi bi-pencil"></i> </div>
                <button class="deleteBtn" onclick="certificateDelete()">
                    <i class="bi bi-x-square"></i>
                </button>
            </div>
        </div>
        <div class="section_box2_detail2">
            <div>${certificatePlace}</div>
        </div>
`;
    // 부모 요소에 추가
    certificateListForm.appendChild(sectionBox);
}

function certificateDelete(){
    alert("자격증 삭제");
}

//파일
// 라디오 버튼들
const fileRadio = document.getElementById('fileRadio');
const urlRadio = document.getElementById('urlRadio');

// 입력 필드들
const fileInputBox = document.getElementById('fileInputBox');
const urlInputBox = document.getElementById('urlInputBox');
const fileInput = document.getElementById('fileInput');
const resumePortfolioUrl = document.getElementById('resumePortfolioUrl');

// 페이지 로드 시 기본 상태로 파일 입력을 보여주기
document.addEventListener('DOMContentLoaded', () => {
    toggleInputFields();
});

// 라디오 버튼 클릭 시 입력 필드 표시/숨기기
fileRadio.addEventListener('change', toggleInputFields);
urlRadio.addEventListener('change', toggleInputFields);

// 파일과 URL 입력 필드를 보이거나 숨기는 함수
function toggleInputFields() {
    if (fileRadio.checked) {
        fileInputBox.style.display = 'block';
        urlInputBox.style.display = 'none';
        resumePortfolioUrl.value = '';
    } else if (urlRadio.checked) {
        fileInputBox.style.display = 'none';
        urlInputBox.style.display = 'block';
        fileInput.value = '';
    }
}


//포트폴리오 저장
function portfolioSave(){

    const resumePortfolioStartDate = document.getElementById('resumePortfolioStartDate').value;
    const resumePortfolioEndDate = document.getElementById('resumePortfolioEndDate').value;

    if(resumePortfolioStartDate.trim() === "" || resumePortfolioEndDate.trim()) {
        alert("필수 항목을 입력하세요.");
    }else{
        // 폼 데이터 가져오기
        const portfolioForm = document.getElementById('portfolio-regist');
        const formData = new FormData(portfolioForm);
        //이름 추가
        const username = document.getElementById('username').textContent;
        formData.append('username', username);

        console.log([...formData.entries()]);

        //폼데이터 보내기
        api.post('/api/resume/portfolio', formData, {
        })
            .then(res => {
                if (res.body == '포트폴리오 저장 성공') {  // 응답의 본문은 res.data에 담김
                    portfolioInsert();
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
}



//포트폴리오 박스 띄우기
function portfolioInsert(){

    const resumePortfolioStartDate = document.getElementById('resumePortfolioStartDate').value;
    const resumePortfolioEndDate = document.getElementById('resumePortfolioEndDate').value;
    const resumePortfolioCnt = document.getElementById('resumePortfolioCnt').value;
    const resumePortfolioContent = document.getElementById('resumePortfolioContent').value;
    const fileInput = document.getElementById('fileInput').value;
    const resumePortfolioUrl = document.getElementById('resumePortfolioUrl').value;

    const fileName = fileInput.split('\\').pop();

    // 부모 요소 찾기
    const portfolioListForm = document.getElementById('portfolio-list-form');

    const sectionBox = document.createElement('div');
    sectionBox.classList.add('file-section_box2');

    // 내부 HTML 생성
    sectionBox.innerHTML = `
            <div class="section_box2_detail">
                <div class="file-name">${fileName} ${resumePortfolioUrl}</div>
                <div class="section_box2_detail_modi">
                    <div><i class="bi bi-pencil"></i> </div>
                    <button class="deleteBtn" onclick="portfolioDelete()">
                        <i class="bi bi-x-square"></i>
                    </button>
                </div>
            </div>
            <div class="section_box2_detail2">
                <div>작업기간: ${resumePortfolioStartDate} ~ ${resumePortfolioEndDate}</div>
                <div>작업인원: ${resumePortfolioCnt}명</div>
                <div style="white-space: pre-wrap;">작품소개: ${resumePortfolioContent}</div>
            </div>
    `;
    // 부모 요소에 추가
    portfolioListForm.appendChild(sectionBox);
}

function portfolioDelete(){
    alert("포트폴리오 삭제");
}

//자기소개서 추가
function resumeMyinfoSave(){

    const inputResumeMyTitle = document.getElementById('inputResumeMyTitle').value;
    const inputResumeMyContent = document.getElementById('inputResumeMyContent').value;

    if(inputResumeMyTitle.trim() === "" || inputResumeMyContent.trim()) {
        alert("필수 항목을 입력하세요.");
    }else{
        document.getElementById('resumeMyTitle').innerHTML = inputResumeMyTitle;
        document.getElementById('resumeMyContent').innerHTML = inputResumeMyContent;
        document.getElementById('resumeMyinfo-form').style.display = 'block';
    }
}



function resumeMyinfoDelete(){
    alert("자기소개서 삭제");
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

//체크박스를 누르면
function toggleSkill(checkbox) {
    const skillListContainer = document.querySelector('.skill-list'); // 전체 스킬 리스트 컨테이너
    const skillValue = checkbox.value;
    const skillName = checkbox.getAttribute('id');

    if (checkbox.checked) {
        const skillDiv = document.createElement('div');
        skillDiv.className = 'input-skill-list'; // 클래스 이름 추가
        skillDiv.id = `skill-${skillValue}`; // 고유 ID 설정
        skillDiv.innerHTML = `
            <input type="hidden" name="stackCode" value="${skillValue}">
            <div style="color: #171717;">${skillName}</div>
            <div style="margin-left: 20px;" >| <button class="input-skill-cancle" onclick="removeSkill('${skillValue}')">X</button></div>
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

//이력서 저장
function submitForm(){

    const resumeTitle = document.getElementById('resumeTitle').value;
    if(resumeTitle.trim() === ""){
        alert("이력서 제목을 입력하세요.");
        document.getElementById("resumeTitle").focus();
    }else if(document.getElementById('education-list-form').childElementCount === 0){
        alert("학력을 입력하세요.");
        document.getElementById("resumeEducationName").focus();
    }else{

        const formData = new FormData();

        const resumeMyTitle = document.getElementById('resumeMyTitle').innerHTML;
        const resumeMyContent = document.getElementById('resumeMyContent').innerHTML;
        const resumePubilceYn = document.querySelector('input[name="resumePubilceYn"]:checked').value;
        const career = document.getElementById('career').value;
        const salary = document.getElementById('salary').value;
        const username = document.getElementById('username').textContent;

        formData.append('username', username);
        formData.append('resumeTitle', resumeTitle);
        formData.append('resumeMyTitle', resumeMyTitle);
        formData.append('resumeMyContent', resumeMyContent);
        formData.append('resumePubilceYn', resumePubilceYn);
        formData.append('career', career);
        formData.append('salary', salary);

        //폼데이터 보내기
        api.post('/api/resume/resumeSubmit', formData, {
        })
            .then(res => {
                if (res.body == '이력서 저장 성공') {  // 응답의 본문은 res.data에 담김
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
}
/*
//완성도
function changeCompletion() {
    let completedFields = 0; // 채워진 필드 개수
    let totalFields = 5; // 총 필드 개수 (예: 학교명, 전공, 입학년월 등)

    // 학력 섹션의 필드 값 확인
    const educationName = document.getElementById("resumeEducationName").value;
    const educationMajor = document.getElementById("resumeEducationMajor").value;
    const educationIndt = document.getElementById("resumeEducationIndt").value;
    const educationOutdt = document.getElementById("resumeEducationOutdt").value;
    const educationGbnCode = document.getElementById("resumeEducationGbnCode").value;

    // 값이 입력된 필드 개수 계산
    if (educationName.trim() !== "") completedFields++;
    if (educationMajor.trim() !== "") completedFields++;
    if (educationIndt.trim() !== "") completedFields++;
    if (educationOutdt.trim() !== "") completedFields++;
    if (educationGbnCode !== "학력 구분 선택") completedFields++;

    // 완성도 계산
    const completionRate = Math.floor((completedFields / totalFields) * 100);

    // 프로그레스 바와 텍스트 업데이트
    const progressBar = document.getElementById("education-progress");
    const progressText = document.getElementById("education-progress-text");
    progressBar.value = completionRate;
    progressText.textContent = `${completionRate}%`;
}

// 각 필드에 change 이벤트 리스너 추가
document.getElementById("resumeEducationName").addEventListener("input", changeCompletion);
document.getElementById("resumeEducationMajor").addEventListener("input", changeCompletion);
document.getElementById("resumeEducationIndt").addEventListener("input", changeCompletion);
document.getElementById("resumeEducationOutdt").addEventListener("input", changeCompletion);
document.getElementById("resumeEducationGbnCode").addEventListener("change", changeCompletion);
*/