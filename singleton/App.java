public class App {
    public static void main(String[] args) {
        NormalClass instance1 = new NormalClass();
        NormalClass instance2 = new NormalClass();
        System.out.println(instance1 == instance2); // false

        // 이렇듯 new를 통해서 생생시킨 instance는 다를 수 밖에 없다.
        // 따라서 new keyword를 사용하지 못하도록 생성자를 private로 선언한다.

        // SingletonClass singletonClass1 = new SingletonClass();
        // 'SingletonClass()' has private access in 'com.designpattern.singleton.SingletonClass'
        // 위와 같이 싱글톤 클래스의 경우에는 private로 되어 있어서 접근할 수가 없다.
        // 따라서 객체를 생성할 수 있는 새로운 방법을 제공해야한다.
        SingletonClass instance3 = SingletonClass.getInstance();
        SingletonClass instance4 = SingletonClass.getInstance();
        System.out.println(instance3 == instance4); // true

        // 그러나 이 방법도 굉장한 문제를 가지고 있다.
        // 그건 바로 일반적인 웹 어플리케이션에서는 멀티 쓰레드 환경에서 동작하게 된다
        // 멀티 쓰레드 환경에서 Thread A가 if문을 통해서 객체 생성을 확인하고,
        // 객체 생성을 위해 if 블럭으로 진입한 순간 Thread B가 if문을 통해서 객체 생성을 확인하면,
        // 아직 객체가 생성되지 않은 시점이기 때문에 Thread B도 if 블럭으로 접근할 수 있게 된다.

        // 구현 방법
        // 1. syncronized 키워드를 이용하여 다른 Thread의 접근을 제한합니다.
        // 2. Early initialization(이른 초기화)해버리기.
        // 3. doulb checked locking 사용하기
        // 4. static inner class 사용하기
    }
}


