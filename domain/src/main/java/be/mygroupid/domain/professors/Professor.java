package be.mygroupid.domain.professors;

public class Professor {

    private int id;
    private String firstname;
    private String lastname;

    private Professor() {

    }

    public Professor(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public static class ProfessorBuilder {

        private int id;
        private String firstname;
        private String lastname;

    }
}
