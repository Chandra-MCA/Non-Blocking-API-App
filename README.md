# This project creates a non-blocking REST API using spring-boot-webflux and Reactive API's.

When we use the spring framework in writing non blocking applications or reactive applications then mostly we will be programming with reactive streams.



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

## What is back-pressure in non-blocking API's?




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




## Read for basic concepts:
https://medium.com/@AnkurRatra/spring-reactive-stream-basic-concepts-mono-or-flux-part-1-baed4b432977

https://www.nurkiewicz.com/2019/02/rxjava-vs-reactor.html

https://github.com/chang-chao/spring-webflux-reactive-jdbc-sample

https://github.com/netifi/webflux-rxjava2-jdbc-example/blob/master/src/main/java/io/netifi/asynchdb/webflux/EmployeeRepository.java


