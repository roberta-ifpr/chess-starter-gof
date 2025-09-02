package chess.model;

public class Board {
    private static Board INSTANCE;
    private Piece[][] matrix = new Piece[8][8];

    private Board() {
        setupInitialPosition();
    }

    public static Board getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Board();
        }
        return INSTANCE;
    }

    private void setupInitialPosition() {
        // Setup Black (top, row 0 & 1)
        matrix[0][0] = new Piece(PieceType.ROOK, PieceColor.BLACK);
        matrix[0][1] = new Piece(PieceType.KNIGHT, PieceColor.BLACK);
        matrix[0][2] = new Piece(PieceType.BISHOP, PieceColor.BLACK);
        matrix[0][3] = new Piece(PieceType.QUEEN, PieceColor.BLACK);
        matrix[0][4] = new Piece(PieceType.KING, PieceColor.BLACK);
        matrix[0][5] = new Piece(PieceType.BISHOP, PieceColor.BLACK);
        matrix[0][6] = new Piece(PieceType.KNIGHT, PieceColor.BLACK);
        matrix[0][7] = new Piece(PieceType.ROOK, PieceColor.BLACK);
        for (int c = 0; c < 8; c++) {
            matrix[1][c] = new Piece(PieceType.PAWN, PieceColor.BLACK);
        }

        // Setup White (bottom, row 7 & 6)
        matrix[7][0] = new Piece(PieceType.ROOK, PieceColor.WHITE);
        matrix[7][1] = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        matrix[7][2] = new Piece(PieceType.BISHOP, PieceColor.WHITE);
        matrix[7][3] = new Piece(PieceType.QUEEN, PieceColor.WHITE);
        matrix[7][4] = new Piece(PieceType.KING, PieceColor.WHITE);
        matrix[7][5] = new Piece(PieceType.BISHOP, PieceColor.WHITE);
        matrix[7][6] = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        matrix[7][7] = new Piece(PieceType.ROOK, PieceColor.WHITE);
        for (int c = 0; c < 8; c++) {
            matrix[6][c] = new Piece(PieceType.PAWN, PieceColor.WHITE);
        }
    }

    public static Board getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(Board iNSTANCE) {
        INSTANCE = iNSTANCE;
    }

    public Piece[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Piece[][] matrix) {
        this.matrix = matrix;
    }

}