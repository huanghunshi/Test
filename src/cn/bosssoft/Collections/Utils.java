package cn.bosssoft.Collections;

import java.util.Random;
import java.util.TreeSet;

public class Utils {// ����������û���ظ���Treeset����
	// TODO �Զ����ɵĹ��캯�����
	public void qc(int x, TreeSet<Object> u) {// x����Ҫ���켸����u����ı�ʾ���������Ҫ����ļ���
		TreeSet<Integer> ts = new TreeSet<>();
		int i = 0;
		Random r = new Random(1);
		while (i < x) {
			int r1 = r.nextInt(x);
			if (ts.contains(r1) == true)
				continue;
			else
				ts.add(r1);
			i++;

		}
		for (Integer inte : ts) {
			System.out.println(inte);
		}
		u.addAll(ts);
	}
}
