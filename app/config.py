import os
from dotenv import load_dotenv
from langsmith import Client

load_dotenv()

# API Keys
GROQ_API_KEY = os.getenv("GROQ_API_KEY")
ANTHROPIC_API_KEY = os.getenv("ANTHROPIC_API_KEY")
LANGCHAIN_API_KEY = os.getenv("LANGCHAIN_API_KEY")

# Vectorstore path
VECTOR_DB_PATH = "vectorstore"
WORKSPACE_DIR = "workspace"

# LangSmith client
client = Client()
