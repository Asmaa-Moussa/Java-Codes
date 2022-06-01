public class Student{
	private String name;
	private int id;
	private int age;
	private String dept;
	
	public Student(String n, int i, int a, String d){
		name = n;
		id = i;
		age = a;
		dept = d;
	}
	
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public void setAge(int a){
		age = a;
	}
	public int getAge(){
		return age;
	}
	public void setId(int i){
		id = i;
	}
	public int getId(){
		return id;
	}
	public void setDept(String d){
		dept = d;
	}
	public String getDept(){
		return dept;
	}

}