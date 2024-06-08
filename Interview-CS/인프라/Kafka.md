### 카프카 토픽이란
데이터를 구분하는 최소 단위

### 클러스터 구성은 어떻게 되어있나요
총 3개의 Kafka 노드로 구성

### Replica 설정 컨벤션은?
보통 상용 환경에서 파티션별 2개의 Replica 를 설정하고 있음

### 파티션 구성 컨벤션은?
컨슈머 그룹에 포함된 컨슈머 * 2

### 컨슈머 그룹이란?
동일한 토픽을 구독하는 컨수머들의 그룹

### 주키퍼의 역할
1. 클러스터 메타데이터 관리
   1. Kafka 클러스터의 메타데이터 관리 브로커 목록, 토픽정보, 파티션 삭제 및 복제 정보등을 관리
2. 파티션 리더 선출
   1. 파티션의 리더와 팔로워를 선출, 파티션 리더에 장애가 있는 경우 새로운 리더를 선출
3. 브로커 관리
   1. 브로커 장애시 새로운 브로커 리더 선출
4. 컨슈머 그룹 관리
   1. Kafka 초기 버젼에서는 오프셋 관리를 주키퍼가 진행 했지만 최근 Kafka 에서는 __consumer_offsets 라는 토픽을 내장 하여 offset 을 관리함.

```yaml
spring:
  kafka:
    bootstrap-servers:
      - 
      - 
      - 
    producer:
      batch-size: 20000
      compression-type: gzip
      buffer-memory: 33554432
      acks: 1
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
      properties:
        linger.ms: 10
    consumer:
      group-id: api-send-email
      enable-auto-commit: false
      max-poll-records: 300
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      auto-offset-reset: latest
      properties:
        max.poll.interval.ms: 600000
    listener:
      concurrency: 1
      ack-mode: manual_immediate
      poll-timeout: 3000
      type: single
```
