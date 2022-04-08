# Singleton pattern

## Singloton pattern 이란?

- 같은 종류의 객체가 하나만 존재하도록 하여서 다른 코드에서 객체에 대한 단일 엑세스 지점을 제공하는 생성 디자인 패턴

## 구현

- Naive Singleton(single-threaded)
    ```java
    public final class Singleton {
        private static Singleton instance;
        private Singleton() {}
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
    ```
    가장 단순한 구현방법으로 생성자의 접근제어자를 private로 설정하여 외부에서 호출할 수 없도록 하고  
    static method를 이용하여 객체를 제공한다.


- Naive Singleton(multi-threaded)
    ```java
    public final class Singleton {
        private static Singleton instance;
        private Singleton() {}
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
    ```
    syncronized 키워드를 통해서 쓰레드의 접근을 제한하여 Thread safe하게 할 수 있다.  
    하지만, 이렇게 될 경우 method 접근에 대한 lock으로 인해 멀티쓰레드 환경에서 성능이 저하될 수 있다.

- Early initialaztion(multi-threaded)
    ```java
    public final class Singleton {
        private static Singleton INSTANCE = new Singleton();
        private Singleton() {}
        public static Singleton getInstance() {
            return INSTANCE;
        }
    }
    ```
    Early initialization을 통해서 객체를 미리 생성할 경우 Thread safe하게 할 수 있다.  
    하지만, 해당 인스턴스를 생성하는 것이 굉장히 무거운 행위이고 생성 후 사용을 잘 하지 않는다면 굉장한 낭비가 될 수 있다.

- Double Checked locking(multi-threaded)
    ```java
    public final class Singleton {
        private static volatile Singleton instance;
        private Singleton() {}
        public static Singleton getInstance() {
            if(instance == null) {
                synchronized (Singleton.class) {
                    if(instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    ```
    이 방법은 실제로 이해하기가 어려운 면이 있다. volatile이라는 키워드를 왜 써야하는 지?
    자바1.4의 메모리 등을 알아야하기 때문이다.

- static inner class
    ```java
    public class SingletonClass {
        private static SingletonClass instance;
    
        private static class SingletonClassHolder{
            private static final SingletonClass INSTANCE = new SingletonClass();
        }
    
        public static SingletonClass getInstance() {
            return SingletonClassHolder.INSTANCE;
        }
        private SingletonClass() {};
    }
    ```
    static inner class를 통해서 생성하는 것도 하나의 방법이다.

## Singleton을 깨트리는 방법

- reflection을 이용하여 접근제어자를 풀어준다.
    ```java
    import java.lang.reflect.Constructor;public class App {
        public static void main(String[] args) {
            SingletonClass singleton1 = SingletonClass.getInstance();
            
            Constructor<SingletonClass> constructor = SingletonClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonClass singleton2 = constructor.newInstance();
  
            System.out.println(singleton1 == singleton2); // false
        }
    }
    ```
- object가 역직렬화될 경우 new를 이용해 새로운 객체를 생성하므로 싱글톤패턴이 꺠지게 된다.
  - 이 경우에는 readResolve method를 작성하여 방지할 수 있다.
  

## Enum 이용하기

- enum을 이용하게 되면 꺠지지 않는 singleton을 만들 수 있게 된다.
- enum을 내부적으로 reflection을 통해서 새로운 객체를 생성할 수 없기 떄문에 완벽한 singleton을 구현할 수 있다.
- 하지만 enum은 상속 받을 수 없고, Early initialization 된다는 것이 단점이다.