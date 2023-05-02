# Factory Design Pattern.
The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class.

This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.

A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.

The Factory Method Pattern is also known as **Virtual Constructor**.

# Advantage of Factory Design Pattern:

1) Factory design pattern provides approach to code for interface rather than implementation.Factory Method Pattern allows the sub-classes to choose the type of objects to create.

2) It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.

3) Factory pattern provides abstraction between implementation and client classes through inheritance.


# Usage of Factory Design Pattern

1) When a class doesn't know what sub-classes will be required to create

2) When a class wants that its sub-classes specify the objects to be created.

3) When the parent classes choose the creation of objects to its sub-classes.

# Pros and Cons:

**Pros:** <br />
1) Avoid tight coupling between the creator and the concrete products.
2) Single Responsibility Principle. We can move the product creation code into one place in the program, making the code easier to support.
3) Open/Closed Principle. We can introduce new types of products into the program without breaking existing client code.

**Cons:** <br />

The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.


**Relations with Other Patterns:** <br />
Many designs start by using Factory Method (less complicated and more customizable via subclasses) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, but more complicated).

Abstract Factory classes are often based on a set of Factory Methods, but you can also use Prototype to compose the methods on these classes.

You can use Factory Method along with Iterator to let collection subclasses return different types of iterators that are compatible with the collections.

Prototype isn’t based on inheritance, so it doesn’t have its drawbacks. On the other hand, Prototype requires a complicated initialization of the cloned object. Factory Method is based on inheritance but doesn’t require an initialization step.

Factory Method is a specialization of Template Method. At the same time, a Factory Method may serve as a step in a large Template Method.
