Here's the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/yerba-mate")
public class YerbaMateEndpoint {

    @GetMapping("/{brand}")
    public ResponseEntity<YerbaMate> getYerbaMateByBrand(@PathVariable String brand) {
        // Implement the logic to retrieve Yerba Mate by brand
        YerbaMate yerbaMate = // Retrieve Yerba Mate from a service or repository
        
        if (yerbaMate != null) {
            return ResponseEntity.ok(yerbaMate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
```