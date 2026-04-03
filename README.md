# 모집 참여 동시성 처리 튜토리얼

## 소개
이 프로젝트는 캠퍼스 밥 친구 서비스의 모집 참여 기능에서 발생하는 동시성 문제를 해결하기 위한 예제입니다.

## 주제 선정 이유
모집 기능에서는 동시에 여러 사용자가 참여 요청을 보낼 수 있습니다.
이때 별도의 동시성 처리가 없으면 정원 초과 문제가 발생할 수 있습니다.
본 예제는 JPA의 @Version을 이용한 낙관적 락으로 이 문제를 해결합니다.

## 사용 기술
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- IntelliJ IDEA

## 프로젝트 구조
- domain: 엔티티와 상태값 정의
- repository: DB 접근
- service: 모집 참여 비즈니스 로직
- controller: API 요청 처리
- exception: 예외 처리

## 핵심 기능
- 모집 참여 처리
- 정원 초과 방지
- 모집 상태 FULL 전환
- 낙관적 락 적용

## 실행 방법
1. IntelliJ에서 프로젝트를 연다.
2. Gradle 의존성 다운로드를 기다린다.
3. Application 클래스를 실행한다.
4. Postman에서 아래 API를 호출한다.

## 테스트 API
POST /posts/1/join

예시:
http://localhost:8080/posts/1/join

## 기대 결과
- 첫 요청: 참여 완료
- 이후 요청: 이미 모집이 완료되었습니다.
