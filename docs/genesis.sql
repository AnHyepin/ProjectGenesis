-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.7.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 genesis.tbl_applications 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_applications` (
  `application_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '채용공고 번호',
  `username` varchar(15) NOT NULL COMMENT '사용자 고유 ID',
  `application_title` varchar(225) NOT NULL COMMENT '채용공고 제목',
  `start_date` varchar(255) NOT NULL,
  `deadline_date` varchar(255) DEFAULT NULL,
  `application_code` char(1) NOT NULL DEFAULT 'O',
  `salary` int(11) DEFAULT 0 COMMENT '연봉',
  `career_code` varchar(255) NOT NULL,
  `position_code` varchar(20) DEFAULT NULL COMMENT '직책/직급코드',
  `education_gbn_code` varchar(20) DEFAULT NULL COMMENT '학력 구분 코드',
  `employment_code` char(1) NOT NULL DEFAULT 'A',
  `working_area` varchar(255) NOT NULL COMMENT '근무지역',
  `role_code` varchar(20) DEFAULT NULL COMMENT '개발직무',
  `content` text DEFAULT NULL COMMENT '모집부문 및 상세내용',
  `procedure_code` int(11) DEFAULT NULL COMMENT '1차(1) /2차(2) /3차(3)',
  `delete_yn` char(1) NOT NULL DEFAULT 'N',
  `regist_dt` varchar(255) NOT NULL DEFAULT current_timestamp(),
  `modi_dt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`application_no`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='채용공고 테이블';

-- 테이블 데이터 genesis.tbl_applications:~12 rows (대략적) 내보내기
INSERT INTO `tbl_applications` (`application_no`, `username`, `application_title`, `start_date`, `deadline_date`, `application_code`, `salary`, `career_code`, `position_code`, `education_gbn_code`, `employment_code`, `working_area`, `role_code`, `content`, `procedure_code`, `delete_yn`, `regist_dt`, `modi_dt`) VALUES
	(1, '1234567890', '열정가득한 웹 개발자 채용', '2025-01-05', NULL, 'O', 3000, 'S', 'S', 'H', 'A', '부산광역시 연제구 중앙대로 1001', 'BE', '담당업무\r\n시스템 설계\r\n프로그램 설계\r\n프레임워크 기반 웹 개발\r\n안드로이드 SDK 개발\r\n\r\n우대사항\r\n컴퓨터활용능력 우수, 문서작성 우수자,  의사소통, 협업 능력 우수자, PPT능력 우수자\r\n\r\n근무조건\r\n근무형태 : 정규직(수습기간) -3개월, 계약직(정규직 전환가능) -1년\r\n근무일시 : 주5일(월~금) 9:00 ~ 6:00\r\n근무지역 : 부산 동래구 링카빌딩 3층\r\n\r\n접수 기간 및 방법\r\n접수기간 : 2024년 12월 21일 ~ 채용시 마감\r\n접수방법 : 사람인 입사지원, 홈페이지 지원\r\n제출서류 : 이력서, 포트폴리오 첨부\r\n\r\n복리후생\r\n4대보험\r\n연차\r\n점심/저녁 지원', 1, 'N', '2025-01-05 17:40:25', NULL),
	(2, '혜빈컴퍼니', '노예소집!', '2025-01-05', '2025-12-12', 'O', 1800, 'S', 'S', 'H', 'A', '관현집', 'BE', '저희 회사는 가 족같은 회사입니다.\r\n어서 지원하세요!', 1, 'N', '2025-01-05 20:06:38', NULL),
	(3, '혜빈컴퍼니', '일잘러 모집합니다.', '2025-01-05', '2025-12-12', 'O', 3000, 'G', 'T', 'U4', 'A', '우성집', 'AI', '빨리 지원해. 일잘러들은 여기 좋은 회사인거 알잖아.', 3, 'N', '2025-01-05 20:07:54', NULL),
	(4, '1234567890', '앱 개발자 채용', '2025-01-06', '2025-02-28', 'O', 3000, 'S', 'S', 'H', 'A', '부산광역시 부산진구 양정로15번길 26', 'MA', '담당업무\r\n시스템 설계\r\n프로그램 설계\r\n프레임워크 기반 웹 개발\r\n안드로이드 SDK 개발\r\n\r\n근무조건\r\n근무형태 : 정규직(수습기간) -3개월, 계약직(정규직 전환가능) -1년\r\n근무일시 : 주5일(월~금) 9:00 ~ 6:00\r\n근무지역 : 부산 동래구 링카빌딩 3층\r\n\r\n접수 기간 및 방법\r\n접수기간 : 2024년 12월 21일 ~ 채용시 마감\r\n접수방법 : 사람인 입사지원, 홈페이지 지원\r\n제출서류 : 이력서, 포트폴리오 첨부\r\n\r\n복리후생\r\n4대보험\r\n연차\r\n점심/저녁 지원', 0, 'N', '2025-01-05 20:31:51', NULL),
	(5, '1231231231', '관현컴퍼니에서 관에 보내드립니다!', '2025-01-06', '2025-01-30', 'O', 2000, 'S', 'S', 'U3', 'C', '부산', 'DO', '관현컴퍼니에서 관에 보내드립니다!', 0, 'N', '2025-01-06 09:09:47', NULL),
	(6, '1111111111', '그린컴퍼니 프론트엔드 개발자 모집', '2025-01-30', '2025-03-29', 'O', 3500, 'S', 'S', 'H', 'A', '그린컴퍼니', 'FE', NULL, 2, 'N', '2025-01-06 12:05:54', NULL),
	(7, '1111111111', '그린컴퍼니 프론트엔드 개발자 모집', '2025-01-30', '2025-03-29', 'O', 3500, 'S', 'S', 'H', 'A', '그린컴퍼니', 'FE', NULL, 2, 'N', '2025-01-06 12:06:02', NULL),
	(12, '1111111111', '경력 3년차 백엔드 개발자 채용', '2025-01-06', '2025-02-28', 'O', 8000, 'G', 'J', 'H', 'F', '부산광역시 부산진구 양정로15번길 26', 'BE', NULL, 2, 'N', '2025-01-06 14:27:23', NULL),
	(13, '1111111111', '게임 개발자 모집', '2025-01-06', '2025-04-30', 'O', 4000, 'S', 'S', 'H', 'A', '경기 성남시 분당구 삼평동 256번길 7', 'GD', '담당업무\r\n\r\n시스템 설계\r\n프로그램 설계\r\n프레임워크 기반 웹 개발\r\n안드로이드 SDK 개발\r\n\r\n우대사항\r\n컴퓨터활용능력 우수, 문서작성 우수자, 의사소통, 협업 능력 우수자, PPT능력 우수자\r\n\r\n근무조건\r\n근무형태 : 정규직(수습기간) -3개월, 계약직(정규직 전환가능) -1년\r\n근무일시 : 주5일(월~금) 9:00 ~ 6:00\r\n근무지역 : 부산 동래구 링카빌딩 3층\r\n\r\n접수 기간 및 방법\r\n접수기간 : 2024년 12월 21일 ~ 채용시 마감\r\n접수방법 : 사람인 입사지원, 홈페이지 지원\r\n제출서류 : 이력서, 포트폴리오 첨부\r\n\r\n복리후생\r\n4대보험\r\n연차\r\n점심/저녁 지원', 1, 'N', '2025-01-06 15:58:31', NULL),
	(14, '1111111111', '데이터 엔지니어 채용공고(신입)', '2025-02-01', '2025-02-28', 'O', 4600, 'S', 'S', 'U3', 'A', '서울특별시 서대문구 연세로2나길 61', 'DE', '모집부문\r\n툴 상관없이 쿼리문 사용 능숙(Join 등)', NULL, 'N', '2025-01-06 16:07:39', NULL),
	(15, '혜빈컴퍼니', '99년생 한상인 부하구함', '2025-01-06', '2070-05-12', 'O', 9, 'G', 'S', 'B', 'C', '천안', 'DO', '천안 광부 구함.. 흐흐흐', 0, 'N', '2025-01-06 17:27:56', NULL),
	(16, '1231231231', '하하하', '2025-01-17', '2025-01-03', 'O', 3000, 'S', 'S', 'U4', 'F', '서울 관악구 신사로', 'BE', NULL, NULL, 'N', '2025-01-06 17:28:33', NULL);

-- 테이블 genesis.tbl_application_stack 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_application_stack` (
  `application_stack_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '공고 기술스택 번호',
  `application_no` bigint(20) NOT NULL COMMENT '채용공고 번호',
  `stack_code` varchar(20) NOT NULL COMMENT '기술스택',
  PRIMARY KEY (`application_stack_no`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='공고별 기술 스택 테이블';

-- 테이블 데이터 genesis.tbl_application_stack:~62 rows (대략적) 내보내기
INSERT INTO `tbl_application_stack` (`application_stack_no`, `application_no`, `stack_code`) VALUES
	(1, 1, 'J'),
	(2, 1, 'P'),
	(3, 1, 'PY'),
	(4, 1, 'RB'),
	(5, 4, 'AOS'),
	(6, 4, 'FL'),
	(7, 4, 'iOS'),
	(8, 5, 'AOS'),
	(9, 5, 'FL'),
	(10, 5, 'iOS'),
	(11, 5, 'AS'),
	(12, 5, 'C'),
	(13, 6, 'C'),
	(14, 6, 'H'),
	(15, 6, 'JS'),
	(16, 6, 'NX'),
	(17, 6, 'NG'),
	(18, 6, 'R'),
	(19, 6, 'T'),
	(20, 7, 'C'),
	(21, 7, 'H'),
	(22, 7, 'JS'),
	(23, 7, 'NX'),
	(24, 7, 'NG'),
	(25, 7, 'R'),
	(26, 7, 'T'),
	(27, 12, 'F'),
	(28, 12, 'G'),
	(29, 12, 'J'),
	(30, 12, 'KT'),
	(31, 12, 'P'),
	(32, 13, 'C'),
	(33, 13, 'D'),
	(34, 13, 'E'),
	(35, 13, 'F'),
	(36, 13, 'G'),
	(37, 14, 'MG'),
	(38, 14, 'MS'),
	(39, 14, 'OR'),
	(40, 14, 'PS'),
	(41, 14, 'SS'),
	(42, 15, 'AOS'),
	(43, 15, 'F'),
	(44, 15, 'G'),
	(45, 15, 'DY'),
	(46, 15, 'ES'),
	(47, 15, 'FM'),
	(48, 15, 'OR'),
	(49, 15, 'PS'),
	(50, 15, 'RD'),
	(51, 15, 'SS'),
	(52, 15, 'GF'),
	(53, 15, 'A'),
	(54, 15, 'T'),
	(55, 15, 'JK'),
	(56, 15, 'PL'),
	(57, 16, 'P'),
	(58, 16, 'DY'),
	(59, 16, 'ES'),
	(60, 16, 'PS'),
	(61, 16, 'GL'),
	(62, 16, 'GF');

-- 테이블 genesis.tbl_apply_status 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_apply_status` (
  `apply_status_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 채용공고 제출번호',
  `resume_no` bigint(20) NOT NULL COMMENT '이력서 고유 넘버',
  `application_no` bigint(20) NOT NULL COMMENT '채용공고 번호',
  `apply_status_gbn_code` varchar(20) NOT NULL DEFAULT 'H' COMMENT '이력서 공고 매칭 상태(H:진행중, F: 불합격, P: 합격)',
  `regist_id` varchar(20) DEFAULT NULL COMMENT '입력자',
  `regist_dt` datetime DEFAULT current_timestamp() COMMENT '입력일시',
  `modi_id` varchar(20) DEFAULT NULL COMMENT '수정자',
  `modi_dt` datetime DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`apply_status_no`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 지원현황 테이블';

-- 테이블 데이터 genesis.tbl_apply_status:~38 rows (대략적) 내보내기
INSERT INTO `tbl_apply_status` (`apply_status_no`, `resume_no`, `application_no`, `apply_status_gbn_code`, `regist_id`, `regist_dt`, `modi_id`, `modi_dt`) VALUES
	(1, 9, 3, 'F', '안혜빈', '2025-01-05 18:11:12', NULL, '2025-01-05 18:11:12'),
	(2, 9, 3, 'F', '안혜빈', '2025-01-05 18:11:31', NULL, '2025-01-05 18:11:31'),
	(3, 9, 3, 'F', '안혜빈', '2025-01-05 19:47:49', NULL, '2025-01-05 19:47:49'),
	(5, 13, 3, 'H', '한우성', '2025-01-05 22:29:22', NULL, '2025-01-05 22:29:24'),
	(6, 12, 2, 'P', '노관현', '2025-01-05 22:30:21', NULL, '2025-01-05 22:30:22'),
	(7, 11, 3, 'H', '안제연', '2025-01-06 10:38:10', NULL, '2025-01-06 10:38:10'),
	(8, 101, 2, 'P', 'saya1013', '2025-01-06 11:55:59', NULL, '2025-01-06 11:55:59'),
	(9, 101, 3, 'F', 'saya1013', '2025-01-06 12:00:26', NULL, '2025-01-06 12:00:26'),
	(13, 11, 2, 'F', '안제연', '2025-01-06 16:13:13', NULL, '2025-01-06 16:13:13'),
	(19, 11, 13, 'H', '안제연', '2025-01-06 16:23:12', NULL, '2025-01-06 16:23:12'),
	(21, 9, 2, 'F', '안혜빈', '2025-01-06 17:26:02', NULL, '2025-01-06 17:26:02'),
	(22, 9, 2, 'F', '안혜빈', '2025-01-06 17:26:06', NULL, '2025-01-06 17:26:06'),
	(23, 9, 2, 'F', '안혜빈', '2025-01-06 17:26:09', NULL, '2025-01-06 17:26:09'),
	(24, 9, 2, 'F', '안혜빈', '2025-01-06 17:26:11', NULL, '2025-01-06 17:26:11'),
	(25, 9, 2, 'F', '안혜빈', '2025-01-06 17:26:44', NULL, '2025-01-06 17:26:44'),
	(26, 132, 1, 'H', 'qwer', '2025-01-06 17:29:08', NULL, '2025-01-06 17:29:08'),
	(27, 132, 1, 'H', 'qwer', '2025-01-06 17:29:11', NULL, '2025-01-06 17:29:11'),
	(28, 132, 1, 'H', 'qwer', '2025-01-06 17:29:15', NULL, '2025-01-06 17:29:15'),
	(29, 132, 1, 'H', 'qwer', '2025-01-06 17:29:24', NULL, '2025-01-06 17:29:24'),
	(30, 140, 1, 'H', 'dongha', '2025-01-06 17:29:55', NULL, '2025-01-06 17:29:55'),
	(31, 132, 1, 'H', 'qwer', '2025-01-06 17:30:03', NULL, '2025-01-06 17:30:03'),
	(32, 140, 1, 'H', 'dongha', '2025-01-06 17:30:04', NULL, '2025-01-06 17:30:04'),
	(33, 132, 1, 'H', 'qwer', '2025-01-06 17:30:08', NULL, '2025-01-06 17:30:08'),
	(34, 140, 1, 'H', 'dongha', '2025-01-06 17:30:13', NULL, '2025-01-06 17:30:13'),
	(35, 132, 1, 'H', 'qwer', '2025-01-06 17:30:28', NULL, '2025-01-06 17:30:28'),
	(36, 140, 1, 'H', 'dongha', '2025-01-06 17:30:41', NULL, '2025-01-06 17:30:41'),
	(37, 132, 1, 'H', 'qwer', '2025-01-06 17:30:54', NULL, '2025-01-06 17:30:54'),
	(38, 141, 1, 'H', '콜라에밥말아먹기~', '2025-01-06 17:31:18', NULL, '2025-01-06 17:31:18'),
	(39, 141, 1, 'H', '콜라에밥말아먹기~', '2025-01-06 17:31:22', NULL, '2025-01-06 17:31:22'),
	(40, 132, 2, 'F', 'qwer', '2025-01-06 17:31:29', NULL, '2025-01-06 17:31:29'),
	(41, 143, 1, 'H', '1ikeZZang', '2025-01-06 17:31:49', NULL, '2025-01-06 17:31:49'),
	(42, 143, 1, 'H', '1ikeZZang', '2025-01-06 17:31:52', NULL, '2025-01-06 17:31:52'),
	(43, 143, 1, 'H', '1ikeZZang', '2025-01-06 17:31:56', NULL, '2025-01-06 17:31:56'),
	(44, 143, 1, 'H', '1ikeZZang', '2025-01-06 17:32:01', NULL, '2025-01-06 17:32:01'),
	(45, 132, 2, 'H', 'qwer', '2025-01-06 17:32:21', NULL, '2025-01-06 17:32:21'),
	(46, 143, 1, 'H', '1ikeZZang', '2025-01-06 17:32:30', NULL, '2025-01-06 17:32:30'),
	(47, 143, 1, 'H', '1ikeZZang', '2025-01-06 17:32:36', NULL, '2025-01-06 17:32:36'),
	(48, 9, 15, 'H', '안혜빈', '2025-01-06 17:36:43', NULL, '2025-01-06 17:36:43');

-- 테이블 genesis.tbl_board 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_board` (
  `board_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '게시판 번호',
  `title` varchar(200) NOT NULL COMMENT '게시판 제목',
  `content` text DEFAULT NULL COMMENT '게시판 내용',
  `board_gbn_code` varchar(20) NOT NULL DEFAULT 'F' COMMENT '게시판구분(N: 자주묻는질문, F:문의)',
  `board_answer_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '답변여부(Y, N)',
  `view_cnt` bigint(20) NOT NULL DEFAULT 0 COMMENT '조회수',
  `delete_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부(N)미삭제(Y)삭제',
  `regist_id` varchar(20) DEFAULT NULL COMMENT '입력자',
  `regist_dt` datetime DEFAULT current_timestamp() COMMENT '입력일시',
  `modi_id` varchar(20) DEFAULT NULL COMMENT '수정자',
  `modi_dt` datetime DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`board_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='고객센터';

-- 테이블 데이터 genesis.tbl_board:~0 rows (대략적) 내보내기

-- 테이블 genesis.tbl_coment 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_coment` (
  `coment_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '댓글 번호',
  `board_no` bigint(20) NOT NULL COMMENT '게시판 번호',
  `coment_content` text NOT NULL COMMENT '댓글 내용',
  `del_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부',
  `regist_id` varchar(20) DEFAULT NULL COMMENT '입력자',
  `regist_dt` datetime DEFAULT current_timestamp() COMMENT '입력일시',
  `modi_id` varchar(20) DEFAULT NULL COMMENT '수정자',
  `modi_dt` datetime DEFAULT current_timestamp() COMMENT '수정일시',
  PRIMARY KEY (`coment_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='댓글 테이블';

-- 테이블 데이터 genesis.tbl_coment:~0 rows (대략적) 내보내기

-- 테이블 genesis.tbl_companys 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_companys` (
  `username` varchar(15) NOT NULL COMMENT '사용자 고유 ID',
  `password` varchar(255) NOT NULL COMMENT '비밀번호(해시값)',
  `name` varchar(255) NOT NULL COMMENT '기업 이름',
  `email` varchar(255) NOT NULL COMMENT '이메일',
  `phone` varchar(15) NOT NULL COMMENT '기업 번호',
  `content` text DEFAULT NULL COMMENT '기업소개',
  `birth` date NOT NULL COMMENT '생년월일',
  `address` varchar(255) NOT NULL COMMENT '주소',
  `address_detail` varchar(255) DEFAULT NULL COMMENT '상세주소',
  `zip_code` int(5) NOT NULL COMMENT '우편번호',
  `ceo_name` varchar(50) DEFAULT NULL COMMENT '대표자명',
  `homepage` varchar(255) DEFAULT NULL COMMENT '홈페이지주소',
  `employees` int(11) DEFAULT 0 COMMENT '사원수',
  `sale` int(11) DEFAULT 0 COMMENT '매출액',
  `role` varchar(100) NOT NULL DEFAULT 'ROLE_USER' COMMENT '권한',
  `delete_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부(N)미삭제(Y)삭제',
  `regist_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modi_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='기업 테이블';

-- 테이블 데이터 genesis.tbl_companys:~4 rows (대략적) 내보내기
INSERT INTO `tbl_companys` (`username`, `password`, `name`, `email`, `phone`, `content`, `birth`, `address`, `address_detail`, `zip_code`, `ceo_name`, `homepage`, `employees`, `sale`, `role`, `delete_yn`, `regist_dt`, `modi_dt`) VALUES
	('1111111111', '$2a$10$5dUaY4MA/fBIGPI7x8w2J.pIHgZHIBAaytyV1gDs8iuE9wk6oyqa2', '그린Company', 'green@naver.com', '01012345678', '여기는 그린 컴퍼니입니다.', '2025-01-06', '전남 영광군 영광읍 그린테크로 3', '1층', 57024, '박그린', NULL, 10, 8000, 'ROLE_COMPANY', 'N', '2025-01-06 03:03:03', '2025-01-06 03:03:03'),
	('1231231231', '$2a$10$RBfcq18nQjlqlFhuDpZSZecR2ibxaTrH.UcPLCJLB0UPeCDVvD2vq', '(대)관현왕국', 'hihi@naver.com', '01011112222', '오면 다 죽는거야', '2025-01-06', '강원특별자치도 원주시 지정면 간현로 10', '관현컴퍼니 101호', 26359, '노관현', 'hihi@naver.com', 2000, 100000000, 'ROLE_COMPANY', 'N', '2025-01-06 00:08:21', '2025-01-06 00:08:21'),
	('1234567890', '$2a$10$RgBUCtpxt/BzhfxtKyqmIO7Slwoj5OkO2FXC1ovwY7BYRpnX1ILSm', '(주)HelloWorld', 'helloworld@test.com', '07012345678', '코딩에 처음 발을 들였다면 Hello World를 많이 보셨을 겁니다. 처음 시작을 떠올렸다면 그 때 열정을 기억하실 겁니다.  우리 회사는 그 열정을 가진 사람들이 모여 코딩하는 곳입니다.', '2025-01-02', '부산 부산진구 중앙대로 981', '월드빌딩', 47209, 'Hellworld', NULL, 5, 8000, 'ROLE_COMPANY', 'N', '2025-01-05 08:17:36', '2025-01-05 08:17:36'),
	('혜빈컴퍼니', '$2a$10$Oix3YrBi5ebQXUOfIFV.4.zfIbDKZkzT30wXsw7wSTLD1I5qa5Ubi', '상인과노예들', 'gpqls@naver.com', '12345861234', '', '2025-01-05', '강원특별자치도 양양군 손양면 하양혈길 1-4', '1231호', 25042, '안혜빈', 'http://localhost:1111/join/company', 123456, 1111111111, 'ROLE_COMPANY', 'Y', '2025-01-05 08:11:33', '2025-01-06 00:40:34');

-- 테이블 genesis.tbl_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_file` (
  `file_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '파일번호',
  `file_gubn_code` varchar(50) DEFAULT NULL COMMENT '파일구분(EX) question_no)',
  `file_ref_no` varchar(50) DEFAULT NULL COMMENT '파일 영향받는 아이디(EX) 1)',
  `file_old_name` varchar(255) DEFAULT NULL COMMENT '파일 관리명(저장하는 파일명 시간으로 들어감 밀리세컨드까지)',
  `file_new_name` varchar(255) DEFAULT NULL COMMENT '파일명(불러올 파일명)',
  `file_ext` varchar(50) DEFAULT NULL COMMENT '파일 확장자',
  `file_size` int(11) DEFAULT NULL COMMENT '단위 MB',
  `file_url` varchar(255) DEFAULT NULL COMMENT '파일 위치',
  PRIMARY KEY (`file_no`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='파일테이블';

-- 테이블 데이터 genesis.tbl_file:~42 rows (대략적) 내보내기
INSERT INTO `tbl_file` (`file_no`, `file_gubn_code`, `file_ref_no`, `file_old_name`, `file_new_name`, `file_ext`, `file_size`, `file_url`) VALUES
	(1, 'profile_user', '안혜빈', '가트몬', '20250105170614457', '.PNG', 304255, 'http://localhost:1111/uploads/20241231103952648.jpg'),
	(2, 'profile_user', '안제연', '안제연', '20250105170658169', '.PNG', 113424, 'http://localhost:1111/uploads/다람쥐.JPG'),
	(3, 'profile_user', '한우성', '보노보노', '20250105170735079', '.PNG', 47746, 'http://localhost:1111/uploads/20241231104826735.jpg'),
	(4, 'profile_user', '노관현', '스폰지밥', '20250105170928001', '.PNG', 33275, 'http://localhost:1111/uploads/노관현.JPG'),
	(5, 'profile_company', '혜빈컴퍼니', '옥희야', '20250105171134007', '.jpg', 658576, 'http://localhost:1111/uploads/혜빈컴퍼니.JPG'),
	(6, 'company_detail', '혜빈컴퍼니', '옥희야', '20250105171134101', '.jpg', 658576, 'http://localhost:1111/uploads/30382ec44b0918ddcf304c4d2a03733e.png'),
	(7, 'profile_company', '1111111111', 'company1', '20250105171737040', '.jpg', 5739755, 'http://localhost:1111/uploads/20250105171737040.jpg'),
	(8, 'company_detail', '1111111111', 'company2', '20250105171737194', '.jpg', 1776355, 'http://localhost:1111/uploads/cec58e74ced77.jpg'),
	(9, 'application_no', '1', 'company1', '20250105174025742', '.jpg', 5739755, 'http://localhost:1111/uploads/30382ec44b0918ddcf304c4d2a03733e.png'),
	(10, 'application_no', '1', 'company2', '20250105174025941', '.jpg', 1776355, 'http://localhost:1111/uploads/cec58e74ced77.jpg'),
	(11, 'portfolio_no', '1', '옥희야', '20250105175133855', '.jpg', 658576, 'http://localhost:1111/uploads/20250105175133855.jpg'),
	(12, 'portfolio_no', '3', 'KakaoTalk_20210717_110110056_03', '20250105180213747', '.jpg', 3034661, 'http://localhost:1111/uploads/20250105180213747.jpg'),
	(13, 'portfolio_no', '4', '레이드_2', '20250105180503004', '.png', 3660739, 'http://localhost:1111/uploads/20250105180503004.png'),
	(14, 'portfolio_no', '6', '1,2층 S등급 클리어', '20250105180731187', '.pptx', 383580, 'http://localhost:1111/uploads/20250105180731187.pptx'),
	(15, 'application_no', '4', 'company4', '20250105203152083', '.jpg', 688309, 'http://localhost:1111/uploads/card_944_3.jpg'),
	(16, 'application_no', '4', 'company5', '20250105203152223', '.jpg', 2565253, 'http://localhost:1111/uploads/images.png'),
	(17, 'profile_company', '1231231231', '20241230094808802.jpg', '20250106090821293', '.jpg', 3130, 'http://localhost:1111/uploads/20250106090821293.jpg'),
	(18, 'company_detail', '1111111111', 'company2', '121231', '.jpg', 12, 'http://localhost:1111/uploads/card_944_3.jpg'),
	(19, 'company_detail', '1231231231', 'company2', '12315', '.png', 123486, 'http://localhost:1111/uploads/images.png'),
	(20, 'application_no', '2', 'company2', '123456', '.png', 12345, 'http://localhost:1111/uploads/d6176e45-57e7-4063-b4d8-124674801128.png'),
	(21, 'application_no', '2', '123', '123', '.jpg', 123456, 'http://localhost:1111/uploads/m__db71ffd252b00651c9c49428500c7acf214531612214__m.jpg'),
	(22, 'application_no', '2', '123', '123', '.jpg', 12345, 'http://localhost:1111/uploads/17c234905995208e4b2e5214e021c3c1.jpg'),
	(24, 'profile_user', 'saya1013', 'william-hook-9e9PD9blAto-unsplash', '20250106115535608', '.jpg', 3248880, 'http://localhost:1111/uploads/20250106115535608.jpg'),
	(25, 'profile_company', '1234567890', '3d-view-puzzle-pieces', '20250106120304089', '.jpg', 2359516, 'http://localhost:1111/uploads/20250106120304089.jpg'),
	(26, 'company_detail', '1231231231', 'christina-wocintechchat-com-NDoVgcS_lZM-unsplash', '20250106120304180', '.jpg', 3682962, 'http://localhost:1111/uploads/20250106120304180.jpg'),
	(27, 'application_no', '7', 'company3', '20250106120602674', '.jpg', 1576859, 'http://localhost:1111/uploads/20250106120602674.jpg'),
	(28, 'application_no', '7', 'company4', '20250106120602750', '.jpg', 5739755, 'http://localhost:1111/uploads/20250106120602750.jpg'),
	(29, 'application_no', '7', 'company5', '20250106120602830', '.jpg', 1562191, 'http://localhost:1111/uploads/20250106120602830.jpg'),
	(30, 'application_no', '12', 'company1', '20250106142723490', '.jpg', 2565253, 'http://localhost:1111/uploads/20250106142723490.jpg'),
	(31, 'application_no', '12', 'company2', '20250106142723573', '.jpg', 688309, 'http://localhost:1111/uploads/20250106142723573.jpg'),
	(32, 'application_no', '12', 'company3', '20250106142723651', '.jpg', 1576859, 'http://localhost:1111/uploads/20250106142723651.jpg'),
	(33, 'profile_user', 'hgd', 'hgd', '20250106144727941', '.png', 505344, 'http://localhost:1111/uploads/20250106144727941.png'),
	(34, 'profile_user', '혜빈', 'christina-wocintechchat-com-YKWLJPpat4o-unsplash', '20250106152722190', '.jpg', 3294744, 'http://localhost:1111/uploads/20250106152722190.jpg'),
	(35, 'application_no', '13', 'company2', '20250106155831774', '.jpg', 688309, 'http://localhost:1111/uploads/20250106155831774.jpg'),
	(36, 'application_no', '13', 'company3', '20250106155831845', '.jpg', 1576859, 'http://localhost:1111/uploads/20250106155831845.jpg'),
	(37, 'application_no', '14', 'company3', '20250106160739881', '.jpg', 1576859, 'http://localhost:1111/uploads/20250106160739881.jpg'),
	(38, 'profile_user', 'qwer', 'cat', '20250106172634121', '.jpg', 4463, 'http://localhost:1111/uploads/20250106172634121.jpg'),
	(39, 'profile_user', '콜라에밥말아먹기~', 'img_default_gonggo', '20250106172637435', '.png', 1477569, 'http://localhost:1111/uploads/20250106172637435.png'),
	(40, 'profile_user', 'dongha', 'cat', '20250106172657724', '.jpg', 9748, 'http://localhost:1111/uploads/20250106172657724.jpg'),
	(41, 'application_no', '15', '123', '20250106172757602', '.jpg', 101713, 'http://localhost:1111/uploads/20250106172757602.jpg'),
	(42, 'profile_user', '1ikeZZang', '업무분장최종 (1)', '20250106172849656', '.png', 41128, 'http://localhost:1111/uploads/20250106172849656.png'),
	(43, 'portfolio_no', '7', '1조 일정표 및 업무분장표', '20250106173118415', '.pdf', 108686, 'http://localhost:1111/uploads/20250106173118415.pdf');

-- 테이블 genesis.tbl_gubn 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_gubn` (
  `group_code` varchar(255) NOT NULL,
  `gubn_code` varchar(255) DEFAULT NULL,
  `gubn_name` varchar(255) NOT NULL,
  PRIMARY KEY (`group_code`,`gubn_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='공통코드';

-- 테이블 데이터 genesis.tbl_gubn:~144 rows (대략적) 내보내기
INSERT INTO `tbl_gubn` (`group_code`, `gubn_code`, `gubn_name`) VALUES
	('application_code', 'C', '마감'),
	('application_code', 'S', '모집일시중지'),
	('application_code', 'O', '모집중'),
	('apply_status_gbn_code', 'F', '불합격'),
	('apply_status_gbn_code', 'H', '진행중'),
	('apply_status_gbn_code', 'P', '합격'),
	('app_code', 'AOS', 'Android'),
	('app_code', 'FL', 'Flutter'),
	('app_code', 'iOS', 'iOS'),
	('back_code', 'AS', 'ASP.NET'),
	('back_code', 'C', 'C++'),
	('back_code', 'D', 'Django'),
	('back_code', 'E', 'Express.js'),
	('back_code', 'F', 'Flask'),
	('back_code', 'G', 'Go'),
	('back_code', 'J', 'Java'),
	('back_code', 'KT', 'Kotlin'),
	('back_code', 'P', 'PHP'),
	('back_code', 'PY', 'Python'),
	('back_code', 'RB', 'Ruby'),
	('board_gbn_code', 'F', '문의'),
	('board_gbn_code', 'N', '자주묻는질문'),
	('career_code', 'G', '경력'),
	('career_code', 'S', '신입'),
	('career_code', 'SG', '신입/경력'),
	('certificate_code', 'AI', 'AI 개발자'),
	('certificate_code', '임베디드 시스템 개발자', 'ESD'),
	('certificate_code', 'ID', 'iOS 개발자'),
	('certificate_code', 'ME', 'MySQL 전문가'),
	('certificate_code', 'SD', 'SQL 개발자'),
	('certificate_code', 'SE', 'SQL 전문가'),
	('certificate_code', 'GD', '게임 개발자 '),
	('certificate_code', 'NA', '네트워크 관리자'),
	('certificate_code', 'DBA', '데이터베이스 관리자'),
	('certificate_code', 'BE', '백엔드 개발자'),
	('certificate_code', 'BDA', '빅데이터 분석 전문가'),
	('certificate_code', 'SD', '소프트웨어 개발자'),
	('certificate_code', 'SA', '시스템관리자'),
	('certificate_code', 'AD', '안드로이드 개발자'),
	('certificate_code', 'WD', '웹개발자'),
	('certificate_code', 'AD', '응용프로그램 개발자'),
	('certificate_code', 'IS', '정보보안기사'),
	('certificate_code', 'IP', '정보처리기사'),
	('certificate_code', 'CE', '클라우드 전문가'),
	('certificate_code', 'FS', '풀스택 개발자'),
	('certificate_code', 'PLE', '프로그래밍 언어 전문가'),
	('certificate_code', 'FE', '프론트엔드 개발자'),
	('certificate_pass_code', 'S', '실기'),
	('certificate_pass_code', 'P', '필기'),
	('database_code', 'CD', 'Cassandra'),
	('database_code', 'DY', 'DynamoDB'),
	('database_code', 'ES', 'Elasticsearch'),
	('database_code', 'FM', 'Firebase'),
	('database_code', 'MG', 'MongoDB'),
	('database_code', 'MS', 'MySQL'),
	('database_code', 'OR', 'Oracle'),
	('database_code', 'PS', 'PostgreSQL'),
	('database_code', 'RD', 'Redis'),
	('database_code', 'SS', 'SQL Server'),
	('devops_code', 'AC', 'Ansible'),
	('devops_code', 'CI', 'CircleCI'),
	('devops_code', 'GH', 'GitHub Actions'),
	('devops_code', 'GL', 'GitLab CI/CD'),
	('devops_code', 'GF', 'Grafana'),
	('devops_code', 'JK', 'Jenkins'),
	('devops_code', 'K', 'Kubernetes'),
	('devops_code', 'PM', 'Prometheus'),
	('devops_code', 'TF', 'Terraform'),
	('education_code', 'H', '고등학교졸업'),
	('education_code', 'U3', '대학(2,3)년'),
	('education_code', 'U4', '대학교(4년)'),
	('education_code', 'B', '대학원(박사)'),
	('education_code', 'S', '대학원(석사)'),
	('education_gbn_code', 'H', '고등학교졸업'),
	('education_gbn_code', 'U3', '대학(2,3)년'),
	('education_gbn_code', 'U4', '대학교(4년)'),
	('education_gbn_code', 'B', '대학원(박사)'),
	('education_gbn_code', 'S', '대학원(석사)'),
	('employment_code', 'A', '계약/정규직'),
	('employment_code', 'C', '계약직'),
	('employment_code', 'F', '정규직'),
	('front_code', 'A', 'Angular'),
	('front_code', 'C', 'CSS'),
	('front_code', 'H', 'HTML'),
	('front_code', 'JS', 'JavaScript'),
	('front_code', 'NX', 'Next.js'),
	('front_code', 'NG', 'Nuxt.js'),
	('front_code', 'R', 'React'),
	('front_code', 'T', 'TypeScript'),
	('front_code', 'V', 'Vue'),
	('job_code', 'DO', 'DevOps 엔지니어'),
	('job_code', 'PM', 'IT 프로젝트 관리자'),
	('job_code', 'QA', 'QA 엔지니어'),
	('job_code', 'UX', 'UI/UX 디자이너'),
	('job_code', 'GD', '게임 개발자'),
	('job_code', 'TS', '기술 지원 엔지니어'),
	('job_code', 'NE', '네트워크 엔지니어'),
	('job_code', 'DS', '데이터 과학자'),
	('job_code', 'DE', '데이터 엔지니어'),
	('job_code', 'DBA', '데이터베이스 관리자'),
	('job_code', 'ML', '머신러닝 엔지니어'),
	('job_code', 'MA', '모바일 앱 개발자'),
	('job_code', 'BE', '백엔드 개발자'),
	('job_code', 'SE', '보안 엔지니어'),
	('job_code', 'SC', '보안 컨설턴트'),
	('job_code', 'SD', '소프트웨어 개발자'),
	('job_code', 'SA', '시스템 관리자'),
	('job_code', 'AI', '인공지능 연구원'),
	('job_code', 'CE', '클라우드 엔지니어'),
	('job_code', 'FE', '프론트엔드 개발자'),
	('position_code', 'D', '대리'),
	('position_code', 'S', '사원'),
	('position_code', 'J', '주임'),
	('position_code', 'T', '팀장'),
	('procedure_code', '1', '1차 면접 합격'),
	('procedure_code', '2', '2차 면접 합격'),
	('procedure_code', '0', '서류 합격'),
	('resume_education_gbn_code', 'H', '고등학교졸업'),
	('resume_education_gbn_code', 'U3', '대학(2,3)년'),
	('resume_education_gbn_code', 'U4', '대학교(4년)'),
	('resume_education_gbn_code', 'B', '대학원(박사)'),
	('resume_education_gbn_code', 'S', '대학원(석사)'),
	('server_code', 'AWS', 'AWS'),
	('server_code', 'CD', 'Cloud'),
	('server_code', 'D', 'Docker'),
	('server_code', 'GT', 'Git'),
	('server_code', 'JK', 'Jenkins'),
	('server_code', 'L', 'Linux'),
	('stack_code', 'app_code', 'App'),
	('stack_code', 'back_code', 'Back-End'),
	('stack_code', 'database_code', 'Database'),
	('stack_code', 'devops_code', 'DevOps'),
	('stack_code', 'front_code', 'Front-End'),
	('stack_code', 'server_code', 'Server'),
	('stack_code', 'testing_code', 'Testing'),
	('testing_code', 'CT', 'Cypress'),
	('testing_code', 'JM', 'JMeter'),
	('testing_code', 'JU', 'JUnit'),
	('testing_code', 'MC', 'Mockito'),
	('testing_code', 'PD', 'Pact.io'),
	('testing_code', 'PL', 'Playwright'),
	('testing_code', 'PO', 'Postman'),
	('testing_code', 'SE', 'Selenium'),
	('testing_code', 'TM', 'TestNG');

-- 테이블 genesis.tbl_likes 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_likes` (
  `like_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '북마크, 스크랩 번호',
  `username` varchar(15) NOT NULL COMMENT '유저아이디',
  `like_code` char(1) NOT NULL COMMENT '구분 (B: 북마크, S: 스크랩)',
  `like_id` varchar(255) NOT NULL COMMENT '채용공고번호,회사아이디,이력서번호',
  PRIMARY KEY (`like_no`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='북마크,스크랩 테이블';

-- 테이블 데이터 genesis.tbl_likes:~39 rows (대략적) 내보내기
INSERT INTO `tbl_likes` (`like_no`, `username`, `like_code`, `like_id`) VALUES
	(2, '한우성', 'S', '1'),
	(5, '노관현', 'G', '1'),
	(6, '한우성', 'G', '1'),
	(7, '안혜빈', 'G', '1'),
	(8, '안제연', 'G', '1'),
	(129, '혜빈컴퍼니', 'S', '11'),
	(158, '안혜빈', 'S', '2'),
	(159, '안혜빈', 'S', '1'),
	(160, '안혜빈', 'G', '혜빈컴퍼니'),
	(161, '안혜빈', 'G', '1111111111'),
	(165, '안제연', 'S', '2'),
	(169, 'saya1013', 'S', '3'),
	(171, 'saya1013', 'G', '1231231231'),
	(172, 'saya1013', 'S', '1'),
	(173, 'saya1013', 'G', '혜빈컴퍼니'),
	(174, 'saya1013', 'S', '2'),
	(175, '1234567890', 'S', '101'),
	(176, '1234567890', 'S', '13'),
	(177, '안혜빈', 'S', '4'),
	(178, '안제연', 'S', '3'),
	(179, '안제연', 'S', '1'),
	(180, '안제연', 'S', '6'),
	(181, '안제연', 'S', '14'),
	(182, '안제연', 'G', '1111111111'),
	(184, '혜빈컴퍼니', 'S', '9'),
	(185, '안제연', 'S', '13'),
	(186, 'qwer', 'S', '1'),
	(187, '1ikeJJang', 'S', '2'),
	(189, 'user01', 'S', '2'),
	(190, '혜빈컴퍼니', 'S', '101'),
	(191, 'qwer', 'S', '3'),
	(192, 'qwer', 'S', '2'),
	(193, 'qwer', 'S', '5'),
	(194, '1231231231', 'S', '12'),
	(195, '1231231231', 'S', '13'),
	(196, 'dongha', 'S', '2'),
	(197, '혜빈컴퍼니', 'S', '140'),
	(198, '1231231231', 'S', '141'),
	(199, '1ikeZZang', 'G', '1234567890');

-- 테이블 genesis.tbl_offer 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_offer` (
  `offer_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '포지션제안번호',
  `application_no` int(11) NOT NULL DEFAULT 0 COMMENT '공고번호',
  `resume_no` int(11) NOT NULL DEFAULT 0 COMMENT '이력서번호',
  `username` varchar(50) NOT NULL DEFAULT 'current_timestamp()' COMMENT '회사ID',
  `regist_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modi_dt` datetime DEFAULT NULL COMMENT '수정일',
  PRIMARY KEY (`offer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='포지션 제안 테이블';

-- 테이블 데이터 genesis.tbl_offer:~0 rows (대략적) 내보내기

-- 테이블 genesis.tbl_ratings 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_ratings` (
  `company_name` varchar(15) NOT NULL COMMENT '기업 ID',
  `username` varchar(15) NOT NULL COMMENT '사용자  ID',
  `jr_star` float NOT NULL DEFAULT 0 COMMENT '평점 (0~5)',
  `regist_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '입력일시',
  PRIMARY KEY (`company_name`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='기업평점 테이블';

-- 테이블 데이터 genesis.tbl_ratings:~3 rows (대략적) 내보내기
INSERT INTO `tbl_ratings` (`company_name`, `username`, `jr_star`, `regist_dt`) VALUES
	('혜빈컴퍼니', 'saya1013', 5, '2025-01-06 11:58:16'),
	('혜빈컴퍼니', '안혜빈', 5, '2025-01-06 10:59:52'),
	('혜빈컴퍼니', '한우성', 3, '2025-01-05 18:26:02');

-- 테이블 genesis.tbl_resumes 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_resumes` (
  `resume_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 고유 넘버',
  `username` varchar(15) NOT NULL COMMENT '사용자 고유 ID',
  `resume_title` varchar(255) NOT NULL COMMENT '이력서 제목',
  `resume_my_title` varchar(255) DEFAULT NULL COMMENT '자기소개서 제목',
  `resume_my_content` text DEFAULT NULL COMMENT '자기소개서 내용',
  `resume_pubilce_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '공개여부(Y:공개 , N:미공개)',
  `delete_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부(N)미삭제(Y)삭제',
  `regist_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modi_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일',
  `salary` varchar(50) NOT NULL DEFAULT '회사내규에 따름' COMMENT '요구연봉',
  `career` varchar(50) NOT NULL DEFAULT 'S',
  `savedraft` tinyint(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`resume_no`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 테이블';

-- 테이블 데이터 genesis.tbl_resumes:~20 rows (대략적) 내보내기
INSERT INTO `tbl_resumes` (`resume_no`, `username`, `resume_title`, `resume_my_title`, `resume_my_content`, `resume_pubilce_yn`, `delete_yn`, `regist_dt`, `modi_dt`, `salary`, `career`, `savedraft`) VALUES
	(9, '안혜빈', '저는 일을 잘합니다!', '안녕하세요 저는 일을 잘해요', '저 뽑아주세요', 'Y', 'N', '2025-01-05 17:49:54', '2025-01-05 17:49:54', '회사내규에 따름', 'S', 0),
	(11, '안제연', '저 착해요', '뽑아주세요!', '저 잘해요!', 'Y', 'N', '2025-01-05 17:59:05', '2025-01-05 17:59:05', '2,600~3,200만원', 'S', 0),
	(12, '노관현', '저는 행복합니다', '저는 활발합니다.', '굿!', 'Y', 'N', '2025-01-05 18:02:57', '2025-01-05 18:02:57', '1,800만원 이하', 'S', 0),
	(13, '한우성', '돈 많이 주세요.', '돈 많이 벌고 싶어요', '많이 주세요', 'Y', 'N', '2025-01-05 18:05:34', '2025-01-05 18:05:34', '8,000~9,000만원', 'G', 0),
	(101, 'saya1013', '열정 가득한 웹개발자입니다.', '', '', 'Y', 'N', '2025-01-06 11:52:04', '2025-01-06 11:52:04', '회사내규에 따름', 'S', 0),
	(113, '노관현', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 13:30:37', '2025-01-06 13:30:37', '회사내규에 따름', 'S', 1),
	(126, 'hgd', '홍익인간을 실현하는 개발자 홍길동입니다.', '', '', 'N', 'N', '2025-01-06 14:48:06', '2025-01-06 14:48:06', '3,200~3,600만원', 'S', 0),
	(127, 'hgd', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 14:52:30', '2025-01-06 14:52:30', '회사내규에 따름', 'S', 1),
	(130, '한우성', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 16:15:51', '2025-01-06 16:15:51', '회사내규에 따름', 'S', 1),
	(132, 'qwer', '잘 부탁드립니다.', '잘 부탁드립니다', '안녕하세요 합격안시키면 죽입니다.', 'Y', 'N', '2025-01-06 17:26:55', '2025-01-06 17:26:55', '3,200~3,600만원', 'G', 0),
	(139, '1ikeJJang', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:27:57', '2025-01-06 17:27:57', '회사내규에 따름', 'S', 1),
	(140, 'dongha', '돈줘요', '', '', 'Y', 'N', '2025-01-06 17:28:17', '2025-01-06 17:28:17', '8,000~9,000만원', 'G', 0),
	(141, '콜라에밥말아먹기~', '32131', '', '', 'Y', 'N', '2025-01-06 17:28:32', '2025-01-06 17:28:32', '2,600~3,200만원', 'S', 0),
	(143, '1ikeZZang', '뽑아주세요제발 윤서헤어살롱 사장입니다', '최윤서입니다.', '꼭 뽑아주세요 ㅠ', 'Y', 'N', '2025-01-06 17:28:55', '2025-01-06 17:28:55', '8,000~9,000만원', 'G', 0),
	(144, 'saya1013', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:29:01', '2025-01-06 17:29:01', '회사내규에 따름', 'S', 1),
	(146, '안제연', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:29:06', '2025-01-06 17:29:06', '회사내규에 따름', 'S', 1),
	(151, '안혜빈', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:30:36', '2025-01-06 17:30:36', '회사내규에 따름', 'S', 1),
	(153, 'dongha', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:30:56', '2025-01-06 17:30:56', '회사내규에 따름', 'S', 1),
	(157, '1ikeZZang', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:31:39', '2025-01-06 17:31:39', '회사내규에 따름', 'S', 1),
	(158, '콜라에밥말아먹기~', '임시저장입니다.', NULL, NULL, 'N', 'N', '2025-01-06 17:31:41', '2025-01-06 17:31:41', '회사내규에 따름', 'S', 1);

-- 테이블 genesis.tbl_resume_career 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_resume_career` (
  `resume_career_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 경력 번호',
  `resume_no` bigint(20) NOT NULL COMMENT '이력서 고유 넘버',
  `resume_career_company_name` varchar(255) NOT NULL COMMENT '회사명',
  `resume_career_join_dt` varchar(50) NOT NULL DEFAULT '' COMMENT '입사연월',
  `resume_career_out_dt` varchar(50) NOT NULL DEFAULT '' COMMENT '퇴사연월',
  `resume_career_department_name` varchar(50) DEFAULT NULL COMMENT '부서명',
  `resume_career_position` varchar(20) DEFAULT NULL COMMENT '직책',
  `resume_career_duties` text DEFAULT NULL COMMENT '담당업무',
  `resume_career_job` varchar(50) NOT NULL COMMENT '직무 (공통코드)',
  PRIMARY KEY (`resume_career_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 경력 테이블';

-- 테이블 데이터 genesis.tbl_resume_career:~9 rows (대략적) 내보내기
INSERT INTO `tbl_resume_career` (`resume_career_no`, `resume_no`, `resume_career_company_name`, `resume_career_join_dt`, `resume_career_out_dt`, `resume_career_department_name`, `resume_career_position`, `resume_career_duties`, `resume_career_job`) VALUES
	(2, 9, '관현햄공화국', '2024-01', '2025-12', '관현팀', '팀장', '저는 일을 잘합니다. 악명 높은 관현햄공화국에서 관현팀 팀장을 맡은 이력이 있습니다.\r\n\r\n비행기를 타고 아프리카 사막을 여행하고 있던 조종사가 비행기 고장으로 사막에 불시착을 하게 된다. 아무도 없을 것 같던 사막에서 생사를 고민하던 중 우연히 한 소년을 만나게 된다. 조종사는 이 소년과 대화하던 중 그가 다른 별에서 왔다는 것을 알게 되었다. 어린왕자는 B612라는 작은 혹성에서 살았는데 우연히 만난 장미에게 사랑을 느끼지만 장미는 어린왕자에게 상처만 줄 뿐이었다. 그때 어린왕자를 찾아온 사업가를 통해 다른 별의 이야기를 전해 듣고 더 큰 세상을 알면 장미의 행동을 이해할 수 있으리란 생각을 하며 여행을 결심한다. \r\n\r\n어린왕자는 여러 별을 여행하며 사람들은 만나지만 모두 이해할 수 없는 생각과 행동을 할 뿐이라고 생각한다. 자신의 권위가 무엇보다 중요했던 어느 왕, 자기를 칭찬하는 말 이외에는 들으려 하지 않는 허영심 많은 사람이 살고 있는 별. 술 마시는 것이 부끄럽지만 그것을 잊기 위해 다시 술을 마신다는 술꾼이 사는 별. 하늘에 보이는 5억 개의 별이 모두 자기 것이라 주장하는 과대망상증 상인이 있는 별. 그리고 별이 작아서 그럴 필요가 없는데도 계속 1분마다 불을 켜고 끄는 이상한 사람이 사는 별.\r\n\r\n지리학자지만 한 번도 산과 강을 본 적이 없다는 지리학자의 별을 방문하게 된다. \r\n\r\n그리고 지구에서 만난 수많은 꽃과 여우!! 이를 통해 세상에는 같은 장미가 있지만 어린 왕자가 아끼며 돌보던 장미는 이 세상이 하나밖에 없음을 여우를 통해 깨닫고 자기의 별로 돌아갈 것을 결심한다. \r\n\r\n​비행기 수리를 끝낸 조종사는 자신과 함께 가자고 권하지만 어린왕자는 가시 4개로 자신을 보호하려는 꽃이 너무 안쓰러워서 그를 돌봐주러 가야겠다고 말하며 뱀의 독을 이용하여 지구를 떠나게 된다. 죽게 된다. 시간이 흘러 6년 후 하늘의 수많은 별들을 볼 때마다 어린왕자가 어딘가에 살고 있으리라는 희망을 품는다. ', 'QA'),
	(3, 11, '관현햄회사', '2025-01', '2025-08', '관현팀', '과장', '저는 과장입니다.\r\n\r\n입력이 있으면 출력이 있어야 한다. 그래야 ‘내 공부’가 된다. 대학수학능력시험이 끝난 뒤 우등생들의 ‘노트 정리법’이 괜히 관심을 모으는 게 아니다. 공부하거나 읽은 뒤 ‘내 손으로 써봐야’ 머리에 남고, 그것도 ‘제대로 써야’ 공부머리가 단단해진다.\r\n\r\n독서교육에 관심 있는 교사와 학습법 전문가들이 요즘 입을 모아 하는 이야기가 있다. ‘아이들에게 너무 읽기?쓰기?암기교육 안 시킨다’이다. 창의 교육, 4차산업혁명 아무리 외쳐봤자 기본적으로 지식을 읽고 암기하고 써보는 ‘입력’(input) 과정이 공부의 기본이라는 설명이다. ‘검색창에 치면 어차피 다 나오는데 뭐하러 외우냐’라는 건 ‘쓰기와 암기’를 오해하는 말이다.\r\n\r\n김민아 병점초등학교 교사는 “공교육 현장에서도 점점 ‘독후감 쓰기’ 등을 대수롭지 않게 여기는 흐름이 있다. 그런데 책 읽기만큼 중요한 게 바로 독후 활동”이라고 강조했다. 책 읽은 뒤 줄거리를 다시 떠올리고, 인상 깊었던 장면과 느낌을 떠올리는 것. 독서 후 ‘입력과 출력’을 풍부하게 만들어주는 과정이 바로 ‘독후감 쓰기’다. 문구점에서 얇은 공책만 한 권 마련하면 준비는 끝난다.\r\n\r\n독후감 쓰기의 핵심은 ‘줄거리 요약’과 ‘나의 생각 쓰기’다. 아이가 ‘어떻게 요약해요?’라고 묻는다면 ‘육하원칙’을 설명해주자. ‘누가, 언제, 어디서, 무엇을, 어떻게, 왜’ 했는지 하나하나 대입해가며 한 문장, 두 문장 쓰다보면 어느덧 아이 스스로 쓴 한 편의 글이 완성된다. 부모와 아이가 함께 해볼 수 있는 독후 활동 질문 내용을 소개한다.', 'SE'),
	(4, 11, '우성회사', '2024-01', '2024-02', '우성팀', '팀장', '팀장이었습니다.\r\n\r\n① 이 책을 어떻게 읽게 되었습니까? 인상적인 부분은 어디인가요? 그 이유는?\r\n② 등장인물 가운데 친구 삼고 싶은 사람이 있었나요? 또는 좋았던 장면은 무엇입니까? 그 이유는? (싫은 등장인물이나 장면, 그 이유도 써보세요.)\r\n③ 책을 읽은 뒤 생각난 다른 책 혹은 뉴스, 티브이(TV) 프로그램이 있나요?\r\n④ 내가 등장인물이었다면 어떻게 했을까요?\r\n⑤ 작가는 어떤 사람인가요? 이 이야기의 시대적?장소적 배경은?\r\n⑥ 이 책을 읽고 새로 배운 것과 느낀 점을 써보세요.\r\n⑦ 책을 읽으면서 이해가 가지 않았던 부분을 써보세요.', 'PM'),
	(5, 12, '관현컴퍼니', '2025-01', '2025-01', '관현팀', '사원', '책벌레한테는 좋은 숙제지만 책을 별로 좋아하지 않거나 글을 쓰기 싫어하는 사람한테는 수면제를 먹을 기회를 제공해 주는 숙제나 다름없다. 또 책벌레도 책벌레 나름이라, 책은 \'가슴 속에 담아 두는 것\'이라고 생각하는 부류, 글 쓰는 재주가 별로 없는 부류, 예시나 양식이 정해져 있어도 어떻게 써야 할지 감을 잡지 못하는 부류들 역시 독후감 쓰는 것을 매우 골치 아파하고 아무 의미가 없는 일이라고 생각한다. 애초에 독서평론가들이 써놓은 책 뒷면 같은 곳을 봐도 거의 한줄평이지 이런식으로는 안 쓴다.', 'QA'),
	(6, 13, '혜빈컴퍼니', '2025-03', '2025-12', '혜빈팀', '팀장', '저는 팀장입니다.\r\n\r\n독서교육종합시스템으로 쓰게하는 학교가 많아졌는데, 중간중간에 임시저장을 안하면 다 날아갔을 때 답이 없다. 게다가 붙여넣기도 안된다.[3]\r\n\r\n수시의 학생부 종합 전형으로 가는 학생들은 내신/봉사/세특/독서 등등 여러가지로 스펙을 마련해야하므로 어쩔 수 없이 쓰게 된다. 물론 정시로 가거나 내신만 보는 교과 전형으로 간다면 필요 없어지지만 중학생때까지 독서따위 안 했던 사람이더라도 수시로 대학 갈 고등학생들은 여기서 반강제로 독서와 독후감을 하게 된다.\r\n\r\n2020년대 들어 일부 시민단체 등에서 아동 학대, 애들 손 아프다, 자기 자식에게 수치심를 줬다 등의 이유로 교사가 신고 당하는 경우가 많아 안하는 추세이다. 이것이 독해력 및 문해력 저하 같은 문제의 원인 중 하나로 연결되기도 한다.\r\n\r\n학교를 졸업하면 해방인가? 군대에서도 기다리고 있다! 물론 강제로 시키는 건 아니라서 안쓰면 그만인데, 몇 권 이상 쓰면 포상휴가를 주는 부대가 있다. 보통 15~20권 정도에 하루 꼴로 잡는다. 자필이라면 안쓰겠지만, 컴퓨터로 써서 인트라넷에 올리면 되기에[4] 공군 모 비행단의 경우 하루에만 수십편의 감상문이 업로드 되고 있다. 단, 한달에 몇편까지만 인정한다는 상한 제한이 있기에 책벌레 병사들은 한번에 왕창 써놓고 매달 1일 상한선만큼 복붙해 올리는 기이한 경우도 볼 수 있다. 그리고 비축해 둔 독후감이 다 떨어져 갈 즈음에 또 한번에 왕창 써놓는다. 더더욱 꼼수를 부리는 경우, 개미나 해리 포터 시리즈처럼 시리즈물로 된 걸 한권 한권 따로 올리는(...) 얌체족도 존재한다.', 'CE'),
	(7, 13, '관현컴퍼니', '2025-03', '2025-12', '관현팀', '과장', '과장 진급했습니다.\r\n\r\n먼저, \'내가 왜 이 책을 읽게 되었는지\' 는 굳이 쓰지 않아도 무방하다. 터놓고 말해서 숙제를 내 주어서 읽었는데 \'왜 읽게 되었는지\' 를 굳이 써야 할까? 이 대신 책의 주제를 파악한 다음, \'나는 평소에 □□에 대해 어떻게 생각해 왔다\' 하는 식으로 시작하는 것이 좋다. 그리고 책을 읽으면서 □□에 대한 생각이 어떻게 바뀌었다거나, 더욱 확실해졌다는 식으로 논지를 전개하면 쓰기가 수월해진다.\r\n\r\n그리고 만약 진짜로 독후감을 써서 상을 받고 싶다면, 줄거리를 적는 것은 미친 짓이다. 특히 어느 지정된 책 1권일 경우 더더욱. 줄거리는 대충 숙제로 적는 독후감에 글자 채우기 용이나 자유롭게 아무 책이나 독후감을 쓸 때 간단히 적는 거지 대회에서 줄거리를 쓰고 앉아있는 건 그냥 기권이라고 보면 된다. 독후감의 요지는 독자의 감상이지, 얼마나 내용을 잘 요약하는지가 아니기 때문이다.\r\n\r\n또 주제가 비교적 명확한 수필이나 평론이 아니라 소설을 읽은 경우라면, 책의 내용에서 거창한 교훈이나 감상을 굳이 이끌어낼 필요는 없다. 대개 \'참 재미있었다\' 같은 표현이 나오는 것은 책을 그냥 아무 생각없이 \'재미있게\' 읽었기 때문이다. 재미있었다면 어떤 부분이 재미있었는지, 더 재미있으려면 어땠으면 좋았을 것 같다는 평가도 좋다. 책의 특정 부분(배경 설정이나 인물 설정), 혹은 줄거리 상의 특정 사건에서 현실로 이어 나가 자신만의 생각을 드러나는 글을 쓰면 평가가 매우 좋아진다. 예를들어 올더스 헉슬리의 멋진 신세계의 독후감을 쓴다고 하면 멋진 신세계와 1984의 세계관에 어떤 차이가 있다고 보는지, 야만인은 정말로 행복할 것인지, 신세계가 사실은 디스토피아가 아닐 수도 있다던지[5], 사회 시스템은 도덕적 이상을 추구해야 하는지, 사회 구성원에게 만족만 줄 수 있다면 괜찮은지 등의 논점을 전개할 수 있겠다.', 'BE'),
	(8, 140, '1', '0001-01', '0001-01', '1', '1', '1', 'DO'),
	(9, 141, '32142142', '142142-12', '213421-12', '3213', '21321', '321321', 'ML'),
	(10, 143, '그린', '2025-01', '2025-01', 'ppt작성부', '부장', 'ppt만들었습니다', 'PM');

-- 테이블 genesis.tbl_resume_certificates 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_resume_certificates` (
  `certificate_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 자격증 번호',
  `resume_no` bigint(20) NOT NULL COMMENT '이력서 고유 넘버',
  `certificate_dt` varchar(50) NOT NULL DEFAULT '' COMMENT '자격증 취득일',
  `certificate_name` varchar(50) NOT NULL COMMENT '자격증 명',
  `certificate_place` varchar(50) NOT NULL COMMENT '자격증 발급기관',
  `certificate_gbn_cd` char(50) NOT NULL DEFAULT '' COMMENT '합격여부(P: 필기, S:실기)',
  PRIMARY KEY (`certificate_no`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 자격증 테이블';

-- 테이블 데이터 genesis.tbl_resume_certificates:~11 rows (대략적) 내보내기
INSERT INTO `tbl_resume_certificates` (`certificate_no`, `resume_no`, `certificate_dt`, `certificate_name`, `certificate_place`, `certificate_gbn_cd`) VALUES
	(4, 9, '2024-01', 'MySQL 전문가', '관현공화국', 'P'),
	(5, 9, '2024-01', '정보처리기사', '관현공화국', 'S'),
	(6, 9, '2024-01', '정보보안기사', '관현공화국', 'S'),
	(7, 11, '2025-01', '정보보안기사', '관현공화국', 'S'),
	(8, 11, '2025-01', '정보처리기사', '관현공화국', 'S'),
	(9, 11, '2025-01', 'AI 개발자', '관현공화국', 'S'),
	(10, 12, '2025-04', '정보보안기사', '관현공화국', 'P'),
	(11, 13, '2024-01', 'MySQL 전문가', '관현공화국', 'S'),
	(12, 101, '2025-01', '정보처리기사', '대한상공회의소', 'S'),
	(13, 126, '2024-08', '정보처리기사', '산업인력공단', 'S'),
	(14, 143, '2025-01', 'AI 개발자', 'NASA', 'P');

-- 테이블 genesis.tbl_resume_education 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_resume_education` (
  `resume_education_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 학력 번호',
  `resume_no` bigint(20) NOT NULL COMMENT '이력서 고유 넘버',
  `resume_education_gbn_code` varchar(20) NOT NULL COMMENT '학력구분(H: 고, U: 대, S: 석사, D: 박사, J: 전문대)',
  `resume_education_name` varchar(200) NOT NULL COMMENT '학교이름',
  `resume_education_major` varchar(255) DEFAULT NULL COMMENT '전공',
  `resume_education_score` float DEFAULT NULL COMMENT '성적 (필수아님)',
  `resume_education_indt` varchar(50) NOT NULL DEFAULT '' COMMENT '입학날짜',
  `resume_education_outdt` varchar(50) NOT NULL DEFAULT '' COMMENT '졸업날짜',
  `resume_education_transfer_yn` varchar(50) DEFAULT 'N' COMMENT '편입여부(Y, N)',
  `resume_education_resion` varchar(255) DEFAULT NULL COMMENT '지역',
  PRIMARY KEY (`resume_education_no`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 학력 테이블';

-- 테이블 데이터 genesis.tbl_resume_education:~19 rows (대략적) 내보내기
INSERT INTO `tbl_resume_education` (`resume_education_no`, `resume_no`, `resume_education_gbn_code`, `resume_education_name`, `resume_education_major`, `resume_education_score`, `resume_education_indt`, `resume_education_outdt`, `resume_education_transfer_yn`, `resume_education_resion`) VALUES
	(3, 9, 'U3', '관현대학교', '유아교육과', NULL, '2024-01', '2025-01', 'N', NULL),
	(4, 11, 'S', '관현햄대학교', '컴퓨터공학과', NULL, '2025-03', '2025-12', 'N', NULL),
	(5, 12, 'S', '관현햄대학', '관현햄', NULL, '2025-01', '2025-01', 'N', NULL),
	(6, 13, 'B', '관현햄대학', '관현과', NULL, '2025-02', '2025-12', 'N', NULL),
	(7, 101, 'U3', '김해대학교', '컴퓨터공학과', NULL, '2025-01', '2025-10', 'N', NULL),
	(8, 126, 'U4', '한양대학교', '소프트웨어공학', NULL, '2021-03', '2024-02', 'N', NULL),
	(9, 131, 'U3', '123', '123', NULL, '2025-04', '2025-12', 'N', NULL),
	(10, 132, 'U4', '서울대학교', '컴퓨터공학과', NULL, '2015-03', '2021-02', 'N', NULL),
	(11, 136, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(12, 136, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(13, 136, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(14, 136, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(15, 136, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(16, 136, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(17, 141, 'U3', '321', '321421', NULL, '32132-12', '32142-12', 'N', NULL),
	(18, 140, 'U4', '동서대학교', '사회복지학과', NULL, '2016-03', '2022-02', 'N', NULL),
	(19, 141, 'U3', '321', '321421', NULL, '32132-12', '32142-12', 'N', NULL),
	(20, 141, 'U3', '321', '321421', NULL, '32132-12', '32142-12', 'N', NULL),
	(21, 143, 'U4', '부산대학교', '의류학과', NULL, '2025-01', '2025-01', 'N', NULL);

-- 테이블 genesis.tbl_resume_portfolio 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_resume_portfolio` (
  `resume_portfolio_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 포트폴리오 번호',
  `resume_no` bigint(20) NOT NULL COMMENT '이력서 고유 넘버',
  `resume_portfolio_start_date` date NOT NULL COMMENT '작업시작기간',
  `resume_portfolio_end_date` date NOT NULL COMMENT '작업종료기간',
  `resume_portfolio_url` text DEFAULT NULL COMMENT 'url',
  `resume_portfolio_cnt` int(11) DEFAULT NULL COMMENT '작업인원',
  `resume_portfolio_content` text DEFAULT NULL COMMENT '작업내용',
  PRIMARY KEY (`resume_portfolio_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 포트폴리오 테이블';

-- 테이블 데이터 genesis.tbl_resume_portfolio:~7 rows (대략적) 내보내기
INSERT INTO `tbl_resume_portfolio` (`resume_portfolio_no`, `resume_no`, `resume_portfolio_start_date`, `resume_portfolio_end_date`, `resume_portfolio_url`, `resume_portfolio_cnt`, `resume_portfolio_content`) VALUES
	(1, 9, '2025-01-01', '2025-01-05', '', 2, '저는 일을 잘합니다. 악명 높은 관현햄공화국에서 관현팀 팀장을 맡은 이력이 있습니다.\r\n\r\n비행기를 타고 아프리카 사막을 여행하고 있던 조종사가 비행기 고장으로 사막에 불시착을 하게 된다. 아무도 없을 것 같던 사막에서 생사를 고민하던 중 우연히 한 소년을 만나게 된다. 조종사는 이 소년과 대화하던 중 그가 다른 별에서 왔다는 것을 알게 되었다. 어린왕자는 B612라는 작은 혹성에서 살았는데 우연히 만난 장미에게 사랑을 느끼지만 장미는 어린왕자에게 상처만 줄 뿐이었다. 그때 어린왕자를 찾아온 사업가를 통해 다른 별의 이야기를 전해 듣고 더 큰 세상을 알면 장미의 행동을 이해할 수 있으리란 생각을 하며 여행을 결심한다. \r\n\r\n어린왕자는 여러 별을 여행하며 사람들은 만나지만 모두 이해할 수 없는 생각과 행동을 할 뿐이라고 생각한다. 자신의 권위가 무엇보다 중요했던 어느 왕, 자기를 칭찬하는 말 이외에는 들으려 하지 않는 허영심 많은 사람이 살고 있는 별. 술 마시는 것이 부끄럽지만 그것을 잊기 위해 다시 술을 마신다는 술꾼이 사는 별. 하늘에 보이는 5억 개의 별이 모두 자기 것이라 주장하는 과대망상증 상인이 있는 별. 그리고 별이 작아서 그럴 필요가 없는데도 계속 1분마다 불을 켜고 끄는 이상한 사람이 사는 별.\r\n\r\n지리학자지만 한 번도 산과 강을 본 적이 없다는 지리학자의 별을 방문하게 된다. \r\n\r\n그리고 지구에서 만난 수많은 꽃과 여우!! 이를 통해 세상에는 같은 장미가 있지만 어린 왕자가 아끼며 돌보던 장미는 이 세상이 하나밖에 없음을 여우를 통해 깨닫고 자기의 별로 돌아갈 것을 결심한다. \r\n\r\n​비행기 수리를 끝낸 조종사는 자신과 함께 가자고 권하지만 어린왕자는 가시 4개로 자신을 보호하려는 꽃이 너무 안쓰러워서 그를 돌봐주러 가야겠다고 말하며 뱀의 독을 이용하여 지구를 떠나게 된다. 죽게 된다. 시간이 흘러 6년 후 하늘의 수많은 별들을 볼 때마다 어린왕자가 어딘가에 살고 있으리라는 희망을 품는다. '),
	(2, 9, '2025-01-01', '2025-01-05', 'http://localhost:1111/resume', 4, '이번 팀플 재밌어요!'),
	(3, 11, '2025-01-02', '2025-01-05', '', 100, '독후감(讀後感)은 책이나 글을 읽은 후 감상을 쓰는 일, 또는 감상을 쓴 글을 뜻하는 말이다. \'독후감상문\'의 준말이고 실질적으로 준말이 더 널리 쓰인다.\r\n\r\n일기와 함께 초등학생들의 2대 주적.[1] 책에 친숙하지 못한 사람의 속을 터지게 만드는 최악의 병기이며 작문능력이 떨어지는 이를 곤란하게 만드는 비밀 병기. 아무리 책을 좋아해도 글쓰기를 싫어하면 독후감을 잘 쓰지 못한다. 심지어 책을 좋아하고 글쓰기를 좋아해도 독후감은 극도로 혐오하는 경우도 있다. 또한 초등학교에서 끝나는 거였으면 이 문서가 작성되었을 리가 없다. 중고등학교에서도 독후감은 미처 대비하지 못한 불행한 학생들을 수행평가의 모습으로 덮친다. 대학생도 마찬가지다. 서평이라는 거창한 이름을 붙였지만 결국 독서감상문.\r\n\r\n보통 학교에서 책을 읽고 자신이 느꼈던 점을 쓰는 것이지만 대부분의 사람들은 그냥 줄거리만 요약하는 경우가 있다. 짧은 책이면 간단히 쓸 수 있지만 줄거리가 매우 긴 책이라면 더 이상의 자세한 설명은 생략한다. 하지만 몇 장 이상으로 분량이 정해져 있는 경우 줄거리 요약만으로 일정 분량을 커버할 수가 있다. 물론 줄거리 따위 쓰지 않고 몇개 핵심 단어만 꼽아서 줄줄히 자기 생각을 읊어낼 수 있다면 상관이 없겠지만, 대다수는 그러지 못하니...'),
	(4, 12, '2025-01-03', '2025-01-24', '', 1, '초등생 수준의 독후감에서는 말미에 땜빵용으로 쓰이는 "참 재미있었다."는 거의 필수요소다.[2] 초등학교 저학년생들의 독후감 숙제를 보면 \'참 재미있었다\'는 표현이 쓰이지 않은 독후감이 손에 꼽을 정도로 극히 적다. 그래서인지 초등학교 고학년 이상부터는 선생님이 \'참 재미있었다\'는 표현이 들어간 글을 쓰지 못하게 한다. 이때는 "명작이었다", "가슴에 와 닿는 소설이었다", "또 읽고 싶다" 같은 꼼수로 독후감에 쓰게 된다.\r\n\r\n간혹 "책의 주인공에게 가상의 편지를 써 보라" 같은 방법이 더해진다. 이 경우에는 책의 줄거리를 그대로 요약하는 꼼수를 부리기 힘들게 되기 때문에 난이도가 좀 더 상승하게 된다.\r\n\r\n고등학교에서는 거의 점수 주기용으로 나오는 거라 그냥 정신줄 놓고 써도 어지간하면 100점은 나온다.\r\n'),
	(5, 13, '2025-01-03', '2025-01-17', 'http://localhost:1111/resume', 3, '사실 단순히 시켜서 하는 숙제 형식의 독후감이라면 굳이 독후감 하나로 눈물겨운 작품을 완성해야할 이유도, 목적도 없다. 독후감이 단순한 글자 채우기가 아닌 내면의 표현이라 해봤자 곧이곧대로 만인에게 통하지도 않을 일. 따라서 아래 내용은 제대로 된 독후감을 작성하는 법이라기 보단, 당장 독후감 과제가 급한 이들에게 추천하는 요령이다.'),
	(6, 13, '2025-01-03', '2025-01-17', '', 3, '문장을 존댓말로 써도 분량이 매우 늘어난다.\r\n예시: "우리들은 과학 기술의 위대함을 보았다." 를 "저희들은 과학 기술의 위대함을 보았습니다."라고 쓰면 2글자가 늘어나는데, 이것을 누적하여 쓰면 10문장 쓰면 20글자, 대략 1~2문장의 분량 정도 체감상으로 더 길어진다는 것을 알 수 있다.\r\n'),
	(7, 143, '2025-01-06', '2025-01-06', '', 4, '일라이크 짱');

-- 테이블 genesis.tbl_resume_stack 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_resume_stack` (
  `resume_stack_no` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '이력서 기술스택 번호',
  `resume_no` bigint(20) NOT NULL COMMENT '이력서 고유 넘버',
  `stack_code` varchar(20) NOT NULL COMMENT '기술스택',
  PRIMARY KEY (`resume_stack_no`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='이력서 기술스택 테이블';

-- 테이블 데이터 genesis.tbl_resume_stack:~82 rows (대략적) 내보내기
INSERT INTO `tbl_resume_stack` (`resume_stack_no`, `resume_no`, `stack_code`) VALUES
	(46, 9, 'AOS'),
	(47, 9, 'iOS'),
	(48, 9, 'OR'),
	(49, 9, 'RD'),
	(50, 9, 'GL'),
	(51, 9, 'AC'),
	(52, 9, 'D'),
	(53, 9, 'CI'),
	(54, 9, 'GH'),
	(55, 9, 'JK'),
	(56, 9, 'L'),
	(57, 9, 'JM'),
	(58, 9, 'JU'),
	(59, 9, 'PD'),
	(60, 11, 'D'),
	(61, 11, 'E'),
	(62, 11, 'JS'),
	(63, 11, 'NX'),
	(64, 11, 'NG'),
	(65, 11, 'JK'),
	(66, 11, 'JM'),
	(67, 11, 'JU'),
	(68, 12, 'J'),
	(69, 13, 'AOS'),
	(70, 13, 'D'),
	(71, 13, 'MG'),
	(72, 13, 'GL'),
	(73, 13, 'D'),
	(74, 13, 'CD'),
	(75, 13, 'D'),
	(76, 13, 'RD'),
	(77, 13, 'DY'),
	(78, 13, 'CD'),
	(79, 13, 'D'),
	(80, 13, 'F'),
	(81, 13, 'G'),
	(82, 13, 'KT'),
	(83, 13, 'P'),
	(84, 101, 'AOS'),
	(85, 101, 'FL'),
	(86, 101, 'iOS'),
	(87, 126, 'FL'),
	(88, 126, 'J'),
	(89, 126, 'MS'),
	(90, 126, 'OR'),
	(91, 126, 'H'),
	(92, 126, 'C'),
	(93, 126, 'JS'),
	(94, 126, 'AWS'),
	(95, 126, 'GT'),
	(96, 132, 'J'),
	(97, 132, 'P'),
	(98, 132, 'MS'),
	(99, 132, 'OR'),
	(100, 132, 'C'),
	(101, 132, 'H'),
	(102, 132, 'AWS'),
	(103, 132, 'L'),
	(104, 132, 'JU'),
	(105, 140, 'J'),
	(106, 140, 'C'),
	(107, 140, 'H'),
	(108, 140, 'JS'),
	(109, 140, 'AWS'),
	(110, 141, 'G'),
	(111, 143, 'OR'),
	(112, 143, 'PS'),
	(113, 143, 'AC'),
	(114, 143, 'CI'),
	(115, 143, 'GH'),
	(116, 143, 'PY'),
	(117, 143, 'AS'),
	(118, 143, 'C'),
	(119, 143, 'E'),
	(120, 143, 'G'),
	(121, 143, 'P'),
	(122, 143, 'NG'),
	(123, 143, 'T'),
	(124, 143, 'V'),
	(125, 143, 'D'),
	(126, 143, 'JK'),
	(127, 143, 'CT');

-- 테이블 genesis.tbl_users 구조 내보내기
CREATE TABLE IF NOT EXISTS `tbl_users` (
  `username` varchar(15) NOT NULL COMMENT '사용자 고유 ID',
  `password` varchar(255) NOT NULL COMMENT '비밀번호(해시값)',
  `name` varchar(255) NOT NULL COMMENT '사용자 이름',
  `email` varchar(255) NOT NULL COMMENT '이메일',
  `gender` char(1) NOT NULL COMMENT 'N:남자.F:여자',
  `birth` date NOT NULL COMMENT '생년월일',
  `phone` varchar(15) NOT NULL COMMENT '휴대폰번호',
  `address` varchar(255) NOT NULL COMMENT '주소',
  `address_detail` varchar(50) DEFAULT NULL COMMENT '상세주소',
  `zip_code` int(5) NOT NULL COMMENT '우편번호',
  `role` varchar(100) NOT NULL DEFAULT 'ROLE_USER' COMMENT '권한',
  `delete_yn` char(1) NOT NULL DEFAULT 'N' COMMENT '삭제여부(N)미삭제(Y)삭제',
  `regist_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일',
  `modi_dt` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정일',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='구직자 테이블';

-- 테이블 데이터 genesis.tbl_users:~13 rows (대략적) 내보내기
INSERT INTO `tbl_users` (`username`, `password`, `name`, `email`, `gender`, `birth`, `phone`, `address`, `address_detail`, `zip_code`, `role`, `delete_yn`, `regist_dt`, `modi_dt`) VALUES
	('1ikeJJang', '$2a$10$zbZNie51s2k8EsuD9xyLwO1eGuhp09GVqI/SjoALyLzW5mLpDSWNm', '일라이크짱', 'klk510a@gmail.com', 'M', '2025-01-06', '01026529514', '제주특별자치도 제주시 한림읍 협재로 1', '협재', 63011, 'ROLE_USER', 'N', '2025-01-06 08:26:20', '2025-01-06 08:26:20'),
	('1ikeZZang', '$2a$10$JTxU0FUnJOUhJvhI4KBEROf.j09TbX4baHjItBTTWuyPVN8G7CPmi', '최윤서', 'dbstj@gmail.com', 'F', '2025-01-06', '01077776120', '제주특별자치도 제주시 한림읍 협재로 1', '123', 63011, 'ROLE_USER', 'N', '2025-01-06 08:28:49', '2025-01-06 08:34:05'),
	('dongha', '$2a$10$zHngZ/DVu7yxk9xrpY1sEOmDwu3aZUpqn/emqxPh9Md8IRT3i9yA2', '이동하', 'dongha@naver.com', 'M', '1997-06-17', '01037453270', '부산 부산진구 중앙대로 688', '한준빌딩 2층', 47296, 'ROLE_USER', 'N', '2025-01-06 08:26:57', '2025-01-06 08:26:57'),
	('hgd', '$2a$10$dscYqe9tyGsTm6jUKegAz.DLWq5s6iDf8eXmM7SREFKSoqqXM8yUq', '홍길동', 'hgd@green.com', 'M', '1443-02-06', '01022223333', '충북 충주시 가주농공2길 21', '1-1', 27479, 'ROLE_USER', 'N', '2025-01-06 05:47:27', '2025-01-06 05:47:27'),
	('qwer', '$2a$10$pjmolTOkMmFyUTZkEUTWM.QxYfQQsehwnVBxGILO4bLdwbZ1Im89G', '대관현', 'qwer@qwer.com', 'M', '1996-09-11', '01022293282', '서울 용산구 독서당로 111', '203동 1012호', 4419, 'ROLE_USER', 'N', '2025-01-06 08:26:34', '2025-01-06 08:26:34'),
	('saya1013', '$2a$10$cYadBWx6d0IoEkn6c08QE.KqiEXETdzJTvaFi5OAEeYhQB/EZ2XH.', '사야', 'saya1031@naver.com', 'F', '2024-01-01', '01011111111', '부산 부산진구 거제천로40번길 31', '1층', 47209, 'ROLE_USER', 'N', '2025-01-06 02:49:43', '2025-01-06 02:55:35'),
	('user01', '$2a$10$l2BRVqqJW3p0G3hv/dEi6.Q.ngpzZaqWaqp9q7U.yEM6tgLuM2iUi', '으르렁', 'ffffsf@naver.com', 'M', '2025-01-02', '01012345678', '부산 수영구 광남로 2', 'ㄹㅇㄹ', 48307, 'ROLE_USER', 'N', '2025-01-06 08:27:06', '2025-01-06 08:27:06'),
	('노관현', '$2a$10$fpYcVbjZDn3k//1.D8Wzqekal6t8y1/2V1xS8x5zZT8uSUYCDD1J6', '노관현', 'rhksgus@naver.com', 'M', '2025-01-22', '12134536413', '서울 성동구 난계로 67', '123호', 4721, 'ROLE_USER', 'N', '2025-01-05 08:09:27', '2025-01-05 08:09:27'),
	('안제연', '$2a$10$VOenc1Pdqw6oYLwFf.LeHuEdSa3jhPdp3DI6.2fFSQ6s0J3oxXuJm', '안제연', 'wpdus@naver.com', 'M', '1997-04-02', '01012341234', '경기 성남시 분당구 대왕판교로 477', '123호', 13480, 'ROLE_USER', 'N', '2025-01-05 08:06:58', '2025-01-05 08:06:58'),
	('안혜빈', '$2a$10$.BfrOpADdWZoTKmlr2P22OwyblMACDdb/07vylk07yfrlrZ28OZOm', '안혜빈', 'gpqls9524@naver.com', 'M', '1998-01-15', '01066639447', '부산 동래구 반송로354번길 10', '제일명장맨션 210호', 47766, 'ROLE_USER', 'N', '2025-01-05 08:06:14', '2025-01-06 06:16:16'),
	('콜라에밥말아먹기~', '$2a$10$CewK.fMZ1SIodOPQs0B.yuXP.QqnEy6FpD4PSo6xJGvqpliIiPK5a', '', '', 'M', '2025-01-06', '', '광주 남구 제중로 11', '', 61664, 'ROLE_USER', 'N', '2025-01-06 08:26:37', '2025-01-06 08:28:27'),
	('한우성', '$2a$10$Oix3YrBi5ebQXUOfIFV.4.zfIbDKZkzT30wXsw7wSTLD1I5qa5Ubi', '한우성', 'dntjd@naver.com', 'M', '2025-01-05', '12345123421', '부산 영도구 해양힐링로 8', '12312호', 49126, 'ROLE_USER', 'N', '2025-01-05 08:07:35', '2025-01-05 08:07:35'),
	('혜빈', '$2a$10$3HG9l8l4b5u3F7IspZP3q.6dK9iJq6ucKa9JXebtpVjsPn.JXt3wa', '혜빈', 'irem2493@naver.com', 'M', '2025-01-22', '010-1111-22', '서울 서대문구 서소문로 43-8', '123', 3741, 'ROLE_USER', 'N', '2025-01-06 06:27:22', '2025-01-06 06:27:22');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
