package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        //Use just if you have the data already
//        Mono<String> mono = Mono.just(getName());


        //Only send the name if someone subscribed it to.
        //Only if there is a subscription to it.
        Mono<String> mono = Mono.fromSupplier(() -> getName());

        for (int i = 0; i < 10; i++) {
            System.out.println("Generating name index :"+ i);
            mono.subscribe(
                    Util.onNext(),
                    Util.onError(),
                    Util.onComplete()
            );
        }



    }

    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
