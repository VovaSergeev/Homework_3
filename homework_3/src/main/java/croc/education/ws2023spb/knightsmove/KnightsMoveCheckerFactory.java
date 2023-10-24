package croc.education.ws2023spb.knightsmove;

/**
 * Класс, реализующий фабричный метод, возвращающий обработчики, проверяющие,
 * что последовательность клеток на шахматной
 * доске может быть пройдена ходом коня.
 *
 * @author Dmitry Malenok
 */
public final class KnightsMoveCheckerFactory {

    /**
     * Конструктор.
     */
    public static KnightsMoveChecker get() {
        // Метод возвращает обработчик, проверяющий, что последовательность клеток на
        // шахматной доске может быть пройдена ходом коня.
        return new KnightsMoveChecker() {
            public void check(String[] positions) throws IllegalMoveException, IllegalPositionException {
                for (int i = 0; i < positions.length - 1; i++) {
                    ChessPosition current = ChessPositionParser.parse(positions[i]);
                    ChessPosition next = ChessPositionParser.parse(positions[i + 1]);

                    int dx = Math.abs(current.x() - next.x());
                    int dy = Math.abs(current.y() - next.y());
                    
                    if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
                        throw new IllegalMoveException(current + " -> " + next);
                    }
                }
            }
        };
    }
}
