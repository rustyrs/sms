package model.bean;

public class Student implements java.io.Serializable {
	
	// --- コンストラクタ ---
	public Student() {}
	public Student(int id, String name, int course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}
	
	// --- フィールド ---
	private int    id;
	private String name;
	private int    course;

	// --- ゲッター ---
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getCourse() {
		return course;
	}

	// --- セッター ---
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setCourse(int course) {
		this.course=course;
	}
}
