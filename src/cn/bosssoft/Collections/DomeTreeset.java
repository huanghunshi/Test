package cn.bosssoft.Collections;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

import org.junit.Test;

public class DomeTreeset {
	@Test
	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<>(new Compare());
		TreeSet<Integer> ts1 = new TreeSet<>();
		int i = 1;
		String sex = null;
		Random r = new Random(1);
		while (i < 100) {
			int r1 = r.nextInt(100);
			if (r1 % 2 == 0)
				sex = "男";
			else
				sex = "女";
			if (ts1.contains(r1) == true)
				continue;
			else {
				ts1.add(r1);
                ts.add(new Student(r1, "张三" + i, i, sex));
			}
			i++;
		}
		System.out.println("排序后的学生信息:");
		for (Student s : ts) {
			System.out.println(s);
		}
	}

}

class Compare implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO 自动生成的方法存根
		int num = o1.getId() - o2.getId();
		return num == 0 ? o1.getYong() - o2.getYong() : num;
	}

}