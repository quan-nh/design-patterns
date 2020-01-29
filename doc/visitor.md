The purpose of a Visitor pattern is to define a new operation without introducing the modifications to an existing object structure.

Imagine that we have:
```java
abstract class Shape {}
class Circle extends Shape {}
class Rectangle extends Shape {}
```

Now, we want to add pdf export function to our code without modification of existing classes.

The `Visitor design pattern` is the answer.

By introduce Visitor interface:
```java
interface Visitor {
    void visitCircle(Circle c);
    void visitRectangle(Rectangle r);
}
```

& add it into class
```java
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
```

Now we can have new function by define a new implementation of `Visitor` interface, e.g. pdf export
```java
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
```

If we want to export to XML: `XmlExportVisitor implements Visitor`.. 
