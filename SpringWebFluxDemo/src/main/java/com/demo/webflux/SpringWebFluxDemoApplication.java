package com.demo.webflux;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import com.demo.webflux.websocket.handler.SampleWebSocketHandler;

@SpringBootApplication
@EnableWebFlux
public class SpringWebFluxDemoApplication {

	@Autowired
	SampleWebSocketHandler studentWebSocket;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxDemoApplication.class, args);
	}

	@Bean
	public HandlerMapping webSocketHandlerMapping() {
		Map<String, WebSocketHandler> urlMap = new HashMap<>();
		urlMap.put("/student", studentWebSocket);

		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setUrlMap(urlMap);

		return mapping;
	}

	@Bean
	public WebSocketHandlerAdapter handlerAdapter() {
		return new WebSocketHandlerAdapter();
	}

}
