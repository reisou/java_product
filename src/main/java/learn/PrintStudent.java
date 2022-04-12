package learn;

import java.util.ArrayList;

public class PrintStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student(1, "li", 22, 88.2, "japan1");
		Student stu2 = new Student(2, "la", 21, 89.34, "japan2");
		Student stu3 = new Student(3, "le", 20, 99.12, "japan3");

		ArrayList<Student> stu_list = new ArrayList<Student>();
		stu_list.add(stu1);
		stu_list.add(stu2);
		stu_list.add(stu3);

		double scoreMax = getScoreMax(stu_list);
		double scoreMin = getScoreMin(stu_list);

		System.out.println("max:" + scoreMax);
		System.out.println("min:" + scoreMin);

	}

	static double getScoreMax(ArrayList<Student> stu_list) {
		double max = 0;
		for (Student s : stu_list) {
			if (s.getScore() > max) {
				max = s.getScore();
			}
		}
		return max;
	}

	static double getScoreMin(ArrayList<Student> stu_list) {
		double min = stu_list.get(0).getScore();
		for (Student s : stu_list) {
			if (s.getScore() < min) {
				min = s.getScore();
			}
		}
		return min;
	}
}
