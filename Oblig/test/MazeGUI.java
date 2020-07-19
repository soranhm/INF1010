import javax.swing.*;
import java.awt.*;

/** The JFrame that contains the Brussel sprouts game */
public class MazeGUI extends JFrame {

    JLabel[][] labels;  // The table of characters making up the game

    JPanel mazePanel= new JPanel();  // The panel on which the maze is placed

    Box JenBox= new Box(BoxLayout.Y_AXIS);   // Jen's titled score
    JLabel JenScore= new JLabel("   0", SwingConstants.CENTER);

    Box SteveBox= new Box(BoxLayout.Y_AXIS); // Box's titled score
    JLabel SteveScore= new JLabel("   0", SwingConstants.CENTER);

    Box southBox= new Box(BoxLayout.Y_AXIS); // South panel
    JLabel sproutsLeft= new JLabel("        Brussel sprouts left: 5555");

    Box northBox= new Box(BoxLayout.Y_AXIS); // North panel
    JLabel endOfGame= new JLabel("        Steve won!");

    public Maze maze; // The Maze for this MazeGui

    /** Constructor: An instance in which to play Brussel Sprouts;
        the information about the game appears in maze. The GUI
        is visible. */
    public MazeGUI(Maze maze) {
        this.maze= maze;
        Container con = this.getContentPane();

        JenBox.add(new JLabel("  Jen "));
        JenBox.add(new JLabel("  ate "));
        JenBox.add(JenScore);
        SteveBox.add(new JLabel(" Steve "));
        SteveBox.add(new JLabel("  ate "));
        SteveBox.add(SteveScore);

        con.add(JenBox, BorderLayout.WEST);
        con.add(SteveBox, BorderLayout.EAST);

        northBox.add(endOfGame);
        northBox.add(new JLabel(" "));
        con.add(northBox, BorderLayout.NORTH);

        southBox.add(new JLabel(" "));
        southBox.add(sproutsLeft);
        con.add(southBox, BorderLayout.SOUTH);

        mazePanel.setLayout(new GridLayout(maze.nRows(), maze.nCols()));

        // Create the array of JLabels and add them to the maze
        labels= new JLabel[maze.nRows()][maze.nCols()];
        for (int r= 0; r != labels.length; r= r+1) {
            for (int c= 0; c != labels[0].length; c= c+1) {
                labels[r][c]= new JLabel("" + maze.WALL);
                mazePanel.add(labels[r][c]);
            }
        }
        update();

        con.add(mazePanel, BorderLayout.CENTER);

        addKeyListener(new MazeKeyListener(this, maze));
        pack();
        show();
    }

    /** Update the GUI */
    public void update() {
        // Update the array of JLabels
        for (int r= 0; r != labels.length; r= r+1) {
            for (int c= 0; c != labels[0].length; c= c+1) {
                labels[r][c].setText(visualChar(r,c));
            }
        }

        // Update Jen's and Steve's score
        JenScore.setText("  " + maze.JenTheRat.getNumSprouts());
        SteveScore.setText("  " + maze.SteveTheRat.getNumSprouts());

        // Update the number of sprouts left
        sproutsLeft.setText("        Brussel sprouts left: " + maze.sproutsLeft());

        // If game has not ended, return.
        endOfGame.setText("  ");
        if (maze.sproutsLeft() != 0)
        return;

        // { Game has ended }
        endOfGame.setText("        It's a tie");
        if (maze.JenTheRat.getNumSprouts() > maze.SteveTheRat.getNumSprouts()) {
                endOfGame.setText("        Jen won!");
        }
        else if (maze.JenTheRat.getNumSprouts() < maze.SteveTheRat.getNumSprouts()) {
                endOfGame.setText("        Steve won!");
        }
    }

    /** = the visual char to place at position (r,c) */
    public String visualChar(int r, int c) {
        char ch= maze.getChar(r,c);
        if (maze.JenTheRat.getRow() == r &&
            maze.JenTheRat.getCol() == c) {
            ch= 'J';
        }
        if (maze.SteveTheRat.getRow() == r &&
            maze.SteveTheRat.getCol() == c) {
            ch= 'S';
        }

        return Character.toString(ch);
    }
}
