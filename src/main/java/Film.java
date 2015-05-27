import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeansmits on 27/05/15.
 */
@Entity
public class Film {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Genre genre;

    public Film() {
    }

    public Film(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
