package com.streaming.app.streaming.catalog_item.domain.filters;

import com.streaming.app.streaming.shared.domain.filter.Filter;

public class ScoreFilterBetweenIntervals implements Filter<Double> {

    private double minScore;
    private double maxScore;

    public ScoreFilterBetweenIntervals(double minScore, double maxScore) {

        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public ScoreFilterBetweenIntervals(int minScore) {
        this.minScore = (double) minScore;
        this.maxScore = minScore + 0.99;

    }


    @Override
    public Double value() {
        return minScore;
    }

    @Override
    public String name() {
        return "averageScore";
    }
}
