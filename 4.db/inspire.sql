SHOW DATABASES;

USE inspire;

/*
SQL (Structure Query Language)

SELECT
DDL : create, drop, alter
DML : insert, update, delete
DCL : commit, rollback


select : 데이터를 검색할 때

select column_name | * | expression | function | as | distinct column_name
from table_name
[WHERE]    : 행의 제한 / 테이블에 대한 필터
[GROUP_BY] : 데이터를 그룹으로 묶기 ( 표현식 / 컬럼명 / 별치 X )
[HAVING]   : 그룹에 대한 조건 / 그룹에 대한 필터
[ORDER BY] : 정렬(내림차순 DESC, 오름차순 ASC)

*/

SELECT * 
FROM employee;

SELECT EMP_ID 
FROM employee;

SELECT * 
FROM department;

SELECT 	*
FROM 		employee
WHERE 	DEPT_ID = '90';

/* AS 생략 가능 */
SELECT	EMP_NAME,
			SALARY,
			((SALARY + (SALARY*IFNULL(BONUS_PCT, 0))) * 12) AS `연 봉`
FROM 		employee;


-- NULL 처리를 위한 함수 : IFNULL(EXP1, EXP2) , NULLIF(EXP1, EXP2)
--                         EXP1이 NULL이면 EXP2 실행

SELECT IFNULL(NULL, 'who are you');
SELECT NULLIF(100, 'not null');


-- distinct : 컬럼에 포함된 중복값을 한 번씩만 출력
-- distinct 는 한 query에 한 번만 가능
SELECT  distinct DEPT_ID
FROM employee;

SELECT  distinct DEPT_ID,
					JOB_ID
FROM employee;

-- where
-- 연산자(비교(like. not like), 산술, 논리(and, or, not))

-- 부서번호가 90번이거나 급여가 4000000 이상인 사원은?
SELECT *
FROM employee
WHERE DEPT_ID = '90' OR SALARY >= 4000000

-- CONCAT() : 연결연산자
SELECT CONCAT('임정섭', '강사님은', '강사료가', '얼마일까')

SELECT CONCAT(EMP_NAME,'의 급여는 ', SALARY, '입니다.') AS '급여'
FROM employee;


-- 급여정보가  350 이상이고, 550 이하인 사원은?
-- BETWEEN ~ AND
SELECT *
FROM employee
WHERE SALARY >= 3500000 AND SALARY <= 5500000;

SELECT *
FROM employee
WHERE SALARY BETWEEN 3500000 and 5500000;

-- LIKE, NOT LIKE : 패턴 검색 (%, _)
-- % : 하나 이상의 문자와 매칭
-- _ : 하나의 문자와 매칭


-- 김씨성을 가진 사원만
SELECT *
FROM employee
WHERE EMP_NAME LIKE '김%';

-- IS NULL, IS NOT NULL : 널 값은 = 비교 불가.
-- 부서 배치를 받지 않은 사원은?
SELECT *
FROM employee
WHERE DEPT_ID IS NULL;

-- 부서번호가 60번이거나 90번인 사원의 정보
-- IN()
SELECT *
FROM employee
WHERE DEPT_ID = '60' OR DEPT_ID = '90';

SELECT *
FROM employee
WHERE DEPT_ID IN(60, 90);


-- Basic SELECT
-- 1
SELECT 	DEPARTMENT_NAME '학과 명',
			CATEGORY '계열'
FROM 		tb_department;

-- 2
SELECT 	CONCAT(DEPARTMENT_NAME, '의 정원은 ', CAPACITY, '명 입니다.')
FROM 		tb_department;

-- 3
SELECT STUDENT_NAME
FROM tb_student
WHERE DEPARTMENT_NO = 001 
  AND ABSENCE_YN = 'Y'
  AND STUDENT_SSN LIKE '%-2%';

-- 4
SELECT STUDENT_NAME
FROM tb_student
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');

-- 5
SELECT DEPARTMENT_NAME, CATEGORY
FROM tb_department
WHERE CAPACITY BETWEEN 20 AND 30;

-- 6
SELECT PROFESSOR_NAME
FROM tb_professor
WHERE DEPARTMENT_NO IS NULL;

-- 7 
SELECT *
FROM tb_student
WHERE DEPARTMENT_NO IS NULL;

-- 8
SELECT CLASS_NO
FROM tb_class
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

-- 9
SELECT DISTINCT CATEGORY
FROM tb_department;

-- 10
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM tb_student
WHERE STUDENT_ADDRESS LIKE '%전주%'
  AND ENTRANCE_DATE LIKE '__02%'
  AND ABSENCE_YN = 'N';
  
  
  -- ---------------------------------------------------------------------
  -- 함수
  /*
  프로그램에서 반복적으로 사용되는 부분을 분리한 서브 프로그램
  
  - 유형
  단일행 함수 : 문자열, 날짜, 숫자, 기타변형 함수
                함수 적용 전과 후의 쿼리 결과 개수가 같음.
  복수행(그룹) 함수 : min, max, sum, avg ..
  */
  
SELECT *
FROM employee;

SELECT EMP_NAME,
		 CONCAT(EMP_NAME, '님'),
		 LENGTH(EMP_NAME),
		 CHAR_LENGTH(EMP_NAME)
FROM 	 employee;

-- LOWER(), UPPER()

SELECT LOWER('HELLO'), UPPER('hello');

-- LPAD, RPAD : 자리수를 고정하기 위해 빈 공간을 원하는 문자로 채움
-- 정렬
SELECT 	EMAIL AS '원본데이터',
			LENGTH(EMAIL) '원본길이',
			LPAD(EMAIL, 30),
			RPAD(EMAIL, 30, '*'),
			LENGTH(LPAD(EMAIL, 30))
FROM 		employee;


-- ELT() 	: 인덱스를 이용해서 특정 위치의 문자를 찾는 함수
-- INSTR() 	: 문자열을 이용해서 부분문자열을 찾는 함수

SELECT ELT(2, '1', '2', '3'),
		 INSTR('임정섭', '임');
		 
SELECT 	EMAIL
FROM 		employee;

-- LEFT(), RIGHT()
SELECT LEFT('abcde', 3), RIGHT(abcde, 3);

