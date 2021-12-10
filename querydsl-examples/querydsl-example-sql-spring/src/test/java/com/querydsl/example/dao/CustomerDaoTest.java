package com.querydsl.example.dao;

import com.querydsl.example.dto.Customer;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.annotations.PropertyType;
import com.querydsl.sql.SQLQueryFactory;
//import com.querydsl.core.types.dsl.numberTemplate;
//import org.junit.core.type.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoTest extends AbstractDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Test
    public void findAll() {
        List<Customer> customers = customerDao.findAll();
        assertFalse(customers.isEmpty());
    }

    @Test
    public void findById() {
        assertNotNull(customerDao.findById(1));
    }

    @Test
    public void update() {
        Customer customer = customerDao.findById(1);
        customerDao.save(customer);
    }

    @Test
    public void delete() {
        Customer customer = customerDao.findById(1);
        customerDao.delete(customer);
        assertNull(customerDao.findById(1));
    }

    /*
    * Begin added tests:
    * -problem was "1L" an input was returning null pointer exception instead of incompatible type
    * -"1L" is a quoted string
    */

    /*
    @Test
    //received correct "incompatible type" error when using findbyId of quoted string
    //testing inside of a prewritten function
    public void findById_string() {

        assertNotNull(customerDao.findById(Expressions.numberTemplate(Long.class,"'1L'")));
    }

    //received correct "incompatible type" error when writing a query function from scratch
    @Test
    public void mod_findAll() {
        SQLQueryFactory queryFactory;
        List<Customer> customers = queryFactory.from(customerDao).select(Expressions.numberTemplate(Long.class,"'1L'")).fetch();
        assertFalse(customers.isEmpty());
    }*/

}
