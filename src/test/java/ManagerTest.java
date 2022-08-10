import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.*;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Product book1 = new Book(1, "Skazki", 1000, "Pushkin");
    Product book2 = new Book(2, "Rasskazy", 1200, "Tolstoy");
    Product book3 = new Book(3, "Novelly", 600, "Lermontov");
    Product book4 = new Book(4, "Povesty", 938, "Dostoevsky");
    Product book5 = new Book(5, "Povesty", 760, "Pushkin");
    Product phone1 = new Smartphone(1, "Model-1", 300, "Elephone");
    Product phone2 = new Smartphone(1, "Model-2", 350, "Elephone");
    Product phone3 = new Smartphone(1, "Model-1", 500, "Blackberry");

    @Test
    public void findAllBooks() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, book4, book5};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void searchTwoBooksByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);

        Product[] actual = manager.searchBy("Povesty");
        Product[] expected = {book4, book5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneBookByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);

        Product[] actual = manager.searchBy("Novelly");
        Product[] expected = {book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBadName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        Product[] actual = manager.searchBy("Opera");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        repo.remove(3);
        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book4, book5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllPhones() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


        Product[] actual = repo.findAll();
        Product[] expected = {phone1, phone2, phone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTwoPhonesByName() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


        Product[] actual = manager.searchBy("Model-1");
        Product[] expected = {phone1, phone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOnePhoneByName() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


        Product[] actual = manager.searchBy("Model-2");
        Product[] expected = {phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBadPhoneName() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }
}
