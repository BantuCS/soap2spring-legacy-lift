import os
import shutil
import getpass
from git import Repo
from pathlib import Path

from app.config import WORKSPACE_DIR

def _set_env(var: str):
    if not os.environ.get(var):
        os.environ[var] = getpass.getpass(f"{var}: ")

# Set GitHub PAT if needed (for private repos; optional)
_set_env("GITHUB_PAT")

def clone_repo(repo_url: str, project_name: str = None) -> Path:
    """
    Clone a public or private GitHub repo into the workspace directory.
    """
    if not os.path.exists(WORKSPACE_DIR):
        os.makedirs(WORKSPACE_DIR)

    project_name = project_name or repo_url.rstrip("/").split("/")[-1].replace(".git", "")
    clone_path = os.path.join(WORKSPACE_DIR, project_name)

    if os.path.exists(clone_path):
        print(f"Removing existing project at {clone_path}")
        shutil.rmtree(clone_path)

    # Use HTTPS with token if needed (for private repos)
    if "github.com" in repo_url and "@" not in repo_url and os.environ.get("GITHUB_PAT"):
        repo_url = repo_url.replace("https://", f"https://{os.environ['GITHUB_PAT']}@")

    print(f"Cloning {repo_url} to {clone_path}...")
    Repo.clone_from(repo_url, clone_path)
    print("✅ Repo cloned successfully.")

    return Path(clone_path)

def contains_java_files(path: Path) -> bool:
    return any(path.rglob("*.java"))

# Example usage:
if __name__ == "__main__":
    url = input("Enter GitHub repo URL: ")
    path = clone_repo(url)
    
    if contains_java_files(path):
        print("✅ Java files found — ready for analysis.")
    else:
        print("⚠️ No Java files found — not a valid SOAP project?")
