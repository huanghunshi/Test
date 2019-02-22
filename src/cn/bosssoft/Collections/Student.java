package cn.bosssoft.Collections;

public class Student {
	private int id;
	private String name;
	private int yong;
	private String sex;

	public Student() {
		super();

	}

	public Student(int id, String name, int yong, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.yong = yong;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYong() {
		return yong;
	}

	public void setYong(int yong) {
		this.yong = yong;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", yong=" + yong + ", sex=" + sex + "]";
	}
//	public int compareTo(Student o) {
//		int num = this.id-o.id;		//学号是主要条件
//		return num == 0 ? this.yong - o.yong : num;	//年龄是次要条件
//	}

}
