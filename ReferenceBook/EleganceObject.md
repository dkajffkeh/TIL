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

위와 같은 코드에서는 부 생성자가 주 생성자를 호출 하는 방식으로 구현이 되었다 아래는 그와같은 규칙을 따르지 않았을때를 봐보도록하자

```java
class Cash {

    private int dollars;

    // 주생성자
    Cash(int dollars) {
        this.dollars = dollars;
    }

    Cash(float dollar) {
        this.dollars = (int) dollar;
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

객체 초기화에는 코드가 없어야 하고 인자를 건드려서는 안된다. 기본생성자는 어떤 일을 수행하는 곳이 아니기 때문에 생성자 안에 인자에게 어떠한 작업을 하도록 요청해서는 안된다.

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
Cash cash=new Cash("5");
        int dollars=cash.intValue();
        int dollars2=cash.intValue();
```

두번째 케이스에서 intValue 를 사용할 경우

```java
Cash cash=new Cash("5");
        int dollars=num.intValue();
        int dollars2=num.intValue();
```

첫번째 케이스에서는 intValue 를 얻을 경우 생성자에서 파싱을 한번 하지만 두번째 케이스에서는 파싱을 2번 해야한다

아니 그러면 생성자에 코드가 들어가있는게 더 코드 효율이 좋은것 아닌가 라고 할 수 있다 아래 예시를 보자

- 생성자에 코드가 있을경우 성능최적화가 불가능해진다

객체를 생성하는 시점에 parsing 이라는 코드는 불가피하게 실행되어야만 한다. 하지만 인자를 레핑하고 인자를 보존 했다면 클래스의 사용자들이 파싱 시점을 자유롭게 결정할 수
있다.

예를 들어 파싱에 대한 로직이 매우 오래걸릴 경우 캐싱을 통해 최적화를 해나갈 수 있는 여지가 생긴다.

올바르게 설계된 객체지향 소프트웨어를 보면 다음과 같은 형태를 자주 보게 된다

```java
App app=new App(new Data(),new Screen());
        app.run();
```

app 이 생성될때 어떠한 일도 처리하지 않는다. 그저 App 을 실행시키지 위한 준비과정만 있을 뿐이다.

위와같은 룰을 지키기 위해서는 가장 중요하게 주 생성자에는 코드가 존재해서는 안된다는 사실이다.

## 챕터 2 교육

> 이 챕터는 객체를 다른 객체와 상호작용할 수 있도록 준비시키시 위해 필요한 원칙을 설명합니다.
> 이 챕터에서 설명할 문장은 객체는 작아야 한다 로 요약할 수있다.

### 2.1 가능하다면 적게 캡슐화 하세요

> 4개 또는 그 이하의 객체를 캡슐화 할것을 권장한다. 더 많은 객체를 캡슐화 해야 한다면 클래스에 문제가 있는것이다.

객체를 식별할 수 있는 방법, 이 세계에서 특정 객체를 식별하는 방법은 항상 단순하게 구성한다. 이름과 생년월일 또는 자동차 제조번호와 모델명, 또는 번호판과 차종으로 나뉠 수도
있다. 객체또한 하나의 객체를 식별하는 속성이 다량으로 존재한다면 매우 난해하며 객체간에 같다 라고 할 수 있는 포인트가 매우 모호해진다.

### 2.2 최소한 뭔가는 캡슐화 하세요.

객체가 그 무엇도 캡슐화 하지 않는다면 객체의 좌표가 없을 뿐더러 존재해야 하는 타당한 이유또한 존재하지 않는다.

### 2.3 항상 인터페이스를 사용하세요.

객체는 서로 필요관계에 의해 서로 결합된다. 하지만 결합도가 증가할수록 유지보수성에 영향을 미치게 된다.

기술적인 관점에서 객체 분리란 상호작용 하는 다른 객체를 수정하지 않고도 해당 객체를 수정할 수 있는것을 말한다.

```java
class DefaultCash implements Cash {

    private int dollars;

    DefaultCash(int dlr) {
        this.dollars = dlr;
    }

    @Override
    Cash multiply(float factor) {
        return DefaultCash(this.dollars * factor);
    }
}

class Employee {

    private Cash salary;
}
```

