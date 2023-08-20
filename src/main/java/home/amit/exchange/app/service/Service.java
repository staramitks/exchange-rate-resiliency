package home.amit.exchange.app.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
/*
User :- AmitSingh
Date :- 8/20/2023
Time :- 6:26 PM
Year :- 2023
*/

public interface Service {
    String failure();

    String failureWithFallback();

    String success();

    String successException();

    String ignoreException();

    Flux<String> fluxSuccess();

    Flux<String> fluxFailure();

    Flux<String> fluxTimeout();

    Mono<String> monoSuccess();

    Mono<String> monoFailure();

    Mono<String> monoTimeout();

    CompletableFuture<String> futureSuccess();

    CompletableFuture<String> futureFailure();

    CompletableFuture<String> futureTimeout();

}