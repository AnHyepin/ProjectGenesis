/**
 * 파일 목록 업데이트
 */
function updateFileList() {
    const fileInput = document.getElementById('file-input');
    const fileNamesField = document.getElementById('file-names');

    if (fileInput.files.length > 3) {
        alert("최대 3개의 파일만 선택할 수 있습니다.");
        fileInput.value = "";
        fileNamesField.value = "선택된 파일이 없습니다.";
        return;
    }

    const fileNames = Array.from(fileInput.files).map(file => file.name).join(', ');
    fileNamesField.value = fileNames || "선택된 파일이 없습니다.";
}

function validationCheck(){
    const requiredFields = ['applicationTitle', 'careerCode', 'workingArea', 'startDate'];

    // 각 필드에 대해 반복
    for (let field of requiredFields) {

        const inputElement = document.querySelector(`[name='${field}']`);
        const value = inputElement.value.trim();  // 입력 값 가져오기

        // 빈 값 확인
        if (!value) {
            // 각 필드에 따른 알림 메시지
            if (field === 'applicationTitle') {
                alert('공고 제목을 입력해주세요.');
            } else if (field === 'workingArea') {
                alert('근무지를 입력해주세요.');
            } else if (inputElement.tagName === 'SELECT' && field === 'careerCode') {
                alert('경력을 선택해주세요.');
            } else if (inputElement.type === 'date' && field === 'startDate') {
                alert('공고 시작일을 선택해주세요.');
            } else {
                alert(`필수 입력 항목을 모두 채워주세요: ${field}`);
            }

            // 해당 입력 필드에 포커스를 설정
            inputElement.focus();
            return false;  // 유효성 검사 실패 시 함수 종료
        }
    }
    return true;  //
}