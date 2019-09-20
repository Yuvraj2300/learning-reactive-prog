package com.demo.reactor;

import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class ReactorFromOtherPublisher {
	public static void main(String[] args) {
		Flux<String> fewWords = Flux.just("One", "Two");

		Flux<Integer> intFlux = Flux.fromArray(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });

		Flux<String> strFlux = Flux
				.fromStream(Stream.of("Ten", "Hundred", "Thousand", "Ten Thousand", "Twenty Thousand"));

		Flux<String> fromOtherFlux = Flux.from(fewWords);

		intFlux.subscribe(System.out::println);
		strFlux.subscribe(System.out::println);
		fromOtherFlux.subscribe(d -> System.out.println(d));
	}
}
