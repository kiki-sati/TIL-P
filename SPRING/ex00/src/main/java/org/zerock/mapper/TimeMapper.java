package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//시간을 가지고 테스트 하는 습관 가지기
public interface TimeMapper {

    //mybatis 주의사항 ! -> ; 없어야 한다.
    @Select("select sysdate from dual")
    String getTime ();

}
