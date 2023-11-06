package com.crud.crudtest.service;


import com.crud.crudtest.domain.Person;
import com.crud.crudtest.domain.PersonEntity;
import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.mapper.PersonMapper;
import com.crud.crudtest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
//    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public void insertPerson(PersonDTO personDTO) {
        Person person = new Person();

        person.setUser_id( personDTO.getUser_id() );
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

    //회원정보 조회
    public PersonDTO getPersonData(long id) {
//        Person person = personMapper.getPersonData(reqPer);
        Optional<PersonEntity> person = personRepository.findById(id)
        PersonDTO data = new PersonDTO();
        data.setUser_id(person.get().getUser_id());
        data.setPassword(person.get().getPassword());
        data.setName(person.get().getName());
        return data;
    }

    // 회원정보 수정
    public void updatePerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setPassword(personDTO.getPassword());
        person.setUser_id(personDTO.getUser_id());
        personMapper.updatePerson(person);
    }

    // 회원 정보 삭제
    public void deletePerson(String user_id) {
        personMapper.deletePerson(user_id);
    }
}