위와같은 코드에서 Employee 클래스와 Cash 클래스에서 Cash 가 변경되던 교체되던 아무런 영향도 없습니다. 이는 클래스를 느슨하게 분리되었다 라는 의미입니다. 클래스
안에 모든 퍼블릭 메서드가 인터페이스를 구현하도록 만들어여 한다고 책은 제안하고있다.

```java
class Cash {

    public int cents() {
        ...
    }
}
```

위와같은 코드는 Cash 에 의존하고 있는 객체가 Cash.cents 를 사용할 수 밖에 없기때문에 이 클래스에 강하게 결합되도록 조장한다.

---
---

### 2.4 메서드 이름을 신중히 선택하세요

> 빌더의 이름은 명사, 조정자의 이름은 동사로 짓는다.

빌더는 뭔가를 만들고 새로운 객체를 반환하는 메서드를 가리킨다. 빌더는 절때 void 가 될 수 없으며 이름은 항상 명사 여야 한다.

```text
int pow(int base, int power)
float speed()
Employee employee(int id);
String parsedCell(int x, int y);
형용사 + 명사 -> 규칙에 위배되지 않음.
```

실제 엔티티를 수정하는 메서드를 조정자 라고 부른다. 조정자의 반환 타입은 void 이고 이름은 항상 동사입니다.

```text
void save(String content);
void put(String key, Float value)
```

이 책에서는 jpa 또는 Collection Map 객체에 사용되는 메서드 또한 잘못됐다고 표현하고 있다.

```text
int save(Object content);
boolean put(K key, V value);
```

setter 와 getter 는 동사이지만 특정 반환값을 갖는 빌더이다.

***어떤것을 반환하는 메서드 명을 동사로 짓는것은 잘못된 방법이다.***

#### 2.4.1 빌더는 명사다

우린 커피숍에가서 브라우니 요리해주세요, 커피 끓여주세요 라고 주문하지 않는다. 단지 커피 하나요, 브라우니요 라고 요구한다.

```text
올바르게 지은 메서드 이름은 사용자들이 객체를 설계한 목적 객체가 수행하야 하는 임무 객체의 존재 목적과 살아가는 의미를 더 잘 
이해할 수 있도록 해준다.

int add(int x, int y) -> int sum(int x, int y) add 대신 sum 으로 바꾸는게 참 하찮아 보일 순 있지만 
실제로 규약을 따르는 컨벤션에선 매우큰 차이를 만들어내게 된다.
```

#### 2.4.2 조정자는 동사다

```text
조정자가 반환값을 갖는다면 바텐더에게 음악 볼륨을 높인후에 음악 볼륨을 알려주세요 라고 말하는것과 같다.
```

***빌더 사용시 with 로 시작하는 메서드를 사용해도 좋다***

#### 2.4.3 조정자와 빌더 혼합하기

```text
Book withAuthor(String author); -> (BookWithAuthor) 의 줄인말이다.

빌더와 조정자가 동시에 필요하다면 조정자 이후 빌더를 호출 하는 방식으로 구현하면 아주 간단하게 해결이 가능하다.
```

#### 2.4.4 Boolean 리턴인경우

```text
값을 반환하기 때문에 이 메서드 들은 빌더에 속하지만 가독성 측면에서 형용사로 지어야한다.
boolean empty();
boolean readable();
boolean negative();
```

***메서드는 빌더 또는 조정자 둘중 하나의 역할만 하며 빌더와 조정자의 역할을 동시에 하게 해선 안된다.***

### 2.4 퍼블릭 상수(public static final)를 사용하지 마세요.

```text
객체는 독립적이고 닫혀있어야 한다, 하지만 퍼블릭 상수는 이와같은 룰을 역행한다.
```

흔히 우리는 static 상수를 중복을 해결하기 위해 사용한다.

```java
class Records {

    private static final String EOL = "\r\n"
    ...
}

class Rows {

    private static final String EOL = "\r\n"
    ...
}
```

