package com.rx.demo;

import io.reactivex.Observable;

public class RxJavaBasics {
	public static void main(String[] args) {
		//Observable
		Observable<String> adminUsers	=	Observable.just("Dave",
				"John",
				"Mike",
				"Travis",
				"Aubrey",
				"Demi");
		
		//Observer as a Lambda exp
		adminUsers.subscribe(s -> System.out.println(s));
		System.out.println();
		adminUsers.map(s -> s.startsWith("D") ? s : "******")
							.subscribe(s -> System.out.println(s));
	}
}
