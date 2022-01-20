package com.sbrf.reboot.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     */
    @Test
    public void addStudentToRating() {

        // Наеврное в формулировке задания предполгася связанный список, раз студент
        // доавлялся в начало списка, но можно предпологать, что в будущем студенты будут
        // добавляться и в середену списка тоже. Так что ArrayList.
        List<String> students = new ArrayList<>();

        students.add("Козлов");
        students.add("Петров");
        students.add("Сидоров");
        students.add("Ганжа");


        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = new HashSet<>();

        moneyBox.add(1);
        moneyBox.add(2);
        moneyBox.add(3);
        moneyBox.add(4);
        moneyBox.add(5);
        moneyBox.add(6);
        moneyBox.add(7);
        moneyBox.add(8);
        moneyBox.add(9);
        moneyBox.add(10);

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }

        List<Book> bookshelf = new ArrayList<>();

        bookshelf.add(new Book());
        bookshelf.add(new Book());
        bookshelf.add(new Book());

        assertEquals(3, bookshelf.size());
    }

    /*
     * Задание на 5+.
     *
     * Придумать и реализовать хотя бы один свой пример использования Collection framework
     * с описанием аналогично существующим.
     *
     * Задача.
     * Имеется список студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В каждом семестре происходит подсчетов оценок студент.
     *
     * Вопрос.
     * Какую коллекцию из Collection framework вы предпочтете для хранения и
     * использования списка студентов и их результатво?
     *
     * Предпологается, что фамилии студентов УНИКАЛЬНЫ!
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов с их суммарной оценкой
     *  что бы тест завершился успешно.
     */
    @Test
    public void addStudentWithRating() {

        Map<String, Integer> students = new HashMap<>();

        students.put("Козлов",55);
        students.put("Петров",54);
        students.put("Сидоров",53);
        students.put("Ганжа",52);


        assertEquals(4, students.size());
    }


}
