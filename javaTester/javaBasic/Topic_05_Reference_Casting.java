package javaBasic;

public class Topic_05_Reference_Casting {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student Name = " + studentName);
	}
	public static void main(String[] args) {
		Topic_05_Reference_Casting student1 = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting student2 = new Topic_05_Reference_Casting();

		student1.setStudentName("Nguyen van Nam");
		student2.setStudentName("Le Van Long");
		
		student1.showStudentName();
		student2.showStudentName();
		
		//Ép kiểu
		student2= student1;
		
		student1.showStudentName();
		student2.showStudentName();
		
		student2.setStudentName("Tran Thi Hoa");
		
		student1.showStudentName();
		student2.showStudentName();
	}

}
