package cn.bosssoft.Collections;

import java.util.Random;
import java.util.TreeSet;

public class Utils {// 随机数构造出没有重复的Treeset集合
	// TODO 自动生成的构造函数存根
	public void qc(int x, TreeSet<Object> u) {// x代表要构造几个，u后面的表示构造完成需要放入的集合
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
