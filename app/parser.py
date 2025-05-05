import javalang
from pathlib import Path

def extract_class_info(java_code):
    """
    Extracts class name, annotations, and all public methods from Java source code.
    """
    class_info = {}

    try:
        tree = javalang.parse.parse(java_code)
    except Exception:
        return None

    for _, node in tree.filter(javalang.tree.ClassDeclaration):
        class_name = node.name
        annotations = [ann.name for ann in node.annotations]
        methods = []
        for method in node.methods:
            if "public" in method.modifiers:
                methods.append(method.name)

        class_info[class_name] = {
            "annotations": annotations,
            "methods": methods
        }

    return class_info

def scan_java_directory(directory):
    """
    Recursively scans all Java files in a directory and extracts class + method info.
    """
    directory = Path(directory)
    all_classes = {}

    for file in directory.rglob("*.java"):
        try:
            with open(file, "r", encoding="utf-8") as f:
                java_code = f.read()
                class_data = extract_class_info(java_code)
                if class_data:
                    all_classes.update(class_data)
        except Exception as e:
            print(f"❌ Failed to read {file}: {e}")

    return all_classes

# Example usage
if __name__ == "__main__":
    classes = scan_java_directory("workspace/soap-ws-example/src/main/java")

    for cls, meta in classes.items():
        print(f"🏷️ Class: {cls}")
        if meta["annotations"]:
            print(f"  🔖 Annotations: {', '.join(meta['annotations'])}")
        else:
            print("  🔖 Annotations: None")
        for method in meta["methods"]:
            print(f"   └─ ⚙️ Method: {method}")
