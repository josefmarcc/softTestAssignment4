# softTestAssignment4

Josef Marc Pedersen - <em>cph-jp325</em>

## 1. Mockito Powerups

* How do you verify that a mock was called?

Use the verify function as shown:
![alt text](https://github.com/josefmarcc/softTestAssignment4/blob/main/verifyfunction.png)

* How do you verify that a mock was NOT called?


Use the verify function with the following parameters
```
verify(dependency, never()).someMethod();
```

* How do you verify that a mock was called with specific arguments?

use the argThat method like so
```
argThat(x -> x.firstname.equals(firstName) &&
        x.lastname.equals(lastName)));
```

* How do you use a predicate to verify the properties of the arguments given to a call to the mock?

Here is an example to verify a isUserVaild() method

1. Always return the exact same Predicate instance from your isUserValid() method. Since the Predicate is stateless, that's not a problem.
2. Implement the Predicate as a real class, implementing equals() and hashCode().
3. Use a matcher:
```
 Mockito.when(mockObjectA).methodA(Mockito.eq("some id"), Mockito.<Predicate<User>>anyObject()).thenReturn("something");
```
4. Don't use a static method to create the predicate, but an injectable Factory, that you can mock and verify:
```
PredicatesProvider mockPredicatesProvider = mock(PredicatesProvider.class);
Predicate<User> expectedPredicate = (u -> true);
when(mockPredicatesProvider.isUserValid()).thenReturn(expectedPredicate);
when(mockObjectA).methodA("some id", expectedPredicate).thenReturn("something");
```

## 2. JSONParser TDD

JSONParser implementation: Click [Here](https://github.com/josefmarcc/softTestAssignment4/blob/main/src/main/java/JSONParser/JSONParser.java)

All tests found here: Click [Here](https://github.com/josefmarcc/softTestAssignment4/blob/main/src/test/java/JSONParser/JSONParserTests.java)

## Test Results

### Jacoco

![Jacoco](https://github.com/josefmarcc/softTestAssignment4/blob/main/jacoco.PNG)

### PMD

![PMD](https://github.com/josefmarcc/softTestAssignment4/blob/main/pmd.PNG)

### PiTest

![PMD](https://github.com/josefmarcc/softTestAssignment4/blob/main/pittest.PNG)

