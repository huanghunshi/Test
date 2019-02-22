package cn.bosssoft.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {

	protected static List<String> list4 = new ArrayList<>();
	static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	public static void main(String[] args) {

		// TODO 自动生成的方法存根
		One one = new One();
		Two two = new Two();

		one.start();
		two.start();
	}

	static class One extends Thread {
		public void run() {
			lock.lock();
			try {
				while (true) {
					if (list4.size() > 20)
						break;
					if (list4.size() < 20) {
						list4.add("1");
						System.out.println("线程1" + "插入了一个数据");
						try {
							Thread.sleep(1000);
							condition.signal();    // 唤醒“condition所在锁上的其它线程”
							condition.await(); // 等待
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}

					}
				}
			} finally {
				lock.unlock();
			}

		}
	}

	static class Two extends Thread {
		public void run() {
			lock.lock();
			try {
				while (true) {
					if (list4.size() > 20)
						break;
					if (list4.size() < 20) {
						list4.add("2");
						System.out.println("线程2" + "插入了一个数据");
						try {
							Thread.sleep(1000);
							condition.signal();    // 唤醒“condition所在锁上的其它线程”
							condition.await(); // 等待
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}
			} finally {
				lock.unlock();
			}

		}
	}
}