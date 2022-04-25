package CASE_STUDY.models.Person;

public abstract class Person {
    private String codeOfPerson;
    private String name;
    private String  dateOfBirth;
    private String gender;
    private int id;
    private int tel;
    private String email;

    public Person() {
    }

    public Person(String codeOfPerson, String name, String dateOfBirth, String gender,
                  int id, int tel, String email) {
        this.codeOfPerson = codeOfPerson;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.tel = tel;
        this.email = email;
    }

    public String getCodeOfPerson() {
        return codeOfPerson;
    }

    public void setCodeOfPerson(String codeOfPerson) {
        this.codeOfPerson = codeOfPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
