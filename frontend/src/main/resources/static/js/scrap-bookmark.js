$(document).ready(function () {
    $(".scrap-icon").click(function (e) {
        e.stopPropagation();

        const userElement = document.getElementById("user-data");
        const isLoggedIn = userElement.dataset.isLoggedIn === "true";
        const username = userElement.dataset.username;

        console.log("로그인 여부 (isLoggedIn):", isLoggedIn);
        console.log("사용자 이름 (username):", username);
        if (!isLoggedIn) {
            Swal.fire({
                title: "로그인 필요",
                text: "로그인 후 진행해주세요.",
                icon: "warning",
                confirmButtonText: "확인"
            });
            return;
        }

        const ele = this;
        const actionType = $(ele).data("action-type");
        const actionId = $(ele).data("action-id");

        console.log("클릭한 Type:", actionType);
        console.log("클릭한 ID:", actionId);

        const modalTitle = actionType === "S" ? "스크랩" : "북마크";
        const modalText = actionType === "S"
            ? "스크랩 상태를 변경하시겠습니까?"
            : "북마크 상태를 변경하시겠습니까?";

        Swal.fire({
            title: modalTitle,
            text: modalText,
            icon: "question",
            showCancelButton: true,
            confirmButtonText: "확인",
            cancelButtonText: "취소"
        }).then((result) => {
            if (result.isConfirmed) {
                api.post('/api/likes/toggle', {
                    username: username,
                    likeCode: actionType,
                    likeId: actionId
                })
                    .then(response => {
                        console.log("API 응답:", response);
                        location.reload();
                    })
                    .catch(error => {
                        console.error("API 요청 실패:", error);
                        Swal.fire({
                            title: "오류 발생",
                            text: "상태 변경에 실패했습니다.",
                            icon: "error",
                            confirmButtonText: "확인"
                        });
                    });
            }
        });
    });
});