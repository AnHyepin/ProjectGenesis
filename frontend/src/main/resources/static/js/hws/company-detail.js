const inputRange = document.querySelector(".rate_range");
const activeRate = document.querySelector(".active_rate");
const rateValue = document.querySelector("#rate_value");

document.querySelector(".rating-badge").addEventListener("click", function () {
    const userElement = document.querySelector("#user-data");
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

    document.querySelector("#rating-popup").classList.add("on");
});

document.querySelector("#confirm-rating").addEventListener("click", function () {
    const popup = document.querySelector("#rating-popup");
    const finalRating = rateValue.value;

    console.log("선택한 별점:", finalRating);

    const companyName = document.querySelector("#company-data").dataset.companyData;
    const username = document.querySelector("#user-data").dataset.username;


    myapi.post("/api/company/rating", {
        companyName: companyName,
        username: username,
        jrStar: finalRating
    })
        .then(response => {
            console.log("별점 제출 성공:", response);
            Swal.fire({
                title: "별점 제출 완료",
                text: "별점이 성공적으로 제출되었습니다.",
                icon: "success",
                confirmButtonText: "확인"
            });
            popup.classList.remove("on");
        })
        .catch(error => {
            console.error("별점 제출 실패:", error);
            Swal.fire({
                title: "이미 별점을 준 기업입니다.",
                text: "돌아가!",
                icon: "error",
                confirmButtonText: "확인"
            });
            popup.classList.remove("on");

        });
});

inputRange.addEventListener("input", (event) => {
    const range = event.target.value;
    const rate = range / 2;
    activeRate.style.width = `${range * 10}%`;
    rateValue.value = rate;
    document.querySelector(".range_text").innerHTML = rate + "점";
});