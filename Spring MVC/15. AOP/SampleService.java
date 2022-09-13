package org.zerock.myapp.service;


public interface SampleService {

    public abstract Integer doAdd(String op1, String op2) throws Exception;

    public abstract void methodForAroundAdvice() throws Exception;
}
