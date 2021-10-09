package com.hfm.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-07 21:32
 * @Description 使用 SAX 解析原样输出 XML 文件
 * @date 2020/8/7
 */
public class PrintXML {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1.使用 SAXParserFactory 工厂类对象，然后创建 SAXParser 对象
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        // 2.创建监听器子类
        DefaultHandler defaultHandler = new DefaultHandler() {
            private StringBuffer stringBuffer = new StringBuffer();

            public String getContent() {
                return this.stringBuffer.toString();
            }

            /**
             * 遇到开始位置触发
             * @throws SAXException
             */
            @Override
            public void startDocument() throws SAXException {
                super.startDocument();
                System.out.println("开始 SAX 解析");
            }

            /**
             * 遇到开始标签
             * @param uri
             * @param localName
             * @param qName 表示开始标签名称
             * @param attributes 属性
             * @throws SAXException
             */
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // super.startElement(uri, localName, qName, attributes);
                this.stringBuffer.append("<" + qName);
                if (attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        this.stringBuffer.append(" " + attributes.getQName(i) + "=/" + attributes.getValue(i) + "/");
                    }
                }
                this.stringBuffer.append(">");
            }

            /**
             * 遇到结束标签
             */
            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                //super.endElement(uri, localName, qName);
                this.stringBuffer.append("<" + qName + ">");

            }

            /**
             * 遇到文本内容
             * @param ch 表示当前读到的文本内容
             * @param start 表示当前内容的起始位置
             * @param length 表示当前内容的长度
             * @throws SAXException
             */
            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                //super.characters(ch, start, length);
                String content = new String(ch, start, length);
                this.stringBuffer.append(content);
            }

            /**
             * 解析结束
             * @throws SAXException
             */
            @Override
            public void endDocument() throws SAXException {
                super.endDocument();
                System.out.println(getContent());
                System.out.println("结束 SAX 解析");
            }
        };

        // 3. SAX 解析 XML 文件
        saxParser.parse(new File("xml\\xml\\contacts.xml"), defaultHandler);
    }
}
