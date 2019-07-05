package com.codedchai.DailyCodingProblem;

public class FloodFill {

    public static void main(String[] args){

        int[][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        for(int i = 0; i < screen.length; i++){
            for(int j = 0; j < screen[0].length; j++){
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }


        int x = 4, y = 4, newColor = 3;

        floodFill(screen, x, y, newColor);

        System.out.println("--------------------------------------------");

        for(int i = 0; i < screen.length; i++){
            for(int j = 0; j < screen[0].length; j++){
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void floodFill(int[][] screen, int startX, int startY, int newColor){
        floodFill(screen, startX, startY, newColor, screen[startX][startY]);
    }

    static void floodFill(int[][] screen, int startX, int startY,  int newColor, int colorToFill){
        if(startX < 0 || startY < 0 || startX >= screen.length || startY >= screen[0].length || colorToFill != screen[startX][startY]){
            return;
        }

        screen[startX][startY] = newColor;

        // Fill Up
        floodFill(screen, startX, startY - 1, newColor, colorToFill);

        // Fill Down
        floodFill(screen, startX, startY + 1, newColor, colorToFill);

        // Fill Left
        floodFill(screen, startX - 1, startY , newColor, colorToFill);

        // Fill Right
        floodFill(screen, startX + 1, startY, newColor, colorToFill);


    }

}
