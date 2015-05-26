import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by jeansmits on 26/05/15.
 */
public class Main {
    public static void main(String[] args) {
        // Set up
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        BookRepository bookRepository = new BookRepositoryBean(entityManager);
        List<Book> books = bookRepository.findAllBooks();


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
