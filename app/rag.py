import os
import getpass
from pathlib import Path
from langchain.prompts import PromptTemplate
from langchain_anthropic import ChatAnthropic
from langchain_core.runnables import RunnableMap
from app.transformer import prepare_all_prompt_inputs
from app.parser import scan_java_directory

# ✅ Load API key securely from prompt
def _set_env(var: str):
    if not os.environ.get(var):
        os.environ[var] = getpass.getpass(f"{var}: ")

_set_env("ANTHROPIC_API_KEY")

# ✅ Load prompt template
prompt_template_path = Path("prompts/soap_to_rest.txt")
prompt_str = prompt_template_path.read_text(encoding="utf-8")
template = PromptTemplate.from_template(prompt_str)

# ✅ LLM initialization
llm = ChatAnthropic(model="claude-3-opus-20240229", temperature=0)

# ✅ Main RAG pipeline
def generate_controllers():
    parsed = scan_java_directory("workspace/soap-ws-example/src/main/java")
    prompt_inputs = prepare_all_prompt_inputs(parsed)

    chain = template | llm

    os.makedirs("generated", exist_ok=True)

    for i, inputs in enumerate(prompt_inputs):
        output = chain.invoke(inputs)
        class_name = inputs["class_name"]
        file_path = f"generated/{class_name}Controller.java"
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(output.content.strip())
        print(f"✅ Generated: {file_path}")


# Optional entry point to run from CLI
if __name__ == "__main__":
    generate_controllers()
