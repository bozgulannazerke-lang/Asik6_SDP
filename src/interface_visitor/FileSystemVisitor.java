package interface_visitor;

import concrete_elements.File;
import concrete_elements.Directory;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}