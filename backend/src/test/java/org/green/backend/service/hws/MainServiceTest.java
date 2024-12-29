package org.green.backend.service.hws;

import org.green.backend.dto.hws.PopularApplicationDto;
import org.green.backend.entity.Application;
import org.green.backend.repository.jpa.hws.ApplyStatusRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainServiceTest {

    @Mock
    private ApplyStatusRepository applyStatusRepository;

    @InjectMocks
    private MainService mainService;

    @Test
    void givenPopularApplicationsExist_whenNonLoginMainListCalled_thenReturnListOfApplications() {

        // Given: 인기 공고가 존재할 때
        Application app1 = new Application();
        app1.setApplicationNo(1);
        app1.setApplicationTitle("백엔드 엔지니어");
        app1.setDeleteYn("N");

        Application app2 = new Application();
        app2.setApplicationNo(2);
        app2.setApplicationTitle("프론트엔드 엔지니어");
        app2.setDeleteYn("N");

        List<Application> mockApplications = List.of(app1, app2);

        // When:비로그인 메인 리스트 메서드를 호출하면
        when(applyStatusRepository.findPopularApplications()).thenReturn(mockApplications);
        List<PopularApplicationDto> result = mainService.nonLoginMainList();

        // Then:공고 리스트를 반환
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("백엔드 엔지니어", result.get(0).getApplicationTitle());
        verify(applyStatusRepository, times(1)).findPopularApplications();
    }
}
