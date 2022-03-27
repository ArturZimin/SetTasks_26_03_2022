package task3;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TaskThreeQueue extends Throwable {

    public static Queue<Integer> server = new PriorityQueue<>();

    public static Set<Statistic> setStatistic = new HashSet<Statistic>();

    public static void main(String[] args) {


    }


    /**
     * Задание 3
     * Разработать приложение, имитирующее очередь запросов к серверу.
     * Должны быть клиенты, посылающие
     * запросы на сервер, у каждого из которых есть свой приоритет.
     * Каждый новый клиент попадает в очередь в зависимости от своего приоритета.
     * Необходимо сохранять
     * статистику запросов (пользователь, время) в отдельной
     * очереди.
     * Предусмотреть вывод статистики на экран.
     */
}
