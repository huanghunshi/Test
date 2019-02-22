package cn.bosssoft.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gzstaack {

	private static Scanner in;

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		System.out.println("模拟栈的特性开始");
		in = new Scanner(System.in);
		while (true) {
			System.out.println("0-退出菜单；1-入栈；2-出栈; 3-判断栈空");
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
			System.out.println("请输入：");
			in = new Scanner(System.in);
			Object b = in.nextLine();
			list.add(b);
			System.out.println(b + " 入栈成功,当前栈容量为：" + list.size());
		}

		public static void pop(List<Object> list) {
			int i = list.size();
			System.out.print(list.get(i - 1) + " 出栈成功,当前栈容量为：" );
			list.remove(i - 1);
			System.out.println(list.size());
		}

		public static void empty(List<Object> list) {
			if (list.isEmpty())
				System.out.println("栈为空");
			else
				System.out.println("栈不为空");
		}
	}
}
