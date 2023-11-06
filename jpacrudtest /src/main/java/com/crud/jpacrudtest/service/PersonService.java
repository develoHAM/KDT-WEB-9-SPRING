package com.crud.jpacrudtest.service;


import com.crud.jpacrudtest.domain.Person;
import com.crud.jpacrudtest.domain.PersonEntity;
import com.crud.jpacrudtest.dto.PersonDTO;
import com.crud.jpacrudtest.mapper.PersonMapper;
import com.crud.jpacrudtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public void insertPerson(PersonDTO personDTO) {
        PersonEntity person = new PersonEntity();

        person.setUserid( personDTO.getUserid() );
        person.setPassword( personDTO.getPassword() );
        person.setName( personDTO.getName() );

        personRepository.save(person);
    }
    //로그인
    public PersonDTO getPerson(PersonDTO personDTO) {
        Optional<PersonEntity> person = personRepository.findByUseridAndPassword(personDTO.getUserid(), personDTO.getPassword());

        PersonDTO data = new PersonDTO();
        data.setId( person.get().getId() );

        return data;
    }

    //회원정보 조회
    public PersonDTO getPersonData(long id) {
        Optional<PersonEntity> person = personRepository.findById(id);
        PersonDTO data = new PersonDTO();

        data.setUserid( person.get().getUserid() );
        data.setName( person.get().getName());
        data.setPassword( person.get().getPassword());
        return data;
    }

    //회원정보 수정
    public  void updatePerson(PersonDTO personDTO) {
        PersonEntity person = personRepository.findByUserid(personDTO.getUserid());

        person.setName( personDTO.getName() );
        person.setPassword( personDTO.getPassword() );
//        person.setUserid( personDTO.getUserid() );

        personRepository.save(person);
    }


    //회원정보 삭제
    public  void deletePerson(PersonDTO personDTO) {
        PersonEntity person = personRepository.findByUserid(personDTO.getUserid());
        personRepository.deleteById(person.getId());
    }
}