위 코드에서 중복이 발생했다. 하지만 이를 해결하기 위해 아래와 같이

```java
public class Constants {

    public static final String EOL = "\r\n";
}
```

으로 코딩하였을때 중복코드는 해결 되었지만 결합도가 높아졌으며 위와같은 방법이 아니라면 코드 응집도가 낮아지게 된다.

위와같이 EOL 을 수정 했다면 위 코드를 사용하고 있는 객체에서 어떤 변화가 일어날지 전혀 예측할 수 가 없다.

상수대신 새로운 기능을 공유할 새로운 클래스를 만들어야 합니다.

```java
class EOLString {

    private final String origin;

    EOLString(String src) {
        this.origin = src;
    }

    @Override
    String toString() {
        return String.format("\r\n", origin);
    }
}
```

이와같이 두 클래스 모두 한줄이 종료 될때 EOL 객체를 이용할 수 있다. 또한 위와같이 코드를 작성했을 경우 변경에도 유연하게 대응 할 수 있다.

```java
class EOLString {

    private final String origin;

    EOLString(String src) {
        this.origin = src;
    }

    @Override
    String toString() {
        if (os.window()) {
            /* Exception */
        }
        return String.format("\r\n", origin);
    }
}
```

```text
수백개의 단순한 상수 문자열 리터럴 대신 수백개의 마이크로 클래스를 만들어야 하며 클래스 사이에 중복 코드가 없다면
클래스가 작아질수록 코드는 더 깔끔해진다. 퍼블릭 상수를 절대로 사용하지 말자.
```

### 2.6 불변객체를 만드세요

> 불변객체란 간단하게 객체를 생성후 상태 변경이 불가능한 객체를 말한다.

```java
class MutableCash {

    private int dollars;

    public void setDollars(int val) {
        this.dollars = val
    }
}

class ImmutableCash {

    private int dollars;

    ImmutableCash(int val) {
        this.dollars = val;
    }
}
```

불변객체의 수정이 일어나야 한다면 새로운 객체를 생성해야 한다.

```java
class ImmutableCash {

    private int dollars;

    ImmutableCash(int val) {
        this.dollars = val;
    }

    public Cash multiple(int factor) {
        return new ImmutableCash(this.dollars * factor);
    }
}
```

#### 2.6.1 식별자 가변성

```java

public static void main(String[]args){

        Map<Cash, String> map=new HashMap<>();
        Cash five=new Cash(5);
        Cash ten=new Cash(10);
        map.put(five,"five");
        map.put(ten,"ten");
        System.out.println(map);
        }

public static class Cash {

    private int dollars;

    public Cash(int dlr) {
        this.dollars = dlr;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getDollars() {
        return dollars;
    }

    public void mul(int factor) {
        this.dollars *= factor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cash cash = (Cash) o;
        return dollars == cash.dollars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dollars);
    }

    @Override
    public String toString() {
        return "Cash{" +
                "dollars=" + dollars +
                '}';
    }
}
```

불변객체 에 대한 규약을 지키지 않은 경우 map.get(five) 를 호출했을때 ten 과 five 둘중 하나가 리턴될것입니다.

이는 식별자 가변성 으로 알려져있으며 매우 심각하고 찾기 어려운 버그로 이어질 수 있다.

#### 2.6.2 실패 원자성

> 사실 이부분에 대해 동의되지 않은 부분이 있어 이부분은 추후 정리해보려한다.

#### 2.6.3 시간적 결합

불변객체를 사용하지 않을경우 하나의 라이프 사이클을 갖는 컬럼들에 대한 수정이 이뤄지기 어렵다

ex)

```text
Cash price = new Cash();
// 30줄 의 코드
price.setDollars(x);
// 30줄 의 코드
price.setCents(y);
// 30줄 의 코드
이와같은 코드일때 setDollars 가 실행된 이후 setCents 가 실행되어야 하도록 개발되어있다면 이는
전적으로 코드를 핸들링 하는 개발자가 추론해 내야하며 추론이 잘못되었을경우 버그를 야기시킬 가능성이 매우 높다.
```

