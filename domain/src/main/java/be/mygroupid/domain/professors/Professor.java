package be.mygroupid.domain.professors;
// copied code from example exercise
public class Professor {

    private String id;
    private String firstname;
    private String lastname;

    private Professor() {

    }

    Professor(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

        private String id;
        private String firstname;
        private String lastname;

        private ProfessorBuilder() {}

        public static ProfessorBuilder professor() { return new ProfessorBuilder(); }

        public Professor build() {
            Professor professor = new Professor();
            professor.setId(id);
            professor.setFirstname(firstname);
            professor.setLastname(lastname);
            return professor;
        }

        public ProfessorBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ProfessorBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public ProfessorBuilder withLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

    }

}