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

        person.setUser_id( personDTO.getUser_id() );
        person.setPassword( personDTO.getPassword() );
        person.setName( personDTO.getName() );

        personMapper.insertPerson(person);
    }
    //로그인
    public PersonDTO getPerson(PersonDTO personDTO) {

        Person person = personMapper.getPerson(personDTO.getUser_id(), personDTO.getPassword());

        PersonDTO data = new PersonDTO();
        data.setId( person.getId() );

        return data;
    }

    //회원정보 조회
    public PersonDTO getPersonData(long id) {
        Person person = personMapper.getPersonData(id);

        PersonDTO data = new PersonDTO();
        data.setUser_id( person.getUser_id() );
        data.setName( person.getName());
        data.setPassword( person.getPassword());

        return data;
    }

    //회원정보 수정
    public  void updatePerson(PersonDTO personDTO) {

        Person person = new Person();

        person.setName( personDTO.getName() );
        person.setPassword( personDTO.getPassword() );
        person.setUser_id( personDTO.getUser_id() );

        personMapper.updatePerson(person);

    }


    //회원정보 삭제
    public  void deletePerson(PersonDTO personDTO) {
        personMapper.deletePerson(personDTO.getUser_id());
    }
}
