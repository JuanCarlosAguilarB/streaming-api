package com.streaming.app.streaming.shared.domain;

public class GeneratorValuesRandom {
    public static int generateRandomValue(int start, int end){
        return (int) (Math.random()*(end-start)  + start);
    }

    public static int generateRandomValue(int limit){
        return (int) (Math.random()*limit);
    }

}
