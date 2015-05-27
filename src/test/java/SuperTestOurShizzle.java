import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by jeansmits on 26/05/15.
 */
public abstract class SuperTestOurShizzle {
    private static EntityManagerFactory entityManagerFactory;
    protected EntityManager em;
    Logger logger = LoggerFactory.getLogger(TestOurShizzle.class);

    @BeforeClass
    public static void initializeemf() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("RealDolmenPersistenceUnit");

    }

    @AfterClass
    public static void destroyemf() {
        entityManagerFactory.close();

    }

    @Before
    public void initializeEM() {
        em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void destroyEM() {
        em.getTransaction().commit();
        em.close();
    }
}
