package com.rx.demo;

import java.util.ArrayList;
import java.util.List;

import com.rx.demo.pojo.EmployeeRating;

import io.reactivex.Observable;

public class RxJavaIterableDemo {
	public static void main(String[] args) {
		List<EmployeeRating> employeeList = new ArrayList();
		EmployeeRating employeeRating1 = new EmployeeRating();
		employeeRating1.setName("Lilly");
		employeeRating1.setRating(6);
		employeeList.add(employeeRating1);

		employeeRating1 = new EmployeeRating();
		employeeRating1.setName("Peter");
		employeeRating1.setRating(5);
		employeeList.add(employeeRating1);

		employeeRating1 = new EmployeeRating();
		employeeRating1.setName("Bhakti");
		employeeRating1.setRating(9);
		employeeList.add(employeeRating1);

		employeeRating1 = new EmployeeRating();
		employeeRating1.setName("Harmi");
		employeeRating1.setRating(9);
		employeeList.add(employeeRating1);
	
		Observable<EmployeeRating>	employeeRatingSource	=	
				Observable.fromIterable(employeeList);
		
		employeeRatingSource.filter(employeeRating ->
					employeeRating.getRating() >=7).subscribe(empR ->
							System.out.println("Star Employee : "+empR.getName()+
									" Rating : "+empR.getRating()));
	}
}
