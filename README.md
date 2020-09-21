<a name="top">

# codeTest

</a>

## 목차

#### [1. 프로젝트 설명](#about_project)
#### [2. 기능](#functions)
#### [3. 아키텍처](#architecture)
#### [4. 외부 라이브러리](#dependency)
#### [5. 실행 가이드](#install_guide)
#### [6. 테스트 가이드](#test_guide)


</br>

<a name="about_project">

### 1. 프로젝트 설명

</a>

 > OpenAPI를 이용한 장소 검색 서비스
 
[맨 위로 가기](#top)
</br>

</br>

<a name="functions">

### 2. 기능
 - 로그인/로그아웃
 - 키워드로 장소 검색
 - 검색된 장소 리스트
 - 인기 검색어 목록
 
</a>


[맨 위로 가기](#top)
</br>

</br>

<a name="architecture">

### 3. 아키텍처

</a>

![Architecture](https://user-images.githubusercontent.com/24487772/93759119-98d08700-fc44-11ea-9b93-da5d9cbd9b3a.PNG)

##### 기술 스택
 - Spring Boot
 - JAVA 1.8
 - H2 DB
 - Spring JPA
 - Maven
 - Thymeleaf

[맨 위로 가기](#top)
</br>

</br>

<a name="dependency">

### 4. 의존성
</a>

![dependencies](https://user-images.githubusercontent.com/24487772/93759147-a423b280-fc44-11ea-8d72-ca858dd6ccf1.PNG)

 > dependency
 - spring-web : 톰캣, webmvc 등
 - thymeleaf : 타임리프 템플릿 엔진(view)
 - h2 database : InMemory DB
 - spring-security : 로그인/로그아웃 시 사용
 - spring-data-jpa : aop, jdbc, jpa
 - org.json : API에서 전달받은 값을 DTO와 매핑
 - devtools : 개발할 때 유용한 라이브러리
 - lombok : Java 코드 컴파일 시 자동으로 추가 메서드 생성

[맨 위로 가기](#top)
</br>

</br>

<a name="install_guide">

### 5. 실행 가이드

</a>

실행방법
1) 'cmd' 창을 열어 프로젝트의 pom.xml이 있는 경로로 이동(/codeTest/pom.xml)

2) maven 프로젝트 빌드 수행
```
mvn javacc:javacc
```
```
mvn clean install
```

##### Properties
3) 발급받은 API Key를 `application.properties` 혹은 실행 시 옵션에 추가합니다.
```
kakao.rest.api={Your Rest API Key}
```

4) target/codeTest-0.0.1.war 경로로 이동 후 프로젝트 실행
 - `application.properties`를 수정하지 않은 상태에서 키 값을 옵션으로 주지 않고 실행 시, 서버 에러가 발생합니다.
```
java -jar codeTest-0.0.1.war (--kakao.rest.api={Your Rest API Key})
```
* Rest API 키 획득은 다음 경로 참조 : <https://developers.kakao.com/docs/latest/ko/local/dev-guide>

[맨 위로 가기](#top)
</br>

<a name="test_guide">

### 6. 테스트 가이드

</a>

 > 최초 로그인
 - 계정 : `admin/admin`
 
 > DB 접속 정보
 - 계정 : `sa/(비밀번호 없음)`
 - 콘솔 경로 : <http://localhost:8080/h2_db>
 
[맨 위로 가기](#top)
</br>

빌드 결과물 : <https://github.com/jparkorea/codeTest/releases>

##### TODO
 - 테스트 코드 작성
 - 버전 상향
