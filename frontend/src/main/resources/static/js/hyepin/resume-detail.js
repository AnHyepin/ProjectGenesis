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
