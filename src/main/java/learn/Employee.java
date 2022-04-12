package learn;

public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;
	private String department;
	
	//1.構造方法-contructor
	public Employee(int id,String name,int age,double salary,String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public Employee() {
		
	}
	public Employee(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public Employee(String name, int age, double salary, String department) {

		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}
	//2.get/set 方法
	public int getId(){
		return this.id;
	}
	public void setId() {
		//void返す値がなし
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//3.toString
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", department="
				+ department + "]";
	}
	

	
}
