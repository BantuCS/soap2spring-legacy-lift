def format_for_prompt(class_name: str, annotations: list, methods: list) -> dict:
    """
    Formats parsed class metadata into a prompt-friendly dictionary.
    """
    return {
        "class_name": class_name,
        "annotations": ", ".join(annotations) if annotations else "None",
        "methods_list": "\n".join(f"- {method}" for method in methods)
    }

def prepare_all_prompt_inputs(parsed_classes: dict) -> list:
    """
    Converts the full parsed class dictionary into a list of prompt inputs.
    """
    formatted = []
    for class_name, meta in parsed_classes.items():
        formatted.append(format_for_prompt(
            class_name=class_name,
            annotations=meta.get("annotations", []),
            methods=meta.get("methods", [])
        ))
    return formatted
