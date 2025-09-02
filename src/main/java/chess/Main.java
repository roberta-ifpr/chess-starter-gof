package chess;

import chess.ui.ChessFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new ChessFrame().setVisible(true);
        });
    }
}