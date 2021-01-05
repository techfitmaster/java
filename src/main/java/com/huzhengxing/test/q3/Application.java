package com.huzhengxing.test.q3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class Application {

    public RBTree<Integer, Person> createTree() {
        // ########## YOUR CODE STARTS HERE ##########
        RBTree<Integer, Person> tree = new RBTree<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person(i, "name", 1, "oc");
            tree.insert(person.getId(),person);
        }
        return tree;
        // ########## YOUR CODE ENDS HERE ##########
    }

    public void saveXML(RBTree<Integer, Person> tree) {
        List<Node> nodeList = tree.inorder();
        // ########## YOUR CODE STARTS HERE ##########
        StringWriter writer;
        JAXBContext jaxbContext= null;
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            writer = new StringWriter();
            marshaller.marshal(nodeList, writer);
            jaxbContext = JAXBContext.newInstance(Node.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ########## YOUR CODE ENDS HERE ##########
    }

    public static void main(String[] args) {
        Application application = new Application();
        RBTree<Integer, Person> tree = application.createTree();
        application.saveXML(tree);
    }
}
