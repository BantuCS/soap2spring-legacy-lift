Here is the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/yerba-mate")
public class YerbaMateFactoryController {

    private final YerbaMateFactory yerbaMateFactory;

    public YerbaMateFactoryController(YerbaMateFactory yerbaMateFactory) {
        this.yerbaMateFactory = yerbaMateFactory;
    }

    @GetMapping("/examples")
    public List<String> getExamples() {
        return yerbaMateFactory.examples();
    }

    @GetMapping("/examples/random")
    public List<String> getExamplesRandomOrder() {
        return yerbaMateFactory.examplesRandomOrder();
    }

    @GetMapping("/pajarito")
    public String getPajarito() {
        return yerbaMateFactory.pajarito();
    }

    @GetMapping("/taragui")
    public String getTaragui() {
        return yerbaMateFactory.taragui();
    }

    @GetMapping("/mate-green-fuerte")
    public String getMateGreenFuerte() {
        return yerbaMateFactory.mateGreenFuerte();
    }

    @GetMapping("/selecta-despalada")
    public String getSelectaDespalada() {
        return yerbaMateFactory.selectaDespalada();
    }

    @GetMapping("/rosamonte")
    public String getRosamonte() {
        return yerbaMateFactory.rosamonte();
    }

    @GetMapping("/pipore-despalada")
    public String getPiporeDespalada() {
        return yerbaMateFactory.piporeDespalada();
    }
}
```