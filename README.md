# 패스트포워드 과제

1. 실행 방법
2. 환경
3. 과제 설명
---
## 1. 실행 방법

```shell
1. 서버 실행
docker compose up -d
2. API 요청 
curl --location --request POST 'localhost:8080/stock'
3. API 문서
http://localhost:8080/swagger-ui/index.html
```

## 2. 환경
- mysql:8.0.31
- OpenJDK:17
- SpringBoot:2.7.6

## 과제 설명
1. 호출하면 특정 API 호출 & 저장 & 결과를 return 하는 API를 만들었습니다.
2. Rest 에서 POST 와 GET 메소드 를 섞은 느낌이지만, 요구사항에 `저장` 및 `출력`이라고 되어있어서 저장에 초점을 맞춰서 `POST` 메소드를 선택했습니다.  
3. 주식데이터에서 `symbol(주식코드)` 값과 `timestamp(거래일자)` 는 테이블에서 업무적 PK 라고 생각되어서 복합키로 만들었습니다.
4. `Yahoo finance API` 호출을 `OpenFeign Client` 를 통해 HTTP 요청하도록 했습니다.
