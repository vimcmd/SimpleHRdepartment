package ru.javacource.student.book1.logic;

import java.text.Collator;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Student implements Comparable
{
    private int studentId;
    private String firstName;
    private String surName;
    private String patronymic; // ОТЧЕСТВО
    private Date dateOfBirth;
    private char sex;
    private int groupId;
    private int educationYear;

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSurName()
    {
        return surName;
    }

    public void setSurName(String surName)
    {
        this.surName = surName;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public void setPatronymic(String patronymic)
    {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public char getSex()
    {
        return sex;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public int getGroupId()
    {
        return groupId;
    }

    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }

    public int getEducationYear()
    {
        return educationYear;
    }

    public void setEducationYear(int educationYear)
    {
        this.educationYear = educationYear;
    }

    @Override
    public String toString()
    {
        return new StringBuilder()
                .append(surName)
                .append(" ")
                .append(firstName)
                .append(" ")
                .append(patronymic)
                .append(", ")
                .append(DateFormat.getDateInstance(DateFormat.SHORT).format(getDateOfBirth()))
                .append(", Группа ID = ")
                .append(groupId)
                .append(", Год:")
                .append(educationYear)
                .toString();
    }

    public int compareTo(Object obj)
    {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}
