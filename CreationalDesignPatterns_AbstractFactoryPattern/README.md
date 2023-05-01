We have a single Factory class. This factory class returns different subclasses based on the input provided and factory class uses if-else or switch statement to achieve this. 

In the Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class. Then an Abstract Factory class that will return the sub-class based on the input factory class.



# Pros and Cons:

**Pros:** <br />
1) Avoid tight coupling between the creator and the concrete products. <br />
2) Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.<br />
3) Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.

**Cons:**

The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.


