package com.haejun.springpractice.exec3;

/**
 * packageName    : com.haejun.springpractice.exec3
 * fileName       : SingleTonWarn
 * author         : NAHAEJUN
 * date           : 2024-07-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-07        NAHAEJUN              최초생성
 */
public class SingleTonWarn {

    private int price;

    public void order(String name , int price) {
        System.out.println(name + " is ordered to " + price);
        this.price = price;
        System.out.println("------------------------------");
        System.out.println(name + " is ordered to " + price);
    }

    public int getPrince(){
        return price;
    }
}
