import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyShop {
    private static List<Toy> toys = new ArrayList<>();

    private final InputValidator inputValidator = new InputValidator(new Scanner(System.in));

    public static List<Toy> getToys() {
        return toys;
    }

    public void addToy() {
        int id = inputValidator.getValidInput("Введите ID игрушки (целое число): ", Integer.class);
        id = inputValidator.idValidator(id, toys);

        String name = inputValidator.getValidInput("Введите имя игрушки: ", String.class);

        int quantity = inputValidator.getValidInput("Введите количество игрушек (целое число): ", Integer.class);
        quantity = inputValidator.quantityValidator(quantity);

        double dropFrequency = inputValidator.getValidInput("Введите вероятность выпадания игрушки (от 0 до 1): ", Double.class);
        dropFrequency = inputValidator.dropFrequencyValidator(dropFrequency);

        Toy toy = new Toy(id, name, quantity, dropFrequency);
        toys.add(toy);
    }

    public void deleteToy() {
        int toyId = inputValidator.getValidInput("Введите ID игрушки для удаления: ", Integer.class);

        boolean toyFound = false;
        Iterator<Toy> iterator = ToyShop.getToys().iterator();

        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getId() == toyId) {
                iterator.remove();
                System.out.println("Игрушка успешно удалена.");
                toyFound = true;
                break;
            }
        }
        if (!toyFound) {
            System.out.println("Игрушка с ID " + toyId + " не найдена.");
        }
    }

    public void showToyList() {
        if (toys.isEmpty()) {
            System.out.print("Список игрушек пуст.");
            return;
        }
        System.out.println("Список игрушек:");
        for (Toy toy : toys) {
            System.out.print("ID: " + toy.getId() + ", ");
            System.out.print("Имя: " + toy.getName() + ", ");
            System.out.print("Количество: " + toy.getQuantity() + ", ");
            System.out.println("Вероятность выпадения: " + toy.getDropFrequency()*100 + "%");
        }
    }

    public void updateToyFrequency() {
        int toyId = inputValidator.getValidInput("Введите ID игрушки, для которой нужно изменить вероятность: ", Integer.class);

        boolean toyFound = false;

        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                System.out.print("Введите новую вероятность выпадения: ");
                double newFrequency = inputValidator.getValidInput("Введите вероятность выпадания игрушки (от 0 до 1): ", Double.class);
                newFrequency = inputValidator.dropFrequencyValidator(newFrequency);
                toy.setDropFrequency(newFrequency);
                System.out.println("Вероятность для игрушки с ID " + toyId + " успешно изменена.");
                toyFound = true;
                break;
            }
        }
        if (!toyFound) {
            System.out.println("Игрушка с ID " + toyId + " не найдена.");
        }
    }

    public void organizeLottery() {
        if (toys.isEmpty()){
            System.out.println("Организовать лотерею невозможно! Список игрушек пуст!");
            return;
        }

        Random random = new Random();
        Toy wonToy = null;
        Toy lotteryToy = null;

        // int randomValue = random.nextInt(100); // Генерируем случайное число от 0 до 99
        int maxRand = 0;
        // выбираем какая игрушка будет разыгрываться из списка
        for (Toy toy : toys) {
            maxRand += toy.getDropFrequency() * 100;
        }
        int randomValue = random.nextInt(maxRand);
        int cumulativeFreq = 0;
        for (Toy toy : toys) {
            cumulativeFreq += toy.getDropFrequency() * 100;
            if (cumulativeFreq > randomValue) {lotteryToy = toy;}
        }

        // Выпадет ли игрушка
        randomValue = random.nextInt(100);
        if (lotteryToy != null && randomValue < lotteryToy.getDropFrequency() * 100) {
            wonToy = lotteryToy;
            Iterator<Toy> iterator = toys.iterator();
            while (iterator.hasNext()) {
                Toy toy = iterator.next();
                if (toy.getId() == wonToy.getId()) {
                    if (toy.getQuantity() == 1) {
                        iterator.remove(); // Используем итератор для удаления элемента
                    } else {
                        toy.setQuantity(toy.getQuantity() - 1);
                    }
                    break; // Выходим из цикла после обработки выигрыша
                }
            }
        }

        if (wonToy != null) {
            System.out.println("Поздравляем! Вы выиграли: " + wonToy.getName());

            try (FileWriter fileWriter = new FileWriter("won_toys.txt", true)) {
                fileWriter.write(wonToy.getName() + "\n");
            } catch (IOException e) {
                System.out.println("Не удалось записать выигрыш в файл.");
            }
        } else {
            System.out.println("К сожалению, вы не выиграли ни одной игрушки.");
        }
    }
}
