package com.kurdestan.testmaven;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({ "20", "30", "50"})
    public int iterations;



    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 2, time = 1)
    @BenchmarkMode(Mode.Throughput)
    public String concatUsingStringBuilder(ExecutionPlan executionPlan) {

        StringBuilder result = new StringBuilder();
        for (int i =  executionPlan.iterations;i>0 ;i--) {
            result.append(i);
        }
        return result.toString();
    }


}