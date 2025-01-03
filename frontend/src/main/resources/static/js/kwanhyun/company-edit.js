let uploadedFile = null;
const profileBox = document.querySelector('.profile-box');

function submitForm() {
    const formData = new FormData();

    const fields = ['username', 'name', 'birth', 'email', 'phone', 'zipcode', 'roadAddress', 'detailAddress', 'ceoName', 'homepage', 'employees', 'sale', 'content'];
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

    for (let [key, value] of formData.entries()) {
        console.log(`${key}:`, value);
    }

    api.put('/api/company', formData)
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

function deleteCompany() {
    const username = document.getElementById('username').value
    api.put(`/api/company/delete/${username}`)
        .then(data => {
            console.log('삭제 성공:', data);
            alert('유저 삭제 성공');
            location.href = '/logout';
        })
        .catch(error => {
            console.error('업데이트 실패:', error);
            alert('정보 수정에 실패했습니다.');
        });
}