-- SUBSTRING()
-- 부분문자열을 반환하는 함수
SELECT SUBSTR('abcde', 1, 2);

-- . 앞의 문자 'c'의 인덱스 번지는?
SELECT 	EMAIL,
			SUBSTR(EMAIL, INSTR(EMAIL, '.') - 1, 1)
FROM		employee;


-- TRIM(), LTRIM(), RTRIM() : 뭔가를 제거할 때

SELECT		LTRIM('		LGCNS'), 
				RTRIM('LGCNS			'), 
				TRIM('		LGCNS		');
				
SELECT		TRIM(BOTH '123' FROM '123TECH123'),
				TRIM(LEADING '123' FROM '123TECH123'),
				TRIM(TRAILING '123' FROM '123TECH123');
				
-- 문자열 반복
SELECT REPEAT('LGCND', 3);

-- 문자열 치환
-- REPlACE('원본 문자열', '타겟 문자열', '바꿀 문자열')
SELECT REPLACE('오늘은 코스모스 졸업식', '졸업식', '입학식');



-- 중요 ********************
-- SUBSTRING(문자열, 시작위치, 길이) OR 
--				(문자열 FROM 시작위치 FOR 길이)
-- SUBSTRING_INDEX(문자열, 구분자, 횟수)

SELECT	SUBSTRING('this is inspire camp',
					  	 9,
						 7),
			SUBSTRING('this is inspire camp'
					    FROM 9
					    FOR 7);
					    
SELECT 	SUBSTRING_INDEX('www.lgcns.com', '.', 1),
			SUBSTRING_INDEX('www.lgcns.com', '.', -1);
			
			
/*
employee

1. 사원의 이메일 중 id만 추출
2. 입사년도만 추출
3. 주민번호 앞 6자리
4. 입사일 출력 포맷을 xxxx년 xx월, xx일
*/

SELECT 	SUBSTRING_INDEX(EMAIL, '@', 1),
			SUBSTRING_INDEX(HIRE_DATE, '-', 1),
			LEFT(EMP_NO, 6),
			CONCAT(SUBSTRING(HIRE_DATE, 1, 4), '년 ',
					 SUBSTRING(HIRE_DATE, 6, 2), '월 ',
					 SUBSTRING(HIRE_DATE FROM 9 FOR 2), '일')
		
FROM 		employee;


SELECT *
FROM usertbl;

SELECT *
FROM buytbl;

-- 평균 구매 개수를 확인하려면?
SELECT 	CAST(AVG(amount) AS INT) '평균구매'
FROM 		buytbl;

-- 구매 번호, 총 금액(price * amount), 구매 액
SELECT		num '구매번호',
				CONCAT(CAST(PRICE AS VARCHAR(10)),
					    '*',
					    CAST(AMOUNT AS VARCHAR(10))) AS '총 금액',
				(price*amount) '총 금액',
				price '구매 액'
FROM 			buytbl;


SELECT	LEFT(EMP_NO, 6),
			RIGHT(EMP_NO, 7),
			LEFT(EMP_NO, 6) + RIGHT(EMP_NO, 7),
			CAST(LEFT(EMP_NO, 6) AS INT) + CAST(RIGHT(EMP_NO, 7) AS INT)
FROM 		employee;


-- 숫자 함수
SELECT 	ABS(-100),
			CEILING(4.8),
			FLOOR(4.7),
			ROUND(4.5),
			ROUND(4.4),
			TRUNCATE(123.223423, 2),
			TRUNCATE(123.223423, -2);
			
-- 날짜함수
SELECT		NOW(),
				SYSDATE(),
				CURDATE(),
				CURTIME();
				
-- 날짜 연산?
-- ADDDATE(DATE, INTERVAL EXPRESSION TYPE), DATE_ADD()
-- SUBDATE()

-- ADDTIME(), SUBTIME()
SELECT 	NOW() + 1;

-- INTERVAL [YEAR, MONTH, DAY]
SELECT 	ADDDATE(NOW(), INTERVAL 1 MONTH ),
			SUBDATE(NOW(), INTERVAL 1 MONTH ),
			ADDTIME(NOW(), '1:1:1'),
			SUBTIME(NOW(), '2:0:0');
			
			
			
SELECT 	*
FROM		employee;

-- 오늘 날짜를 기준으로 근속년수가 25년 이상인 사원의 정보
-- DATEDIFF(A, B) : A-B를 일수로 표현
SELECT		*
FROM			employee
WHERE 		SUBSTRING(SUBDATE(CURDATE(), INTERVAL LEFT(HIRE_DATE, 4) YEAR), 3, 2) >= 25;

SELECT		*
FROM			employee
WHERE 		ROUND (DATEDIFF( CURDATE(), HIRE_DATE ) / 365) >= 25;

-- YEAR(), MONTH(), DAY(), HOUR(), MINUTE(), SECOND()
SELECT	CAST(YEAR(HIRE_DATE) AS CHAR),
			MONTH(HIRE_DATE),
			DAY(HIRE_DATE)
FROM 		employee;


-- 기타 변형함수
-- 제어 흐름 함수(IF, IFNULl, CASE ~ WHEN ~ END)
SELECT IF(100 > 200, '참', '거짓');

SELECT 	case 4
				when 1 then '1'
				when 10 then '10'
				ELSE '내가 원하는게 읍서'
			END AS '구분';
			
-- 부서번호가 50번인 사원의 이름, 주민번호, 성별  검색
SELECT 		EMP_NAME '이름',
				EMP_NO '주민번호',
				case
					when SUBSTRING(EMP_NO, 8, 1) IN (1, 3) then '남'
					when SUBSTRING(EMP_NO, 8, 1) IN (2, 4) then '여'
				END AS '성별'
FROM			employee
WHERE			DEPT_ID = '50';

-- 사원테이블에서 남자사원의 이름, 주민번호, 성별
SELECT 		EMP_NAME '이름',
				EMP_NO '주민번호',
				'남' AS '성별'
FROM			employee
WHERE			SUBSTRING(EMP_NO, 8, 1) IN (1, 3);


