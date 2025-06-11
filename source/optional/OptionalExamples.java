package optional;

import java.util.*;

public class OptionalExamples {
    public static void main(String[] args) {
        // 1. Creating an Optional
        Optional<String> optionalValue = Optional.of("Hello, Java!");
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Optional Value: " + optionalValue.orElse("No Value"));
        System.out.println("Empty Optional: " + emptyOptional.orElse("No Value"));
        System.out.println("---------------------");
        // 2. Checking if a Value is Present
        Optional<String> name = Optional.ofNullable(null);
        if (name.isPresent()) {
            System.out.println("Name: " + name.get());
        } else {
            System.out.println("No name present.");
        }
        System.out.println("---------------------");
        // 3. Using ifPresent() to Avoid Explicit Checks
        Optional<String> greeting = Optional.of("Hey there!");
        greeting.ifPresent(System.out::println); // Prints only if the value is present
        Optional<String> greeting2 = Optional.empty();
        greeting2.ifPresent(System.out::println); // Prints only if the value is present
        System.out.println("---------------------");

        // 4. Providing a Default Value with orElse()
        String defaultValue = Optional.ofNullable( (String)null).orElse("Default Value");
        System.out.println("Default Value: " + defaultValue);
        System.out.println("---------------------");
        // 5. Using orElseGet() for Lazy Evaluation
        String generatedValue = Optional.ofNullable((String)null).orElseGet(() -> "Generated Value");
        System.out.println("Generated Value: " + generatedValue);
        System.out.println("---------------------");
        // 6. Throwing an Exception with orElseThrow()
        try {
            Optional<String> errorCheck = Optional.empty();
            errorCheck.orElseThrow(() -> new RuntimeException("Value missing!"));
        } catch (RuntimeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        System.out.println("---------------------");
        // 7. Using map() for Transformation
        Optional<String> optionalString = Optional.of("Hello");
        Optional<Integer> length = optionalString.map(String::length);
        System.out.println("String Length: " + length.orElse(0));
        System.out.println("---------------------");
        // 8. Using flatMap() When Optional Contains Another Optional
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested Value"));
        Optional<String> flattened = nestedOptional.flatMap(o -> o);
        System.out.println("Flattened Value: " + flattened.orElse("No Value"));
        System.out.println("---------------------");
        // 9. Filtering Optional Values
        Optional<Integer> number = Optional.of(10);
        Optional<Integer> filteredNumber = number.filter(n -> n > 5); // Retains value
        System.out.println("Filtered Number Present? " + filteredNumber.isPresent());

        Optional<Integer> emptyFiltered = number.filter(n -> n > 20); // Removed
        System.out.println("Empty Filtered Present? " + emptyFiltered.isPresent());
        System.out.println("---------------------");
        // 10. Chaining Optional Calls for Cleaner Code
        Optional<String> nameOptional = Optional.of("Java")
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("J"));
        System.out.println("Chained Result: " + nameOptional.orElse("Not Found"));
        System.out.println("---------------------");
    }
}
