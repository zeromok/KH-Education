package org.zerock.myapp.service;


import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;

import java.util.List;

public interface BoardService {

    // 각 웹 3계층의 성격에 맞게 추상메소드의 이름을 결정해라

    // 1. 게시글 전체목록 획득(게시글번호의 역순으로....)
    public abstract List<BoardVO> getList() throws ServiceException;

    // 2. 새로운 게시글 등록
    public abstract boolean register(BoardDTO dto) throws ServiceException;

    // 3. 기존 게시글 수정
    public abstract boolean modify(BoardDTO dto) throws ServiceException;

    // 4. 기존 게시글 삭제
    public abstract boolean remove(BoardDTO dto) throws ServiceException;

    // 5. 특정 게시글 상세조회
    public abstract BoardVO get(BoardDTO dto) throws ServiceException;

//    ======================================= 페이징 처리 ================================

    // 1-1 페이징 처리된 게시글 목록 획득
    public abstract List<BoardVO> getListWithPaging(Criteria ct) throws ServiceException;

    // 6. 총 게시물 갯수 조회
    public abstract int getTotal() throws ServiceException;

}// end interface
