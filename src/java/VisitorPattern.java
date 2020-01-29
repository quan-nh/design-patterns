abstract class Shape {
    abstract void accept(Visitor visitor);
}

class Circle extends Shape {
    @Override
    void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }
}

class Rectangle extends Shape {
    @Override
    void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }
}

interface Visitor {
    void visitCircle(Circle c);

    void visitRectangle(Rectangle r);
}

class PdfExportVisitor implements Visitor {
    @Override
    public void visitCircle(Circle c) {
        System.out.println("Exporting circle to pdf..");
    }

    @Override
    public void visitRectangle(Rectangle r) {
        System.out.println("Exporting rectangle to pdf..");
    }
}

class VisitorPattern {
    public static void main(String[] args) {
        var circle = new Circle();
        var rectangle = new Rectangle();

        Visitor pdfExport = new PdfExportVisitor();

        circle.accept(pdfExport);
        rectangle.accept(pdfExport);
    }
}
