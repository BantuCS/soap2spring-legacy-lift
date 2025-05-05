import os

def generate_soap_mermaid(classes: dict) -> str:
    diagram = ["classDiagram"]

    for cls, meta in classes.items():
        diagram.append(f"    class {cls} {{")
        for method in meta["methods"]:
            diagram.append(f"        +{method}()")
        diagram.append("    }")

    return "\n".join(diagram)


def generate_rest_mermaid(classes: dict) -> str:
    diagram = ["flowchart LR"]  # Switch to Left-to-Right for readability

    for cls, meta in classes.items():
        route_base = f"/{cls.lower()}"
        sub_nodes = []

        for method in meta["methods"]:
            # Infer HTTP verb
            if "get" in method.lower():
                verb = "GET"
            elif "add" in method.lower() or "create" in method.lower():
                verb = "POST"
            elif "update" in method.lower():
                verb = "PUT"
            elif "delete" in method.lower() or "remove" in method.lower():
                verb = "DELETE"
            else:
                verb = "POST"

            # Safe node ID
            node_id = f"{cls}_{method}".replace("-", "_").replace(" ", "_")

            # Wrap long route with line break
            label = f"{verb}\\n{route_base}/{method.lower()}"

            sub_nodes.append(f"    {node_id}[\"{label}\"]")

        if sub_nodes:
            diagram.append(f"    subgraph {cls}")
            diagram.extend(sub_nodes)
            diagram.append("    end")

    return "\n".join(diagram)



if __name__ == "__main__":
    from app.parser import scan_java_directory

    # Step 1: Parse classes and methods
    classes = scan_java_directory("workspace/soap-ws-example/src/main/java")

    # Step 2: Generate diagrams
    soap_diagram = generate_soap_mermaid(classes)
    rest_diagram = generate_rest_mermaid(classes)

    # Step 3: Optional print
    print("\n🧾 SOAP Mermaid Diagram:\n", soap_diagram)
    print("\n🔁 REST Mermaid Diagram:\n", rest_diagram)

    # Step 4: Save .mmd files
    os.makedirs("output", exist_ok=True)
    with open("output/soap_diagram.mmd", "w", encoding="utf-8") as f:
        f.write(soap_diagram)
    with open("output/rest_diagram.mmd", "w", encoding="utf-8") as f:
        f.write(rest_diagram)

    print("\n✅ Mermaid .mmd files saved to /output/. Use `mmdc` to convert to .png:")
    print("   mmdc -i output/soap_diagram.mmd -o output/soap_diagram.png --scale 2")
    print("   mmdc -i output/rest_diagram.mmd -o output/rest_diagram.png --scale 2")
