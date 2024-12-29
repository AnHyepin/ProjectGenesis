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


/**
 * 다음 주소 API
 */
function openDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            document.querySelector('input[name="zipcode"]').value = data.zonecode;
            document.querySelector('input[name="roadAddress"]').value = data.roadAddress;
        }
    }).open();
}

/**
 * 프로필 이미지 미리보기
 */
function previewImage(event) {
    const file = event.target.files[0];
    const reader = new FileReader();
    const previewBox = document.querySelector('.profile-box');
    const plusSign = previewBox.querySelector('h1');

    if (file) {
        reader.onload = function (e) {
            plusSign.style.display = 'none';

            const existingImage = previewBox.querySelector('img');
            if (existingImage) {
                previewBox.removeChild(existingImage);
            }

            const img = document.createElement('img');
            img.src = e.target.result;
            img.style.width = '100%';
            img.style.height = '100%';
            img.style.objectFit = 'cover';
            img.style.borderRadius = '8px';
            previewBox.appendChild(img);
        };
        reader.readAsDataURL(file);
    } else {
        plusSign.style.display = 'block';
    }
}

/**
 * 사업자 번호 중복체크
 */
function idCheck() {
    const companyId = document.querySelector("input[name='username']");
    const checkButton = document.querySelector("button[onclick='idCheck()']");

    if (!companyId) {
        alert("사업자 번호를 입력해주세요.");
        return;
    }

    api.get(`/api/company/${companyId.value.trim()}`)
        .then(data => {
            if (data.body === '중복됨') {
                alert("중복된 사업자 번호입니다.");
                isDuplicateChecked = false;
            } else {
                alert("사용 가능한 사업자 번호입니다.");
                checkButton.classList.add("disabled");
                companyId.disabled = true;
                checkButton.disabled = true;
                checkButton.textContent = "확인 완료";
                isDuplicateChecked = true;
            }
        })
        .catch(error => {
            console.error(error);
            alert("중복 체크 중 오류가 발생했습니다.");
        });
}

/**
 * 유효성 검사 및 폼 데이터 제출
 */
function submitForm() {

    if (!isDuplicateChecked) {
        alert("사업자 번호 중복 체크를 먼저 진행해주세요.");
        return;
    }

    const requiredFields = [
        'username', 'password', 'passwordCheck', 'name', 'birth',
        'email', 'phone', 'zipcode', 'roadAddress', 'detailAddress',
        'ceoName'
    ];

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

    const fields = [
        'username', 'password', 'name', 'birth', 'email', 'phone',
        'zipcode', 'roadAddress', 'detailAddress', 'ceoName', 'homepage',
        'employees', 'sale', 'content'
    ];

    fields.forEach(field => {
        const value = document.querySelector(`input[name='${field}']`)?.value.trim() || document.querySelector(`textarea[name='${field}']`)?.value.trim();
        if (value) {
            formData.append(field, value);
        }
    });

    const fileInput = document.getElementById('file-input');
    const files = fileInput.files;

    if (files.length > 0) {
        Array.from(files).forEach(file => {
            formData.append("files", file);
        });
    }

    api.post('/api/company', formData, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    })
        .then(res => {
            if (res.body === '회원가입 성공') {
                alert("가입 성공");
                location.href = '/login';
            } else {
                alert("가입 실패");
            }
        })
        .catch(error => {
            console.error("오류:", error);
            alert("회원가입  오류");
        });
}
