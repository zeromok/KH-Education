package org.zerock.myapp.exception;

// 예외클래스의 기본골격
public class ControllerException extends Exception{
    private static final long serialVersionUID = 1L;

    public ControllerException(String message) { super(message); }
    // 생성자 1

    public ControllerException(Exception e) { super(e); }
    // 생성자 2

}
