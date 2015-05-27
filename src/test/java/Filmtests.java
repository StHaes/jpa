import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeansmits on 27/05/15.
 */
public class Filmtests extends SuperTestOurShizzle{
    @Test
    public void testfilm() throws Exception {
        Film f = new Film("The fastest man alive",Genre.ACTIE);
        em.persist(f);
        assertNotNull(f.getId());

    }
}
