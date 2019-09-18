package com.rx.demo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxJavaHotIObservableDemo {
	public static void main(String[] args) {
		Observable<Long> observableInterval = 
				Observable.interval(2, TimeUnit.SECONDS);
		
	PublishSubject<Long>	publishSubject	=	PublishSubject.create();
	observableInterval.subscribe(publishSubject);
	publishSubject.subscribe(i->System.out.println("Observable #1 : "+i));
	addDelay(4000);
	publishSubject.subscribe(i->System.out.println("Observable #2 : "+i));
	addDelay(10000);
	}

	public	static	void	addDelay(int	milliseconds) {
		try {
			Thread.sleep(milliseconds);
		}catch(Exception	e) {
			e.printStackTrace();
		}
	}

}
