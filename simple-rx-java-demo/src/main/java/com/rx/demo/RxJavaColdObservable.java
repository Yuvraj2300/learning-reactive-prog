package com.rx.demo;

import io.reactivex.Observable;

public class RxJavaColdObservable {
	public static void main(String[] args) {
		Observable<String> source = Observable.just("One", "Two", "Three", "Four", "Five", "Six", "Seven");

		source.filter(s -> s.contains("o")).subscribe(data -> System.out.println(data));

		System.out.println();

		source.subscribe(data -> System.out.println(data));

	}
}
