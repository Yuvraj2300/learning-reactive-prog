package com.demo.reactor;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

public class ReactorLifeCycleMethods {
	public static void main(String[] args) {
		List<String> desgList = Arrays.asList("Associate", "Associate Consultant", "Consultant", "Manager",
				"Associate Principal", "Principal");

		Flux<String> desigFlux = Flux.fromIterable(desgList);

		desigFlux.doOnComplete(() -> System.out.println("Operation Completed"))
				.doOnNext(value -> System.out.println("value in onNext() -->" + value)).doOnSubscribe(s -> {
					System.out.println("Fetching the values ...!!");
					for (int index = 0; index < 6; index++) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						s.request(1);
					}
				}).doOnError(throwable -> {
					System.out.println("Opps, Something went wrong ..!! " 
								+ throwable.getMessage());
				})
				.doFinally(signalType ->
				System.out.println("Shutting down the operation, Bye ..!! "+signalType.name()))
							
				.subscribe();
		
	}
}
