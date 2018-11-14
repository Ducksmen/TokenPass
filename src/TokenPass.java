public class TokenPass
{
    private int[] board;
    private int currentPlayer;
    public int a;

    public TokenPass(int playerCount)
    {
        board = new int[playerCount];
        for(int i=0;i<playerCount;i++)
        {
            board[i]=(int)(Math.random()*10)+1;
        }
        this.currentPlayer = (int)(Math.random()*playerCount);
        a = playerCount;
    }

    public void distributeCurrentPlayerTokens()
    {
        int b = currentPlayer + 1;
        if (b > board.length - 1) {
            b = 0;
        }
        int cTokens = board[b];
        board[b] = 0;
        for(int i=0;i<cTokens;i++)
        {
            b++;
            if (b > board.length - 1) {
                b = 0;
            }
            board[b]++;
        }
            a--;
    }

    public void nextPlayer()
    {
        currentPlayer++;
        if (currentPlayer > board.length - 1) {
            currentPlayer = 0;
        }
        System.out.println("Current Player: " + currentPlayer);
    }

    public void printBoard()
    {
        String boardState = "";
        for(int i=0;i<board.length;i++)
        {
            boardState = boardState + "Player " + i + ": " + board[i] + " ";
        }
        System.out.println(boardState);
    }

    public int gameOver()
    {
        for(int i=0;i<board.length;i++)
        {
            if (board[i] == 0)
            {
                return i;
            }
            else return -1;
        }
        return -1;
    }
}
