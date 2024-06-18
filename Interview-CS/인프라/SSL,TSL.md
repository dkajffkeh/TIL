#### TLS Handshake 과정

TLS HandShake 과정이 선행 되기전 
TCP 3 way handshake 과정이 일어나게 됩니다.

Client 측에서는 SYNC 과 함께 임의의 seq 번호를 서버측에 보내고 연결 서버 측에서는 SYNC 를 잘 받았다 라는 의미로<br>
SYNC 에 담겨온 임의의 SEQ 에 1을 더하여 클라이언트 측으로 SYNC 와 Acknowledgement 를 전송하며 여기에도 임의의 SEQ 를 전달합니다.<br>
ACK 를 전달 받은 클라이언트는 연결을 맺을 서버에 ACK 를 전달하며 서버 측으로 부터 받은 SEQ 에 1을 더해 서버로 응답합니다<br>
위 과정을 통해 3 way handshake 과정으로 연결 Session 이 생성되며 이 이후 SSL Handshake 과정이 이뤄집니다.

먼저 Client Hello 를 서버로 전송하게 되는데 이 Client Hello 에는 <br> 
- Random 바이트
- 사용 가능한 Cipher 목록
- SSL Handshake Session Id
- SSL 버젼 
등이 포함됩니다. <br>

Client Hello 를 응답 받은 서버는 Server Hello 를 응답하게 되는데 아래와 같이 전송합니다.
- Random 바이트
- Client 로 받은 Cipher 방식중 하나를 채택하여 암호화 방식을 응답
- Server 에서 발행한 공개키와 CA 디지털 서명이 들어있는 SSL 인증서

Client 는 서버로 부터 받은 SSL 인증서를 CA 인증기관의 공개키를 이용하여 복호화 한 후 복호화에 성공 했다면 CA 인증기관에서 
서명한 것으로 간주 하게 됩니다.
CA 인증이 완료 되었다면 Client 측에서는 Client Hello 때 보낸 Random 바이트와 Sever Hello 때 받은 Random 바이트를 조합하여
임시키 즉 클라이언트에서 사용할 대칭키를 만든후 서버에서 보낸 공개키를 이용해 암호화 한후 서버측으로 전달하게 됩니다.

서버는 이 클라이언트로 전달받은 임시키로 키를 만들고 클라이언트 또한 이 임시키를 대칭키로 사용하게 됩니다.
서버가 대칭키 생성을 완료 했다면 Finish Packet 을 Client 에 전송하는 과정으로 SSL Handshake 과정이 종료됩니다.

SSL Handshake 의 목적은 이 대칭키를 각각 서버와 클라이언트가 소유 하는것에 있습니다.



