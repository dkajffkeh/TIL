### DB 격리 단계 Isolation

총 4가지의 단계가 있습니다 
가장 격리 수준이 높은 순으로
Serializable
Repeatable Read
Read Committed
마지막으로 가장 낮은 경리 수준을 갖는
Read Uncommitted 가 있습니다.

Serializable 은 가장 고순위 격리 단계 이며
Read Level 에서는 S-lock
Write Level 에서는 X-lock 을 사용합니다.

select update 의 경우 하나의 thread 가 리소스를 점유하기 때문에 성능이슈가 발생할 수 있으며 정말 높은 수준의
격리 단계를 유지 해야할때 도입을 검토 할 수 있는 단계입니다.

Repeatable Read 는
트랜젝션이 시작할때 자신보다 낮은 트랜잭션 번호를 갖는 트랜잭션에서 커밋한 데이터만 읽을 수 있는 격리 수준입니다.

Read Committed 커밋된 데이터로만 접근할 수 있게 하는 격리 수준 입니다.
이경우 None Repeatable Read 가 발생할 수 있습니다. (Select 문을 두번 실행했을때 결과가 다르게 나올 수 있음)

Read Uncommitted 는 가장 낮은 격리 수준으로 커밋되지 않은 데이터도 읽을 수 있는 격리 수준입니다.

