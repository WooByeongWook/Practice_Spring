package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();    //static영역에 들어감(하나만 만들어져서 들어감).

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {    //private으로 다른곳에서 new로 쓸려는 것을 막음.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
