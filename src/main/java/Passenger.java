import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeansmits on 26/05/15.
 */
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;

    private int ffm;
    private byte[] picture;
    @Column(name = " first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Transient
    private int age;
    @Enumerated(EnumType.STRING)
    private PassengerType type;
    @Column(nullable = false, updatable = false)
    @Access(AccessType.PROPERTY)
    private Date birthDate;

    public Passenger() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFfm() {
        return ffm;
    }

    public void setFfm(int ffm) {
        this.ffm = ffm;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
