import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jeansmits on 3/06/15.
 */
public class TestOfFilmDirectors extends SuperTestOurShizzle{
    @Test
    public void testA() throws Exception {
        Film fe = em.find(Film.class, 1);
        fe.getActors();
        fe.getTitle();


    }

    @Test
    public void testB() throws Exception {
        Actor a = em.find(Actor.class,1);

        a.getFilms();

    }

    @Test
    public void testAddStuff() throws Exception {
        Film f = new Film("The fastest man alive", Genre.ACTIE);
        em.persist(f);
        assertNotNull(f.getId());
        Film fe = new Film("Dance with Dragons", Genre.ACTIE);
        em.persist(fe);
        assertNotNull(fe.getId());
        Actor a = new Actor("Barry", "Allen", Gender.MALE);
        em.persist(a);
        assertNotNull(a.getId());
        Director d = new Director("Michael Bay");
        em.persist(d);
        assertNotNull(d.getId());
        f.setD(d);
        f.addActor(a);
        fe.addActor(a);
//        List<Actor>actors = new ArrayList<>();
//        actors.add(a);
//        List<Film> films = new ArrayList<>();
//        films.add(f);
//        films.add(fe);
//
//        a.setFilms(films);
//        f.setActors(actors);
    }
}
