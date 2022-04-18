# REST 방식의 스프링 배치

## REST API 애플리케이션 만들기

### 필요한 의존성
* Spring Batch
* MySQL Driver
* Spring Web



REST API 를 작성할 때 SimpleJobLauncher를 사용한다
@EnableBatchProcessing을 적용하면 스프링 배치가 ㅅ제공하는 SimpleJobLauncher를 바로 사용가능하다.