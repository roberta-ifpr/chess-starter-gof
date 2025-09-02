package chess.ui;

import chess.model.Board;
import chess.model.Piece;
import chess.factory.PieceImageFactory;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardPanel extends JPanel {
    private static final int TILE_SIZE = 72;
    private static final Color LIGHT = new Color(240, 217, 181);
    private static final Color DARK = new Color(181, 136, 99);

    private final Board board = Board.getInstance();
    private final PieceImageFactory imageFactory = PieceImageFactory.getInstance();
    private final Map<String, Image> cache = new HashMap<>();

    public BoardPanel() {
        setPreferredSize(new Dimension(8 * TILE_SIZE, 8 * TILE_SIZE));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw tiles
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean dark = (row + col) % 2 == 1;
                g.setColor(dark ? DARK : LIGHT);
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        // draw pieces
        Piece[][] matrix = board.getMatrix();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece p = matrix[row][col];
                if (p != null) {
                    Image img = getImageFor(p);
                    int x = col * TILE_SIZE;
                    int y = row * TILE_SIZE;
                    g.drawImage(img, x, y, TILE_SIZE, TILE_SIZE, null);
                }
            }
        }
    }

    private Image getImageFor(Piece p) {
        String key = p.getColor().name() + "_" + p.getType().name();
        if (cache.containsKey(key))
            return cache.get(key);
        try {
            Image img = ImageIO.read(imageFactory.getImageStream(p));
            cache.put(key, img);
            return img;
        } catch (IOException e) {
            throw new RuntimeException("Could not load image for " + key, e);
        }
    }
}