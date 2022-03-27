package task3;

import task2.User;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class Statistic {

    private User user;
    private Date date;

    public Statistic(User user, Date date) {
        this.user = user;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return Objects.equals(user, statistic.user) && Objects.equals(date, statistic.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, date);
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "user=" + user +
                ", date=" + date +
                '}';
    }
}
