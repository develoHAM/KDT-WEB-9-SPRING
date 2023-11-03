package com.crud.crudtest.mapper;


import com.crud.crudtest.domain.Person;
import com.crud.crudtest.dto.PersonDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonMapper {



    //회원가입
    @Insert("INSERT INTO person (userid, password, name) VALUES ( #{userid}, #{password}, #{name} )")
    void insertPerson(Person person);


    //로그인
    @Select("SELECT * FROM person WHERE (userid=#{userid} and password=#{password}) ORDER BY id DESC LIMIT 1 ")
    Person getPerson(PersonDTO personDTO);

    //사용자 정보 조회
    @Select("SELECT * FROM person WHERE id=#{id}")
    Person getPersonData(PersonDTO personDTO);

    //사용자 정보 수정
    @Update("UPDATE person SET password=#{password}, name=#{name} WHERE userid=#{userid} ")
    void updatePerson(Person person);

    //사용자 정보 삭제
    @Delete("DELETE FROM person WHERE userid=#{userid}")
    void deletePerson(String userid);
}
