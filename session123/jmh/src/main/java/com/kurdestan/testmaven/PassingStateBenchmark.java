package com.kurdestan.testmaven;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class PassingStateBenchmark {
    @State(Scope.Thread)
    public static class MyState {
        String a, b;
        @Setup(Level.Iteration)
        public void setup() {
            a = "some-val";
            b = "some-val2";
        }
        @TearDown(Level.Iteration)
        public void teardown() {
            a = b = "";
        }
    }
 /*   @Benchmark
    public String benchmark(MyState myState) {
        //do whatever with myState
        return myState.a + myState.b;
        //....
    }*/

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 5, time = 1)
    @Warmup(iterations = 1, time = 1)
    public void benchmarks(MyState myState, Blackhole blackhole) {
        String res = myState.a + myState.b;
        //..
        blackhole.consume(res);
        //perform computation 2
        blackhole.consume(res);
    }
}