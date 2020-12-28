package com.xyy.dubbo.usercenter;

/**
 * @Author: Xiongyy
 * @Date: 2020/5/24 14:14
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LocalVariablesTest {

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int i = 10;
        test.test1();
    }

    private void test1(){
        int i = 10;
        int j = 20;
        System.out.println(i + j);
    }
}
