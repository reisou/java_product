package learn;

public class Student {
	private int id;
	private String name;
	private int age;
	private double score; 
	private String address;
	
	public Student(int id, String name, int age, double score, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + ", address=" + address
				+ "]";
	}
	
	
	
	

}
