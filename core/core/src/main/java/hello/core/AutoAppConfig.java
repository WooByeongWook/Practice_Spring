package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", //member 패키지부터 하위 패키지로 찾아들어간다.
//        basePackageClasses = AutoAppConfig.class,

        //default시 AutoAppConfig에 들어잇는 package hello.core가 시작위치가 된다.
        //권장방법: 패키지 위치를 따로 지정하지않고 설정 정보 클래스의 위치를 프로젝트 최상단에 두어 사용한다.

        //예외로 빼는 부분(예제를 위해서) 빼지않으면 @Configuration 붙은 설정 정보도 자동으로 등록된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
