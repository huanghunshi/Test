package cn.bosssoft.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

public class Test2 {


	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}

	public static Object res1="��";
	public static Object res2="��";

	static class Producer extends Thread {// �߳�1

		public Producer() {
			// TODO �Զ����ɵĹ��캯�����
		}

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
			System.out.println("Producer������");
			while (true) {
				synchronized (res1){
					
				System.out.println("Producer�õ���1����");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				System.out.println("Producer��Ҫ2����");
				synchronized(res2){
					System.out.println("Producer�õ���1����");
				}
				}
}
			}
		}

	static class Consumer extends Thread {// �߳�2

		public Consumer() {
			// TODO �Զ����ɵĹ��캯�����
		}

		@Override
		public void run() {
			// TODO �Զ����ɵķ������
				System.out.println("Consumer������");
				while (true) {
					synchronized (res2){
						
					System.out.println("Consumer�õ���2����");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					System.out.println("Consumer��Ҫ1����");
					synchronized(res1){
						System.out.println("Consumer�õ���1����");
					}
					}
					}
				}
		}
	}
