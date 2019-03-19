
/*

Design a Snake game that is played on a device with screen size = width x height. 
Play the game online if you are not familiar with the game.
The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
You are given a list of food's positions in row-column order. 
When a snake eats the food, its length and the game's score both increase by 1.
Each food appears one by one on the screen. 
For example, the second food will not appear until the first food was eaten by the snake.
When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].
Snake snake = new Snake(width, height, food);
Initially the snake appears at position (0,0) and the food at (1,2).
|S| | |
| | |F|

snake.move("R"); -> Returns 0
| |S| |
| | |F|

snake.move("D"); -> Returns 0
| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
| |F| |
| |S|S|

snake.move("U"); -> Returns 1
| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)
| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

*/

/*

O(n),O(n)

*/

class SnakeGame {
    
    private int width;
    private int height;
    private int[][] food;
    private int x, y;
    private int i;
    private LinkedList<int[]> snake;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.snake = new LinkedList<>();
        this.snake.add(new int[] {0, 0});
        this.width = width;
        this.height = height;
        this.food = food;
        this.x = this.y = this.i = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction) {
            case "U": x--; break;
            case "L": y--; break;
            case "R": y++; break;
            case "D": x++; 
        }
        if (x < 0 || x >= height || y < 0 || y >= width) return -1;
        for (int j = 1; j < snake.size(); ++j) {
            if (snake.get(j)[0] == x && snake.get(j)[1] == y) return -1;
        }
        if (i < food.length && food[i][0] == x && food[i][1] == y) i++;
        else snake.remove(0);
        snake.add(new int[] {x, y});
        return i;
    }
}




