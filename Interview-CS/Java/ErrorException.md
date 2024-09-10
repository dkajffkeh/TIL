### 에러와 익셉션
 
Error 클래스는 Throwable 의 하위 클래스이며 코드상 프로그래머의 실수로 발생하는 예외 상황이 아닌 코드에서 복구할 수 없는

에러이며 JVM 자체의 문제로 인해 발생합니다. 

Error 는 try catch 문과 같은 코드레벨에서 처리 복구 하는것이 적절하지 않습니다.
OutOfMemoryError, StackOverflowError, NoClassDefFoundError 등이 Error 의 대표적인 예입니다.

Exception 은 항상 runtime 에서 발상하는 코드 에러로써 대표적으로 SqlException, NullPointException 등이 있습니다.

Exception 종류는 RuntimeException 을 상속하는 Unchecked Exception 과 그렇지 않은 Checked Exception 으로 나뉩니다.

Unchecked Exception 은 개발자의 코드 실수나 로직상에서 발생하며 예외 처리를 강제하지 않습니다.

checked Exception 은 컴파일러가 예외처리를 하도록 강제합니다. ex) IOException, SQLException, FileNotFoundException 등이 있습니다.

***NoClassDefFoundError, ClassNotFoundException 차이***

NoClassDefFounderError -> 컴파일 시점애는 클래스가 존재했지만 런타임 시점에 에러가 발생하여 클래스를 로드 하지 못한 경우

ClassNotFoundException -> 컴파일 시점에 클래스가 존재하지 않아서 클래스를 로드하지 못한 경우


