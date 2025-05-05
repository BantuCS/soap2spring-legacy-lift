from tree_sitter import Language

Language.build_library(
    # Output file path
    'build/my-languages.so',

    # Language grammar source folder(s)
    ['tree-sitter-java']
)
