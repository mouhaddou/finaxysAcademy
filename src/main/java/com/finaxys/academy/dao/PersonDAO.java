package com.finaxys.academy.dao;
import java.util.Date;
import java.util.List;

import com.finaxys.academy.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {

    public List<Person> findByFullNameLike(String name);

    public List<Person> findByDateOfBirthGreaterThan(Date date);

}