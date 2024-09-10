## GC 란

필요 없게 된 메모리 객체를 힙영역을 타겟으로 주기적으로 제거 하는 프로세스 입니다.

- STW (stop the world)

GC 가 발생하면 GC 작업을 위해 JVM 이 애플리케이션 실행을 멈추는 시간을 의미합니다.
GC 작업이 끝나면 다시 애플리케이션 실행을 재개합니다.

Heap 메모리는 GC 알고리즘 종류에 따라 차이가 있지만 Young generation 과 Old Generation
으로 나눠지며 오래된 객체는 금방 접근 불가능한 상태가 되며
오래된 객체는 젊은 객체로부터 참조가 되는경우는 드물다 라는 가설 하에 힙 영역을 2가지로 분류 합니다.

- Parallel GC (Mark and Sweep Compact)

java8 의 default GC, 마이너 GC 즉 young generation 클린이 일어날때
멀티스레드로 Heap 영역을 청소하지만 메이저 GC 가 일어날때에는 단일 스레드로 처리된다.

- G1 GC (Garbage First)
java 9 이상부터 default GC 로 사용됩니다.

G1 GC 는 heap 영역을 region 으로 나누어 관리되며
region 의 크기는 개발자가 설정할 수 있고 JVM 이 작동할대 정해지며 변하지 않습니다.

