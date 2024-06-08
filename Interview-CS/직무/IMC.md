### 장애감지 시스템

### IMC (Integrated Message Center) (온프레미스)

IMC 시스템은 기업형 메시지를 제공을 해주는 서비스로 첫번째로 설치형 Agent 가 Client 에게 제공 되게 됩니다. <br>
Client 는 Agent 설치 서버와 DB 설치서버 최소 2대 를 구비하는것을 권장 하고 있으며 설치 서버가 방화벽 내부에 존재한다면
IMC 서버의 공인 IP 방화벽이 신청 되어있어야합니다.

Client 에 배포된 Agent 를 기동과 동시에 IMC 인증서버와 웹소켓 연결을을 시도하며 소켓연결이 완료 되었을 경우
Agent 에서는 IMC 서버로 계약시 발급 받았던 ID와 PWD 가 IMC 인증서버로 도착하게 됩니다. IMC 인증서버에서는
ID 와 PWD 그리고 출발지 IP 를 대조하여 인증 성공 실패 여부를 판별하며 인증에 성공했을 시 Message Enc Key 와
메시지 발송서버 port, 메시지 발송 결과 서버의 port 번호를 Response 로 받게 됩니다.

인증서버와의 통신 완료후 발송서버의 Port 와 결과 Response 서버의 Port 를 받은 경우 서버 정보를 토대로 Agent
는 발송서버, 리포트 서버와 웹소켓 연결을 체결합니다.

소캣 연결후 Agent DB 에 Insert 가 발생할 경우 Agent 는 Polling 방식을 이용하여 DB 에서 Select 후
Select 된 데이터를 Packet 이라는 객체로 만들어 Message Server 로 Frame 을 전달하게 됩니다.

Message 서버는 보통 접수 서버로 메세지 채널을 분류 하여 로드 벨런서 에서 구독하고 있는 토픽에 Data 를 프로듀싱 합니다
이때 보통 카프카 토픽은 통상 2개로 각 토픽별로 파티션은 10개로 구성되어있습니다.

저희는 발송 토픽 그룹이라는 것을 지정하는데 하나의 그룹에 여러개의 Kafka 토픽을 배정하여 1개의 Agent 에 할당하게 됩니다.
위 토픽을 그룹별로 나눈 이유는 토픽별 라운드 로빈으로 트레픽을 분산시키려는 의도도 있지만 실시간으로 발송 중계사를 바꾸기 위한 의도도 존재합니다.

그다음 Store 모듈에서는 이력을 적재하고 Agent 즉 Client 측으로 Report 를 전송하는 부분은
Report LoadBalancer 가 그 역을을 하여 Report-LB 는 ActiveMQ 에 Report 를 적재하는 역할을 담당합니다.
