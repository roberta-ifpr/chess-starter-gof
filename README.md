# Chess Starter (VSCode, Java Swing)

Projeto didático para exibir **apenas o tabuleiro e as peças**, usando:
- **Singleton** (`chess.model.Board`) para a matriz do tabuleiro e posição inicial.
- **Factory** (`chess.factory.PieceImageFactory`) para carregar **imagens** das peças a partir de `resources/img`.

## Como abrir no VSCode
1. Instale as extensões "Extension Pack for Java" (Microsoft).
2. Abra a pasta `chess-starter-vscode` no VSCode.
3. O VSCode deve detectar automaticamente o projeto Java (estrutura simples).

### Rodando
- Localize `src/main/java/chess/Main.java` e clique em **Run**.
- Alternativamente: `javac` e `java` via terminal (estando na pasta `src/main/java`):
  ```bash
  javac chess/**/*.java
  java chess.Main
  ```

## Estrutura
```
src/
  main/
    java/
      chess/
        Main.java
        ui/
          ChessFrame.java
          BoardPanel.java
        model/
          Board.java
          Piece.java
          PieceType.java
          PieceColor.java
        factory/
          PieceImageFactory.java
    resources/
      img/ (12 PNGs)
```

## Trocar as imagens
Se quiser usar imagens reais das peças, **substitua** os arquivos em `src/main/resources/img` mantendo os nomes:
- `white_king.png`, `white_queen.png`, ..., `white_pawn.png`
- `black_king.png`, `black_queen.png`, ..., `black_pawn.png`

Tamanho sugerido: 72x72 px (ou maior; o código redimensiona).# chess-starter-gof
