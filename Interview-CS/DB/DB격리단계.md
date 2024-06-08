### DB 격리 단계 Isolation

총 4가지의 단계가 있습니다 
가장 격리 수준이 높은 순으로
Serializable
Repeatable Read
Read Committed
마지막으로 가장 낮은 경리 수준을 갖는
Read Uncommitted 가 있습니다.

Serializable 은 가장 고순위 격리 단계로 여러 트랜잭션이 동일한 레코드로 접근할 수 없으며 어떠한
데이터 부정합도 발생하지 않는 격리 단계입니다.








