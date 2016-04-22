package conway;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Life {

    private int [][] grid;
    private int width;
    private int height;

    public Life(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int [width][height];
        IntStream.range(0,width).forEach(i -> {
            IntStream.range(0,height).forEach(j -> {
                grid[i][j] = 0;
            });
        });
    }

    public void flipCell(int i, int j){
        grid[i][j] = (grid[i][j] + 1) % 2;
    }

    public Life step(){
        Life output = new Life(width, height);
        IntStream.range(0,width).forEach(i -> {
            IntStream.range(0,height).forEach(j -> {
                output.getGrid()[i][j] = grid[i][j];
            });
        });
        return output;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        IntStream.range(0,width).forEach(i -> {
            IntStream.range(0,height).forEach(j -> {
                output.append(grid[i][j] > 0 ? "█" : ".");
            });
            output.append("\n");
        });
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Life life = (Life) o;

        if (width != life.width) return false;
        if (height != life.height) return false;
        return Arrays.deepEquals(grid, life.grid);

    }

    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(grid);
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}
