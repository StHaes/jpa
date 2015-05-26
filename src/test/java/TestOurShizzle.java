import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestOurShizzle {


    private EntityManager em;
    @Test
    public void testOurLogic() {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em =
                entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            BookRepository bookRepository = new BookRepositoryBean(em);
            List<Book> books = bookRepository.findAllBooks();
            assertEquals(2, books.size());
        } catch (NullPointerException n){
            System.out.println("result is NULL");

        }

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }

}
