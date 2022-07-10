package org.example.model.res;

public class BaseSearchRes<T> {

    private int count;

    private T data;

    public static <T> BaseSearchRes<T> from(T data, int count){
        var res = new BaseSearchRes<T>();
        res.count = count;
        res.data = data;
        return res;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
