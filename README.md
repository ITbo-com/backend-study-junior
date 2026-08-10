# Spring Boot 백엔드 스터디 커리큘럼 예시 코드베이스

이 저장소는 Java Spring Boot 백엔드 스터디(주니어반)의 1주차부터 4주차까지의 진행 과정을 단계별로 담고 있는 예시 프로젝트입니다.

---

## 📌 깃 브랜치 체크포인트 (Branch Checkpoints)

각 주차별 학습 결과물은 전용 **Git Branch**로 분리되어 있어, 커리큘럼 진행에 맞춰 언제든지 해당 주차의 완성된 코드로 전환할 수 있습니다.

| 주차 | 브랜치 이름 | 학습 주제 | 커밋 메시지 (Conventional Commits) |
|---|---|---|---|
| **1주차** | `week1` | 요청과 응답, REST API 기초 (@PathVariable, @RequestParam, @RequestBody) | `feat(week1): add hello controller and user endpoints...` |
| **2주차** | `week2` | MVC 3계층 분리 (Controller-Service-Model) & 메모리 CRUD | `refactor(week2): separate 3 layers and implement memo crud...` |
| **3주차** | `week3` | 도메인형 패키지 구조 재배치 & Spring Data JPA + H2 DB 연동 | `feat(week3): restructure to domain-driven packages and integrate...` |
| **4주차** | `week4` / `main` | 전역 예외 처리, 공통 응답 포맷 통일, Bean Validation 적용 | `feat(week4): implement global exception handling, unified api...` |

---

## 🚀 브랜치 이동 가이드 (Git Checkout)

수강생들은 아래 명령어를 통해 각 주차별 코드 상태로 손쉽게 이동할 수 있습니다:

```bash
# 1주차 최종 코드로 이동
git checkout week1

# 2주차 최종 코드로 이동
git checkout week2

# 3주차 최종 코드로 이동
git checkout week3

# 4주차 (최종 완성본)로 이동
git checkout week4  # 또는 git checkout main
```

---

## 📂 주차별 주요 변경 내용 요약

### 1주차 (`week1`)
- `HelloController`: `GET /hello` 기본 응답 테스트
- `UserController`: `@PathVariable`, `@RequestParam`, `@RequestBody` 세 가지 파라미터 수신 방법 비교 실습

### 2주차 (`week2`)
- 3계층 (Controller -> Service -> Model) 구조 및 DTO 도입
- `MemoService` (메모리 `List<Memo>` 기반 메모장 CRUD 구현)

### 3주차 (`week3`)
- 계층형 패키지 구조에서 도메인형 패키지 구조 (`domain.user`, `domain.memo`)로 전환
- `Memo` 객체를 `@Entity`로 변환 및 `MemoRepository extends JpaRepository<Memo, Long>` 생성
- H2 인메모리 데이터베이스 및 H2 콘솔(`/h2-console`) 연동

### 4주차 (`week4` / `main`)
- `@RestControllerAdvice` 기반 `GlobalExceptionHandler` 작성
- `ApiResponse<T>` 객체를 통한 전역 응답 형태 표준화 (`success`, `data`, `message`)
- `@Valid` 및 Bean Validation(`@NotBlank`, `@Size`) 적용으로 요청 유효성 검증

---

## 🛠 실행 방법

```bash
# 프로젝트 빌드 및 실행 (Gradle)
./gradlew bootRun
```

- 서버 주소: `http://localhost:8080`
- H2 콘솔: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)
