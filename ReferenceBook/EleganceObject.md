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

> 이 챕터는 객체를 다른 객체와 상호작용할 수 있도록 준비시키시 위해 필요한 원칙을 설명합니다.
> 이 챕터에서 설명할 문장은 객체는 작아야 한다 로 요약할 수있다.

### 2.1 가능하다면 적게 캡슐화 하세요
> 4개 또는 그 이하의 객체를 캡슐화 할것을 권장한다. 더 많은 객체를 캡슐화 해야 한다면 클래스에 문제가 있는것이다.

객체를 식별할 수 있는 방법, 이 세계에서 특정 객체를 식별하는 방법은 항상 단순하게 구성한다. 이름과 생년월일 또는
자동차 제조번호와 모델명, 또는 번호판과 차종으로 나뉠 수도 있다.
객체또한 하나의 객체를 식별하는 속성이 다량으로 존재한다면 매우 난해하며 객체간에 같다 라고 할 수 있는 포인트가 매우 모호해진다.

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

위와같은 코드에서 Employee 클래스와 Cash 클래스에서 Cash 가 변경되던 교체되던 아무런 영향도 없습니다.
이는 클래스를 느슨하게 분리되었다 라는 의미입니다. 클래스 안에 모든 퍼블릭 메서드가 인터페이스를 구현하도록 만들어여 한다고 책은 
제안하고있다.

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
이와같이 두 클래스 모두 한줄이 종료 될때 EOL 객체를 이용할 수 있다.
또한 위와같이 코드를 작성했을 경우 변경에도 유연하게 대응 할 수 있다.

```java
class EOLString {

    private final String origin;

    EOLString(String src) {
        this.origin = src;
    }

    @Override
    String toString() {
        if(os.window()) {
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

```java

    public static void main(String[] args) {

        Map<Cash, String> map = new HashMap<>();
        Cash five = new Cash(5);
        Cash ten = new Cash(10);
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

불변객체 에 대한 규약을 지키지 않은 경우 

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

