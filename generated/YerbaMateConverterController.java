Here's the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/api/yerba-mate")
public class YerbaMateController {

    private final YerbaMateConverter yerbaMateConverter;

    public YerbaMateController(YerbaMateConverter yerbaMateConverter) {
        this.yerbaMateConverter = yerbaMateConverter;
    }

    @GetMapping("/{id}")
    public YerbaMateDTO getYerbaMate(@PathVariable Long id) {
        YerbaMateEntity entity = // Retrieve YerbaMateEntity by id
        return yerbaMateConverter.convertToDTO(entity);
    }

    @PostMapping
    public YerbaMateDTO createYerbaMate(@RequestBody YerbaMateDTO yerbaMateDTO) {
        YerbaMateEntity entity = yerbaMateConverter.convertToEntity(yerbaMateDTO);
        // Save YerbaMateEntity and retrieve the saved entity
        return yerbaMateConverter.convertToDTO(savedEntity);
    }

    @PutMapping("/{id}")
    public YerbaMateDTO updateYerbaMate(@PathVariable Long id, @RequestBody YerbaMateDTO yerbaMateDTO) {
        YerbaMateEntity entity = // Retrieve YerbaMateEntity by id
        // Update entity with data from yerbaMateDTO
        // Save updated YerbaMateEntity and retrieve the saved entity
        return yerbaMateConverter.convertToDTO(savedEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteYerbaMate(@PathVariable Long id) {
        // Delete YerbaMateEntity by id
    }

    @GetMapping
    public List<YerbaMateDTO> getAllYerbaMates() {
        List<YerbaMateEntity> entities = // Retrieve all YerbaMateEntities
        return yerbaMateConverter.convertToEntities(entities);
    }
}
```

Note: The code assumes the existence of `YerbaMateEntity` and `YerbaMateDTO` classes, as well as the necessary repository or service layer to interact with the database. The `//` comments indicate where you would need to add the actual implementation logic for retrieving, saving, updating, and deleting `YerbaMateEntity` instances.