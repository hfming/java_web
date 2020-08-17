package com.hfm.servlet.demo.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-06 22:23
 * @Description
 * @date 2020/8/6
 */
public class XMLManager {
    private static FileOutputStream fileOutputStream = null;
    private static BufferedOutputStream bufferedOutputStream = null;
    /**
     * 漂亮的格式
     */
    private static OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
    /**
     * 紧凑的格式，更省空间
     */
    private static OutputFormat compactFormat = OutputFormat.createCompactFormat();

    /**
     * 静态代码块
     */
    static {
        // 设置输出的编码格式
        // 1.可以影响 XML 文档声明的 encoding 编码
        // 2.还可以影响 XML 文件保存的编码
        prettyPrint.setEncoding("utf-8");
        compactFormat.setEncoding("utf-8");
    }

    /**
     * 解析 XML 文件获取 documnet 对象
     *
     * @param url
     * @return
     */
    public static Document getDocument(String url) {
        // 1.创建 XML 解析器
        SAXReader saxReader = new SAXReader();

        // 2.创建 document 对象
        Document read = null;
        try {
            read = saxReader.read(url);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return read;
    }

    /**
     * 解析 XML 文件获取 documnet 对象
     *
     * @param url
     * @return
     */
    public static Element getRootElement(String url) {
        // 1.创建 XML 解析器
        SAXReader saxReader = new SAXReader();

        // 2.创建 document 对象
        Document read = null;
        Element rootElement = null;
        try {
            read = saxReader.read(url);
            // 3.获取根标签对象
            rootElement = read.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return rootElement;
    }

    /**
     * 写出 XML 文件
     *
     * @param document
     */
    public static void xmlWrite(Document document, String path) {
        XMLWriter xmlWriter = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            xmlWriter = new XMLWriter(fileOutputStream, prettyPrint);

            // 写出文件
            xmlWriter.write(document);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 写出 XML 文件
     *
     * @param rootElement
     */
    public static void xmlWrite(Element rootElement, String path) {
        XMLWriter xmlWriter = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            xmlWriter = new XMLWriter(fileOutputStream, prettyPrint);

            Document document = rootElement.getDocument();
            // 写出文件
            xmlWriter.write(document);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (xmlWriter != null) {
                try {
                    xmlWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
