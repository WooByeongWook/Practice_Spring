package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성하는 파일
 * AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.
 */
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();    //할인정책 적용을 위해 Fix -> Rate   //이코드는 %DIP위반%
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();     //그러나 FixDiscountPolicy도 의존했기에 바꾸면 RateDiscountPolicy에도 의존하게됨 %OCP위반%
//    private DiscountPolicy discountPolicy;  //인터페이스만 의존하기위해 final을 빼고 설정 (final은 값이 필요)



    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
