### Array 와 List 의 차이

- Array 는 메모리 상에 데이터가 연속적으로 저장되고 List 는 메모리상에 데이터가 비 연속적으로 저장된다. <br>
Array 와 LinkedList 의 차이가 있는 것

Array 는 고정된 크기를 가지며 논리적저장 (코드상에 존재하는 인덱스) 와 물리적 저장(실제 메모리에 저장되는)
순서가 일치 합니다.

삽입 삭제의 경우 재정렬 작업이 필요 하기 때문에 O(N) 의 시간복잡도를 가진다.

원소에 접근할때는 Index 를 통해 접근하기 때문에 O(1) 의 시간 복잡도를 가진다.

참조 시역성: CPU 가 짧은 시간 범위 내에 일정 구간의 메모리 영역을 반복적으로 참조하는 경향, 짧은 시간 동안에는
메모리에 균일하게 접근하기 보다는 특정 부분에 집중 참조하는 경향을 지님

시간 지역성과 공간 지역성으로 나뉨

시간 적으로 볼때 프로세스에서 현재 참조된 메모리 주소의 근처에 있는 주소를 참조할 확률이 높다.

공간 지역성

메모리 주소를 참조할때 근처에 있는 주소를 참조할 확률이 높다.

따라서 실제 ArrayList 는 메모리상에 연속적으로 저장되어 있기 때문에 CPU 의 캐시 메모리 효율이 좋다.

---

List 는 메모리상에 데이터가 연속적으로 저장되지 않고 다음 노드의 주소를 가지고 있는 형태로 저장됩니다.

원소에 접근할때 O(N) 의 접근성을 가지며 삽입 삭제의 경우도 O(N) 의 시간 복잡도를 가집니다.

요소에 접근이 자주 접하지 않은경우, LinkedList 의 구현체인 Queue Stack 이 주로 사용 되어집니다.


