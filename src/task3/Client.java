package task3;

import java.util.Objects;

public class Client {

    private String firstName;
    private String lastName;
    private int priority;

    public Client(String firstName, String lastName, int priority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
    }
    public Client(){}

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }



    public int getPriority() {
        return priority;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return priority == client.priority && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, priority);
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
