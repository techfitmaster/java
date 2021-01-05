package com.huzhengxing.test.q3;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test(timeout = 1000)
    public void testCreateTree() {
        Application application = new Application();
        RBTree<Integer, Person> tree = application.createTree();
        assertNotNull(tree);
        List<Node> nodeList = tree.preorder();
        assertNotNull(nodeList);
        assertFalse(nodeList.isEmpty());
        assertTrue(nodeList.size() >= 10);
        for(Node node : nodeList) {
            assertNotNull(node);
            assertNotNull(node.getKey());
            assertNotNull(node.getData());
        }
    }

    @Test(timeout = 1000)
    public void testSaveXml() {
        Person p1 = new Person(33, "name1", 1, "occ1");
        Person p2 = new Person(11, "name2", 2, "occ2");
        Person p3 = new Person(88, "name3", 3, "occ3");
        Person p4 = new Person(10, "name4", 4, "occ4");
        Person p5 = new Person(16, "name5", 5, "occ5");
        Person p6 = new Person(43, "name6", 6, "occ6");

        RBTree<Integer, Person> tree = new RBTree<>();
        tree.insert(p1.getId(), p1);
        tree.insert(p2.getId(), p2);
        tree.insert(p3.getId(), p3);
        tree.insert(p4.getId(), p4);
        tree.insert(p5.getId(), p5);
        tree.insert(p6.getId(), p6);

        Application application = new Application();
        application.saveXML(tree);


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("people.xml"));
            Element root = doc.getDocumentElement();

            NodeList nl = root.getElementsByTagName("person");
            List<Element> personNodes = new ArrayList<>();
            for (int i = 0; i < nl.getLength(); i++) {
                org.w3c.dom.Node n = nl.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element elem = (Element) n;
                    personNodes.add(elem);
                }
            }
            assertEquals(6, personNodes.size());
            // 10 RED, 11 BLACK, 16 RED, 33 BLACK, 43 RED,   88 BLACK

            assertEquals(10, Integer.parseInt(personNodes.get(0).getAttribute("id"))) ;
            assertEquals(4, Integer.parseInt(personNodes.get(0).getAttribute("age"))) ;
            assertEquals("name4", personNodes.get(0).getAttribute("name")) ;
            assertEquals("occ4", personNodes.get(0).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(11, Integer.parseInt(personNodes.get(1).getAttribute("id"))) ;
            assertEquals(2, Integer.parseInt(personNodes.get(1).getAttribute("age"))) ;
            assertEquals("name2", personNodes.get(1).getAttribute("name")) ;
            assertEquals("occ2", personNodes.get(1).getElementsByTagName("occupation").item(0).getTextContent()) ;

            assertEquals(16, Integer.parseInt(personNodes.get(2).getAttribute("id"))) ;
            assertEquals(5, Integer.parseInt(personNodes.get(2).getAttribute("age"))) ;
            assertEquals("name5", personNodes.get(2).getAttribute("name")) ;
            assertEquals("occ5", personNodes.get(2).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(33, Integer.parseInt(personNodes.get(3).getAttribute("id"))) ;
            assertEquals(1, Integer.parseInt(personNodes.get(3).getAttribute("age"))) ;
            assertEquals("name1", personNodes.get(3).getAttribute("name")) ;
            assertEquals("occ1", personNodes.get(3).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(43, Integer.parseInt(personNodes.get(4).getAttribute("id"))) ;
            assertEquals(6, Integer.parseInt(personNodes.get(4).getAttribute("age"))) ;
            assertEquals("name6", personNodes.get(4).getAttribute("name")) ;
            assertEquals("occ6", personNodes.get(4).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(88, Integer.parseInt(personNodes.get(5).getAttribute("id"))) ;
            assertEquals(3, Integer.parseInt(personNodes.get(5).getAttribute("age"))) ;
            assertEquals("name3", personNodes.get(5).getAttribute("name")) ;
            assertEquals("occ3", personNodes.get(5).getElementsByTagName("occupation").item(0).getTextContent()) ;


        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSaveXml2() {

        Person p1 = new Person(48, "name1", 1, "occ1");
        Person p2 = new Person(34, "name2", 2, "occ2");
        Person p3 = new Person(52, "name3", 3, "occ3");
        Person p4 = new Person(86, "name4", 4, "occ4");
        Person p5 = new Person(77, "name5", 5, "occ5");
        Person p6 = new Person(15, "name6", 6, "occ6");

        RBTree<Integer, Person> tree = new RBTree<>();
        tree.insert(p1.getId(), p1);
        tree.insert(p2.getId(), p2);
        tree.insert(p3.getId(), p3);
        tree.insert(p4.getId(), p4);
        tree.insert(p5.getId(), p5);
        tree.insert(p6.getId(), p6);

        Application application = new Application();
        application.saveXML(tree);


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("people.xml"));
            Element root = doc.getDocumentElement();

            NodeList nl = root.getElementsByTagName("person");
            List<Element> personNodes = new ArrayList<>();
            for (int i = 0; i < nl.getLength(); i++) {
                org.w3c.dom.Node n = nl.item(i);
                if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    Element elem = (Element) n;
                    personNodes.add(elem);
                }
            }
            assertEquals(6, personNodes.size());
            // 15 RED, 34 BLACK, 48 BLACK, 52 RED,  77 BLACK,  86 RED

            assertEquals(15, Integer.parseInt(personNodes.get(0).getAttribute("id"))) ;
            assertEquals(6, Integer.parseInt(personNodes.get(0).getAttribute("age"))) ;
            assertEquals("name6", personNodes.get(0).getAttribute("name")) ;
            assertEquals("occ6", personNodes.get(0).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(34, Integer.parseInt(personNodes.get(1).getAttribute("id"))) ;
            assertEquals(2, Integer.parseInt(personNodes.get(1).getAttribute("age"))) ;
            assertEquals("name2", personNodes.get(1).getAttribute("name")) ;
            assertEquals("occ2", personNodes.get(1).getElementsByTagName("occupation").item(0).getTextContent()) ;

            assertEquals(48, Integer.parseInt(personNodes.get(2).getAttribute("id"))) ;
            assertEquals(1, Integer.parseInt(personNodes.get(2).getAttribute("age"))) ;
            assertEquals("name1", personNodes.get(2).getAttribute("name")) ;
            assertEquals("occ1", personNodes.get(2).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(52, Integer.parseInt(personNodes.get(3).getAttribute("id"))) ;
            assertEquals(3, Integer.parseInt(personNodes.get(3).getAttribute("age"))) ;
            assertEquals("name3", personNodes.get(3).getAttribute("name")) ;
            assertEquals("occ3", personNodes.get(3).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(77, Integer.parseInt(personNodes.get(4).getAttribute("id"))) ;
            assertEquals(5, Integer.parseInt(personNodes.get(4).getAttribute("age"))) ;
            assertEquals("name5", personNodes.get(4).getAttribute("name")) ;
            assertEquals("occ5", personNodes.get(4).getElementsByTagName("occupation").item(0).getTextContent()) ;


            assertEquals(86, Integer.parseInt(personNodes.get(5).getAttribute("id"))) ;
            assertEquals(4, Integer.parseInt(personNodes.get(5).getAttribute("age"))) ;
            assertEquals("name4", personNodes.get(5).getAttribute("name")) ;
            assertEquals("occ4", personNodes.get(5).getElementsByTagName("occupation").item(0).getTextContent()) ;


        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
