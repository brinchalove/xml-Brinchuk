package com.company.xml.stax;

import java.io.OutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.company.xml.Employee;

public class StAXSerializer {
    public void serialize(List<Employee> employees, OutputStream out) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(out);
            writer.writeStartDocument();
            writer.writeStartElement("employees");

            for (Employee employee : employees) {
                serialize(employee, writer);
            }

            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } finally {
            close(writer);
        }
    }

    private void serialize(Employee employee, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("employee");
        writer.writeAttribute("id", employee.getId().toString());

        writer.writeStartElement("firstName");
        writer.writeCharacters(employee.getFirstName());
        writer.writeEndElement();

        writer.writeStartElement("lastName");
        writer.writeCharacters(employee.getLastName());
        writer.writeEndElement();

        writer.writeStartElement("email");
        writer.writeCharacters(employee.getEmail());
        writer.writeEndElement();

        writer.writeStartElement("password");
        writer.writeCharacters(employee.getPassword());
        writer.writeEndElement();

        writer.writeStartElement("phoneNumber");
        writer.writeCharacters(employee.getPhoneNumber());
        writer.writeEndElement();

        writer.writeStartElement("tag");
        writer.writeCharacters(employee.getTag());
        writer.writeEndElement();

        writer.writeStartElement("userRoleId");
        writer.writeCharacters(employee.getUserRoleId().toString());
        writer.writeEndElement();

        writer.writeEndElement();
    }

    private void close(XMLStreamWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (XMLStreamException e) {
                throw new RuntimeException();
            }
        }
    }
}