-- 사원테이블에서 직급이 J4 인 사원의 사번과 이름 사수 번호
-- 추가 ) 사수번호가 없는 사원의 MGR_ID컬럼에 '관리자'
SELECT		EMP_ID,
				EMP_NAME,
				case
					when MGR_ID = '' then '관리자'
					ELSE MGR_ID
				END AS EMR_ID
FROM 			employee
WHERE			JOB_ID = 'J4';

-- 사원 급여 등급
-- 3000000 이하면 초급, 4000000 이하면 중급, 초과면 고급

SELECT		EMP_ID,
				EMP_NAME,
				SALARY,
				case
					when SALARY <= 3000000 then '초급'
					when SALARY <= 4000000 then '중급'
					when SALARY > 4000000 then '고급'
				END AS '급여등급'
FROM			employee
ORDER BY '급여등급' ;

-- 복수행(그룹, 집계) 함수

SELECT 	COUNT(*),
			COUNT(BONUS_PCT),
			COUNT(IFNULL(BONUS_PCT, 0)),
			MIN(SALARY),
			MAX(SALARY),
			SUM(SALARY),
			AVG(SALARY)
FROM employee;


SELECT *
FROM employee;

SELECT *
FROM department;

SELECT *
FROM job;




SELECT *
FROM tb_department
FROM tb_student
FROM tb_class
FROM tb_class_professor
FROM tb_professor
FROM tb_grade

-- work book additional function
-- 1
SELECT STUDENT_NO '학번',
		 STUDENT_NAME '이름',
		 ENTRANCE_DATE '입학년도'
FROM tb_student
WHERE department_no = 002
ORDER BY '입학년도';

-- 2
SELECT PROFESSOR_NAME,
		 PROFESSOR_SSN
FROM tb_professor
WHERE length(PROFESSOR_NAME) != 9;

-- 3
SELECT PROFESSOR_NAME '이름',
		 (2025 - CONCAT(19, LEFT(PROFESSOR_SSN, 2))) AS '나이'
FROM tb_professor
WHERE SUBSTRING(PROFESSOR_SSN, 8, 1) = 1
ORDER BY 나이;

-- 4 
SELECT SUBSTRING(PROFESSOR_NAME, 2, LENGTH(PROFESSOR_NAME)/3)
FROM tb_professor;

-- 5
SELECT STUDENT_NO,
		 STUDENT_NAME
FROM tb_student
WHERE LEFT(ENTRANCE_DATE, 4) - CONCAT(19, LEFT(STUDENT_SSN, 2)) > 19;

-- 6 ) WEEKDAY() 날짜의 요일을 정수로 반환 / DAYOFWEEK() 
SELECT case 
			when DAYOFWEEK('2020-12-25') = 2 then '월' 
			when DAYOFWEEK('2020-12-25') = 3 then '화' 
			when DAYOFWEEK('2020-12-25') = 4 then '수' 
			when DAYOFWEEK('2020-12-25') = 5 then '목' 
			when DAYOFWEEK('2020-12-25') = 6 then '금' 
			when DAYOFWEEK('2020-12-25') = 7 then '토' 
			when DAYOFWEEK('2020-12-25') = 1 then '일' 
		END AS '크리스마스'
		
-- 8
SELECT STUDENT_NO,
		 STUDENT_NAME
FROM tb_student
WHERE LEFT(STUDENT_NO, 1) != 'A';

-- 9
SELECT		*
FROM			tb_student
WHERE			STUDENT_NO = 'A517178';

-- 10
SELECT		DEPARTMENT_NO AS '학과번호',
				count(DEPARTMENT_NO) AS '학생수(명)'
FROM			tb_student
GROUP BY		DEPARTMENT_NO;

-- 11
SELECT COUNT(*)
FROM tb_student
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12
SELECT		LEFT(TERM_NO, 4) '년도',
				CEIL(AVG(POINT) * 10) / 10 '년도 별 평점'
FROM			tb_grade
WHERE			STUDENT_NO = 'A112113'
GROUP BY		LEFT(TERM_NO, 4);

-- 13
SELECT		DEPARTMENT_NO '학과코드명',
				sum(IF(ABSENCE_YN = 'Y', 1, 0)) '휴학생'
FROM			tb_student
GROUP BY		DEPARTMENT_NO;

-- 14
SELECT 		STUDENT_NAME,
				COUNT(STUDENT_NAME)
FROM 			tb_student
GROUP	BY		STUDENT_NAME
HAVING		COUNT(STUDENT_NAME) >= 2
ORDER BY		1;

-- 15
SELECT		SUBSTRING(TERM_NO, 1, 4) '년도',
				SUBSTRING(TERM_NO, 5, 2) '학기',
				round(AVG(POINT), 1) '평점'
FROM 			tb_grade
WHERE			STUDENT_NO = 'A112113'
GROUP BY		SUBSTRING(TERM_NO, 1, 4), SUBSTRING(TERM_NO, 5, 2) WITH ROLLUP;


-- GROUP BY : 하위 데이터의 그룹
-- 특정 column에 대해 동일한 값을 가지는 행들을 하나의 행으로 처리
-- 통계 작업

SELECT		*
FROM			buytbl;

-- 사용자별 구매 총액은?

SELECT		USERID, 
				SUM(PRICE * AMOUNT)
FROM			buytbl
GROUP BY		USERID
ORDER BY		2 DESC ;


-- 사용자별 평균 구매수는?

SELECT		USERID, 
				ROUND (AVG(AMOUNT))
FROM			buytbl
GROUP BY		USERID
ORDER BY		2 DESC ;


SELECT		*
FROM			employee;

-- 부서별 평균 급여
SELECT		DEPT_ID,
				ROUND (AVG(salary))
FROM			employee
GROUP BY		DEPT_ID;

-- 성별에 따른 급여 평균

SELECT		IF (SUBSTRING(EMP_NO, 8, 1) = 1, '남', '여') AS '성별',
				ROUND (AVG(salary)) '급여 평균'
FROM			employee
GROUP BY		SUBSTRING(EMP_NO, 8, 1);



-- 부서별 금여 총액이 900 이상인 부서만 필터링
-- HAVING : GROUP BY 에 대한 where 절
SELECT		DEPT_ID,
				ROUND (SUM(salary))
