# 엘레강트 오브젝트
<p align="center"><img src="images/Elegance Object.png" width="300" align="center"/></p>

### 서론

> TDD 클린코드 With java 16 기 강의를 수강하며 많은 도움이 되었다는 리뷰가 있어 함께 공부해보고자 한다. 위 책은 객체의 라이프 사이클에 대한 설명을 
> 출생/학습/취업/은퇴 순으로 정리하고있다.


## 1장 출생

### 1.1 -er,-or 로 끝나는 이름을 사용하지마세요

```text
개념상 팩토리 패턴과 new 연산자가 크게 다르지 않다. 
클래스는 객체의 팩토리 이다.

클래스의 이름은 객체가 노출하고 있는 기능에 기반해서는 안된다.
무엇을 하는지 가 아니라 무엇인지 에 기반해야 한다.

객체는 역량으로 특정지어야 하며 세부적인 속성이 주가 되선 안된다 할 수 있을 일에 집중하여 명명하자
```

```text
객체는 내부와 외부를 이어주는 연결장치(Connector)가 아니다. 캡슐화된 데이터의 대표자 역할을 해야한다.

클래스에 대해 이름을 붙일 때는 무엇을 하는지 가 아니라 무엇인지 를 생각해야 한다.

다시 정리하자면 객체는 무엇을 하는존재가 아닌 객체가 갖고있는 데이터의 대표자이다.

하지만 예외 조항으론 User 와 Computer 와 같은부분은 -er 과 같은 명명 규칙을 사용하지만 그 데이터들의 대표자로
정의될 수 있다.
```

---
---

### 1.2 생성자를 주 생성자로 만드세요

```text
생성자의 수가 메서드 보다 더 많아 질 수 있다 

응집도가 높고 견고한 클래스 에서 적은 수의 메서드와 많은 수의 생성자가 존재한다.

생성자가 많아질수록 클래스를 더 유연하게 만들며 메서드가 많아질수록 단일책임 원칙을 위반하기 쉬워진다.
```
***Root 기본생성자 [책 표현 생성자를 지칭 -> (ctor)]***
> 프로퍼티를 초기화 하는 일은 단 하나의 ctor(이하 생성자) 에만 위치시키고 주 생성자라 부르고 부 생성자는 주 생성자를
> 호출하여 객체를 생성한다.

```java
class Cash {

    private int dollars;

    // 주생성자
    Cash(int dollars) {
        this.dollars = dollars;
    }

    Cash(float dollar) {
        this((int) dollar);
    }

    Cash(String dlr) {
        this(parseInt(dlr));
    }
}
```
위와 같은 코드에서는 부 생성자가 주 생성자를 호출 하는 방식으로 구현이 되었다 아래는 그와같은 규칙을 따르지 않았을때를
봐보도록하자

```java
class Cash {

    private int dollars;

    // 주생성자
    Cash(int dollars) {
        this.dollars = dollars;
    }

    Cash(float dollar) {
        this.dollars = (int)dollar;
    }

    Cash(String dlr) {
        this.dollars = parseInt(dlr);
    }
}
```
(Wrong Case) 위와같은 경우 모든 생성자에 validation 처리가 있어야함을 의마한다. 

---
---

### 1.3 생성자에 코드를 넣지 마세요

***생성자에 코드를 넣지 말라는 의미는 생성자 인자에 손대지 말라는 의미이다.***

아래 코드는 인자에 손을 댄 코드이다

```java
class Cash {
    private int dollars;
    
    Cash(String dlr) {
        this.dollars = parseInt(dlr);
    }
}
```
객체 초기화에는 코드가 없어야 하고 인자를 건드려서는 안된다. 기본생성자는 어떤 일을 수행하는 곳이 아니기 때문에
생성자 안에 인자에게 어떠한 작업을 하도록 요청해서는 안된다.

위와같은 코드가 꼭 필요하다면 주 생성자와 부 생성자를 분리 한다면 위와같은 위배 코드를 방지할 수 있다. 

아래와같은 예로도 인자를 건들지 않고 동일한 작업을 수행할 수 있다
```java
class Cash {
    private Number dollars;

    Cash(String dlr) {
        this.dollars = parseInt(dlr);
    }
    
    private static class StringAsInteger implements Number {
        private String source;
        
        StringAsInteger(String src) {
            this.source = src;
        }
        
        int intValue() {
            return Integer.parseInt(this.source);
        }
    }
}
```
dlr 이라는 변수로 유입된 인자를 하나도 건들이지 않고 객체에 할당할 수 있다.

***자 그렇다면 인자를 생성자에서 수정한부분과 인자를 수정하지 않은 부분은 어떤 차이가 있을까***

1. 첫번쨰 케이스
```java
class Cash {
    private int dollars;
    
    Cash(String dlr) {
        this.dollars = parseInt(dlr);
    }
    
    public int intValue() {
        return this.dollars;
    }
}
```
2. 두번째 케이스
```java
class Cash {
    private Number dollars;

    Cash(String dlr) {
        this.dollars = parseInt(dlr);
    }
    
    public static class StringAsInteger implements Number {
        private String source;
        
        StringAsInteger(String src) {
            this.source = src;
        }
        
        int intValue() {
            return Integer.parseInt(this.source);
        }
    }
}
```

첫번째 케이스에서 intValue 를 사용할 경우
```java
Cash cash = new Cash("5");
int dollars = cash.intValue();
int dollars2 = cash.intValue();
```
두번째 케이스에서 intValue 를 사용할 경우
```java
Cash cash = new Cash("5");
int dollars = num.intValue();
int dollars2 = num.intValue();
```

첫번째 케이스에서는 intValue 를 얻을 경우 생성자에서 파싱을 한번 하지만 두번째 케이스에서는 파싱을 2번 해야한다

아니 그러면 생성자에 코드가 들어가있는게 더 코드 효율이 좋은것 아닌가 라고 할 수 있다 아래 예시를 보자

- 생성자에 코드가 있을경우 성능최적화가 불가능해진다

객체를 생성하는 시점에 parsing 이라는 코드는 불가피하게 실행되어야만 한다. 하지만 인자를 레핑하고 인자를 보존 했다면 
클래스의 사용자들이 파싱 시점을 자유롭게 결정할 수 있다.

예를 들어 파싱에 대한 로직이 매우 오래걸릴 경우 캐싱을 통해 최적화를 해나갈 수 있는 여지가 생긴다.

올바르게 설계된 객체지향 소프트웨어를 보면 다음과 같은 형태를 자주 보게 된다
```java
App app = new App(new Data(), new Screen());
app.run();
```

app 이 생성될때 어떠한 일도 처리하지 않는다. 그저 App 을 실행시키지 위한 준비과정만 있을 뿐이다.

위와같은 룰을 지키기 위해서는 가장 중요하게 주 생성자에는 코드가 존재해서는 안된다는 사실이다.

## 챕터 2 교육



<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

