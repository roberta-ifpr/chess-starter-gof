package chess.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import chess.model.Piece;

public class PieceImageFactory {
    private static PieceImageFactory INSTANCE;

    private PieceImageFactory() {

    }

    public static PieceImageFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PieceImageFactory();
        }
        return INSTANCE;
    }

    public InputStream getImageStream(Piece piece) {
        String fileName = piece.getColor().name().toLowerCase() +
                "_" + piece.getType().name().toLowerCase() + ".png";
        Path path = Path.of("src/main/resources/img2", fileName);
        try {
            return new FileInputStream((path.toFile()));
        } catch (IOException e) {
            throw new RuntimeException("Imagem nao encontrada", e);
        }
    }

}
