package croc.education.ws2023spb.knightsmove;

public final class Application {
    public static void main(final String[] args) throws IllegalPositionException {
        // Создаем объект для проверки хода коня
        KnightsMoveChecker checker = KnightsMoveCheckerFactory.get();

        // Проверяем, что были переданы аргументы с последовательностью ходов
        if (args.length == 0) {
            System.out.println("Пожалуйста, укажите последовательность ходов в качестве аргументов.");
            return;
        }

        try {
            // Проверяем, что последовательность может быть пройдена ходом коня
            checker.check(args);
            // Выводим сообщение об успехе
            System.out.print("OK");
        } catch (IllegalMoveException e) {
            // Выводим сообщение об ошибке
            System.out.print("конь так не ходит: " + e.getMessage());
        }
    }
}
