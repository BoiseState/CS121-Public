import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * GUI for playing a TicTacToeGame.
 * @author mvail
 */
public class TicTacToeGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private final String PLAYER = "X";
	private final String COMPUTER = "O";
	private final String OPEN = "";
	private final int DIM = 3;
	private GridButton[][] gameGrid;
	private JTextArea movesTextArea;
	private JButton newGameButton;
	private TicTacToeGame game;
	
	/** Initialize the GUI. */
	public TicTacToeGUI() {
		game = new TicTacToeGame();
		Font bigFont = new Font("Serif", Font.PLAIN, 48);
		Font smallFont = new Font("Serif", Font.PLAIN, 36);
		gameGrid = new GridButton[DIM][DIM];
		GridButtonListener buttonListener = new GridButtonListener();
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				gameGrid[row][col] = new GridButton(OPEN, row, col);
				gameGrid[row][col].addActionListener(buttonListener);
				gameGrid[row][col].setPreferredSize(new Dimension(128,128));
				gameGrid[row][col].setFont(bigFont);
			}
		}
		
		this.setLayout(new BorderLayout());
		
		JPanel controlsPanel = new JPanel(); //default FlowLayout
		newGameButton = new JButton("New Game");
		newGameButton.setFont(bigFont);
		newGameButton.addActionListener(new NewGameButtonListener());
		controlsPanel.add(newGameButton);
		this.add(controlsPanel, BorderLayout.SOUTH);
		
		JPanel movesPanel = new JPanel(); //vertical BoxLayout
		movesPanel.setLayout(new BoxLayout(movesPanel, BoxLayout.Y_AXIS));
		JLabel movesLabel = new JLabel("Moves");
		movesLabel.setFont(smallFont);
		movesPanel.add(movesLabel);
		movesTextArea = new JTextArea();
		movesTextArea.setPreferredSize(new Dimension(256,512));
		movesTextArea.setFont(smallFont);
		movesTextArea.setEnabled(false);
		movesPanel.add(movesTextArea);
		this.add(movesPanel, BorderLayout.EAST);
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(DIM,DIM));
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				gamePanel.add(gameGrid[row][col]);
			}
		}
		this.add(gamePanel, BorderLayout.CENTER);
	}
	
	/** Reset the game and corresponding GUI controls. */
	private void resetGame() {
		//reset the game
		game.newGame();
		//clear the GUI board
		for(int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				gameGrid[row][col].setText(OPEN);
				gameGrid[row][col].setEnabled(true);
			}
		}
		//clear visual list
		movesTextArea.setText("");
		//refresh GUI
		revalidate();
	}
	
	/** Disable GUI game board and display game results */
	private void endGame() {
		//disable game board buttons
		for (int row = 0; row < DIM; row++) {
			for (int col = 0; col < DIM; col++) {
				gameGrid[row][col].setEnabled(false);
			}
		}
		//display the moves history and winner
		movesTextArea.setText("");
		Point[] moves = game.getMoves();
		for (int i = 0; i < moves.length; i++) {
			if (i %2 == 0) {
				movesTextArea.append("X: ");
			} else {
				movesTextArea.append("O: ");
			}
			movesTextArea.append("row " + moves[i].x + ", col " + moves[i].y + "\n"); 
		}
		if (game.getGameState() == TicTacToe.GameState.TIE) {
			movesTextArea.append("NO WINNER\n");
		} else if (game.getGameState() == TicTacToe.GameState.X_WON) {
			movesTextArea.append("Winner: X\n");
		} else if (game.getGameState() == TicTacToe.GameState.O_WON) {
			movesTextArea.append("Winner: O\n");
		} else {
			movesTextArea.append("ERROR\n");
		}
	}
	
	/** Start the GUI
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TicTacToeGUI());
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Private inner class to respond to newGameButton clicks.
	 */
	private class NewGameButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			resetGame();
		}
	}
	
	/**
	 * Private inner class to respond to grid button clicks.
	 * Update 'gameGrid' if the button is not already claimed.
	 * Make a computer move after player moves.
	 * Check for game over conditions.
	 */
	private class GridButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GridButton button = (GridButton)(arg0.getSource());
			if (!game.gameOver()) {
				//call choose(X, row, col) corresponding to clicked button
				//  if the position is successfully claimed
				if (game.choose(TicTacToe.BoardChoice.X, button.getRow(), button.getCol())) {
					button.setText(PLAYER);
					if (game.gameOver()) { //did the player just win?
						endGame();
					} else { //make a random move for the computer
						Random rand = new Random();
						boolean done = false;
						while (!done) {
							int cRow = rand.nextInt(DIM);
							int cCol = rand.nextInt(DIM);
							if (game.choose(TicTacToe.BoardChoice.O, cRow, cCol)) {
								gameGrid[cRow][cCol].setText(COMPUTER);
								done = true;
							}
						}
						if (game.gameOver()) { //did the computer just win?
							endGame();
						}
					}
				}//if player clicked an unclaimed position
			}//if game not over
		}//actionPerformed()
	}//GridButtonListener
	
	/**
	 * A button that knows its row,col coordinates
	 */
	private class GridButton extends JButton {
		private static final long serialVersionUID = 1L;
		private int row;
		private int col;
		
		/**
		 * Create this button with given text and coordinates.
		 * @param row row coordinate for this button
		 * @param column column coordinate for this button
		 */
		public GridButton(String text, int row, int column) {
			super(text);
			this.row = row;
			this.col = column;
		}

		/** @return the row */
		public int getRow() {
			return row;
		}

		/** @return the col */
		public int getCol() {
			return col;
		}
	} //GridButton
} //TicTacToeGUI
