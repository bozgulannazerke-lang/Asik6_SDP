package concrete_visitors;

import interface_element.FileSystemElement;
import interface_visitor.FileSystemVisitor;
import concrete_elements.File;
import concrete_elements.Directory;

public class ExportXmlVisitor implements FileSystemVisitor {
    private StringBuilder xml = new StringBuilder();

    @Override
    public void visit(File file) {
        xml.append("<file name=\"").append(file.getName()).append("\" size=\"").append(file.getSize()).append("\"/>\n");
    }

    @Override
    public void visit(Directory directory) {
        xml.append("<directory name=\"").append(directory.getName()).append("\">\n");
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
        xml.append("</directory>\n");
    }

    public String getXml() {
        return xml.toString();
    }
}