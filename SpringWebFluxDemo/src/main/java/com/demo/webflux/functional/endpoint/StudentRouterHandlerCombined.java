package com.demo.webflux.functional.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

	@Bean
	protected RouterFunction<ServerResponse> getOneStudent(){
		
		HandlerFunction<ServerResponse> studentHandler	=
				request	->{
					int	rollNo	=	getInt(request.pathVariable("rollNo"));
					return	ServerResponse.ok().body(repo.findByRollNo(rollNo),Student.class);
				};
				
		RouterFunction<ServerResponse> response	=	
					RouterFunctions.route(
							RequestPredicates.GET("/api/f/combine/getStudent/{rollNo}"),
									studentHandler
							);
				
		return response;
	}
	
	protected	RouterFunction<ServerResponse> getAllStudents(){
		HandlerFunction<ServerResponse> studentHandler	=
				request	->	{
					return	ServerResponse.ok().
							body(repo.findAll(),Student.class);
				};
				
				
		RouterFunction<ServerResponse> router	=
				RouterFunctions.route(
						RequestPredicates.GET("/api/f/combine/students"),
				studentHandler);
	
		return	 router;
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
