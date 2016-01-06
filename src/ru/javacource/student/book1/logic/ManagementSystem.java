package ru.javacource.student.book1.logic;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class ManagementSystem
{
    private List<Group> groups;
    private Collection<Student> students;

    // статическая переменная для Singletone
    private static ManagementSystem instance;


    private ManagementSystem()
    {
        loadGroups();
        loadStudents();
    }

    public static synchronized ManagementSystem getInstance()
    {
        if (instance == null)
        {
            instance = new ManagementSystem();
        }

        return instance;
    }

    //public static void main(String[] args)
    //{
    //
    //    try
    //    {
    //        System.setOut(new PrintStream("out.txt"));
    //
    //    } catch (FileNotFoundException e)
    //    {
    //        e.printStackTrace();
    //        return;
    //    }
    //
    //
    //    ManagementSystem ms = ManagementSystem.getInstance();
    //
    //
    //    // Просмотр полного списка групп
    //    printString("Полный список групп");
    //    printString("*******************");
    //    List<Group> allGroups = ms.getGroups();
    //
    //    for(Group gi : allGroups)
    //    {
    //        printString(gi);
    //    }
    //    printString();
    //
    //
    //    // Просмотр полного списка студентов
    //    printString("Полный список студентов");
    //    printString("***********************");
    //    Collection<Student> allStudents = ms.getAllStudents();
    //    for(Student si : allStudents)
    //    {
    //        printString(si);
    //    }
    //    printString();
    //
    //
    //    // Вывод списков студентов по группам
    //    printString("Список студентов по группам");
    //    printString("***************************");
    //    List<Group> groups = ms.getGroups();
    //
    //    for(Group gi : groups)
    //    {
    //        printString("---> Группа:" + gi.getNameGroup());
    //
    //        Collection<Student> students = ms.getStudentsFromGroup(gi, 2006);
    //
    //        for(Student si : students)
    //        {
    //            printString(si);
    //        }
    //    }
    //    printString();
    //
    //
    //    // Создадим нового студента и добавим его в список
    //    Student s = new Student();
    //
    //    Calendar c = Calendar.getInstance();
    //    c.set(1991, Calendar.AUGUST, 31);
    //
    //    s.setStudentId(5);
    //    s.setFirstName("Игорь");
    //    s.setSurName("Перебежкин");
    //    s.setPatronymic("Владимирович");
    //    s.setSex('М');
    //    s.setDateOfBirth(c.getTime());
    //    s.setGroupId(1);
    //    s.setEducationYear(2006);
    //
    //    printString("Добавление студента: " + s);
    //    printString("********************");
    //
    //    ms.insertStudent(s);
    //    printString("--->> Полный список студентов после добавления");
    //    allStudents = ms.getAllStudents();
    //    printAllStudents(allStudents);
    //
    //
    //    // Изменим данные о студенте - Перебежкин станет у нас Новоперебежкиным
    //    // Но все остальное будет таким же - создаем студента с таким же ИД
    //    s = new Student();
    //    s.setStudentId(5);
    //    s.setFirstName("Игорь");
    //    s.setPatronymic("Владимирович");
    //    s.setSurName("Новоперебежкин");
    //    s.setSex('М');
    //    c = Calendar.getInstance();
    //    c.set(1991, Calendar.AUGUST, 31);
    //    s.setDateOfBirth(c.getTime());
    //    s.setGroupId(1);
    //    s.setEducationYear(2006);
    //    printString("Редактирование данных студента: " + s);
    //    printString("*******************************");
    //    ms.updateStudent(s);
    //    printString("--->> Полный список студентов после редактирования");
    //    allStudents = ms.getAllStudents();
    //    printAllStudents(allStudents);
    //
    //    // Удалим нашего студента
    //    printString("Удаление студента: " + s);
    //    printString("******************");
    //    ms.deleteStudent(s);
    //    printString("--->> Полный список студентов после удаления");
    //    allStudents = ms.getAllStudents();
    //    printAllStudents(allStudents);
    //
    //    // Здесь мы переводим всех студентов одной группы в другую
    //    // Мы знаем, что у нас 2 группы
    //    // Не совсем элегантное решение, но пока сделаем так
    //    Group g1 = groups.get(0);
    //    Group g2 = groups.get(1);
    //    printString("Перевод студентов из 1-ой во 2-ю группу");
    //    printString("***************************************");
    //    ms.moveStudentsToGroup(g1, 2006, g2, 2007);
    //    printString("--->> Полный список студентов после перевода");
    //    allStudents = ms.getAllStudents();
    //    printAllStudents(allStudents);
    //
    //    // Удаляем студентов из группы
    //    printString("Удаление студентов из группы: " + g2 + " в 2006 году");
    //    printString("*****************************");
    //    ms.removeStudentsFromGroup(g2, 2006);
    //    printString("--->> Полный список студентов после удаления");
    //    allStudents = ms.getAllStudents();
    //
    //    for(Student allStudent : allStudents)
    //    {
    //        printString(allStudent);
    //    }
    //    printString();
    //}

    public void loadGroups()
    {
        // Метод создает две группы и помещает их в коллекцию для групп

        // Проверяем - может быть наш список еще не создан вообще
        if (groups == null)
        {
            groups = new ArrayList<>();
        } else
        {
            groups.clear();
        }

        Group g;

        g = new Group();
        g.setGroupId(1);
        g.setNameGroup("Первая");
        g.setCurator("Доктор Борменталь");
        g.setSpeciality("Создание собачек из человеков");
        groups.add(g);

        g = new Group();
        g.setGroupId(2);
        g.setNameGroup("Вторая");
        g.setCurator("Профессор Преображенский");
        g.setSpeciality("Создание человеков из собачек");
        groups.add(g);

    }

    public void loadStudents()
    {
        if (students == null)
        {
            // Мы используем коллекцию, которая автоматически сортирует свои элементы
            students = new TreeSet<>();
        } else
        {
            students.clear();
        }

        Student s;
        Calendar c = Calendar.getInstance();

        // Вторая группа
        s = new Student();
        s.setStudentId(1);
        s.setFirstName("Иван");
        s.setPatronymic("Сергеевич");
        s.setSurName("Степанов");
        s.setSex('М');
        c.set(1990, Calendar.MARCH, 20);
        s.setDateOfBirth(c.getTime());
        s.setGroupId(2);
        s.setEducationYear(2006);
        students.add(s);

        s = new Student();
        s.setStudentId(2);
        s.setFirstName("Наталья");
        s.setPatronymic("Андреевна");
        s.setSurName("Чичикова");
        s.setSex('Ж');
        c.set(1990, Calendar.JUNE, 10);
        s.setDateOfBirth(c.getTime());
        s.setGroupId(2);
        s.setEducationYear(2006);
        students.add(s);

        // Первая группа
        s = new Student();
        s.setStudentId(3);
        s.setFirstName("Петр");
        s.setPatronymic("Викторович");
        s.setSurName("Сушкин");
        s.setSex('М');
        c.set(1991, Calendar.FEBRUARY, 12);
        s.setDateOfBirth(c.getTime());
        s.setEducationYear(2006);
        s.setGroupId(1);
        students.add(s);

        s = new Student();
        s.setStudentId(4);
        s.setFirstName("Вероника");
        s.setPatronymic("Сергеевна");
        s.setSurName("Ковалева");
        s.setSex('Ж');
        c.set(1991, Calendar.JULY, 19);
        s.setDateOfBirth(c.getTime());
        s.setEducationYear(2006);
        s.setGroupId(1);
        students.add(s);
    }

    // Получить список групп
    public List<Group> getGroups()
    {
        return groups;
    }

    // Получить список всех студентов
    public Collection<Student> getAllStudents()
    {
        return students;
    }

    // Получить список студентов для определенной группы
    public Collection<Student> getStudentsFromGroup(Group group, int year)
    {
        Collection<Student> l = new TreeSet<>();
        for(Student si : students)
        {
            if (si.getGroupId() == group.getGroupId() && si.getEducationYear() == year)
            {
                l.add(si);
            }
        }
        return l;
    }

    // Перевести студентов из одной группы с одним годом обучения в другую группу с другим годом обучения
    public void moveStudentsToGroup(Group oldGroup, int oldYear, Group newGroup, int newYear)
    {
        for(Student si : students)
        {
            if (si.getGroupId() == oldGroup.getGroupId() && si.getEducationYear() == oldYear)
            {
                si.setGroupId(newGroup.getGroupId());
                si.setEducationYear(newYear);
            }
        }
    }

    // Удалить всех студентов из определенной группы
    public void removeStudentsFromGroup(Group group, int year)
    {
        // Мы создадим новый список студентов БЕЗ тех, кого мы хотим удалить.
        // Возможно не самый интересный вариант. Можно было бы продемонстрировать
        // более элегантный метод, но он требует погрузиться в коллекции более глубоко
        // Здесь мы не ставим себе такую цель
        Collection<Student> tmp = new TreeSet<>();
        for(Student si : students)
        {
            if (si.getGroupId() != group.getGroupId() || si.getEducationYear() != year)
            {
                tmp.add(si);
            }
        }

        students = tmp;
    }

    // Добавить студента
    public void insertStudent(Student student)
    {
        // Просто добавляем объект в коллекцию
        students.add(student);
    }

    // Обновить данные о студенте
    public void updateStudent(Student student)
    {
        // Надо найти нужного студента (по его ИД) и заменить поля
        Student updStudent = null;
        for(Student si : students)
        {
            if (si.getStudentId() == student.getStudentId())
            {
                // Вот этот студент - запоминаем его и прекращаем цикл
                updStudent = si;
                break;
            }
        }

        updStudent.setFirstName(student.getFirstName());
        updStudent.setPatronymic(student.getPatronymic());
        updStudent.setSurName(student.getSurName());
        updStudent.setSex(student.getSex());
        updStudent.setDateOfBirth(student.getDateOfBirth());
        updStudent.setGroupId(student.getGroupId());
        updStudent.setEducationYear(student.getEducationYear());
    }

    // Удалить студента
    public void deleteStudent(Student student)
    {
        // Надо найти нужного студента (по его ИД) и удалить
        Student delStudent = null;
        for(Student si : students)
        {
            if (si.getStudentId() == student.getStudentId())
            {
                // Вот этот студент - запоминаем его и прекращаем цикл
                delStudent = si;
                break;
            }
        }
        students.remove(delStudent);
    }


    public static void printAllStudents(Collection<Student> allStudents)
    {
        allStudents.forEach(ManagementSystem::printString);
        printString();
    }


    public static void printString(Object o)
    {
        System.out.println(o.toString());

        //try
        //{
        //  System.out.println(new String(o.toString().getBytes("windows-1251"), "windows-1252"));
        //} catch (UnsupportedEncodingException e)
        //{
        //    e.printStackTrace();
        //}
    }


    public static void printString()
    {
        System.out.println();
    }

}
