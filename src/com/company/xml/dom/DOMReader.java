package com.company.xml.dom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.company.xml.Employee;

public class DOMReader {

    public List<Employee> deserialize(InputStream in) throws ParserConfigurationException, SAXException, IOException {
        InputStream is = new FileInputStream("resources/employees.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        List<Employee> employees = new ArrayList<>();
        Element root = document.getDocumentElement();
        NodeList nodes = root.getElementsByTagName("employee");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element empElm = (Element) nodes.item(i);
            Employee employee = new Employee();
            employees.add(employee);

            String rawId = empElm.getAttribute("id");
            Long id = Long.parseLong(rawId);
            employee.setId(id);

            Element firstNameElm = (Element) empElm.getElementsByTagName("firstName").item(0);
            String firstName = firstNameElm.getTextContent();
            employee.setFirstName(firstName);

            Element lastNameElm = (Element) empElm.getElementsByTagName("lastName").item(0);
            String lastName = lastNameElm.getTextContent();
            employee.setLastName(lastName);

            Element emailElm = (Element) empElm.getElementsByTagName("email").item(0);
            String email = emailElm.getTextContent();
            employee.setEmail(email);

            Element phoneNumberElm = (Element) empElm.getElementsByTagName("phoneNumber").item(0);
            String phoneNumber = phoneNumberElm.getTextContent();
            employee.setPhoneNumber(phoneNumber);

            Element passwordElm = (Element) empElm.getElementsByTagName("password").item(0);
            String password = passwordElm.getTextContent();
            employee.setPassword(password);

            Element tagElm = (Element) empElm.getElementsByTagName("tag").item(0);
            String tag = tagElm.getTextContent();
            employee.setTag(tag);

            Element userRoleIdElm = (Element) empElm.getElementsByTagName("userRoleId").item(0);
            String userRoleId = userRoleIdElm.getTextContent();
            employee.setUserRoleId((Byte.parseByte(userRoleId)));
        }
        return employees;
    }

}
