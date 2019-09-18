package com.rx.demo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class RxJavaCustomObserverDemo {
	public static void main(String[] args) {
		Observable<String> months = Observable.just("January", "February", "March", "April", "May", "June", "July",
				"August");

		Observer<String> customObserver = new Observer<String>() {
			public void onSubscribe(Disposable d) {
				System.out.println(" Subscription Initiated ");
			}

			public void onNext(String value) {
				System.out.println("The value " + value + " is received from Observable");
			}

			public void onError(Throwable e) {
				e.printStackTrace();
			}

			public void onComplete() {
				System.out.println("Done!");
			}
		};
		
		months.filter(m->m.endsWith("y"))
				.subscribe(customObserver);
		
	}
}
