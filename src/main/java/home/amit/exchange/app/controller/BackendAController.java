package home.amit.exchange.app.controller;
/*
User :- AmitSingh
Date :- 8/20/2023
Time :- 6:42 PM
Year :- 2023
*/


import home.amit.exchange.app.service.Service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/backendA")
public class BackendAController {

    private final Service businessAService;

    public BackendAController(@Qualifier("backendAService") Service businessAService){
        this.businessAService = businessAService;
    }

    @GetMapping("failure")
    public String failure(){
        return businessAService.failure();
    }

    @GetMapping("success")
    public String success(){
        return businessAService.success();
    }

    @GetMapping("successException")
    public String successException(){
        return businessAService.successException();
    }

    @GetMapping("ignore")
    public ResponseEntity<String> ignore(){
         businessAService.ignoreException();
         return  ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                 .body("The remote service is unavailable at the moment.");
    }

    @GetMapping("monoSuccess")
    public Mono<String> monoSuccess(){
        return businessAService.monoSuccess();
    }

    @GetMapping("monoFailure")
    public Mono<String> monoFailure(){
        return businessAService.monoFailure();
    }

    @GetMapping("fluxSuccess")
    public Flux<String> fluxSuccess(){
        return businessAService.fluxSuccess();
    }

    @GetMapping("monoTimeout")
    public Mono<String> monoTimeout(){
        return businessAService.monoTimeout();
    }

    @GetMapping("fluxTimeout")
    public Flux<String> fluxTimeout(){
        return businessAService.fluxTimeout();
    }

    @GetMapping("futureFailure")
    public CompletableFuture<String> futureFailure(){
        return businessAService.futureFailure();
    }

    @GetMapping("futureSuccess")
    public CompletableFuture<String> futureSuccess(){
        return businessAService.futureSuccess();
    }

    @GetMapping("futureTimeout")
    public CompletableFuture<String> futureTimeout(){
        return businessAService.futureTimeout();
    }

    @GetMapping("fluxFailure")
    public Flux<String> fluxFailure(){
        return businessAService.fluxFailure();
    }

    @GetMapping("fallback")
    public String failureWithFallback(){
        return businessAService.failureWithFallback();
    }
}