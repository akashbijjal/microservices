package com.hr;

import javax.annotation.PostConstruct;

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
public class deptcontroller {
WebClient webclient;
	
	@PostConstruct
	public void init()
	{
		webclient=WebClient.builder().baseUrl("http://localhost:9091/dept")
				.defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	
	@PostMapping("/adddept")
	public Mono<String> addemp(@RequestBody dept dep )
	{
		return webclient.post().uri("/adddept").syncBody(dep).retrieve().bodyToMono(String.class);
	}
	
	@GetMapping("/getdept")
	public Flux<dept> getemp(){
		return webclient.get().uri("/department").retrieve().bodyToFlux(dept.class);
	}
	
	@GetMapping("/getdept/{id}")
	public Mono<dept> getempbyid(@PathVariable Long id)
	{
		return webclient.get().uri("/department/"+id).retrieve().bodyToMono(dept.class);
	}
}
