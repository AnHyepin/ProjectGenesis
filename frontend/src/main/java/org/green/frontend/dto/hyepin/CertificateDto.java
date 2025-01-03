package org.green.frontend.dto.hyepin;

import lombok.Data;

@Data
public class CertificateDto {
    private int certificateNo;
    private int resumeNo;
    private String username;
    private String certificateDt; //자격증 취득일
    private String certificateName; //자격증명
    private String certificatePlace;    //발급기관
    private char certificateGbnCd; //합격구분
    private String certificateGbnName;  //합격구분이름
}
