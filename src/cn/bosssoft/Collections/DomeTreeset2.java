package cn.bosssoft.Collections;


import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;
import org.junit.Test;


public class DomeTreeset2 {
	@Test
	public static void main(String[] args) {
		HashMap<Student, Myclass> hm = new HashMap<>();
		TreeSet<Integer> ts = new TreeSet<>();
		int i = 0;
		String sex = null;
		Random r = new Random(1);
		while (i < 100) {
			int r1 = r.nextInt(100);
			if (r1 % 2 == 0)
				sex = "男";
			else
				sex = "女";
			if (ts.contains(r1) == true)
				continue;
			else {
				ts.add(r1);
				Myclass ca = new Myclass(r1 % 10);
				hm.put(new Student(r1, "张三" + i, i, sex), ca);
			}
			i++;
		}
		System.out.println("查找的学生信息:");
		// hm.get(new Student())
		// 遍历双列集合
		int j = 0;
		for (Student t : hm.keySet()) { // hm.keySet()代表的是双列集合中键的集合
			// 遍历键的双列集合对象
			Myclass value2 = hm.get(t);
			System.out.println(t + "的" + value2);
			j++;
			if (j == 100) {
				System.out.println("---------------------------------------------------------");
				System.out.println("根据学生key为" + t + "查询班级为");
				Myclass value = hm.get(t); // get(t)根据键对象获取值对象
				System.out.println(value);
			}
		}

	}
}

class Myclass {
	private int c;

	public Myclass() {
	}

	public Myclass(int c) {
		super();
		this.c = c;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "班级是" + c + "班";
	}

}
