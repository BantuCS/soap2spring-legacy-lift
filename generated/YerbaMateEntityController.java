Here's the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/api/yerba-mate")
public class YerbaMateController {

    private final YerbaMateService yerbaMateService;

    public YerbaMateController(YerbaMateService yerbaMateService) {
        this.yerbaMateService = yerbaMateService;
    }

    @GetMapping
    public List<YerbaMateEntity> getAllYerbaMate() {
        return yerbaMateService.findAll();
    }

    @GetMapping("/{id}")
    public YerbaMateEntity getYerbaMateById(@PathVariable Long id) {
        return yerbaMateService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Yerba Mate not found with id: " + id));
    }

    @PostMapping
    public YerbaMateEntity createYerbaMate(@RequestBody YerbaMateEntity yerbaMate) {
        return yerbaMateService.save(yerbaMate);
    }

    @PutMapping("/{id}")
    public YerbaMateEntity updateYerbaMate(@PathVariable Long id, @RequestBody YerbaMateEntity yerbaMateDetails) {
        YerbaMateEntity yerbaMate = yerbaMateService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Yerba Mate not found with id: " + id));

        yerbaMate.setName(yerbaMateDetails.getName());
        yerbaMate.setDescription(yerbaMateDetails.getDescription());
        // Set other properties as needed

        return yerbaMateService.save(yerbaMate);
    }

    @DeleteMapping("/{id}")
    public void deleteYerbaMate(@PathVariable Long id) {
        YerbaMateEntity yerbaMate = yerbaMateService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Yerba Mate not found with id: " + id));

        yerbaMateService.delete(yerbaMate);
    }
}
```

This controller class assumes the existence of a `YerbaMateService` and a `ResourceNotFoundException` class. The `YerbaMateService` is injected via constructor injection.

The controller provides the following RESTful endpoints:

- `GET /api/yerba-mate`: Retrieves all Yerba Mate entities.
- `GET /api/yerba-mate/{id}`: Retrieves a specific Yerba Mate entity by its ID.
- `POST /api/yerba-mate`: Creates a new Yerba Mate entity.
- `PUT /api/yerba-mate/{id}`: Updates an existing Yerba Mate entity.
- `DELETE /api/yerba-mate/{id}`: Deletes a Yerba Mate entity.

The method parameters and return types are inferred based on the provided names and the RESTful conventions.

Note: Make sure to replace `YerbaMateService` and `ResourceNotFoundException` with the actual implementations in your project.