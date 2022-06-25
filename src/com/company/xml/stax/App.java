package com.company.xml.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import com.company.xml.Employee;
import com.company.xml.UserRepository;
import com.company.xml.UserRepositoryInMemory;

public class App {
    private static final UserRepository repo = new UserRepositoryInMemory();
    private static final StAXSerializer xmlWriter = new StAXSerializer();
    private static final StAXDeserializer xmlReader = new StAXDeserializer();

    public static void main(String[] args) throws FileNotFoundException, IOException, XMLStreamException {

        try (OutputStream out = new FileOutputStream("resources/employees-stax.xml")) {
            List<Employee> employees = repo.getAll();
            xmlWriter.serialize(employees, out);
        }

        try (InputStream in = new FileInputStream("resources/employees.xml")) {
            List<Employee> employees = xmlReader.deserialize(in);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