#### 2.6.4 부수효과 제거

불변클래스가 아닐경우 작성한 메서드가 객체의 프로퍼티를 변경함과 동시에 다른 2 ~ 3 가지 역할을 수행할경우 이를 찾아내기 너무 어렵다.

```text
void print(Cash price) {
  print...("price");
  price.mul(2);
  print("Buy now!!");
}
```

와 같이 프린트를 함과 동시에 가격까지 변동하는 코드를 작성했다 가정했을때 문제가 발생한 지점을 찾아내기 매우 어려운 상황이 오게 된다.

#### 2.6.5 null 참조 없애기

```java
class User {

    private final int id;
    private String name = null;

    public User(int num) {
        this.is = num;
    }

    public void setName(String txt) {
        this.name = txt;
    }
}
```

위와같은 코드에서 우리는 name 이 null 인지를 채크하는 문장으로 꽉찰것입니다. 자칫 이러한 로직을 빼먹을경우 NPE 를 숨쉬듯 보게될것입니다.

커다란 클래스를 만드는 이유는 우리가 문제를 더 작은 부분으로 분해하기 위해 상속과 캡슐화를 어떻게 사용해야 하는 지를 모르기 때문이다.

#### 2.6.6 스레드 안정성

흔히 아래와 같은 코드를 작성을 하는 경우는 드물겠지만 2개의 스레드가 동시에 접근할경우 전혀 예상치 못한 값을 반환할 수 있다.

```java
final Cash cash=new Cash(15,10);

final CountDownLatch cdl=new CountDownLatch(1);

final Callable<Object> script=new Callable<>(){

@Override
public Object call()throws Exception{
        start.await();
        cash.mul();
        System.out.println(cash);
        return null;
        }
        }

final ExecutorSErvice svc=Executors.newCachedThreadPool();
        svc.submit(scrit);
        svc.submit(scrit);
        svc.submit(scrit);
        start.count();
```

위와같은 코드 실행시 60 120 이 출력되는등 중구 난방의 결과값을 확인할 수 있다.

#### 2.6.7 작고 더 단순한 객체

java 에서 허용 가능한 클래스의 최대 크기는 주석과 공백을 포함해서 250줄 정도라고 저자는 생각한다. 불변객체를 설계하려면 클래스단위가 아주 작아햐 합니다.

### 2.7 문서를 작성하는 대신 클래스를 만드세요

단위테스트는 독립적인 개체가 아니라 해당 클래스의 일부이다. 깔끔하고 유지보수 가능한 단위 테스트를 추가하면 클래스를 더 깔끔하게 만들 수 있고 유지 보수성을 향상시킬 수 있다.

### 2.8 Mock 대신 Fake 객체를 사용하세요

모킹은 매우 안좋은 프랙티스 이며 최후의 수단으로만 사용해야한다. 페이크 클래스 사용시 테스트를 더 짧게 만들 수 있기 때문에 유지보수성이 눈에 띄게 향상됩니다.

또한 코킹은 가정을 사실로 전환하기 떄문에 단위테스트를 유지보수하기 어렵게 만듭니다.

```java
Exchange exchane=Mockito.mock(Exchange.class);
        Mockito.doReturn(1.15)
        .when(exchange)
        .rate("USD","EUR");
```

위 코드는 Exchange.rate(); 를 호출하리라고 가정한다. 전체 테스트는 위와같은 가정에 기반한다. Cash 가 Exchange 를 위존하고 있지만 우린 Cash 가 어떤
방식으로 작동하는지 모른다. Exchange 를 전혀 사용하지 않을 수도있다. 이는 불확실한 가정을 기반으로 테스트를 작성하고 있는것이다.

클래스가 변경되면 단위 테스트는 코드 리팩토링에 큰 도임이 된다 하지만 동시에 행동이 변경되지 않을 경우에는 테스트가 실패해서는 안된다.

클래스가 공개한 public 메서드가 변경되지 않았을경우 이유없이 실패해서는 절대 안된다. 하지만 Mock 을 사용할경우 테스트는 이유없이 실패할 수 있습니다.

