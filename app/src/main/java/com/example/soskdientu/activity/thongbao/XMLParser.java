package com.example.soskdientu.activity.thongbao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLParser {
    //1. lay ve 1 tài liệu
    public Document getDocument(String xml) throws IOException, SAXException {
        Document document=null;
        //tao moi
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        InputSource inputSource = new InputSource();//tao input
        inputSource.setCharacterStream(new StringReader(xml));//tao luong
        inputSource.setEncoding("UTF-8");//set utf8
        document = builder.parse(inputSource);
        return document;
    }
    //2. lấy về giá trị node
    public String getValue(Element node, String name)
    {
        //2.1. lay ve danh sach cac node co cung name
        NodeList nodeList = node.getElementsByTagName(name);
        //2.2 lay ve text cua phan tu dau tien
        String kq = getTextNodeValue(nodeList.item(0));
        return kq;
    }
    //.3 lấy về text của node
    public  String getTextNodeValue(Node n)
    {
        //3.1 khai bao node con
        Node child;
        if(n!=null)
        {
            if(n.hasChildNodes())//neu co con
            {
                //dua vao for de lay thanh phan con
                for(child=n.getFirstChild(); child!=null;child=child.getNextSibling())
                {
                    //kiem tra co text node khong
                    if(child.getNodeType()==Node.TEXT_NODE)
                    {
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}
