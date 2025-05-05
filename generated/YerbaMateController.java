Here's the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/yerba-mate")
public class YerbaMateController {

    @GetMapping("/is-empty")
    public boolean isEmpty() {
        // Implement the logic to check if the yerba mate is empty
        // Return true if empty, false otherwise
        // Example implementation:
        // return yerbaMateService.isEmpty();
        return false;
    }

    @GetMapping("/is-not-empty")
    public boolean isNotEmpty() {
        // Implement the logic to check if the yerba mate is not empty
        // Return true if not empty, false otherwise
        // Example implementation:
        // return yerbaMateService.isNotEmpty();
        return true;
    }
}
```

In this generated code:

- The `@RestController` annotation is used to indicate that this class is a REST controller.
- The `@RequestMapping` annotation is used to specify the base URL path for the controller, which is `/yerba-mate` in this case.
- The `isEmpty` method is mapped to the `/is-empty` endpoint using the `@GetMapping` annotation, indicating that it responds to GET requests. It returns a boolean value indicating whether the yerba mate is empty or not.
- The `isNotEmpty` method is mapped to the `/is-not-empty` endpoint using the `@GetMapping` annotation, indicating that it responds to GET requests. It returns a boolean value indicating whether the yerba mate is not empty or not.
- The method parameters and return types are inferred from the method names. In this case, both methods have no parameters and return a boolean value.
- The code follows clean and idiomatic Spring Boot practices.

Note: The actual implementation of the `isEmpty` and `isNotEmpty` methods is not provided, as it depends on the specific logic and requirements of your application. You would need to implement the necessary logic to determine the state of the yerba mate based on your application's needs.