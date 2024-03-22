package com.jyx.test.xmlP;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName: XMLParser
 * @Description:
 * @Author: jyx
 * @Date: 2024-01-29 10:49
 **/
public class XMLParser {

    public static void main(String[] args) {
        try {
            String xmlString =
                    "<InitialData>" +
                            "<Component>" +
                            "<Section Virtual=\"True\">" +
                            "<Code Code=\"V001\" DisplayName=\"\"/>" +
                            "<Code1 Code1=\"V00111\" DisplayName1=\"\"/>" +
                            "<Code Code=\"V002\" DisplayName=\"\"/>" +
                            "<Composite>" +
                            "</Composite>" +
                            "</Section>" +
                            "</Component>" +
                            "</InitialData>";

            XmlMapper xmlMapper = new XmlMapper();
            InitialData initialData = xmlMapper.readValue(xmlString, InitialData.class);

            // 输出解析后的对象
            System.out.println("解析完成: " + initialData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@ToString
class InitialData {

    @JacksonXmlProperty(localName = "Code")
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    @JacksonXmlProperty(localName = "Component")
    private Component Component;

    public void setComponent(Component component) {
        this.Component = component;
    }
}

@ToString
class Component {

    @JacksonXmlProperty(localName = "Section")
    private Section Section;

    public void setSection(Section section) {
        this.Section = section;
    }
}

@ToString
class Section {

    @JacksonXmlProperty(localName = "Virtual")
    private String Virtual;
    @JacksonXmlProperty(localName = "Code")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Code> Code;
    @JacksonXmlProperty(localName = "Composite")
    private String Composite;

    @JacksonXmlProperty(localName = "Code1")
    public Code1 code1;

    public void setCode1(Code1 code1) {
        this.code1 = code1;
    }

    public void setVirtual(String virtual) {
        Virtual = virtual;
    }

    public void setCode(List<com.jyx.test.xmlP.Code> code) {
        Code = code;
    }

    public void setComposite(String composite) {
        this.Composite = composite;
    }
}

@ToString
class Code {
    @JacksonXmlProperty(localName = "Code")
    private String Code;
    @JacksonXmlProperty(localName = "DisplayName")
    private String DisplayName;

    public void setCode(String code) {
        this.Code = code;
    }

    public void setDisplayName(String displayName) {
        this.DisplayName = displayName;
    }
}

@ToString
class Code1 {
    @JacksonXmlProperty(localName = "Code1")
    private String Code;
    @JacksonXmlProperty(localName = "DisplayName1")
    private String DisplayName;

    public void setCode(String code) {
        this.Code = code;
    }

    public void setDisplayName(String displayName) {
        this.DisplayName = displayName;
    }
}
