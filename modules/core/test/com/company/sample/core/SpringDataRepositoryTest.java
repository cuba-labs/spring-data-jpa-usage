package com.company.sample.core;

import com.company.sample.SampleTestContainer;
import com.haulmont.bali.db.MapHandler;
import com.haulmont.bali.db.QueryRunner;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.Metadata;
import com.company.sample.core.repositories.CustomerRepository;
import com.company.sample.core.repositories.OrderRepository;
import com.company.sample.entity.Address;
import com.company.sample.entity.Customer;
import com.company.sample.entity.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SpringDataRepositoryTest {

    @ClassRule
    public static SampleTestContainer cont = SampleTestContainer.Common.INSTANCE;

    private Persistence persistence;
    private Metadata metadata;
    private Repositories repositories;
    private EntityStates entityStates;

    private Customer customer1, customer2;
    private Order order1;

    @Before
    public void setUp() throws Exception {
        persistence = cont.persistence();
        metadata = cont.metadata();
        repositories = AppBeans.get(Repositories.class);
        entityStates = AppBeans.get(EntityStates.class);

        customer1 = metadata.create(Customer.class);
        customer1.setName("cust1");
        customer1.setAddress(new Address());
        customer1.getAddress().setCity("Samara");

        customer2 = metadata.create(Customer.class);
        customer2.setName("some cust 2");
        customer2.setAddress(new Address());
        customer2.getAddress().setCity("Springfield");

        order1 = metadata.create(Order.class);
        order1.setCustomer(customer1);
        order1.setNumber("111");
        order1.setDate(new Date());

        persistence.runInTransaction(em -> {
            em.persist(customer1);
            em.persist(customer2);
            em.persist(order1);
        });
    }

    @After
    public void tearDown() throws Exception {
        QueryRunner runner = new QueryRunner(persistence.getDataSource());
        runner.update("delete from SAMPLE_ORDER");
        runner.update("delete from SAMPLE_CUSTOMER");
    }

    @Test
    public void testSave() throws SQLException {
        try (Transaction tx = persistence.getTransaction()) {
            CustomerRepository repository = repositories.get(CustomerRepository.class);

            assertNotNull(repository);

            Customer customer = metadata.create(Customer.class);
            customer.setName("customer");
            repository.save(customer);
        }

        QueryRunner runner = new QueryRunner(persistence.getDataSource());
        Map<String, Object> row = runner.query("select * from SAMPLE_CUSTOMER where ID = '" + customer1.getId() + "'",
                new MapHandler());
        assertNotNull(row.get("CREATE_TS"));
        assertNotNull(row.get("CREATED_BY"));
    }

    @Test
    public void testFindById() {
        Customer customer;
        try (Transaction tx = persistence.getTransaction()) {
            CustomerRepository repository = repositories.get(CustomerRepository.class);
            customer = repository.findOne(customer1.getId());
            assertEquals(customer1, customer);
            assertTrue(entityStates.isManaged(customer));
        }
        assertTrue(entityStates.isDetached(customer));
    }

    @Test
    public void testFindByProperty() {
        try (Transaction tx = persistence.getTransaction()) {
            CustomerRepository repository = repositories.get(CustomerRepository.class);
            Customer customer = repository.findByName(customer1.getName());
            assertEquals(customer1, customer);
        }
    }

    @Test
    public void testFindByPropertyOfEmbedded() {
        try (Transaction tx = persistence.getTransaction()) {
            CustomerRepository repository = repositories.get(CustomerRepository.class);
            List<Customer> customers = repository.findByAddressCity(customer1.getAddress().getCity());
            assertEquals(1, customers.size());
            assertEquals(customer1, customers.get(0));
        }
    }

    @Test
    public void testQueryWithAdvancedLike() {
        try (Transaction tx = persistence.getTransaction()) {
            CustomerRepository repository = repositories.get(CustomerRepository.class);
            List<Customer> customers = repository.findByNameStartingWith("cust");
            assertEquals(1, customers.size());
            assertEquals(customer1, customers.get(0));
        }
    }

    @Test
    public void testFindByAssociationProperty() {
        try (Transaction tx = persistence.getTransaction()) {
            OrderRepository repository = repositories.get(OrderRepository.class);
            List<Order> orders = repository.findByCustomer(customer1);
            assertEquals(1, orders.size());
            assertEquals(order1, orders.get(0));
        }
    }
}
