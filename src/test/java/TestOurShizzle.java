
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestOurShizzle extends SuperTestOurShizzle {

    @Test
    public void testOurLogic() {
        try {
            BookRepository bookRepository = new BookRepositoryBean(em);
            List<Book> books = bookRepository.findAllBooks();
            assertEquals(2, books.size());
        } catch (NullPointerException n) {
            System.out.println("result is NULL");

        }
    }

    @Test
    public void testname() throws Exception {
        List <Book> books = em.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals("Nineteen Eighty Four", books.get(0).getTitle());

    }

    @Test
    public void testGenerate() throws Exception {
        Book b = new Book("Dance with Dragons","Jsnow","0000000003");
        em.persist(b);
        assertNotNull(b.getId());

    }

    @Test
    public void testPassengergen() throws Exception {
        Passenger p = new Passenger("Jhonnny", "Dewolf",40, PassengerType.OCCASIONAL);
        em.persist(p);
        p.setAge(85);
        assertEquals(p.getAge(), 85);

    }

    @Test
    public void testdoublemerge() throws Exception {
        Book b = new Book("mergetest", "me","0000000004" );
        em.getTransaction().commit();
        em.clear();
        b.setAuthor("otherme");
        em.getTransaction().begin();
        b = em.merge(b);
        assertEquals(b.getAuthor(), "otherme");

    }
}
