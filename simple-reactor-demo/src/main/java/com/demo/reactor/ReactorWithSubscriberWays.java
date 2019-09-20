package com.demo.reactor;

import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;

public class ReactorWithSubscriberWays {
	public static void main(String[] args) {
		List<String>	monthList	
						=	Arrays.asList("Jan","Feb","Mar","Apr","May");
		
		Flux<String>	months	
						=	Flux.fromIterable(monthList);
		
		months.subscribe();
		months.subscribe(m->System.out.println(m));
		months.subscribe(
				m->System.out.println("--->"+m),
					e->e.printStackTrace(),
						()->System.out.println("Finished at Third Place"));

		months.subscribe(
				m->System.out.println("--->"+m),
					e->e.printStackTrace(),
						()->System.out.println("Finished at Fourth Place"),
							s -> {
								System.out.println("Subscribed :");
								s.request(5L);
								});
	}
}
