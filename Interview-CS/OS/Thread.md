### 스레드란

단일 프로세스에서 진행되는 작업 흐름의 단위 하나의 프로세스는 최소 1개의 스레드를 가진다.

### 멀티 스레드

멀티 스레드란 하나의 프로세스 내부에 N 개의 작업 수행 스레드를 두는 것을 말합니다.

### 스레드 컨텍스트 스위칭

스레드는 프로세스를 생성하는것보다 메모리 용량이 훨씬 가볍고 생성 삭제시 프로세스 내부의 자원만을 이용하여 관리하기 때문에 

생성 제거가 훨씬 빠르다.

쓰레드의 컨텍스트 스위칭은 CPU 캐시메모리를 비우는 과정이 아닌 캐시메모리를 그대로 활용 할 수 있는 장점이 있어

오버헤드 발생시 비용이 현저히 줄어든다. (stack 과 Register) 만 교체하면 된다.

