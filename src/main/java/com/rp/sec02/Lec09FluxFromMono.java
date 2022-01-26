package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

//        Mono<String> mono = Mono.just("a");
//
//        Flux<String> flux = Flux.from(mono);
//
//        doSomething(flux);


        // This convert a flux into a mono and use the filter to give only the first object that is grater than the filter.l
        Flux.range(1,10)
                .filter( filter -> filter >3)
                .next()
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());



    }

    private static void doSomething(Flux<String> flux){
        flux.subscribe(Util.onNext());
    }
}
