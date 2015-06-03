import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class Filmtests extends SuperTestOurShizzle {
    @Test
    public void testfilm() throws Exception {
        Film f = new Film("The fastest man alive", Genre.ACTIE);
        em.persist(f);
        assertNotNull(f.getId());

    }

    @Test
    public void testactor() throws Exception {
        Actor a = new Actor("Barry", "Allen", Gender.MALE);
        em.persist(a);
        assertNotNull(a.getId());

    }
}
