Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.

This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.

# Advantage:

1) It reduces the need of sub-classing. <br />
2) It hides complexities of creating objects. <br />
3) The clients can get new objects without knowing which type of object it will be. <br />
4) It lets you add or remove objects at runtime. <br />

# Usage:
1) When the classes are instantiated at runtime. <br />
2) When the cost of creating an object is expensive or complicated. <br />
3) When you want to keep the number of classes in an application minimum. <br />
4) When the client application needs to be unaware of object creation and representation. <br />

# Pros and Cons:

**Pros:** <br />
1) clone objects without coupling to their concrete classes. <br />
2) get rid of repeated initialization code in favor of cloning pre-built prototypes. <br />
3) produce complex objects more conveniently. <br />
4) an alternative to inheritance when dealing with configuration presets for complex objects. <br />

**Cons:**

Cloning complex objects that have circular references might be very tricky.


