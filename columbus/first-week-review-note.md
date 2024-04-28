# 1주차 오답노트

다른 사람의 코드를 보고 풀었거나 정리하고 싶은 문제를 정리하시오.

# 1. 문제설명

![img.png](img.png)

- 두 숫자의 입력을 받고,  이 숫자 사이의 소수를 모두 출력하는 문제이다.

1. 접근 방식

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputChunk = br.readLine().split(" ");

        int start = Integer.parseInt(inputChunk[0]);
        int end = Integer.parseInt(inputChunk[1]);

        int[] numberArr = new int[end];

        for(int i = 0; i < numberArr.length; i++) {
            numberArr[i] = i + 1;
        }

        for(int i = 1; i < end / 2; i ++) {
            if (numberArr[i - 1] == 0) continue;
            for(int j = 0; j < numberArr.length; j++) {
                if(numberArr[j] == 1) {
                    numberArr[j] = 0;
                    break;
                }
                if(numberArr[j] == i) {
                    continue;
                }
                if(numberArr[j] % i == 0) {
                    numberArr[j] = 0;
                }
            }
        }
        for (int j : numberArr) {
            if (j != 0 && (j >= start && j <= end)) {
                System.out.println(j);
            }
        }
    }
}

```

결과: 시간초과

###틀린이유 설명

M 의 최소 : 1 <br>
N 의 최소 : 1,000,000 <br>
이라고 가정하였을때 

for loop 에 값을 대입해본다면

```java
       for(int i = 1; i < 500_000; i ++) {
            if (numberArr[i - 1] == 0) continue;
            for(int j = 0; j < 1_000_000; j++) {
                if(numberArr[j] == 1) {
                    numberArr[j] = 0;
                    break;
                }
                if(numberArr[j] == i) {
                    continue;
                }
                if(numberArr[j] % i == 0) {
                    numberArr[j] = 0;
                }
            }
        }
```
위와같이 0으로 바꾼 값을 처리 한다 하여도 과도한 loop 를 돌아야만 결과에 도출할 수 있다.




