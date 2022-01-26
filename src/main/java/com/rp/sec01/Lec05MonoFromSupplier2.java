package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier2 {

    public static void main(String[] args) {

        //Use just if you have the data already
//        Mono<String> mono = Mono.just(getName());


        //Only send the name if someone subscribed it to.
        //Only if there is a subscription to it.
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Callable<String>  stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }

    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
