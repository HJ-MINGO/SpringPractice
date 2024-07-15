package com.haejun.springpractice.exec6;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * packageName    : com.haejun.springpractice.exec6
 * fileName       : NetWorkConnection2
 * author         : NAHAEJUN
 * date           : 2024-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-15        NAHAEJUN              최초생성
 */
public class NetWorkConnection2 implements InitializingBean, DisposableBean {
    /**
     * 빈 생명주기 콜백을 받는 방법중
     * 인터페이스(InitializingBean, DisposableBean) 를 사용한 방식
     *
     *
     * */
    private String url;

    // 객체 생성
    public NetWorkConnection2() {
        System.out.println("NetWorkConnection 초기화 ==>" + url);
    }


    public void connect(){

        System.out.println("NetWorkConnection connect ====> " + url);
    }

    public void call(String message){

        System.out.println("call =====> " + url + ", message====> " + message);
    }

    public void disconnect(){

        System.out.println("NetWorkConnection disconnect ====> " + url);
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    /* 객체가 생성되고 의존성 주입이 완료되었을때 호출되는 메서드 */
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ======>");
        connect();
        call("수정자 주입으로 주소 데이터 주입");
    }
    /* 생명주기가 짧은 빈들도 있지만 이 빈들은 컨테이너와 무관하게 해당 빈이 종료되기 직전에 소멸전 콜백  */
    public void destroy() throws Exception {
        System.out.println("destroy====>");
        disconnect();
    }
}
