package org.green.frontend.service.jeyeon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.green.frontend.dto.jeyeon.ApplicationStackDto;
import org.green.frontend.dto.jeyeon.GubnDto;
import org.green.frontend.global.ApiResponse;
import org.green.frontend.service.ApiRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 12-31 (작성자: 안제연)
 * 이 클래스는 채용공고 화면이동에 관한 서비스입니다.
 */
@Service
@RequiredArgsConstructor
public class ApplicaitonService {

    private final ApiRequestService apiService;
    private final ObjectMapper objectMapper;

    public  String createJobPost(String content) {
        // 정규식을 사용하여 두 개 이상의 줄바꿈을 기준으로 항목별로 나누기
        String[] sections = content.split("\\r\\n\\r\\n");  // 2개 이상의 줄바꿈을 기준으로 분리
        StringBuilder htmlContent = new StringBuilder();

        // 섹션 제목 목록
        String[] sectionTitles = {"담당업무", "우대사항", "근무조건", "접수 기간 및 방법", "복리후생"};

        // 섹션 이름에 맞는 스타일 클래스 추가
        for (String section : sections) {
            // System.out.println(section + "--------------section");  // 섹션 출력

            // 각 섹션을 제목과 항목으로 분리
            String[] lines = section.split("\\r\\n");  // 각 섹션을 줄바꿈 기준으로 분리
            String title = lines[0].trim();  // 제목은 첫 번째 항목

            // 제목이 sectionTitles 배열에 포함되는지 확인
            boolean isValidTitle = false;
            for (String sectionTitle : sectionTitles) {
                if (title.equals(sectionTitle)) {
                    isValidTitle = true;
                    break;
                }
            }

            // 유효한 제목이 있으면 섹션을 추가
            if (isValidTitle) {
                htmlContent.append("<div class=\"section\"><p class=\"section-title\">" + title + "</p><ul class=\"section-content\">");

                // 항목들을 <li> 태그로 추가
                for (int i = 1; i < lines.length; i++) {
                    String item = lines[i].trim(); // 공백 제거
                    if (!item.isEmpty()) { // 빈 항목은 추가하지 않음
                        htmlContent.append("<li>" + item + "</li>");
                    }
                }

                htmlContent.append("</ul></div>");
            }
        }

        // System.out.println(htmlContent.toString());  // 생성된 HTML 출력
        return htmlContent.toString();
    }

    public List<String> getSkillNameList(List<ApplicationStackDto> skillList){
        List<GubnDto> sList = new ArrayList<>();

        for(ApplicationStackDto skill : skillList){
            var skillResponse = apiService.fetchData("/api/application/" + skill.getStackCode());
            List<GubnDto> gubnDtos = objectMapper.convertValue(
                    skillResponse.getBody(),
                    new TypeReference<List<GubnDto>>() {}
            );
            sList.addAll(gubnDtos);
        }

        List<String> skillNameList = new ArrayList<>();
        for(GubnDto skillName : sList){
            skillNameList.add(skillName.getGubnName());
        }

        return skillNameList;
    }
}
