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
				sex = "��";
			else
				sex = "Ů";
			if (ts.contains(r1) == true)
				continue;
			else {
				ts.add(r1);
				Myclass ca = new Myclass(r1 % 10);
				hm.put(new Student(r1, "����" + i, i, sex), ca);
			}
			i++;
		}
		System.out.println("���ҵ�ѧ����Ϣ:");
		// hm.get(new Student())
		// ����˫�м���
		int j = 0;
		for (Student t : hm.keySet()) { // hm.keySet()�������˫�м����м��ļ���
			// ��������˫�м��϶���
			Myclass value2 = hm.get(t);
			System.out.println(t + "��" + value2);
			j++;
			if (j == 100) {
				System.out.println("---------------------------------------------------------");
				System.out.println("����ѧ��keyΪ" + t + "��ѯ�༶Ϊ");
				Myclass value = hm.get(t); // get(t)���ݼ������ȡֵ����
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
		return "�༶��" + c + "��";
	}

}
