# 1주차 (기초 상식/문자열/기초 수학)

1️⃣ 알고리즘/자료구조란?

#### 알고리즘
```text
문제를 처리하는 단계적 절차 및 해결 방법
```

#### 자료구조
```text
프로그램에서 처리하는 데이터의 묶음을 조직화 하여 저장하고 관리하는 방식
```

2️⃣ 시간복잡도/공간복잡도/빅오 표기법이란?

#### 시간복잡도
- 특정 크기의 입력을 기준으로 할 때 필요한 연산의 횟수

#### 공간복잡도
- 알고리즘을 실행시키기 위해 필요한 메모리 공간,

#### Big-O 
```text
데이터 n 개가 주어졌을때 몇번의 연산 과정이 이뤄지는지를 표기하는 지표
```
[본인 작성글](https://velog.io/@dkajffkem/%EB%B9%85%EC%98%A4-%ED%91%9C%EA%B8%B0%EB%B2%95-Big-O-notation-%EC%A0%95%EB%A6%AC)

3️⃣ 다음 기능을 가진 함수를 본인 언어로 정리하시오.

1. 문자열 인덱싱 / 슬라이싱

```java
// indexing
char [] splited = "HelloWorld".toCharArray();

// slicing
String a = "HelloWorld";
a = a.substring(1,3);
System.out.println(a);
```

1. 특정 문자가 있는지 확인

```java

String value = "HelloWorld";
boolean hasValue = value.contains("He"); // true
int index = value.indexOf("He") // 0

```

1. 문자열이 같은지 비교

```java
String value1 = "A";
String value2 = "A";
boolean isEqual = value1.equals(value2); // true
boolean okCase = value1 == value2 // true
```

1. 문자열 길이 반환

```java
int length = "HelloWorld".length();
```

1. 특정 문자의 인덱스 값 찾기

```java
int startIndex = "HelloWorld".indexOf("He") // 0
```

1. 문자열을 구분자 기준으로 나누고 합치기

```java
String [] split = "H A D D".split(" ") // length -> 4 
String [] value = new String[]{"a","b","c"};
String joined = String.join("-", value);

```

1. 문자열 대소문자 변환

```java
"HelloWorld".toLowerCases();
"HelloWorld".toUpperCases();
```

1. 기존 값을 다른 값으로 치환

```java
System.out.println("HelloWorld".replaceAll("Hello", "World"));
```

1. 양쪽 끝에서 특정 문자(혹은 공백) 제거

```java
System.out.println("      a       ".trim());
```

1. 아스키코드로 변환 혹은 대소 비교

```java
int aschii = 'a';
char character = (char) ascii; 
```
