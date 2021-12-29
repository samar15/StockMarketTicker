package com.learning.ticker.model;

import java.io.Serializable;
import java.util.List;

public class Finance implements Serializable {

    private List<Result> result  ;
    private Object error;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }



    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
