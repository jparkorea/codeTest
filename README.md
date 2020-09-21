<a name="top">

# codeTest

</a>

## 목차

#### [1. 프로젝트 설명](#about_project)
#### [2. 기능](#functions)
#### [3. 아키텍처](#architecture)
#### [4. 외부 라이브러리](#dependency)
#### [5. 실행 가이드](#install_guide)


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
 - 로그인
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

 > dependency
 - spring-web : 톰캣, webmvc 등
 - thymeleaf : 타임리프 템플릿 엔진(view)
 - h2 database : InMemory DB
 - spring-data-jpa : aop, jdbc, jpa
 - devtools : 개발할 때 유용한 라이브러리
 - lombok Java 코드 컴파일 시 자동으로 추가 메서드 생성

[맨 위로 가기](#top)
</br>

</br>

<a name="install_guide">

### 5. 실행 가이드

</a>

실행방법
1) 'cmd' 창을 열어 프로젝트의 pom.xml이 있는 경로로 이동

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

4) target\codeTest-0.0.1.war 경로로 이동 후 프로젝트 실행
```
java -jar codeTest-0.0.1.war (--kakao.rest.api={Your Rest API Key})
```
* Rest API 키 획득은 아래 경로 참조
```
# Kakao Rest API
# Reference Site -> https://developers.kakao.com/docs/latest/ko/local/dev-guide
```
[맨 위로 가기](#top)
</br>


##### TODO
 - 테스트 코드 작성
 - 버전 상향
