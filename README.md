# 🚀 Spring Boot 백엔드 스터디 템플릿 프로젝트

이 저장소는 Java Spring Boot 백엔드 스터디(주니어반)를 위한 템플릿 코드베이스입니다.

---

## 🛠 VS Code 개발 환경 설정 가이드

독립된 스터디 전용 프로필을 생성하여 쾌적한 개발 환경을 구축하는 방법입니다.

### 1. 스터디 전용 프로필 만들기 (최초 1회)
1. VS Code 좌측 하단 **⚙️ (설정 아이콘)** → **Profiles** → **Create Profile...** 클릭
2. 프로필 이름에 `Spring-Study` 입력 후 **[Create]** 클릭

### 2. 필수 확장 프로그램 자동 설치
* 이 프로젝트 폴더를 열면 우측 하단에 안내 팝업이 뜹니다.
* **"이 저장소에 대한 권장 확장 프로그램이 있습니다. 모두 설치하시겠습니까?"** → **[Install All]** 클릭

### 3. VS Code 하단 상태 표시줄 (Status Bar) 버튼 활용
`actboy168.tasks` 확장이 설치되면 하단 상태바의 버튼으로 손쉽게 명령을 실행할 수 있습니다:
* **`$(play) Boot Run`** (초록색): Spring Boot 서버 실행 (`./gradlew bootRun`)
* **`$(beaker) Run Tests`** (주황색): 전체 단위 테스트 실행 (`./gradlew test`)
* **`$(shield) Generate SBOM`** (파란색): CycloneDX SBOM 추출 (`./gradlew cyclonedxBom`)

---

## 📋 개발 환경 및 SBOM 버전 확인 가이드

스터디 진행 전, 본인의 개발 환경 및 라이브러리 버전이 표준 명세와 일치하는지 확인해 보세요.

### 1. 프로젝트 주요 버전 명세
* **Java / JDK**: Java 17 (JDK 17 LTS)
* **Spring Boot**: v4.1.0
* **Build Tool**: Gradle 9.5.1 (Wrapper)
* **SBOM Standard**: CycloneDX (v1.5 / v1.6 JSON)

### 2. 내 환경 및 라이브러리 버전을 맞춰보는 방법
```bash
# 1. 내 로컬 Java 및 Gradle 런타임 버전 확인
java -version
./gradlew --version

# 2. CycloneDX SBOM 생성 (의존성 라이브러리 버전 추출)
./gradlew cyclonedxBom

# 3. 생성된 SBOM에서 프로젝트 의존성 라이브러리 및 버전을 표준과 대조 확인
# 생성 경로: build/reports/cyclonedx/application.cdx.json
```

> 💡 **Tip**: 생성된 `application.cdx.json` 파일을 [SBOM Viewer (sbomviewer.com)](https://sbomviewer.com/) 사이트에 드래그 앤 드롭하면 시각적인 웹 화면으로 라이브러리 명세를 편리하게 조회할 수 있습니다.

---

## 🚀 프로젝트 실행 방법

```bash
# 1. 애플리케이션 실행 (Gradle)
./gradlew bootRun

# 2. CycloneDX SBOM 추출
./gradlew cyclonedxBom
```

* **서버 주소**: `http://localhost:8080`
* **CycloneDX SBOM 파일 위치**: `build/reports/cyclonedx/application.cdx.json`
