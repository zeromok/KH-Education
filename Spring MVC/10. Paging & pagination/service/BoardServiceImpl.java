package org.zerock.myapp.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.BoardMapper;

import java.util.List;

@Log4j2
@NoArgsConstructor

@Service
/*
스프링에 빈으로 등록되는 서비스객체의 Annotation
XML(root) 의 경우에는 <component-scan>에서 조사하는 패키지의 클래스들 중에 @Service 가 있는 클래스의 인스턴스를 스프링의 빈으로 설정
*/
public class BoardServiceImpl implements BoardService{

//    @Autowired
    @Setter(onMethod_= {@Autowired} )
    private BoardMapper mapper;

    @Override
    public List<BoardVO> getList() throws ServiceException {
        // 핵심 비지니스 로직 구현
        log.trace("getList() invoked.");

        try {

//            List<BoardVO> list = this.mapper.selectAllList();
//            return list;

            return this.mapper.selectAllList();

        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }// getList()

    @Override
    public boolean register(BoardDTO dto) throws ServiceException {
        // 핵심 비지니스 로직 구현
        log.trace("register({}) invoked.", dto);

        try {

//            return this.mapper.insert(dto) == 1;
            // 바꾸는 이유는 새롭게 등록된 게시글 번호를 받을 수 있는 메소드 이기 때문에
            return this.mapper.insertSelectKey(dto) == 1;
            // 비교연산자 자체가 true/false 값 반환

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }// register()

    @Override
    public boolean modify(BoardDTO dto) throws ServiceException {
        // 핵심 비지니스 로직 구현
        log.trace("modify({}) invoked.", dto);

        try {

            return this.mapper.update(dto) == 1;
            // 비교연산자 자체가 true/false 값 반환

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }// modify()

    @Override
    public boolean remove(BoardDTO dto) throws ServiceException {
        // 핵심 비지니스 로직 구현
        log.trace("remove({}) invoked.", dto);

        try {

            return this.mapper.delete(dto.getBno()) == 1;
            // 비교연산자 자체가 true/false 값 반환

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }// remove()

    @Override
    public BoardVO get(BoardDTO dto) throws ServiceException {
        // 핵심 비지니스 로직 구현
        log.trace("get({}) invoked.", dto);

        try {

//            List<BoardVO> list = this.mapper.selectAllList();
//            return list;

            return this.mapper.select(dto);

        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }// get()


    @Override
    public List<BoardVO> getListWithPaging(Criteria ct) throws ServiceException {
        log.trace("getListWithPaging({}) invoked.", ct);

        try{

            return this.mapper.selectListWithPaging(ct);

        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }// getListWithPaging


    @Override
    public int getTotal() throws ServiceException {
        log.trace("getTotal() invoked.");

        try{

            return this.mapper.getTotalCount();

        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }// getTotal()


}// end class
