Here is the generated Spring Boot REST controller based on the provided service metadata:

```java
@RestController
@RequestMapping("/api/config")
public class WebServiceConfigController {

    @GetMapping("/message-dispatcher")
    public MessageDispatcherServlet messageDispatcherServlet() {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        return servlet;
    }
    
    @GetMapping("/default-wsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(@RequestParam("yerbaMateSchema") XsdSchema yerbaMateSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("YerbaMatePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/yerba-mate");
        wsdl11Definition.setSchema(yerbaMateSchema);
        return wsdl11Definition;
    }

    @PostMapping("/yerba-mate-schema")
    public XsdSchema yerbaMateSchema() {
        return new SimpleXsdSchema(new ClassPathResource("yerba-mate.xsd"));
    }
}
```