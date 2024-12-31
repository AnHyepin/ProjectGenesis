let uploadedFile = null;
const profileBox = document.querySelector('.profile-box');

function setInitialProfileImage() {
    const hiddenProfileUrl = document.getElementById('hidden-profile-url').value;
    const profileBox = document.querySelector('.profile-box');
    const plusSign = profileBox.querySelector('h1');

    if (hiddenProfileUrl) {
        plusSign.style.display = 'none';

        let existingImage = profileBox.querySelector('img');
        if (!existingImage) {
            existingImage = document.createElement('img');
            profileBox.appendChild(existingImage);
        }

        existingImage.src = hiddenProfileUrl;
        existingImage.style.width = '100%';
        existingImage.style.height = '100%';
        existingImage.style.objectFit = 'cover';
        existingImage.style.borderRadius = '8px';
    }
}

function previewImage(event) {
    const file = event.target.files[0];
    const reader = new FileReader();
    const profileBox = document.querySelector('.profile-box');
    const plusSign = profileBox.querySelector('h1');

    if (file) {
        uploadedFile = file;


        reader.onload = function (e) {
            plusSign.style.display = 'none';

            let existingImage = profileBox.querySelector('img');
            if (!existingImage) {
                existingImage = document.createElement('img');
                profileBox.appendChild(existingImage);
            }

            existingImage.src = e.target.result;
            existingImage.style.width = '100%';
            existingImage.style.height = '100%';
            existingImage.style.objectFit = 'cover';
            existingImage.style.borderRadius = '8px';
        };
        reader.readAsDataURL(file);
    } else {
        plusSign.style.display = 'block';
        const existingImage = profileBox.querySelector('img');
        if (existingImage) {
            profileBox.removeChild(existingImage);
        }
        uploadedFile = null;
    }
}

function submitForm() {
    const formData = new FormData();

    if (uploadedFile) {
        formData.append('profilePicture', uploadedFile);

        const fileNo = profileBox.getAttribute('data-file-id');
        if (fileNo && fileNo !== 'null') {
            formData.append('fileNo', fileNo);
        }
    }

    const fields = ['username', 'name', 'birth', 'email', 'phone', 'zipcode', 'roadAddress', 'detailAddress'];
    fields.forEach(field => {
        const input = document.querySelector(`[name="${field}"]`);
        if (input) {
            if (input.type === 'radio' && input.checked) {
                formData.append(field, input.value);
            } else if (input.type !== 'radio') {
                formData.append(field, input.value || '');
            }
        }
    });

    const genderInput = document.querySelector('[name="gender"]:checked');

    if (genderInput) {
        formData.append('gender', genderInput.value);
    }

    for (let [key, value] of formData.entries()) {
        console.log(`${key}:`, value);
    }

    api.put('/api/user', formData)
        .then(data => {
            console.log('업데이트 성공:', data);
            alert('정보가 성공적으로 수정되었습니다!');
            location.reload();
        })
        .catch(error => {
            console.error('업데이트 실패:', error);
            alert('정보 수정에 실패했습니다.');
        });
}


document.addEventListener('DOMContentLoaded', () => {
    setInitialProfileImage();
});
