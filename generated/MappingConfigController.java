Here's the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/api/mapping")
public class MappingController {

    private final MappingConfig mappingConfig;

    public MappingController(MappingConfig mappingConfig) {
        this.mappingConfig = mappingConfig;
    }

    @GetMapping("/model-mapper")
    public ModelMapper getModelMapper() {
        return mappingConfig.modelMapper();
    }
}
```