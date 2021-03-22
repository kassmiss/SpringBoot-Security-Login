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
