import java.util.Scanner;

public class Menu{

    public static ToyShop toyShop;

    public Menu(ToyShop toyShop){
        Menu.toyShop = toyShop;
        Menu.choiceAction();
    }
    public static void welcomeMessage() {
        System.out.println("Добро пожаловать в магазин игрушек!");
    }

    public static void choiceView() {
        String str = "Выберите нужное действие, введя с клавиатуры соответствующую цифру:  " + "\n";
        System.out.println();
        str += "1 - Добавить игрушку " + "\n";
        str += "2 - Удалить игрушку " + "\n";
        str += "3 - Показать список игрушек в консоли" + "\n";
        str += "4 - Изменить вероятность выпадения игрушки " + "\n";
        str += "5 - Запустить лотерею" + "\n";
        str += "клавиша 'Enter' - выйти из программы" + "\n";
        str += "Ваш выбор: ";
        System.out.print(str);
    }

    public static void choiceAction() {
        boolean continueLoop = true;
        String choice = "";
        Scanner scanner = new Scanner(System.in);
        Menu.welcomeMessage();

        while (continueLoop) {
            Menu.choiceView();
            choice = scanner.nextLine();
            switch (choice) {
                case ("1") -> toyShop.addToy();
                case ("2") -> toyShop.deleteToy();
                case ("3") -> toyShop.showToyList();
                case ("4") -> toyShop.updateToyFrequency();
                case ("5") -> toyShop.organizeLottery();
                case ("") -> {
                    continueLoop = false;
                    System.out.println("До свидания!");
                }
                default -> System.out.println("Что-то пошло не так...");
            }
        }
    }
}
