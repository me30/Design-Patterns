
# Singleton Pattern Principles:

1) Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java Virtual Machine.<br />
2) The singleton class must provide a global access point to get the instance of the class.<br />
3) Singleton pattern is used for logging, drivers objects, caching, and thread pool.<br />
4) Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade, etc.<br />
5) Singleton design pattern is used in core Java classes also (for example, java.lang.Runtime, java.awt.Desktop).
Java Singleton Pattern Implementation.<br />


# Singleton Pattern Approaches:

1) **Private constructor** to restrict instantiation of the class from other classes.<br />
2) **Private static variable** of the same class that is the only instance of the class.<br />
3) **Public static method** that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.<br />


# Different Approaches
 
1) Eager initialization
 
```
package com.commons.singleton;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // private constructor to avoid client applications using the constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}
```
 

__Using Reflection to destroy Singleton Pattern__ <br />

Reflection can be used to destroy all the previous singleton implementation approaches.

```
package com.journaldev.singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {

    public static void main(String[] args) {
        EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // This code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
```

2) Static block initialization
 
```
package com.commons.singleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    // static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
```

3) Lazy Initialization
 
```
package com.journaldev.singleton;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
```

4) Thread Safe Singleton

```
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}
```


5) Bill Pugh Singleton Implementation

Prior to Java 5, the Java memory model had a lot of issues, and the previous approaches used to fail in certain scenarios where too many threads tried to get the instance of the singleton class simultaneously. 

So Bill Pugh came up with a different approach to create the singleton class using an inner static helper class. 

Here is an example of the Bill Pugh Singleton implementation:


```
public class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```


Notice the private inner static class that contains the instance of the singleton class. 

When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance() method, this class gets loaded and creates the singleton class instance. This is the most widely used approach for the singleton class as it doesn’t require synchronization.


6) Enum Singleton

To overcome this situation with Reflection, Joshua Bloch suggests the use of enum to implement the singleton design pattern as Java ensures that any enum value is instantiated only once in a Java program. Since Java Enum values are globally accessible, so is the singleton. The drawback is that the enum type is somewhat inflexible (for example, it does not allow lazy initialization).


```
package com.journaldev.singleton;

public enum EnumSingleton {

    INSTANCE;

    public static void doSomething() {
        // do something
    }
}
```


8) Serialization and Singleton

Sometimes in distributed systems, we need to implement Serializable interface in the singleton class so that we can store its state in the file system and retrieve it at a later point in time.

```
package com.journaldev.singleton;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

}
```


The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the class.

```
package com.journaldev.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializedTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

    }

}
```

```
Output
instanceOne hashCode=2011117821
instanceTwo hashCode=109647522
```

So it destroys the singleton pattern. To overcome this scenario, all we need to do is provide the implementation of readResolve() method.

```
protected Object readResolve() {
    return getInstance();
}
```

https://www.tutorialspoint.com/difference-between-readobject-and-readresolve-method-in-serialization