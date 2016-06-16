package Sample;

import org.apache.commons.collections.ListUtils;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FromExcel girls = new FromExcel();
        FromExcel boys = new FromExcel();
        FromExcel boys_and_girls = new FromExcel();
        System.out.println("Читаем excel-файл и записываем в ArrayList.");
        System.out.println("Первый файл:");
        List<Person> girlsList = girls.fromExcelToList("C:\\Users\\Haigus\\Documents\\Java Projects\\Maven\\List01.xlsx");
        System.out.println("Второй файл:");
        List<Person> boysList = boys.fromExcelToList("C:\\Users\\Haigus\\Documents\\Java Projects\\Maven\\List02.xlsx");

        System.out.println();
        System.out.println("Объединяем два ArrayList:");

        List<Person> sexIsNotImportant = ListUtils.union(girlsList, boysList);
        boys_and_girls.print_personArrayList(sexIsNotImportant);

        System.out.println();

        System.out.println("Сортируем ArrayList:");
        Collections.sort(sexIsNotImportant, new Compare());
        boys_and_girls.print_personArrayList(sexIsNotImportant);

        System.out.println();
        System.out.println("Переписываем порядковый номер:");
        boys_and_girls.renumber(sexIsNotImportant);
        boys_and_girls.print_personArrayList(sexIsNotImportant);

//        System.out.println();
//        System.out.println("Записываем содержимое ArrayList в txt.");
//        boys_and_girls.toTxt("Test.txt");

//        System.out.println();
//        System.out.println("Сортируем по возрасту и записываем результат в соответствующие txt.");
//        boys_and_girls.sortingByAge_lessThan20(sexIsNotImportant);
//        boys_and_girls.sortingByAge_moreThan20(sexIsNotImportant);

        System.out.println("Заполняем базу данных.");
        boys_and_girls.adding_to_DB(sexIsNotImportant);
    }
}