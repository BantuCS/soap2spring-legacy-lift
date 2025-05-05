Here is the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/yerba-mate")
public class YerbaMateController {

    @Autowired
    private ObjectFactory objectFactory;

    @GetMapping("/request")
    public GetYerbaMateRequest createGetYerbaMateRequest() {
        return objectFactory.createGetYerbaMateRequest();
    }

    @PostMapping("/response")
    public GetYerbaMateResponse createGetYerbaMateResponse(@RequestBody GetYerbaMateRequest request) {
        return objectFactory.createGetYerbaMateResponse();
    }

    @PostMapping
    public YerbaMate createYerbaMate(@RequestBody YerbaMate yerbaMate) {
        return objectFactory.createYerbaMate();
    }
}
```