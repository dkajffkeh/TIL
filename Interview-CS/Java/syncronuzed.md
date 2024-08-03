### volatile 이란

volatile 키워드는 멀티쓰레드 환경에서 읽어들인 변수의 값이 CPU Cache 메모리가 아닌
메인 메모리에서 읽어들이도록 하는 키워드이다. 하지만 이또한 a 스레드에서 변경사항을 즉시 메인메모리로 반환하지 않는다면
b 스레드에서는 그 변경을 감지 할 수 없기 때문에 그 원자성을 보장하지 않는다.

Multi Thread 환경에서 하나의 Thread만 Read&Write 하고, 다른 Thread들은 Only Read가 보장되는 경우에 사용합니다.

만일 여러 Thread가 Write 하는 상황이라면 synchronized를 사용하여 원자성(atomic)을 보장해야 합니다.


