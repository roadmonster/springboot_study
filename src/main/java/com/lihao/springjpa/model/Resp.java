package com.lihao.springjpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Resp<T> implements Serializable {

    private static final int OK = 0;
    private static final int FAIL = 1;
    private static final int UNAUTHORIZED = 2;
    private static final long serialVersionUID = 3073266993344558516L;

    private T data; //server data
    private int status = OK; //status code
    private String msg = "";//description

    public static Resp isOk(){
        return new Resp();
    }

    public static Resp isFail(){
        return new Resp().status(FAIL);
    }

    public static Resp isFail(Throwable e){
        return new Resp().msg(e);
    }


    private Resp status(int status) {
        this.setStatus(status);
        return this;
    }

    private Resp msg(Throwable e){
        this.setMsg(e.toString());
        return this;
    }

    public Resp data(T data){
        this.setData(data);
        return this;
    }








}
