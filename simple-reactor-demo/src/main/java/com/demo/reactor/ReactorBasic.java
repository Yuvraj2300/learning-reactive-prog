package com.demo.reactor;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorBasic {
	private static List<String> carModels = Arrays.asList("E-Class", "S-Class", "Z-Class", "G-Class", "M-Class");

	public static void main(String[] args) {
		Flux<String> fewWords = Flux.just("Hello", "World");
		Flux<String> manyWords = Flux.fromIterable(carModels);
		Mono<String> singleWord = Mono.just("Single Value");

		fewWords.subscribe(t -> System.out.println(t));
		System.out.println();
		manyWords.subscribe(t -> System.out.println(t));
		System.out.println();
		singleWord.subscribe(t -> System.out.println(t));
	}
}
