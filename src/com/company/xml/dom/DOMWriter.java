package com.company.xml.dom;

import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.company.xml.Employee;

public class DOMWriter {
    public Document createDocument(List<Employee> employees) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = (Document) builder.newDocument();
            Element root = ((org.w3c.dom.Document) document).createElement("employees");
            ((org.w3c.dom.Document) document).appendChild(root);

            employees.forEach((employee) -> {
                serializeUser(document, employee, root);
            });

            return document;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void serializeUser(Document document, Employee employee, Element root) {
        Element empElm = ((org.w3c.dom.Document) document).createElement("employee");
        root.appendChild(empElm);
        empElm.setAttribute("id", String.valueOf(employee.getId()));

        Element firstName = ((org.w3c.dom.Document) document).createElement("firstName");
        empElm.appendChild(firstName);
        firstName.setTextContent(employee.getFirstName());

        Element lastName = ((org.w3c.dom.Document) document).createElement("lastName");
        empElm.appendChild(lastName);
        lastName.setTextContent(employee.getLastName());

        Element email = ((org.w3c.dom.Document) document).createElement("email");
        empElm.appendChild(email);
        email.setTextContent(employee.getEmail());

        Element phoneNumber = ((org.w3c.dom.Document) document).createElement("phoneNumber");
        empElm.appendChild(phoneNumber);
        phoneNumber.setTextContent(employee.getPhoneNumber());

        Element password = ((org.w3c.dom.Document) document).createElement("password");
        empElm.appendChild(password);
        password.setTextContent(employee.getPassword());

        Element tag = ((org.w3c.dom.Document) document).createElement("tag");
        empElm.appendChild(tag);
        tag.setTextContent(employee.getTag());

        Element userRoleId = ((org.w3c.dom.Document) document).createElement("userRoleId");
        empElm.appendChild(userRoleId);
        userRoleId.setTextContent(employee.getUserRoleId().toString());
    }

    public void serialize(Document document, OutputStream out, boolean prettyFormat) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            if (prettyFormat) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }
            transformer.transform(new DOMSource(document), new StreamResult(out));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
