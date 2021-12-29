package com.learning.ticker.model;

import java.util.List;

public class Result {
    private Integer count;
    private List<TickerDto> quotes = null;
    private Long jobTimestamp;
    private Long startInterval;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<TickerDto> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<TickerDto> quotes) {
        this.quotes = quotes;
    }

    public Long getJobTimestamp() {
        return jobTimestamp;
    }

    public void setJobTimestamp(Long jobTimestamp) {
        this.jobTimestamp = jobTimestamp;
    }

    public Long getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(Long startInterval) {
        this.startInterval = startInterval;
    }
}