위 Exchange 클래스가 아래와 같이 규격이 변경되었다고 해보자

```java
interface Exchange {

    float rate(String target);

    float rate(String origin, String target)
}
```

Mock 객체의 경우 이러한 변화에 대해 유연하게 대처할 수 없을뿐더러 클래스 변화에 대해 감지해 낼 수 없지만 Fake 객체인 경우 이러한 변화를 감지해낼 수 있다.

Mocking 은 나쁜프랙티스이며 우리의 가정을 모위 객체 안에 하드코딩한 채 작업을 끝내버린다.

의존하고 있는객체가 의존만 하고있지 실제로 사용하고 있지 않을수도 있습니다. 우리가 만드는 클래스에 Fake 객체까지 함께 만들어 제공하는 역량을 갈러야한다.

### 2.9 인터페이스를 짧게 유지하고 스마트를 사용하세요.

인터페이스는 구현 클래스가 준수하는 계약이다.

```java
interface Exchange {

    float rate(String target);

    float rate(String source, String target);
}
```

위에 제시된 아주 간단한 인터페이스는 너무 많은것을 요구하기 때문에 좋지 못한 설계이다.

구현자에게 너무 많은것을 요구하는 클래스를 제공하게 된다.

두 rate 메서드는 매우 밀접하게 연관되어 있지만 사실 매우 독립적인 함수입니다.

이를 해결하기 위해 smart 클래스를 추가해서 해결할 수 있다.

```java
interface Exchange {

    float rate(String target, String source);

    class Smart {

        private final Exchange origin;
        ctor...

        public float toUsd(String source) {
            return this.origin.rate(source, "USD");
        }
    }
}
```

위와 같은 코드 작성시 해당 interface 를 상속하는 구현체는 공통 로직을 갖고있으며 인터페이스는 작고 높은 응집도를 유지할 수 있다.

## 3 취업

### 3.1 5개 이하의 public 메서드만 노출하라

> 작은 클래스를 유지하는것에 초점을 맞추도록 하자.

### 3.2 정적메서드를 사용하지 마세요

> 정적메서드를 제공 하는 대신 클래스를 제공하라

#### 3.2.1 객체 대 컴퓨터 사고

객체와 컴퓨터 사고의 차이점은 객체는 정의되는것이지만 컴퓨터 사고에서는 순차적으로 실행된다는 차이가 있습니다.

OOP 의 정적 메서드는 정확하게 C 와 어셈블리어의 서브루틴과 동일한 성격을 띕니다.

#### 3.2.2 선언형 스타일과 명령형 스타일

```text
int y = Math.between(5,9,13);
Number y = new Between(5,9,13);
```

정적메서드를 사용했을때는 그 즉시 리턴을 하는 즉 CPU 에 바로 명령을 내리는 방식으로 코드가 수행된다.

선언형 방식이 명령방식보다 좋은 이유는 무엇을까

- 선언형 방식은 성능을 최적화 할 수 있는 서브 로직을 넣을 수 있다(앞에서 다룬 내용과 비슷)
- 다형성 이라는 속성을 이용할 수 있다.

```text
Math.between(x, y, z);
의 경우 Math 클래스를 상속해도 static 클래스인 between 이라는 메서드를 오버라이드 할 수 없다.

하지만 선언형 방식의 new Between(x, y, z).xxx(); 와 같은 경우의 코드는 언제든 다형성 속성을 유지할 수 있다.
```

- 정적메서느들 필이 사용 해야 할정도로 유명한 라이브러리가 있다면 감싸는 클래스를 만들어 정적 로직을 고립시킬 수 있다.

```java
import java.util.Iterator;

class FileLine implements Iterable<String> {

    private final File file;
    public Iterator<String> iterator

    {
        return Arrays.asList(FileUtils.readLines(this.file)).iterator();
    }
}
```

#### 3.2.3 유틸리티 클래스

> Util 클래스를 사용하는것을 절대로 피해야 하지만 만약 구현해야 한다면 기본생성자를 private 으로 선언하여 객체 생성을 막는것
> 을 추천한다.

