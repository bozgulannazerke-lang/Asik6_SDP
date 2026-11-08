import concrete_elements.File;
import concrete_elements.Directory;
import interface_element.FileSystemElement;
import interface_visitor.FileSystemVisitor;
import concrete_visitors.SizeCalculatorVisitor;
import concrete_visitors.ExportXmlVisitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.addElement(new File("document.txt", 150));
        root.addElement(new File("image.png", 500));

        Directory subDir = new Directory("subfolder");
        subDir.addElement(new File("script.js", 80));
        root.addElement(subDir);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total Size: " + sizeVisitor.getTotalSize());

        ExportXmlVisitor xmlVisitor = new ExportXmlVisitor();
        root.accept(xmlVisitor);
        System.out.println("XML Output:\n" + xmlVisitor.getXml());
    }
}