Here's the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/api/yerba-mate")
public class YerbaMateController {

    private final YerbaMateServiceImpl yerbaMateService;

    public YerbaMateController(YerbaMateServiceImpl yerbaMateService) {
        this.yerbaMateService = yerbaMateService;
    }

    @GetMapping("/sample-data")
    public ResponseEntity<?> getSampleData() {
        // Assuming sampleData() returns a collection or an object
        return ResponseEntity.ok(yerbaMateService.sampleData());
    }

    @GetMapping("/brands/{brand}")
    public ResponseEntity<?> getByBrand(@PathVariable String brand) {
        // Assuming findByBrand() takes a String parameter and returns a collection or an object
        return ResponseEntity.ok(yerbaMateService.findByBrand(brand));
    }
}
```