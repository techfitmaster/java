### Q3 - Persistent Data [20 marks]

Implement the method `inorder()` of the class `RBTree` in the `RBTree.java` file, and the methods `createTree()` and `saveXML()` of the class `Application` in the `Application.java` file to save an XML file, following the format below: 


````
<people>
    <person age="20" id="1" name="John">
        <occupation>Student</occupation>
    </person>
    <person age="21" id="2" name="Tom">
        <occupation>Student</occupation>
    </person>
    <person age="22" id="3" name="Jerry">
        <occupation>Student</occupation>
    </person>
</people>
````

The `inorder()` method must return a list of tree nodes using the inorder traversal. [10 marks]  
The `createTree()` method must return an instance of a Red-Black tree (`RBTree`) containing 10 nodes (each node has an integer as key and an instance of Person as data). [2 marks]  
The `saveXML()` method must create an XML file containing all Person instances following the traversal order. The final name of the XML file must be `people.xml`. [8 marks]  

You are allowed to add helper methods in the RBTree class.  
You are NOT allowed to use any external library, you must use the standard Java 8+ library for XML.  
Remember that XML is case-sensitive, you must strictly follow the specified format to avoid getting zero marks.  

Upload the files: `RBTree.java` and `Application.java` to Wattle for marking.  

Note that you are expected to give a generic solution that fulfils the question requirements. You are encouraged to create your own test cases locally to check your solutions. We will use different test cases from the given ones to evaluate your solutions.

