package Sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FromExcel {

    private List<Person> personArrayList = new ArrayList<>();

    public List<Person> fromExcelToList(String file) {

        try (FileInputStream inputStream = new FileInputStream(file)) {
            XSSFWorkbook myWorkBook = new XSSFWorkbook(inputStream);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator<Row> rowIterator = mySheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell numberCell = row.getCell(0);
                Cell nameCell = row.getCell(1);
                Cell ageCell = row.getCell(2);

                if (numberCell != null) {
                    Person person = new Person();
                    person.setNumber((int) Math.round(numberCell.getNumericCellValue()));
                    person.setName(nameCell.getStringCellValue());
                    person.setAge((int) Math.round(ageCell.getNumericCellValue()));
                    personArrayList.add(person);
                }
            }

            print_personArrayList(personArrayList);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return personArrayList;
    }

    public void toTxt(String file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Person i : personArrayList) {
                writer.write(i.getNumber() + "\t" + i.getName() + "\t" + i.getAge() + "\r\n");
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public void print_personArrayList(List<Person> persons) {
        personArrayList = persons;
        for (Person i : persons) {
            System.out.println(i.getNumber() + "\t" + i.getName() + "\t" + i.getAge());
        }
    }

    public void renumber(List<Person> persons) {
        personArrayList = persons;
        for (int i = 0, a = 1; i < persons.size(); i++, a++) {
            persons.get(i).setNumber(a);
        }
    }

    public void sortingByAge_lessThan20(List<Person> persons) {
        try (FileWriter writer1 = new FileWriter("LessThan20.txt")) {
            for (Person i : persons) {
                if (i.getAge() < 20) {
                    writer1.write(i.getNumber() + "\t" + i.getName() + "\t" + i.getAge() + "\r\n");
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public void sortingByAge_moreThan20 (List<Person> persons) {
        try (FileWriter writer1 = new FileWriter("MoreThan20.txt")) {
            for (Person i : persons) {
                if (i.getAge() > 19) {
                    writer1.write(i.getNumber() + "\t" + i.getName() + "\t" + i.getAge() + "\r\n");
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}