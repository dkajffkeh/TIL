GET : 리소스를 조회하며 Server 측에서는 캐싱 기능이 권장됩니다. <br>
메서드는 서버의 리소스를 변환하지 말아야 하며 여러번 보낸다고 해서 리소스의 상태에 변화를 일으키면 안됩니다.

POST : 서버에 새로운 리소스를 생성하거나 기존 리소스에 데이터를 제출할 때 사용됩니다. <br>
주로 리소스의 생성 작업에 사용되며 서버 상태에 변경이 일어압니다. 기본적으로 캐싱기능을 제공하지 않습니다.

PUT : 리소스를 생성, 기존 리소스 전체를 업데이트 할때 사용합니다. <br>
같은 요청 여러번에 결과가 동일 해야합니다 (멱등성 보장)

PATCH : 서버에 있는 리소스의 일부만 부분적으로 업데이트 할때 사용합니다. <br>
멱등성을 보장합니다.

DELETE : 리소스를 삭제할때 사용합니다. <br>
멱등성을 보장합니다.

HEAD : GET 요청과 동일하지만 응답 본문을 포함하지 않습니다. <br>

OPTIONS : 서버에 대한 지원되는 메서드를 확인할때 사용합니다. <br>
