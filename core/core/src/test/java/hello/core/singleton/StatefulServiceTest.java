package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자가 10000을 주문
        statefulService1.order("userA", 10000);
        //ThreadB: B사용자가 20000을 주문
        statefulService2.order("userB", 20000);
        
        //ThreadA: 사용자A가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);


        /*
        원래 목적은 사용자A의 가격을 출력하고 싶었지만, 출력시 사용자B의 가격이 나온다.
        이럴때는 statefulService에서 private으로 price를 설정하지말고
        메소드를 int로 반환하고
        statefulService1.order("userA", 10000); -> int orderAPrice = statefulService1.order("userA", 10000);
        이런식으로 지역변수로 새로선언해 사용하면 해결 가능하다.
         */


    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}