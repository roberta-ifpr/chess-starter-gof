package chess.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class ChessFrame extends JFrame {
    public ChessFrame() {
        super("Chess - Singleton Board + Piece Image Factory");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new BoardPanel(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}