package cn.bosssoft.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gzstaack {

	private static Scanner in;

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		System.out.println("ģ��ջ�����Կ�ʼ");
		in = new Scanner(System.in);
		while (true) {
			System.out.println("0-�˳��˵���1-��ջ��2-��ջ; 3-�ж�ջ��");
			int s = in.nextInt();
			if (s == 0)
				break;
			switch (s) {
			case 1:
				Stack.push(list);
				break;
			case 2:
				Stack.pop(list);
				break;
			case 3:
				Stack.empty(list);
				break;
			}
		}
		in.close();
	}

	static class Stack {

		public static void push(List<Object> list) {
			System.out.println("�����룺");
			in = new Scanner(System.in);
			Object b = in.nextLine();
			list.add(b);
			System.out.println(b + " ��ջ�ɹ�,��ǰջ����Ϊ��" + list.size());
		}

		public static void pop(List<Object> list) {
			int i = list.size();
			System.out.print(list.get(i - 1) + " ��ջ�ɹ�,��ǰջ����Ϊ��" );
			list.remove(i - 1);
			System.out.println(list.size());
		}

		public static void empty(List<Object> list) {
			if (list.isEmpty())
				System.out.println("ջΪ��");
			else
				System.out.println("ջ��Ϊ��");
		}
	}
}
