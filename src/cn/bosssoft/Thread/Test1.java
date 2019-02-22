package cn.bosssoft.Thread;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Test1 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Waiter waiter = new Waiter();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();
		new Thread(new Producer(waiter)).start();

		new Thread(new Consumer(waiter)).start();
	
	}

	static class Waiter {// ��ˮ��
		List<String> alist = new ArrayList<>();

		public void produce() {
			synchronized (alist) {
				while (alist.size() > 9) {
					try {
						alist.wait();
						System.out.println("��ˮ������" + alist.size() + "��");
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				alist.add(new String());
				System.out.println("������" + Thread.currentThread().getName() + "������һ����Ʒ");
				alist.notifyAll();
			}

		}

		public void consume() {
			synchronized (alist) {
				while (alist.size() == 0) {
					try {
						alist.wait();
						System.out.println("��ˮ�����Ѿ�û�в�Ʒ��");
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
				alist.remove(new String());
				System.out.println("������" + Thread.currentThread().getName() + "������һ����Ʒ����ˮ���ϻ���" + alist.size() + "��");
				alist.notifyAll();
			}
		}

	}

	static class Producer extends Thread {// ������
		public Waiter waiter;

		public Producer() {
			// TODO �Զ����ɵĹ��캯�����
		}

		public Producer(Waiter waiter) {
			// TODO �Զ����ɵĹ��캯�����
			this.waiter = waiter;
		}

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			while (true) {
				try {
					Thread.sleep(2000);
					waiter.produce();
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}

		}
	}

	static class Consumer extends Thread {// ������
		public Waiter waiter;

		public Consumer() {
			// TODO �Զ����ɵĹ��캯�����
		}

		public Consumer(Waiter waiter) {
			// TODO �Զ����ɵĹ��캯�����
			this.waiter = waiter;
		}

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			while (true) {
				try {
					Thread.sleep(2000);
					waiter.consume();
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}
}