#### 3.2.4 싱글톤(singleton) 패턴

// To Read 싱글톤에 대해 정확히 회의적인 입장이지만 정확한 의도 파악에 어려움 .. 언제 다시 읽어보도록 하자

#### 3.2.5 함수형 프로그래밍

> FP 보단 OOP 가 표현력면에서 더 뛰어나고 강력한 힘을 발휘하고 있다.

#### 3.2.6 데코레이터

객체들의 전체적인 행동은 내부 캡슐화하고 있는 객체들에 의해 유도된다. 이런 객체들의 조합을 조합가능한 데코레이터라 한다.

***위에 설명한 모든 내용들에 대해 정적메서드를 사용한다면 위에 설명한 모든 장점들을 살릴 수 없다.***

### 3.3 인자값으로 절대 NULL 을 허용하지 마세요.

```text
public Iterable<File> find(String mask) {
    if(mask == null) ...
    else ...
}
```

위와같은 코드는 객체에게 이야기하는 대신 피하고 무시합니다. 객체에게 당신과 이야기할 가치가 있나요? 라고 묻는것이다. 심지어 객체에게 직점 질의 하지도 않습니다.

```text
public Iterable<File> find(Mask mask) {
    if(mask.isEmpty()) ...
    else ...
}
```

객체가 null 을 허용하는 순간 == null 과 같은 비교문을 사용할 수 밖에 없고 객체가 맡아야할 상당량의 역할을 뺏어가버린다.

Null 을 반환하는 경우라면 비어있는 것처럼 행동하는 객체를 반드시 리턴하도록 하라.

### 3.5 절대 getter setter 를 사용하지 마세요

getter setter 의 사용은 모든 객체가 불변함을 유지해야하는 룰에 크게 위배됩니다.

#### 3.5.1 객체 대 자료구조

자료구조라 함은 class 속성에 직접적으로 접근하여 어떤 의사소통도 없이 이를 얻고 수정합니다.

하지만 객체는 맴버에 접근하는 것을 허용하지 않습니다. 게다가 자신의 맴버를 노출하지도 않습니다. 이것이 바로 캡슐화 이며 OOP 가 지향하는 가장 중요한 설계 원칙 중
하나입니다.

자료구조는 클래스 박스 이지만 객체는 블랙 박스입니다. 객체지향적이고 스타일을 유지하기 위해서는 데이터를 객체 안에 감추고 절대로 외부에 노출시켜선 안됩니다. 정확히 데이터를
발가벗겨진 상태로 두어서는 안됩니다.

### Sub 생성자 밖에서는 new 를 사용하지 마세요.

```java
class Cash {

    private final int dollars;

    public int euro() {
        return new Exchange().rate("USD", "EUR") * this.dollars;
    }
}
```

이 코드에서 new Exchange() 라는 클래스가 생성될때마다 미 뉴욕 증권거레소 서버에 요청을 보낸다고 가정했을때

위 코드를 테스트를 할때마다 미 증권거래소에 대해 요청을 하게 된다. 이 문제의 근본 원인은 new 연산자에 있다.

이는 객체가 필요한 의존성을 직접 생성하는것이 아닌 생성자를 통해 직접 주입을 하는 방법으로 해결 할 수 있다.

```java
class Requests {

    private final Socket socket;
    private final Mapping<String, Request> mapping;

    public Requests(Socket skt) {
        this(skt, new Mapping<String, Request>() {
            @Override
            public Request map(String data) {
                return new SilpleRequest(data);
            }
        });
    }

    public Requests(Socket socket, Mapping<String, Request> map) {
        this.socket = skt;
        this.mapping = mag;
    }
}
```

메서드나 주 생성자 안에서 new 를 사용하는 순간 뭔가 잘못하고 있다는 사실을 떠올려야한다.

***주 생성자에 new 를 선언하는 순간 다형성을 사용할 수 없어진다.***

### 3.7 인트로펙션과 캐스팅을 피하라

인트로펙션은 리플렉션 이라는 더 포괄적인 용어로 불리는 여러 가지 기법들 중 하나입니다.

