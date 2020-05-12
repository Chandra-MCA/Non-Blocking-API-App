# This project creates a non-blocking REST API using spring-boot-webflux and Reactive API's.

When we use the spring framework in writing non blocking applications or reactive applications then mostly we will be programming with reactive streams.


# Getting Started
## Steps to setup this project
1. Clone from github:

git clone https://github.com/anuj-mehra/spring-boot-reactive-rest-api.git

2. Import this project into an IDE (I used eclipse)

3. Build project:
mvn clean install

4. Run class: com.poc.springboot.SpringBootApplicationStarter


## Dependencies:



## URL for REST API
http://localhost:8080/positions/positionid?positionId=1

http://localhost:8080/positions/customerid?customerId=1001

http://localhost:8080/positions


## How to validate if response is non-blocking?




# Reactive vs JavaRx2
Spring created MONO or FLUX, Rxjs created Observable , Rxjava created Observable. These all libraries provides the implementation of the reactive stream data type. Basically all are different names but underlying concepts are same.

RxJava and Reactor are quite similar from a functional perspective. 

When it comes to RxJava/Reactor comparison, there are quite a few perspectives. 


## API
Flowable and Flux have very similar API. Obviously, they both support basic operators like map(), filter(), flatMap(), as well as more advanced ones. The main difference is the target Java version. RxJava 2.x must still support Java 6 as it is widely used on Android (read later on). Reactor, on the other hand, targets Java 8+. Therefore Reactor can take advantage of modern java API's.

|JavaRx2         |Reactor   |Purpose                                                                                                                              |
|----------------|----------|-------------------------------------------------------------------------------------------------------------------------------------|
| Completable    | N/A      | Completes successfully or with failure, without emitting any value. Like CompletableFuture<Void>                                    |
| Maybe<T>       | Mono<T>  | Completes successfully or with failure, may or may not emit a single value. Like an asynchronous Optional<T>                        |
| Single<T>      | N/A      | Either complete successfully emitting exactly one item or fails.                                                                    |
| Observable<T>  | N/A      | Emits an indefinite number of events (zero to infinite), optionally completes successfully or with failure.                         |
| Flowable<T>    | Flux<T>  | Emits an indefinite number of events (zero to infinite), optionally completes successfully or with failure. Supports backpressure.  |
-------------------------------------------------------------------------------------------------------------------------------------------------------------------

Reactor (https://github.com/reactor/reactor) is the reactive library of choice for Spring WebFlux. It provides the Mono and Flux API types to work on data sequences of 0..1 (Mono) and 0..N (Flux) through a rich set of operators aligned with the ReactiveX vocabulary of operators. Reactor is a Reactive Streams library and, therefore, all of its operators support non-blocking back pressure. Reactor has a strong focus on server-side Java. It is developed in close collaboration with Spring.

As a general rule, a WebFlux API accepts a plain Publisher as input, adapts it to a Reactor type internally, uses that, and returns either a Flux or a Mono as output.

## What is back-pressure in non-blocking API's?
In synchronous, imperative code, blocking calls serve as a natural form of back pressure that forces the caller to wait. In non-blocking code, it becomes important to control the rate of events so that a fast producer does not overwhelm its destination.
For example a data repository (acting as Publisher) can produce data that an HTTP server (acting as Subscriber) can then write to the response. The main purpose of Reactive Streams is to let the subscriber control how quickly or how slowly the publisher produces data.
(Q) What if a publisher cannot slow down?
(A) The purpose of Reactive Streams is only to establish the mechanism and a boundary. If a publisher cannot slow down, it has to decide whether to buffer, drop, or fail.



# Spring WebFlux vs Spring-mvc
The main difference between the two frameworks is that spring-mvc is based on thread pools, while spring-webflux is based on event-loop concurrency model. Both the models support commonly used annotations such as @Controller.


## Use case for Non-Blocking/Reactive microservice
In a microservice architecture, you can have a mix of applications with either Spring MVC or Spring WebFlux controllers or with Spring WebFlux functional endpoints. Having support for the same annotation-based programming model in both frameworks makes it easier to re-use knowledge while also selecting the right tool for the right job.


## On that foundation, Spring WebFlux provides a choice of two programming models:

(1) Annotated Controllers: Consistent with Spring MVC and based on the same annotations from the spring-web module. Both Spring MVC and WebFlux controllers support reactive (Reactor and RxJava) return types, and, as a result, it is not easy to tell them apart. One notable difference is that WebFlux also supports reactive @RequestBody arguments.

(2) Functional Endpoints: Lambda-based, lightweight, and functional programming model.



## Embedded server for Spring Webflux
Spring Boot has a WebFlux starter that automates these steps. By default, the starter uses Netty, but it is easy to switch to Tomcat, Jetty, or Undertow by changing your Maven or Gradle dependencies. 
Spring Boot defaults to Netty, because it is more widely used in the asynchronous, non-blocking space and lets a client and a server share resources.

Tomcat and Jetty can be used with both Spring MVC and WebFlux. Keep in mind, however, that the way they are used is very different. Spring MVC relies on Servlet blocking I/O and lets applications use the Servlet API directly if they need to. Spring WebFlux relies on Servlet 3.1 non-blocking I/O and uses the Servlet API behind a low-level adapter. It is not exposed for direct use.

## Performance
Performance has many characteristics and meanings. Reactive and non-blocking generally do not make applications run faster. They can, in some cases, (for example, if using the WebClient to execute remote calls in parallel). On the whole, it requires more work to do things the non-blocking way and that can slightly increase the required processing time.

The key expected benefit of reactive and non-blocking is the ability to scale with a small, fixed number of threads and less memory. That makes applications more resilient under load, because they scale in a more predictable way. In order to observe those benefits, however, you need to have some latency (including a mix of slow and unpredictable network I/O). That is where the reactive stack begins to show its strengths, and the differences can be dramatic.

Both Spring MVC and Spring WebFlux support annotated controllers, but there is a key difference in the concurrency model and the default assumptions for blocking and threads.

In Spring MVC (and servlet applications in general), it is assumed that applications can block the current thread, (for example, for remote calls). For this reason, servlet containers use a large thread pool to absorb potential blocking during request handling.

In Spring WebFlux (and non-blocking servers in general), it is assumed that applications do not block. Therefore, non-blocking servers use a small, fixed-size thread pool (event loop workers) to handle requests.

 
###“To scale” and “small number of threads” may sound contradictory but to never block the current thread (and rely on callbacks instead) means that you do not need extra threads, as there are no blocking calls to absorb.
	
	
## Read for basic concepts:
https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux

https://medium.com/@AnkurRatra/spring-reactive-stream-basic-concepts-mono-or-flux-part-1-baed4b432977

https://www.nurkiewicz.com/2019/02/rxjava-vs-reactor.html

https://github.com/chang-chao/spring-webflux-reactive-jdbc-sample

https://github.com/netifi/webflux-rxjava2-jdbc-example/blob/master/src/main/java/io/netifi/asynchdb/webflux/EmployeeRepository.java


