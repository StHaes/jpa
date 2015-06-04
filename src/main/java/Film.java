import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToMany
    private List<Actor> actors =new ArrayList<>();
    @ManyToOne
    private Director d;

    public Film() {
    }

    public Film(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;

    }

    public Director getD() {
        return d;
    }

    public void setD(Director d) {
        this.d = d;
    }
    public void addActor(Actor actor){
        actors.add(actor);
        actor.addFilm(this);
    }
}
