# 스프링부트 + 스프링시큐리티 로그인 구현 (JPA, MariaDB, lombok)
## LoginController.java
페이지 이동, 기능 호출과 관련된 처리를 한다.
* /login : 로그인 페이지 이동
* /signup : 가입 페이지 이동
* /save : 사용자 저장

## LoginService.java, LoginRepository.java
LoginRepository 인터페이스에서 JPA에서 상속받을 수 있는 JpaRepository 클래스를 설정해두었을 때 이와 관련된 다양한 CRUD 기능을 쓸 수 있다.
이 경우 LoginService에서 LoginRepository의 save를 호출했을 때 LoginRepository 내에 save가 선언되어 있지 않아도 상속받은 JpaRepository의 save 기능을 쓸 수 있게 된다.
별도의 쿼리 없이 CRUD를 JPA 기법을 통해 사용하는 주요 예시다.

## SecurityConfig.java
스프링 시큐리티에서 핵심적인 부분이다. 접근 경로 및 호출에 대한 권한을 설정에 따라 자동으로 제어해준다.

## login.html
```html
<input type="text" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
```
스프링 시큐리티에서는 페이지를 호출할 때 token 값을 준다.
해당 token 값은 서버에 동일하게 저장되어 있는데 해당 페이지에서 특정 액션을 취할 때 처음 준 token 값과 서버의 token 값이 동일한지 비교하게 된다.
만약 다른경우 해당 액션이 처리되지 않는다. 이는 CSRF 공격을 방지하기 위한 방법이다.

# 확인필요
1. user_info 테이블의 생성 규칙은 어떻게 되는가? 고정인가? 아니면 도메인명에 따라 바뀌는가?
- 도메인의 UserInfo 클래스가 있다. 해당 클래스의 명칭에 따라 테이블명 규칙이 변경된다. UserInfo -> user_info, UserData -> user_data

