package com.hr;

import javax.annotation.PostConstruct;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hr")
public class empcontroller {


WebClient webclient;
	
	@PostConstruct
	public void init()
	{
		webclient=WebClient.builder().baseUrl("http://localhost:9090/emp")
				.defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	
	@PostMapping("/addemp")
	public Mono<String> addemp(@RequestBody employee emp )
	{
		return webclient.post().uri("/addEmployee").syncBody(emp).retrieve().bodyToMono(String.class);
	}
	
	@GetMapping("/getemp")
	public Flux<employee> getemp(){
		return webclient.get().uri("/Employees").retrieve().bodyToFlux(employee.class);
	}
	
	@GetMapping("/getemp/{id}")
	public Mono<employee> getempbyid(@PathVariable Long id)
	{
		return webclient.get().uri("/Employee/"+id).retrieve().bodyToMono(employee.class);
	}
	
	
	
}
