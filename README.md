# soap2spring-legacy-lift
AI-powered CLI tool that converts Java SOAP-based services into Spring Boot REST controllers using AI (Claude via LangChain), complete with Mermaid architecture diagrams and RAG-based code generation.

## ✅ Features Built

- 🔍 Parse any Java SOAP project (universal annotation scanner)
- 🧾 Generate SOAP and REST architecture diagrams (.mmd)
- 🧠 Auto-generate Spring Boot controller stubs using Claude
- 📂 Organized modular structure (`app/`, `prompts/`, `workspace/`, `output/`)
- 🔐 Secure API key handling via `getpass`
- 🧪 CLI-based execution with modular flags

---
## 🗂️ Project Structure
![image](https://github.com/user-attachments/assets/4aea609e-eea8-4833-b921-67d6f3fd364f)
--

---

## 📥 Clone & Use Locally

```bash
# Clone the repo
git clone https://github.com/BantuCS/soap2spring-legacy-lift.git
cd soap2spring-legacy-lift

# Create a virtual environment
python -m venv soap-rest-env
soap-rest-env\\Scripts\\activate   # On Windows
# OR
source soap-rest-env/bin/activate  # On macOS/Linux

# Install dependencies
pip install -r requirements.txt
---

## ✅ Add a .env file for your API keys
Create a `.env` file in your root directory with the following content:
```env
ANTHROPIC_API_KEY=your_claude_api_key_here
LANGCHAIN_API_KEY=your_langsmith_key_here
GROQ_API_KEY=your_groq_key_here


---
## 🧪 CLI Usage

```bash
# Parse only
python main.py --parse

# Parse and generate diagrams
python main.py --parse --diagram

# Full pipeline: parse + diagram + generate REST
python main.py --parse --diagram --generate
---

