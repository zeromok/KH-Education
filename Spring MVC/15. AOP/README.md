# AOP(Aspect-Oriented Programming)
    관점-지향 프로그래밍
    Aspect 에 대해 이해하고 설정 및 예제를 생성하여 Advice를 실습했습니다.


- __Target__ : 핵심 비지니스 로직이 구현된 서비스 객체 (@Service, 비즈니스 계층의 서비스)


- __JoinPoint__ :  Target객체가 가지고 있는 메소드들


- __Advice__ : 횡단관심사(Cross-Concern)를 실제 구현한 기능 (예: 트랜잭션 처리)


- __Aspect__ : 구현해야할 핵심비지니스 로직은 아니지만, 개발할 때의 관심사(Cross-Concern, 횡단 관심사) : 이는 추상적인 의미일뿐이다.


- __Proxy__ : Target 의 JointPoint 수행시, 필요로 하는 Advice 들을 결합시켜, 하나로 수행시키는 객체 (필수조건: Target과 동일하게 보여야 함. 즉, 타입, 메소드 모두 Target(서비스객체)과 동일하게 갖추고 잇어야 함)
    > 서비스 인터페이스를 구현한 Impl을 주입받는게 아닌 서비스 인터페이스를 똑같이 구현한 Proxy를 주입받는것 이다.
  Proxy가 Impl의 구현된 메소드를 수행시킨다.
  왜 이렇게 해 놓았을까? Advice는 실제 구현된 메소드를 수행시키기 전/후 처리를 해야하므로...


- __PointCut__ : 어느 Target의, 어느 JointPoint에 ,어떤Advice를 적용시킬지를 결정하는 방법







