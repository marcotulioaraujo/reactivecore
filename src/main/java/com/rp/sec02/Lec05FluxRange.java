package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {

        Flux<Integer> fluxRange = Flux.range(1, 10);

        fluxRange
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
