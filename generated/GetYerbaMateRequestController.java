```java
@RestController
@RequestMapping("/yerba-mate")
public class YerbaMateController {

    @GetMapping
    public GetYerbaMateResponse getYerbaMate(@RequestBody GetYerbaMateRequest request) {
        // TODO: Implement service logic
        return new GetYerbaMateResponse();
    }
}
```