import argparse
from app.parser import scan_java_directory
from app.diagram import generate_soap_mermaid, generate_rest_mermaid
from app.transformer import prepare_all_prompt_inputs
from app.rag import generate_controllers
import os

def run_parser():
    print("\n🔍 Running parser...")
    parsed = scan_java_directory("workspace/soap-ws-example/src/main/java")
    for cls, meta in parsed.items():
        print(f"\n📦 Class: {cls}")
        print(f"   🔖 Annotations: {meta['annotations']}")
        print(f"   ⚙️ Methods: {meta['methods']}")
    return parsed

def run_diagram(parsed):
    print("\n🧾 Generating diagrams...")
    soap = generate_soap_mermaid(parsed)
    rest = generate_rest_mermaid(parsed)
    os.makedirs("output", exist_ok=True)
    with open("output/soap_diagram.mmd", "w", encoding="utf-8") as f:
        f.write(soap)
    with open("output/rest_diagram.mmd", "w", encoding="utf-8") as f:
        f.write(rest)
    print("✅ Mermaid .mmd files created in /output")

def run_generation():
    print("\n🧠 Generating Spring Boot REST controllers...")
    generate_controllers()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="SOAP to REST Conversion Tool")
    parser.add_argument("--parse", action="store_true", help="Run metadata parser")
    parser.add_argument("--diagram", action="store_true", help="Generate Mermaid diagrams")
    parser.add_argument("--generate", action="store_true", help="Generate REST controllers using LLM")
    args = parser.parse_args()

    parsed_data = None
    if args.parse or args.diagram:
        parsed_data = run_parser()

    if args.diagram:
        run_diagram(parsed_data)

    if args.generate:
        run_generation()

    if not (args.parse or args.diagram or args.generate):
        print("\n⚠️  No command provided. Example usage:")
        print("   py main.py --parse")
        print("   py main.py --parse --diagram")
        print("   py main.py --parse --diagram --generate")
