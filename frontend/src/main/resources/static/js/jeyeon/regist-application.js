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