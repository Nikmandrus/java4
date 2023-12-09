package org.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = readPeopleFromCSV("foreign_names.csv");
        System.out.println(people);
    }

    public static List<Person> readPeopleFromCSV(String filename) {
        List<Person> people = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] line;
            reader.readNext(); // пропускаем заголовок

            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                String gender = line[2];
                Department department = new Department(Integer.parseInt(line[3]), line[4]);
                int salary = Integer.parseInt(line[5]);
                String birthdate = line[6];

                Person person = new Person(id, name, gender, department, salary, birthdate);
                people.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }

    static class Person {
        private int id;
        private String name;
        private String gender;
        private Department department;
        private int salary;
        private String birthdate;

        public Person(int id, String name, String gender, Department department, int salary, String birthdate) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.department = department;
            this.salary = salary;
            this.birthdate = birthdate;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getBirthdate() {
            return birthdate;
        }

        public void setBirthdate(String birthdate) {
            this.birthdate = birthdate;
        }
    }

    static class Department {
        private int id;
        private String name;

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}