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

		// TODO �Զ����ɵķ������
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
						System.out.println("�߳�1" + "������һ������");
						try {
							Thread.sleep(1000);
							condition.signal();    // ���ѡ�condition�������ϵ������̡߳�
							condition.await(); // �ȴ�
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
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
						System.out.println("�߳�2" + "������һ������");
						try {
							Thread.sleep(1000);
							condition.signal();    // ���ѡ�condition�������ϵ������̡߳�
							condition.await(); // �ȴ�
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
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