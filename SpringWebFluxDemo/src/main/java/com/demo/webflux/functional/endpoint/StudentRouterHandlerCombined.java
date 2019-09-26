package com.demo.webflux.functional.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.webflux.model.Student;
import com.demo.webflux.repository.SpringMongoRepository;

@Configuration
public class StudentRouterHandlerCombined {

	@Autowired
	private SpringMongoRepository repo;

	RouterFunction<ServerResponse> returnStudentWithCombine() {
		
		HandlerFunction<ServerResponse> studentHandler	=	
				serverRequest	->	{
					int	rollNo	=	getInt(serverRequest.pathVariable("rollNo"));
					return	ServerResponse.ok().
							body(repo.findByRollNo(rollNo),
									Student.class);
				};
				
		RouterFunction<ServerResponse> studentResponse	=
				RouterFunctions.route(
						RequestPredicates.GET("/api/f/combine/getStudent/{rollNo}"),
							studentHandler
						);
		
		return studentResponse;
	}

	private int getInt(String value) {
		int returnVal = 0;
		try {
			returnVal = Integer.parseInt(value);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnVal;
	}

}
