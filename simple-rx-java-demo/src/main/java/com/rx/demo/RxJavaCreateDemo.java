package com.rx.demo;

import io.reactivex.Observable;

public class RxJavaCreateDemo {
	public static void main(String[] args) {
		Observable<String> daysOfWeek = Observable.create(
		sourceEmitter -> {
			try {
				sourceEmitter.onNext("Sunday");
				sourceEmitter.onNext("Monday");
				sourceEmitter.onNext("Tuesday");
				sourceEmitter.onNext("Wednesday");
				sourceEmitter.onNext("Thursday");
				sourceEmitter.onNext("Friday");
				sourceEmitter.onNext("Saturday");
				sourceEmitter.onComplete();
			} catch (Exception ex) {
				sourceEmitter.onError(ex);
			}
		});
		Observable<String>	daysInUpperCase	=	
							daysOfWeek.map(day -> day.toUpperCase())
										.filter(day->day.startsWith("S"));
		
		daysInUpperCase.subscribe(day->System.out.println("Day is : "+day));
	}
}
