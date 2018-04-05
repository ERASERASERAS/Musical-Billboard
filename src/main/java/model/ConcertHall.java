package model;

public class ConcertHall {
    private int id;
    private String name, address, email, telephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ConcertHall(int id, String name, String address, String email, String telephone) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Name: "  + this.name + "\n Address: " + this.address + "\n Telephone: " + this.telephone
                + "\n Email: " + this.email;
    }
}
