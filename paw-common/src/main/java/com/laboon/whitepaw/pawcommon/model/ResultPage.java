package com.laboon.whitepaw.pawcommon.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultPage<T> implements Serializable {
    private int offset;
    private int limit;
    private int size;
    private T result;

    private ResultPage() {}

    public static <T> ResultPage<T> of(int offset, int limit, int size, T result) {
        ResultPage<T> resultPage = new ResultPage<>();
        resultPage.setOffset(offset);
        resultPage.setLimit(limit);
        resultPage.setSize(size);
        resultPage.setResult(result);
        return resultPage;
    }
}
