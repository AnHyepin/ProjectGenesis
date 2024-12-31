let isDuplicateChecked = false;

/**
 *  다음주소 api
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
 *  프로필 이미지 미리보기
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
 *  아이디 중복체크
 */
function idCheck() {
    const username = document.querySelector("input[name='username']");
    const checkButton = document.querySelector("button[onclick='idCheck()']");

    if (!username) {
        alert("아이디를 입력해주세요.");
        return;
    }

    api.get(`/api/user/check/${username.value.trim()}`)
        .then(data => {
            if (data.body === '중복됨') {

                alert("중복된 아이디 입니다.");
                isDuplicateChecked = false;

            } else {
                alert("사용 가능한 아이디입니다.");
                checkButton.classList.add("disabled");
                username.display = true;
                checkButton.disabled = true;
                checkButton.textContent = "확인 완료";
                isDuplicateChecked = true;
            }
        })
        .catch(error => {
            console.error(error);
            alert("에러 발생.");
        });
}

/**
 * 간단한  유효성 검사
 */
function submitForm() {

    if (!isDuplicateChecked) {
        alert("아이디 중복 체크를 먼저 진행해주세요.");
        return;
    }

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
