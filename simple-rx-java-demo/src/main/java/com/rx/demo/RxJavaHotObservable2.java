package com.rx.demo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class RxJavaHotObservable2 {
	public static void main(String[] args) {
		Observable<Long> observableint	=
				Observable.interval(2, TimeUnit.SECONDS);
		
		ConnectableObservable<Long> connectableObservable	=
							observableint.publish();
		
		connectableObservable.subscribe(
				i->System.out.println("Observable #1 : "+i));
		
		
		connectableObservable.connect();
		
		addDelay(7000);
		
		connectableObservable.subscribe(
				i->System.out.println("Observable #2 : "+i));
	
	
		addDelay(10000);
	}
	
	
	public static void addDelay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
