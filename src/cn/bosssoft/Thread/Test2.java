package cn.bosssoft.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

public class Test2 {


	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}

	public static Object res1="刀";
	public static Object res2="叉";

	static class Producer extends Thread {// 线程1

		public Producer() {
			// TODO 自动生成的构造函数存根
		}

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			System.out.println("Producer启动了");
			while (true) {
				synchronized (res1){
					
				System.out.println("Producer拿到了1的锁");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println("Producer想要2的锁");
				synchronized(res2){
					System.out.println("Producer拿到了1的锁");
				}
				}
}
			}
		}

	static class Consumer extends Thread {// 线程2

		public Consumer() {
			// TODO 自动生成的构造函数存根
		}

		@Override
		public void run() {
			// TODO 自动生成的方法存根
				System.out.println("Consumer启动了");
				while (true) {
					synchronized (res2){
						
					System.out.println("Consumer拿到了2的锁");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					System.out.println("Consumer想要1的锁");
					synchronized(res1){
						System.out.println("Consumer拿到了1的锁");
					}
					}
					}
				}
		}
	}
