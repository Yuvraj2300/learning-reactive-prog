package com.demo.webflux.functional.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.webflux.model.Student;
import com.demo.webflux.repository.SpringMongoRepository;

public class StudentCompositeRoutes {

	@Autowired
	private	SpringMongoRepository	repo;
	
	RouterFunction<ServerResponse> studentResponse	=
			RouterFunctions.route(RequestPredicates.
					GET("/api/f/composite/getStudent/{rollNo}")
					, serverRequest -> {
						int	rollNo	=	getInt(serverRequest.pathVariable("rollNo"));
						return ServerResponse.ok().
								body(repo.findByRollNo(rollNo),Student.class);
					})
			.and(
				RouterFunctions.route(RequestPredicates.
						GET("/api/f/composite/getAllStudent"),
							serverRequest ->
								ServerResponse.ok().
									body(repo.findAll(), Student.class))
							);

	private int getInt(String pathVariable) {
		int retVal = 0;
		try {
			retVal = Integer.parseInt(pathVariable);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
}
