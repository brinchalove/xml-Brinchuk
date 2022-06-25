package com.company.xml.dom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.company.xml.Employee;
import com.company.xml.UserRepository;
import com.company.xml.UserRepositoryInMemory;

public class App {
    private static final DOMReader reader = new DOMReader();
    private static final DOMWriter writer = new DOMWriter();
    private static final UserRepository repo = new UserRepositoryInMemory();

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        try (InputStream in = new FileInputStream("resources/employees.xml")) {
            List<Employee> employees = reader.deserialize(in);
            employees.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream out = new FileOutputStream("resources/employees-dom.xml")) {
            List<Employee> employees = repo.getAll();
            Document doc = (Document) writer.createDocument(employees);
            writer.serialize(doc, out, true);
        }
    }

}
