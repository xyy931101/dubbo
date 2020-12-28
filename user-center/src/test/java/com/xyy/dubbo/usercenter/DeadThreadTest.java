package com.xyy.dubbo.usercenter;

/**
 * @Author: Xiongyy
 * @Date: 2020/5/17 21:09
 * .............................................
 * 佛祖保佑             永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */
public class DeadThreadTest {

    public static void main(String[] args) {
        Runnable r = () ->{
            System.out.println(Thread.currentThread().getName() + "start !!!!");
            DeadThread thread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "end !!!");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
    }


}

class DeadThread{
    static {
        if (true){
            System.out.println(Thread.currentThread().getName() + "初始化当前类！！！");
            while (true){

            }
        }

    }
}