리플렉션을 사용할경우 메서드 명령어 구문 클래스 객체 타입등을 동적으로 변경 할 수 있습니다. 코드를 유지보수 하기 어렵게 
만드는 매우 너저분한 기법입니다. 런타임에 다른 코드에 의해 수정된다는 사실을 항상 기억해야 한다면 코드를 읽기가 매우 어려울 것입니다.

## 4장 은퇴

### 4.1 Null 을 반환하지 마라

```text
null 을 반환하는 순간 객체에 신뢰도가 떨어지며 무책임하며 유지보수성이 떨어지는 코드를 작성하게 되는것이다.
```

#### 4.1.1 빠르게 실패하기 vs 안전하게 실패하기

***안전하게 실패하기***
> 안전하게 실패하는것은 버그, 입출력문제 메모리 오버플로우가 발생하더라고 소프트웨어가 계속 실행될 수 있도록 최대한 많은
> 노력을 기울일 것을 권장하는 방법이다.

***안전하게 실패하기***
> 문제가 발생하면 곧바로 해당 스레드를 종료시키며 예외를 던지는것입니다.

소프트웨어가 결점을 감추지 않고 노출시키며 중단지점을 명확히 할 수 있다면 단위 테스트와 실패 상황을 손쉡게 재현할 수 있을것입니다.

#### 4.1.2 Null 의 대안 

1. null 을 리턴하는 경우 비어있는 컬렉션을 리턴하여 해당 객체가 비었는지에 대해 메시지를 전달 할 수 있도록 처리한다.
2. 예외를 던지거나 빈 컬렉션을 반환하거나 속성이 Null 인 객체를 반환하도록 한다. 절대 return null; 을 선언하지 말자

### 4.2 체크 예와 만 던지세요

#### 4.2.1 꼭 필요한 경우가 아니라면 예외를 잡지 마세요.

> 가능하면 예외를 더 높은 레밸로 전파하여 모든 catch 문에 납득할 수 있는 이유가 있어야합니다.
> 반드시 예외를 잡아야 하는 이유가 있거나 다른 선택의 여지가 없는 경우가 아니라면 예외를 잡아서는 안된다.

안전한 코드 로직과 결과에 동떨어진 리턴문을 갖는것은 결국엔 해당 데이터가 문제를 야기시키며 그 값이 어디서부터 시작되어

문제가 발생되었는가를 찾기가 너무 어려워진다.

#### 4.2.2 항상 예외를 체이닝하세요.

```java
cath (IOException e) {
    throw new Exception("some messgae");
}
```
위 코드에서서는 예외를 잡은 즉시 새로운 예외를 던집니다. 이와 같은 예외 체이닝은 휼륭한 프랙티스로 분류됩니다.

```java
cath (IOException e) {
    // ex 무시
    // 새로운 메시지를 가지는 새로운 타입의 코드 생성
    throw new Exception("의미 없는 메세지");
}
```

문제를 발생시킨 근본 원인에 관한 매우 가치있는 정보를 손실시키는 예외를 던지지 말자

예외 체이닝은 하나의 메세지로 표현해내기 어렵기때문에 열린파일이 많음 -> 파일 길이를 계산할 수 없음 -> 이미지를 읽을 수 없음

과 같은 메시지를 확인 할 수 있게 된다.

#### 4.2.3 단 한번만 복구하세요

무조건 예외를 잡아서는 안된다는 주장은 전적으로 옳지는 않으며 에러복구를 진행한다면 런타임 환경으로 넘어가기 직전
main 함수에서 예외를 복구하기를 추천한다.
가장 최상위 수준에서 오직 한번만 복구한다.

### final 이거나 abstract 이거나

상속의 가독성과 코드의 본질을 해치는것은 일부 메서드에 대해 오버라이딩 했을때 발생한다.
같은 속성과 서로 데이터를 의존하고 있을경우에는 서로 final 키워드를 붙여 상속을 막던지 아니면 Interface 를 생성하여

같은 속성의 메서드가 함꼐 움직이도록 설계 해야한다.
