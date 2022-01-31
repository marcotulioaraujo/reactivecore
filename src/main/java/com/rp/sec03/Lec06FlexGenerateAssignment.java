package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FlexGenerateAssignment {

    public static void main(String[] args) {


        Flux.generate(synchronousSink -> {


                    //Canada
                    //Max 10
                    //subscriber cancels - exit
                    String country = Util.faker().country().name();
                    System.out.println("Emitting : " + country);
                    synchronousSink.next(country);

                    if (country.toLowerCase().equals("canada")) {
                        synchronousSink.complete();
                    }
                })
                .take(10)
                .subscribe(Util.subscriber());


    }
}
