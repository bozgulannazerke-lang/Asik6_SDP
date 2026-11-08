package concrete_visitors;

import interface_element.FileSystemElement;
import interface_visitor.FileSystemVisitor;
import concrete_elements.File;
import concrete_elements.Directory;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }

    public int getTotalSize() {
        return totalSize;
    }
}