FROM			employee
GROUP BY		DEPT_ID
HAVING		ROUND (SUM(salary)) >= 9000000;


-- buytbl 에서 사용자별 총 구매액이 100 이상인?
SELECT		USERID, 
				SUM(price * amount)
FROM			buytbl
GROUP BY		USERID
HAVING		SUM(price * amount) >= 100
ORDER BY		2 DESC ;




-- group by 확장기능 : 계층적인 집계결과 with rollup

SELECT		*
FROM			buytbl;

-- 구매한 목록 중 그룹이름 별 구매 비용
SELECT		groupName,
				NUM,
				SUM(price*amount)
FROM			buytbl
GROUP BY		groupName, NUM WITH ROLLUP;


-- JOIN : n개 이상의 테이블을 서로 묶어서 하나의 결과로
-- 관계형 데이터베이스의 가장 큰 특징
-- 테이블 관계 (1:N, 1:1)
/*
ANSI 표준 구문

SELECT
FROM			TABLE01 ALIAS
[INNER]				JOIN TABLE02 ON( 조건식 )
[LEFT | RIGHT]		JOIN TABLE02 USING( 컬럼명 )  -- both are the same
*/

SELECT		*
FROM			department D
JOIN			employee E
ON				(D.DEPT_ID = E.DEPT_ID);

SELECT		E.EMP_NAME,
				D.DEPT_NAME,
				L.LOC_DESCRIBE
FROM			department D
JOIN			employee E
USING			(DEPT_ID)
JOIN			location L
ON				(L.LOCATION_ID = D.LOC_ID)
WHERE			DEPT_NAME LIKE '해외%';


-- 사용자가 JYP 인 유저의 이름과 구매 상품은?
SELECT	*
FROM		usertbl U
JOIN		buytbl B
USING		(userID)
WHERE		B.userID = 'JYP';

-- 사용자가 아이디, 이름, 구매상품, 연락처 (mobile1 + mobile2) 조회
SELECT	userID,
			U.name,
			B.prodName,
			CONCAT(U.mobile1, U.mobile2)
FROM		usertbl U
JOIN		buytbl B
USING		(userID);

-- 위 요구사항에서 구매이력이 있는 회원만 조회하면?
SELECT	userID,
			U.name,
			B.prodName,
			CONCAT(U.mobile1, U.mobile2)
FROM		usertbl U
JOIN		buytbl B
USING		(userID);


-- 업무적인 연관성 없는 테이블도 조인이 가능 (ON)
-- 이름, 급여, 급여등급은?
SELECT		E.EMP_NAME,
				E.SALARY,
				S.SLEVEL
FROM			employee E
JOIN			sal_grade S
ON				( E.SALARY BETWEEN S.LOWEST AND S.HIGHEST )
ORDER BY		3;


-- OUTER JOIN (LEFT | RIGHT)
-- join 의 조건에 만족하지 않는 모든 행을 조회할 때
-- LEFT 면 join 기준 왼쪽의 테이블에서 누락된 것, right 면 반대
SELECT		*
FROM			department D
RIGHT JOIN			employee E
ON				(D.DEPT_ID = E.DEPT_ID);


-- 부서배치를 받지 않은 사원의 이름, 부서명은?
SELECT		EMP_NAME '이름',
				DEPT_NAME '부서명'
FROM			department D
RIGHT JOIN			employee E
ON				(D.DEPT_ID = E.DEPT_ID)
WHERE			D.DEPT_ID IS NULL;


-- 사원의 이름과 사수의 이름은?
SELECT		E.EMP_NAME '사원',
				E2.EMP_NAME '사수'
FROM			employee E
LEFT JOIN			employee E2
ON				(E.MGR_ID = E2.EMP_ID);


-- 직급이 대리이고 지역이 아시아, 대리인 사원
SELECT		E.EMP_NAME,
				D.DEPT_NAME,
				L.LOC_DESCRIBE,
				C.COUNTRY_NAME,
				J.JOB_TITLE,
				S.SLEVEL
FROM			employee E
JOIN			job J				USING(job_id)
JOIN			department D 	USING(dept_id)
JOIN			location L		ON(D.LOC_ID = L.LOCATION_ID)
JOIN			country C		USING(country_id)
JOIN			sal_grade S		ON(E.SALARY BETWEEN S.LOWEST AND S.HIGHEST)
WHERE 		J.JOB_TITLE = '대리' AND L.LOC_DESCRIBE LIKE	'아시아%'



-- workbook 3

-- 1
SELECT 	student_name '이름',
			student_address '주소지'
FROM 		tb_student
ORDER BY	1;

-- 2
SELECT		STUDENT_NAME,
				STUDENT_SSN
FROM 			tb_student
WHERE			ABSENCE_YN = 'Y'
ORDER BY		2 DESC;

-- 3
SELECT		STUDENT_NAME '학생이름',
				STUDENT_NO '학번',
				STUDENT_ADDRESS '거주지 주소'
FROM 			tb_student
WHERE			(STUDENT_ADDRESS LIKE	'%강원도%' OR STUDENT_ADDRESS LIKE	'%경기도%')
				AND LEFT(STUDENT_NO, 1) = 9 
ORDER BY 	1;

-- 4
SELECT	PROFESSOR_NAME,
			PROFESSOR_SSN
FROM		tb_professor
WHERE		DEPARTMENT_NO = '005'
ORDER BY	2;

-- 5
SELECT STUDENT_NO,
		 POINT
FROM tb_grade
WHERE CLASS_NO = 'C3118100' AND TERM_NO = '200402'
ORDER	BY	2 DESC;

-- 6
SELECT 	S.STUDENT_NO,
			S.STUDENT_NAME,
			D.DEPARTMENT_NAME
FROM 		tb_student S
JOIN		tb_department D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
ORDER BY	2 ;

-- 7
SELECT		C.CLASS_NAME,
				D.DEPARTMENT_NAME
FROM			tb_class C
JOIN			tb_department D ON (C.DEPARTMENT_NO = D.DEPARTMENT_NO);

-- 8
SELECT		C.CLASS_NAME,
				P.PROFESSOR_NAME
