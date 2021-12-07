package com.querydsl.example.dao;

import com.querydsl.example.dto.Customer;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.annotations.PropertyType;
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
    *Test submitted in issue is commented out below
    * -problem was "1L" an input was returning null pointer exception instead of incompatible type
    * -"1L" is a quoted string
    */

    /*
    @Test
    //received correct "incompatible type" error when using findbyId of quoted string
    public void findById_string() {

        assertNotNull(customerDao.findById("'1L'"));
    }*/

    //throw in a test for a field/select that wouldn't exist

    @Test
    public void mod_findAll() {
        //Customer customer = new Customer();
        //val num = Expressions.numberTemplate(Long.class, "'1L'");
        //val num = Expressions.numberTemplate(Long,"'1L'");
        List<Customer> customers = queryFactory.select(Expressions.numberTemplate(Long.class,"'1L'")).from(customerDao).fetchOne();
        //List<Customer> customers = customerDao.findAll(Expressions.numberTemplate(Long.class,"'1L'"));
        assertFalse(customers.isEmpty());
    }

    /*
    @Test
    public void find_list_by_predicate() {
        Tweet tw1 = new Tweet();
        tw1.setPosterId(posterId);
        tw1.setContent("It is a alive! #YOLO");
        repository.save(tw1);

        Tweet tw2 = new Tweet();
        tw2.setPosterId(posterId);
        tw2.setContent("Oh the humanity!");
        repository.save(tw2);

        Tweet tw3 = new Tweet();
        tw3.setPosterId(posterId);
        tw3.setContent("#EpicFail");
        repository.save(tw3);

        assertEquals(1, repository.findAll(tweet.content.contains("#YOLO")).size());
    }*/

    /*
    @Test
    fun `unexpectedly throws NPE on incompatible type`() {
    val num = Expressions.numberTemplate(Long::class.java, "'1L'")
    sql.select(num)
        .from(Expressions.stringTemplate("dual"))
        .fetch()
}*/

}
