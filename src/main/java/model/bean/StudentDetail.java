package model.bean;


public class StudentDetail implements java.io.Serializable {
	
	// コンストラクタ
	public StudentDetail() {}
	
	private int number;
	private String name;
	private String comment;

	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getComment() {
		return comment;
	}

	public void setNumber(int number) {
		this.number=number;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setComment(String comment) {
		this.comment=comment;
	}
}
