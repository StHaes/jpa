
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
}
