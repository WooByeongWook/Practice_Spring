package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//


//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean   //TimeTraceAop 에서 @Component를 통해 bean에 등록하는 것보다 이방식을 더선호함
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//       return new MemoryMemberRepository();
//       return new JdbcMemberRepository(dataSource);
//       return new JdbcMemberRepository(dataSource);
//       return new JpaMemberRepository(em);

//    }
}
