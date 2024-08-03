## GC 란

필요 없게 된 메모리 객체를 주기적으로 제거 하는 프로세스 입니다.

힙영역이 주로 가비지 컬렉션이 대상이 되는 공간이며 객체는 대부분 일회성이며 메모리에 오랫동안 남아있는 경우는 드물다는 것을

기본 설계로 작동합니다.

힙메모리는 Young generation 과 Old Generation 논리적 구조로 설계 되어 있으며  

Young Generation 은 새롭게 생성된 객체가 할당되는 영역이며 GC 가 작동할때 Reachable 상태를 오랫동안 유지 한 객체는 Old Generation 으로 이동하게 됩니다.

- Parallel GC

패러랠 GC 는 Minor GC 즉 Young Generation 에서 Unreachable 상태의 객체를 제거하는 작업을 병렬로 처리하는 방식이며
GC 발생시 Stop the world 시간을 줄이기 위해 멀티 쓰레드로 작업을 처리합니다.

Old Generation 메모리 제거가 일어날때는 full GC 가 일어나기 때문에 대용량 배치, 멀티코어 환경에서 도입 할 수 있는 GC 입니다.

- G1 GC

G1 GC 는 Young Generation 과 Old Generation 을 논리적으로 구분하지 않고 Heap 영역을 Region 으로 나누어 관리하는 방식입니다.
각 스레드가 STW 시간을 줄이기 위해 할당된 region 을 잡고 GC 작업을 병렬로 수행하는 방식입니다.
