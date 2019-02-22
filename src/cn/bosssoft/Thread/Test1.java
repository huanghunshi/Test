package cn.bosssoft.Thread;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Test1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Waiter waiter = new Waiter();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();

		new Thread(new Consumer(waiter)).start();
	
	}

	static class Waiter {// 流水线
		List<String> alist = new ArrayList<>();

		public void produce() {
			synchronized (alist) {
				while (alist.size() > 9) {
					try {
						alist.wait();
						System.out.println("流水线上有" + alist.size() + "个");
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				alist.add(new String());
				System.out.println("生产者" + Thread.currentThread().getName() + "生产了一个产品");
				alist.notifyAll();
			}

		}

		public void consume() {
			synchronized (alist) {
				while (alist.size() == 0) {
					try {
						alist.wait();
						System.out.println("流水线上已经没有产品了");
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				alist.remove(new String());
				System.out.println("消费者" + Thread.currentThread().getName() + "消费了一个产品，流水线上还有" + alist.size() + "个");
				alist.notifyAll();
			}
		}

	}

	static class Producer extends Thread {// 生产者
		public Waiter waiter;

		public Producer() {
			// TODO 自动生成的构造函数存根
		}

		public Producer(Waiter waiter) {
			// TODO 自动生成的构造函数存根
			this.waiter = waiter;
		}

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while (true) {
				try {
					Thread.sleep(2000);
					waiter.produce();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

		}
	}

	static class Consumer extends Thread {// 消费者
		public Waiter waiter;

		public Consumer() {
			// TODO 自动生成的构造函数存根
		}

		public Consumer(Waiter waiter) {
			// TODO 自动生成的构造函数存根
			this.waiter = waiter;
		}

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while (true) {
				try {
					Thread.sleep(2000);
					waiter.consume();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
}
