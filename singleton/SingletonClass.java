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
