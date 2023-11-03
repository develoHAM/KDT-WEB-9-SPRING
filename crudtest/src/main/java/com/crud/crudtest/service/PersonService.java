package com.crud.crudtest.service;


import com.crud.crudtest.domain.Person;
import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;


    public void insertPerson(PersonDTO personDTO) {
        Person person = new Person();

        person.setUserid( personDTO.getUserid() );
        person.setPassword( personDTO.getPassword() );
        person.setName( personDTO.getName() );

        personMapper.insertPerson(person);
    }
    //로그인
    public PersonDTO getPerson(PersonDTO personDTO) {

        Person person = personMapper.getPerson(personDTO);

        PersonDTO data = new PersonDTO();
        data.setId(person.getId());

        return data;
    }

    //회원정보 조죄
    public PersonDTO getPersonData(PersonDTO reqPer) {
        Person person = personMapper.getPersonData(reqPer);

        PersonDTO data = new PersonDTO();
        data.setId(person.getId());
        data.setUserid(person.getUserid());
        data.setPassword(person.getPassword());
        data.setName(person.getName());
        return data;
    }

    // 회원정보 수정
    public void updatePerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setPassword(personDTO.getPassword());
        person.setUserid(personDTO.getUserid());
        personMapper.updatePerson(person);
    }

    // 회원 정보 삭제
    public void deletePerson(String userid) {
        personMapper.deletePerson(userid);
    }
}
