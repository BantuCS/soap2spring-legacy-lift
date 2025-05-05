```java
@RestController
@RequestMapping("/yerba-mate")
public class YerbaMateController {

    @GetMapping
    public GetYerbaMateResponse getYerbaMate() {
        // Implement logic to fetch yerba mate data
        GetYerbaMateResponse response = new GetYerbaMateResponse();
        // Set response properties
        return response;
    }
}
```