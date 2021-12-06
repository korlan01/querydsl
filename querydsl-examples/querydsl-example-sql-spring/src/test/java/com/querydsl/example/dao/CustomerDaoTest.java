package com.querydsl.example.dao;

import com.querydsl.example.dto.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    *Test submitted in issue is commented out below
    * -problem was "1L" an input was returning null pointer exception instead of incompatible type
    * -"1L" is a quoted string
    */

    @Test
    //
    public void findById_string() {

        assertNotNull(customerDao.findById("'1L'"));
    }

    /*
    @Test
    fun `unexpectedly throws NPE on incompatible type`() {
    val num = Expressions.numberTemplate(Long::class.java, "'1L'")
    sql.select(num)
        .from(Expressions.stringTemplate("dual"))
        .fetch()
}*/

}
