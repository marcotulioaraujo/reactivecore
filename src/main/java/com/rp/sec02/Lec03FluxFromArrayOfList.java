package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOfList {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c", "d");

        Flux.fromIterable(strings)
                .subscribe(Util.onNext()
                        ,Util.onError()
                        ,Util.onComplete());


        Integer[] a = {2,3,4,5,6,7,8,9};
        Flux.fromArray(a)
                .subscribe(Util.onNext()
                        ,Util.onError()
                        ,Util.onComplete());

    }
}
