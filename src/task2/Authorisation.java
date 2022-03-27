package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Authorisation {

    public static Set<User> setUser = new HashSet<User>();


    /**
     * Задание 2
     * Необходимо разработать приложение, которое позволит сохранять информацию о логинах пользователей
     * и их паролях. Каждому пользователю соответствует пара
     * логин — пароль. При старте приложение отображается
     * меню:
     * 1. Добавить нового пользователя.
     * 2. Удалить существующего пользователя.
     * 3. Проверить существует ли пользователь.
     * 4. Изменить логин существующего пользователя.
     * 5. Изменить пароль существующего пользователя.
     * В зависимости от выбора пользователя выполняется действие, после чего меню отображается снова. Для
     * решения задачи используйте подходящий класс из Java
     * Collections Framework.
     */

    public static void main(String[] args) throws IOException {
        User user = new User();
        Authorisation a = new Authorisation();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a.showMenu();
        String check = "[1-5]";
        String read = br.readLine();
        int number = 0;
        try {
            number = Integer.parseInt(read);
        } catch (NumberFormatException n) {
            System.out.println("The value entered was wrong! ");
            br.close();
        }
        while (number > 0 && number < 6) {
            if (read.matches(check)) {

                switch (number) {
                    case 1:
                        System.out.println("Enter the login ! ");
                        user.setUserName(br.readLine());
                        System.out.println("Enter the password ! ");
                        user.setPassword(br.readLine());
                        a.addNewUser(user.getUserName(), user.getPassword());
                        System.out.println("New user has been added!");
                        a.showElementsFromCollection();
                        break;
                    case 2:
                        System.out.println("Enter user name for delete !");
                        user.setUserName(br.readLine());
                        System.out.println("Enter password !");
                        user.setPassword(br.readLine());
                        a.deleteUser(user.getUserName(), user.getPassword());
                        a.showElementsFromCollection();
                        break;
                    case 3:
                        System.out.println("Enter user name for check exist or not such a user ");
                        user.setUserName(br.readLine());
                        boolean isExist = a.isExistUser(user.getUserName());
                        if (isExist) {
                            System.out.println("Such the user is Exist .");
                        } else {
                            System.out.println("Such the user is not Exist .");
                        }
                        break;
                    case 4:
                        System.out.println("Enter your old login to change it !");
                        user.setUserName(br.readLine());
                        System.out.println("Enter your new  login !");
                        String newLogin = br.readLine();
                        a.changeLogin(user.getUserName(), newLogin);
                        System.out.println("Your new login was installed!");
                        a.showElementsFromCollection();
                        break;

                    case 5:
                        System.out.println("Enter your  login to change password !");
                        user.setUserName(br.readLine());
                        System.out.println("Enter a new password to change it !");
                        String newPassword = br.readLine();
                        a.changePassword(user.getUserName(), newPassword);
                        System.out.println("Your the password was changed!");
                        a.showElementsFromCollection();
                        break;
                }
            }
            read = br.readLine();
            number = Integer.parseInt(read);
        }


    }

    public void showElementsFromCollection() {
        System.out.println(setUser);
    }

    public boolean changePassword(String userName, String newPassword) {
        Iterator<User> iterator = setUser.iterator();
        User u = new User();
        while (iterator.hasNext()) {
            u = iterator.next();
            if (u.getUserName().equals(userName)) {
                iterator.remove();
                setUser.add(new User(userName, newPassword));
                return true;
            }
        }
        return false;
    }

    public boolean changeLogin(String oldUserName, String newUserName) {
        Iterator<User> iterator = setUser.iterator();
        User u = new User();

        while (iterator.hasNext()) {
            u = iterator.next();
            if (u.getUserName().equals(oldUserName)) {
                String passw = u.getPassword();
                iterator.remove();
                setUser.add(new User(newUserName, passw));
                return true;
            }
        }
        return false;
    }

    public boolean addNewUser(String userName, String password) {

        return setUser.add(new User(userName, password));

    }

    public void deleteUser(String userName, String password) {
        User user = new User(userName, password);
        Iterator<User> iterator = setUser.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(user)) {
                iterator.remove();
            }
        }
    }

    public boolean isExistUser(String userName) {
        boolean isExist = false;
        for (User e : setUser) {
            if (e.getUserName().equals(userName)) {
                isExist = true;
                System.out.println(e.hashCode1());
                return isExist;
            }
        }
        return isExist;
    }

    public void showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Меню: \n");
        sb.append("1. Добавить нового пользователя.\n");
        sb.append("2. Удалить существующего пользователя.\n");
        sb.append("3. Проверить существует ли пользователь.\n");
        sb.append("4. Изменить логин существующего пользователя.\n");
        sb.append("5. Изменить пароль существующего пользователя.\n");
        System.out.println(sb);
    }


}
