package com.haejun.springpractice.exec6;

/**
 * packageName    : com.haejun.springpractice.exec6
 * fileName       : NetWorkConnection
 * author         : NAHAEJUN
 * date           : 2024-07-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-15        NAHAEJUN              최초생성
 */
public class NetWorkConnection {

    private String url;

    // 객체 생성
    public NetWorkConnection() {
        System.out.println("NetWorkConnection 초기화 ==>" + url);
        // url없이 connect() 호출
        connect();
        call("객체 생성");
    }


    public void connect(){
        System.out.println("NetWorkConnection connect ====> " + url);
    }

    public void call(String message){
        System.out.println("call =====> " + url + " message====> " + message);
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
}