FROM			tb_class C
JOIN			tb_class_professor CP ON (C.CLASS_NO = CP.CLASS_NO)
JOIN			tb_professor P			 ON (P.PROFESSOR_NO = CP.PROFESSOR_NO)
ORDER BY 	1;

-- 9
SELECT		C.CLASS_NAME,
				P.PROFESSOR_NAME
FROM			tb_class C
JOIN			tb_class_professor CP ON (C.CLASS_NO = CP.CLASS_NO)
JOIN			tb_professor P			 ON (P.PROFESSOR_NO = CP.PROFESSOR_NO)
JOIN			tb_department D		 ON (D.DEPARTMENT_NO = P.DEPARTMENT_NO)
WHERE			D.CATEGORY = '인문사회';

-- 10
SELECT		S.STUDENT_NO '학번',
				S.STUDENT_NAME '학생 이름',
				ROUND(AVG(G.`POINT`), 1),
				CEIL(AVG(G.`POINT`) * 10) / 10,
				AVG(G.`POINT`)
FROM 			tb_grade G
JOIN			tb_class C 	ON (G.CLASS_NO = C.CLASS_NO)
JOIN			tb_student S	ON (S.STUDENT_NO = G.STUDENT_NO)
JOIN 			tb_department D ON (D.DEPARTMENT_NO = C.DEPARTMENT_NO)
WHERE			D.DEPARTMENT_NAME = '음악학과'
GROUP BY		S.STUDENT_NAME;

-- 11
SELECT		D.DEPARTMENT_NAME '학과이름',
				S.STUDENT_NAME '학생이름',
				P.PROFESSOR_NAME '지도교수이름'
