package org.zerock.myapp.exception;


// 예외처리 클래스의 기본골격
public class DAOException  extends  Exception{
    private static final long serialVersionUID = 1L;

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

} // end class
