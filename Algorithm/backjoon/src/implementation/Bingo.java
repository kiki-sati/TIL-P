package implementation;

import java.util.*;

public class Bingo {
    private static final int BOARD_SIZE = 5;
    private static final int TARGET_LINES = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 25;

    private int[][] board;
    private int lineCount;

    public Bingo() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        lineCount = 0;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        // 사용자로 부터 입력받은 빙고 -> 5x5 크기의 배열을 생성하고 이중루프를 사용하여 입력 받는다.
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        // 사회자는 1부터 25까지 차례대로 숫자를 불른다.
        for (int k = MIN_NUMBER; k <= MAX_NUMBER; k++) {
            int num = scanner.nextInt();

            // 불려진 빙고를 마킹한다.
            markNumber(num);

            // 빙고 라인을 체크한다.
            checkLines();

            // 라인이 모두 0인경우 해당 라인이 빙고라인.
            // 빙고라인이 3개 이상인 경우 해당 숫자를 출력하고 종료.
            if (lineCount >= TARGET_LINES) {
                System.out.println(k);
                break;
            }
        }
    }

    private void markNumber(int num) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                    return;
                }
            }
        }
    }

    private void checkLines() {
        lineCount = 0;
        checkRows();
        checkCols();
        checkDiagonalLeftToRight();
        checkDiagonalRightToLeft();
    }

    private void checkRows() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            int zeroCount = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == BOARD_SIZE) {
                lineCount++;
            }
        }
    }

    private void checkCols() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            int zeroCount = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[j][i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == BOARD_SIZE) {
                lineCount++;
            }
        }
    }

    private void checkDiagonalLeftToRight() {
        int zeroCount = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][i] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == BOARD_SIZE) {
            lineCount++;
        }
    }

    private void checkDiagonalRightToLeft() {
        int zeroCount = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][BOARD_SIZE - 1 - i] == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == BOARD_SIZE) {
            lineCount++;
        }
    }

    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        bingo.play();
    }
}