FROM			tb_student S
JOIN			tb_professor P	ON (S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
JOIN			tb_department D ON (D.DEPARTMENT_NO = S.DEPARTMENT_NO)
WHERE 		S.STUDENT_NO = 'A313047';

-- 12
SELECT		S.STUDENT_NAME,
				G.TERM_NO 'TERM_NAME'
FROM			tb_student S
JOIN			tb_grade G		ON (S.STUDENT_NO = G.STUDENT_NO)
JOIN			tb_class C		ON (C.CLASS_NO = G.CLASS_NO)
WHERE 		G.TERM_NO LIKE	'2007%' AND C.CLASS_NAME = '인간관계론';

-- 13
SELECT	C.CLASS_NAME,
			D.DEPARTMENT_NAME
FROM		tb_class C
JOIN		tb_department D ON (C.DEPARTMENT_NO = D.DEPARTMENT_NO)
LEFT JOIN		tb_class_professor CP ON (C.CLASS_NO = CP.CLASS_NO)
WHERE 	D.CATEGORY = '예체능' AND CP.PROFESSOR_NO IS NULL ;

-- 14
SELECT		S.STUDENT_NAME '학생이름',
				IF(S.COACH_PROFESSOR_NO IS NULL, '지도교수 미지정', P.PROFESSOR_NAME) '지도교수'
FROM			tb_student S
JOIN			tb_department D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
LEFT JOIN			tb_professor P	ON (S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
WHERE			D.DEPARTMENT_NAME = '서반아어학과'
ORDER BY		S.STUDENT_NO;

-- 15
SELECT S.STUDENT_NO '학번', 
		 S.STUDENT_NAME '이름', 
		 D.DEPARTMENT_NAME ' 학과 이름',
		 AVG(G.POINT) '평점'
FROM tb_student S
JOIN tb_grade G ON (S.STUDENT_NO = G.STUDENT_NO)
JOIN tb_department D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY S.STUDENT_NO
HAVING	AVG(G.POINT) >= 4;

-- 16
SELECT G.CLASS_NO, C.CLASS_NAME, AVG(G.`POINT`)
FROM tb_grade G
JOIN tb_student S ON (S.STUDENT_NO = G.STUDENT_NO)
JOIN tb_department D ON (D.DEPARTMENT_NO = S.DEPARTMENT_NO)
JOIN tb_class C ON (C.CLASS_NO = G.CLASS_NO)
WHERE	D.DEPARTMENT_NAME = '환경조경학과' AND C.CLASS_TYPE LIKE '전공%'
GROUP BY G.CLASS_NO

-- 17
SELECT STUDENT_NAME,
		 STUDENT_ADDRESS
FROM tb_student
WHERE DEPARTMENT_NO = ( SELECT DEPARTMENT_NO
								FROM tb_student
								WHERE STUDENT_NAME = '최경희' )
								
-- 18
SELECT S.STUDENT_NO, 
		 S.STUDENT_NAME, 
		 AVG(G.`POINT`)
FROM tb_student S
JOIN tb_grade G ON (S.STUDENT_NO = G.STUDENT_NO)
JOIN tb_department D ON (S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE D.DEPARTMENT_NAME = '국어국문학과'
GROUP BY S.STUDENT_NO;

-- DAY 4 sub query & DDL (데이터 정의어)
-- subquery : 하나의 쿼리가 다른 쿼리를 포함하는 구조
-- 유형 : 단일행(단일열, 다중열), 다중행(단일열, 다중열)
-- where 절(subquery), select (scalar subquery), from 절(inline view)

-- 나승원 사원과 같은 부서원?
SELECT *
FROM employee
WHERE DEPT_ID = ( SELECT DEPT_ID
						FROM employee
						WHERE EMP_NAME = '나승원' );
						
SELECT 		E.DEPT_ID,
				SUM(salary) AS 'total'
FROM 			employee		E
JOIN			department	D	ON (E.DEPT_ID = D.DEPT_ID)
GROUP BY		E.DEPT_ID;


-- 급여 총합이 가장 높은 부서
SELECT 	D.DEPT_ID,
			SUM(SALARY) AS `TOTAL`
FROM 		employee E
JOIN 		department D ON(E.DEPT_ID = D.DEPT_ID)
GROUP BY D.DEPT_ID
HAVING 	SUM(SALARY) = ( 	SELECT MAX(TOTAL)
									FROM ( 	SELECT DEPT_ID,
														 SUM(SALARY) AS `TOTAL`
												FROM 	 employee E
												GROUP BY DEPT_ID ) T
								);
								
								
-- 최소급여 확인
SELECT D.DEPT_NAME,
		 E.EMP_NAME,
		 MIN(SALARY)
FROM employee E
JOIN department D ON (E.DEPT_ID = D.DEPT_ID)
GROUP BY D.DEPT_ID
HAVING	SALARY = ( SELECT (MIN(salary)
						  FROM	employee
						  GROUP BY DEPT_ID);


SELECT	*
FROM 		employee E
WHERE		(DEPT_ID, SALARY) IN (SELECT DEPT_ID,
												  MIN(SALARY)
										 FROM employee
										 GROUP BY DEPT_ID);
												  
												  
SELECT E.EMP_NAME,
		 J.JOB_TITLE,
		 E.SALARY
FROM employee E
JOIN	job J ON (E.JOB_ID = J.JOB_ID)
WHERE	J.JOB_TITLE = '과장';

SELECT E.EMP_NAME,
		 J.JOB_TITLE,
		 E.SALARY
FROM employee E
JOIN	job J ON (E.JOB_ID = J.JOB_ID)
WHERE	J.JOB_TITLE = '대리'
HAVING	E.SALARY < ANY ( SELECT SALARY
									FROM employee E
									JOIN job J ON (E.JOB_ID = J.JOB_ID)
									WHERE JOB_TITLE = '과장');

-- 다중행 서브쿼리일 경우 사용할 수 있는 연산자 (IN, ANY, ALL)
/*
 > ANY , < ANY query 안의 최소값보다 크거나 최대값보다 작음
 > ALL , < ALL query 안의 최소값보다 작거나 최대값보다 큼
*/

-- 단일행 서브쿼리는 일반 연산자 사용 가능

DROP TABLE IF EXISTS job_tbl;

CREATE TABLE JOB_TBL(
	JOB_ID CHAR(3),
	JOB_TITLE VARCHAR(100),
	PRIMARY KEY(JOB_ID)
);

SELECT *
FROM job_tbl;

INSERT INTO job_tbl(JOB_ID, JOB_TITLE) VALUES
('J1', '대표이사'),
('J2', '부장'),
('J3', '차장');

INSERT INTO job_tbl(JOB_ID, JOB_TITLE) VALUES ('J4', '대리');
INSERT INTO job_tbl(JOB_ID, JOB_TITLE) VALUES ('J5', '사원');

SELECT		*
FROM			job_tbl
WHERE			job_id = 'J1';


DROP TABLE IF EXISTS dept_tbl;

CREATE TABLE DEPT_TBL(
	DEPT_ID CHAR(2) PRIMARY KEY,
	DEPT_TITLE VARCHAR(100) NOT NULL
);

SELECT *
FROM dept_tbl;

INSERT INTO dept_tbl(DEPT_ID, DEPT_TITLE) VALUES 
('10', '교육팀'),
('20', '영업팀'),
('30', '힐링팀'),
('40', '레크팀');



-- 외래키 옵션 : 참조무결성 관련
-- ON DELETE CASCADE, ON UPDATE CASCADE




-- DDL(DATA DEFINITION LANGUAGE) : CREATE, DROP, ALTER 
-- TABLE (CONSTRAINT) : NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK
-- VIEW : 읽기 전용(권한, 복잡한 질의어를 단순하게)


-- DML(DATA MANIPULATION LANGUAGE) : INSERT, UPDATE, DELETE
 

DROP TABLE IF EXISTS emp_tbl;

CREATE TABLE EMP_TBL(
	EMP_ID 		VARCHAR(20) 		PRIMARY KEY,
	EMP_NAME 	VARCHAR(100) 	NOT NULL,
	SALARY 		INT 				CHECK( SALARY > 0 ),
	GENDER		CHAR(1)			CHECK( GENDER IN ('F', 'M')),
	JOB_ID		CHAR(3)			NOT NULL,
	DEPT_ID		CHAR(2)			NOT NULL,
	HIRE_DATE	DATE				DEFAULT SYSDATE(),
	FOREIGN KEY (JOB_ID)			REFERENCES job_tbl (JOB_ID),
	FOREIGN KEY (DEPT_ID)			REFERENCES dept_tbl (DEPT_ID)
);

CREATE TABLE EMP_TBL(
	EMP_ID 		VARCHAR(20) 		PRIMARY KEY,
	EMP_NAME 	VARCHAR(100) 	NOT NULL,
	SALARY 		INT 				CHECK( SALARY > 0 ),
	GENDER		CHAR(1)			CHECK( GENDER IN ('F', 'M')),
	JOB_ID		CHAR(3)			NOT NULL,
	DEPT_ID		CHAR(2)			NOT NULL
);



SELECT	*
FROM		emp_tbl;
-- ci_ : 대소문자 구별 x
-- cs_ : 대소문자 구별 o


INSERT INTO EMP_TBL() 
VALUES ('100', '임정섭', 0, 'F', NULL, NULL);


INSERT INTO EMP_TBL() 
VALUES ('100', '임정섭', 0, 'F', 'J1', '10');

INSERT INTO EMP_TBL() 
VALUES ('100', '임정섭', 100, '?', 'J1', '10');

INSERT INTO EMP_TBL
VALUES ('200', '임정섭', 100, 'F', 'J5', '40', NULL);

INSERT INTO EMP_TBL
VALUES ('400', '임정섭', 100, 'F', 'J5', '40', DEFAULT);

INSERT INTO emp_tbl(EMP_ID, EMP_NAME, SALARY, GENDER, JOB_ID, DEPT_ID)
VALUES ('500', '임정섭', 100, 'F', 'J5', '40');

SHOW INDEX FROM emp_tbl;


-- 테이블 생성 후 제약 조건을 추가하기 위해서 ALTER
ALTER TABLE emp_tbl
	ADD CONSTRAINT 
	FOREIGN KEY (JOB_ID) REFERENCES job_tbl(JOB_ID)
	
ALTER TABLE emp_tbl
	ADD CONSTRAINT 
	FOREIGN KEY (DEPT_ID) REFERENCES dept_tbl(DEPT_ID)
	
ALTER TABLE emp_tbl
	ADD COLUMN HIRE_DATE DATE DEFAULT SYSDATE();


CREATE TABLE cus_tbl(
	cus_id		VARCHAR(20) PRIMARY KEY,
	cus_name		VARCHAR(20) CHECK( cus_name IS NOT NULL ),
	cus_gender	CHAR(1)		CHECK( cus_gender IN ('F', 'M'))
);

/*
 INSERT 구문
 INSERT INTO TABLE_NAME ([COLUMN_LIST]) VALUES ([DATA])
 주의 ) 컬럼 리스트 개수와 데이터의 개수와 타입이 일치해야 함
*/

INSERT INTO cus_tbl VALUES('1', '임정섭', 'M');

SELECT *
FROM cus_tbl;


CREATE TABLE prod_tbl (
	prod_id		INT			AUTO_INCREMENT PRIMARY KEY,
	prod_name	VARCHAR(20)	DEFAULT '라벨없음'
);
INSERT INTO prod_tbl(prod_name) VALUES('아이패드');
SELECT *
FROM prod_tbl;

CREATE TABLE ord_tbl(
	ord_id		INT		AUTO_INCREMENT,
	cus_id		VARCHAR(20),
	prod_id		INT,
	PRIMARY KEY (ord_id, cus_id, prod_id),
	FOREIGN KEY (cus_id)			REFERENCES cus_tbl (cus_id),
	FOREIGN KEY (prod_id)		REFERENCES prod_tbl (prod_id)
);
INSERT INTO ord_tbl(cus_id, prod_id) VALUES(1, 1);
SELECT *
FROM ord_tbl;

SELECT		cus_name,
				prod_name
FROM 			cus_tbl C
JOIN			ord_tbl O ON (C.cus_id = O.cus_id)
JOIN			prod_tbl P ON (P.prod_id = O.prod_id);


CREATE VIEW EMP_VIEW
AS
SELECT 	EMP_ID,
			EMP_NAME,
			EMAIL,
			JOB_ID,
			DEPT_ID
FROM		employee;

SELECT *
FROM emp_view;


-- UPDATE
-- 테이블에 포함된 기존 데이터를 수정 (건 수는 수정 X)

/*
UPDATE 	TABLE_NAME
SET		COLUMN_NAME = VALUE, [COLUMN_NAME = VALUE]
WHERE		CONDITION;
*/

SELECT		*
FROM			employee;

-- 심하균의 직급, 부서, 급여를 성해교의 직급, 부서, 급여로 업데이트?
UPDATE	employee
SET		JOB_ID = (SELECT JOB_ID
						 FROM employee	
						 WHERE EMP_NAME = '성해교'),
			DEPT_ID = (SELECT DEPT_ID
						 FROM employee	
						 WHERE EMP_NAME = '성해교'),
			SALARY = (SELECT SALARY
						 FROM employee	
						 WHERE EMP_NAME = '성해교')
WHERE		EMP_NAME = '심하균';

UPDATE 	employee
SET		marriage = DEFAULT
WHERE		EMP_NAME = '나승원';


-- DELETE : 테이블에 포함된 데이터 삭제
-- 행 단위로 삭제되므로 행 수가 달라짐
-- 참조무결성 주의
/*
DELETE [FROM] 	TABLE_NAME
WHERE				CONDITION;
*/

DELETE FROM department
WHERE			DEPT_ID = 20;




-- DDL 실습과제
-- 1
CREATE TABLE customers (
	cno		INT PRIMARY KEY ,
	cname		VARCHAR(10)	NOT NULL,
	address	VARCHAR(50)	NOT NULL,
	email		VARCHAR(20)	NOT NULL,
	phone		VARCHAR(20) NOT NULL
);

CREATE TABLE products (
	pno	INT	PRIMARY KEY,
	pname	VARCHAR(20)	NOT NULL,
	cost	INT	NOT NULL,
	stock	INT	NOT NULL 
);

CREATE TABLE orders (
	orderno		INT			PRIMARY KEY,
	orderdate	DATE			DEFAULT SYSDATE(),
	address		VARCHAR(50)	NOT NULL,
	phone			VARCHAR(20)	NOT NULL,
	STATUS		VARCHAR(20)	NOT NULL CHECK( STATUS IN ('결제완료', '배송중', '배송완료')),
	cno			INT,
	FOREIGN KEY	(cno) REFERENCES customers(cno)
);

CREATE TABLE orderdetail (
	orderno		INT			,
	pno			INT			,
	qty			INT 			DEFAULT 0,
	cost			INT			DEFAULT 0,
	PRIMARY KEY	(orderno, pno),
	FOREIGN KEY	(orderno) REFERENCES orders(orderno),
	FOREIGN KEY	(pno) REFERENCES products(pno)
);

-- 2 
INSERT INTO products VALUES 
(1001, '삼양라면', 1000, 200),
(1002, '새우깡', 1500, 500),
(1003, '월드콘', 2000, 350),
(1004, '빼빼로', 		2000, 700),
(1005, '코카콜라',81000, 550),
(1006, '환타', 		1600 ,300)
;

-- 3
INSERT INTO customers VALUES 
(101, '김철수', '서울 강남구', 'cskim@naver.com', '899-6666'),
(102, '이영희', '부산 서면', 'yhlee@empal.com', '355-8882'),
(103, '최진국', '제주 동광양', 'jkchoi@gmail.com', '852-5764'),
(104, '강준호', '강릉 홍제동', 'jhkang@hanmail.com', '559-7777'),
(105, '민병국', '대전 전민동', 'bgmin@hotmail.com', '559-8741'),
(106, '오민수', '광주 북구', 'msoh@microsoft.com', '542-9988')
;

-- 4
INSERT INTO orders VALUES
(1, 
SYSDATE(), 
'서울 강남구', 
'899-6666', 
'결제완료', 
(SELECT cno FROM customers WHERE cname = '김철수'))

INSERT INTO orderdetail VALUES
(
	1,
	(SELECT pno FROM products WHERE pname = '삼양라면'),
	50,
	1000
);

-- 5
UPDATE 	products
SET 		stock = 150
WHERE		pno = 1001;

-- 6
INSERT INTO orders VALUES
(2, 
SYSDATE(), 
'서울 강남구', 
'337-5000', 
'결제완료', 
(SELECT cno FROM customers WHERE cname = '이영희'))

INSERT INTO orderdetail VALUES
(
	2,
	(SELECT pno FROM products WHERE pname = '새우깡'),
	100,
	1500
);
INSERT INTO orderdetail VALUES
(
	2,
	(SELECT pno FROM products WHERE pname = '월드콘'),
	150,
	2000
);

-- 7
UPDATE 	products
SET 		stock = 400
WHERE		pno = 1002;
UPDATE 	products
SET 		stock = 200
WHERE		pno = 1003;

-- 8
INSERT INTO orders VALUES
(3, 
SYSDATE(), 
'광주 북구', 
'652-2277', 
'결제완료', 
(SELECT cno FROM customers WHERE cname = '오민수'))

INSERT INTO orderdetail VALUES
(
	3,
	(SELECT pno FROM products WHERE pname = '빼빼로'),
	100,
	2000
);
INSERT INTO orderdetail VALUES
(
	3,
	(SELECT pno FROM products WHERE pname = '코카콜라'),
	50,
	1800
);

-- 9
UPDATE 	products
SET 		stock = 600
WHERE		pno = 1004;
UPDATE 	products
SET 		stock = 500
WHERE		pno = 1005;

-- 10
SELECT 	O.orderdate,
			C.cname,
			C.address,
			C.phone,
			O.`STATUS`,
			P.pname,
			OD.cost,
			OD.qty,
			OD.cost * OD.qty
FROM 		customers C
JOIN		orders O 		ON (C.cno = O.cno)
JOIN 		orderdetail OD	ON (O.orderno = OD.orderno)
JOIN		products P		ON (P.pno = OD.pno);

-- 11
SELECT orderdate,
		 SUM(OD.cost*OD.qty)
FROM orders O
JOIN	orderdetail OD ON (O.orderno = OD.orderno)
GROUP BY orderdate;

-- 12
INSERT INTO products VALUES 
(1007, '목캔디', 3000, 500);

SELECT *
FROM products;

-- 13
INSERT INTO orders VALUES
(4, 
SYSDATE(), 
'제주 동광양', 
'352-4657', 
'결제완료', 
(SELECT cno FROM customers WHERE cname = '최진국'));

INSERT INTO orderdetail VALUES
(
	4,
	(SELECT pno FROM products WHERE pname = '목캔디'),
	200,
	3000
);


-- DDL 실습과제 2
-- 1
CREATE TABLE MEMBER (
	member_id		INT				PRIMARY KEY,
	name				VARCHAR(25)		NOT NULL,
	address			VARCHAR(100),
	city				VARCHAR(30),
	phone				VARCHAR(15),
	join_date		DATE				DEFAULT SYSDATE() NOT NULL
);

CREATE TABLE title (
	title_id			INT				PRIMARY KEY,
	title				VARCHAR(60)		NOT NULL,
	description		VARCHAR(400)	NOT NULL,
	rating			VARCHAR(20)		CHECK	( rating IN ('18가', '15가', '12가', '전체가') ),
	category			VARCHAR(20)		CHECK	( category IN ('드라마', '코미디', '액션', '아동', 'SF', '다큐멘터리') ),
	release_date	DATE	
);

CREATE TABLE title_copy (
	copy_id			INT,
	title_id			INT,
	STATUS			VARCHAR(20)		NOT NULL CHECK	( STATUS IN ('대여가능', '파손', '대여중', '예약')),
	PRIMARY KEY (copy_id, title_id),
	FOREIGN KEY (title_id) REFERENCES title(title_id)
);

CREATE TABLE rental (
	book_date		DATE		DEFAULT SYSDATE(),
	member_id		INT,
	copy_id			INT,
	title_id			INT,
	act_ret_date	DATE,
	exp_ret_date	DATE		DEFAULT ADDDATE(SYSDATE(), INTERVAL 2 DAY ),
	PRIMARY KEY		(book_date, member_id, copy_id, title_id),
	FOREIGN KEY	(member_id) REFERENCES MEMBER(member_id),
	FOREIGN KEY	(copy_id) REFERENCES title_copy(copy_id),
	FOREIGN KEY	(title_id) REFERENCES title_copy(title_id)	
);

CREATE TABLE reservation (
	res_date		DATE,
	member_id	INT,
	title_id		INT, 
	PRIMARY KEY	(res_date, member_id, title_id),
	FOREIGN KEY	(member_id) REFERENCES MEMBER(member_id),
	FOREIGN KEY	(title_id) REFERENCES title_copy(title_id)	
);

-- 2
CREATE VIEW member_id_seq
AS
SELECT 

SELECT *
FROM title;



CREATE TABLE BLOG_TBL(
ID INT AUTO_INCREMENT PRIMARY KEY,
TITLE VARCHAR(50) NOT NULL ,
CONTENT VARCHAR(1000) NOT NULL
);

INSERT INTO blog_tbl(TITLE, CONTENT) VALUES
('강사님 짱!!', '냉무'),
('내일은 불금이다', '즐기자'),
('배고프다', '마라탕~ 콜') ;


UPDATE 	blog_tbl
SET		title = 'test', content='test'
WHERE		id = 5;

SELECT id, title, content
FROM blog_tbl
WHERE id = 5;

SELECT *
FROM blog_tbl;

DROP TABLE blog_comments_tbl;


CREATE TABLE blog_comments_tbl (
	id		INT	AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(1000)	NOT NULL ,
	blog_id INT NOT NULL ,
	FOREIGN KEY	(blog_id) REFERENCES blog_tbl(id)	
);

SELECT *
FROM blog_comments_tbl;

INSERT INTO blog_comments_tbl(content, blog_id) VALUES
('hooooooo', 1),
('wow', 1);


SELECT *
FROM user_entity;

SELECT *
FROM blog_entity;

SELECT *
FROM comment_entity;

INSERT INTO blog_entity(title, content, author_email) VALUES
('title~', 'test content~', 'a@a.a');

INSERT INTO comment_entity(blog_id, COMMENT) VALUES
(1, "second comment~~");
