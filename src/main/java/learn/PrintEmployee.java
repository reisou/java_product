package learn;

import java.util.ArrayList;

public class PrintEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee(1,"li",20,3000.01,"IT");
		Employee emp2 = new Employee(2,"lo",22,4000.01,"IT");
		Employee emp3 = new Employee(3,"lu",26,5000.01,"Manager");
		Employee emp4 = new Employee(4,"la",23,3000.01,"HR");
		Employee emp5 = new Employee(5,"le",27,3000.01,"N");
		
		//System.out.println(emp1.toString());
		
		ArrayList<Employee> emp_list = new ArrayList<Employee>();
		emp_list.add(emp1);
		emp_list.add(emp2);
		emp_list.add(emp3);
		emp_list.add(emp4);
		emp_list.add(emp5);
		
		double salaryMax = getSalaryMax(emp_list);
		double salarySum = getSalarySum(emp_list);
		double salaryMin = getSalaryMin(emp_list);
		
		System.out.println("max:"+salaryMax);
		System.out.printf("sum:%.2f\n",salarySum);
		System.out.println("min:"+salaryMin);
		
	}
//static (jingtai) buxuyaoshilihua,yenengyunxing.
	static double getSalaryMax(ArrayList<Employee>emp_list) {
		double max = 0;
		for(Employee e:emp_list) {
		   if(e.getSalary()>max) {
			   max = e.getSalary();
		   }
		}
		return max;
	}
	static double getSalarySum(ArrayList<Employee>emp_list) {
		double sum = 0;
		for(Employee e:emp_list) {
			sum += e.getSalary();
		}
		return sum;
	}
	static double getSalaryMin(ArrayList<Employee>emp_list) {
		double min = emp_list.get(0).getSalary();
		for(Employee e:emp_list) {
			if(e.getSalary()<min) {
				min = e.getSalary();
			}
		}
		return min;
	}
	
	
	
}
