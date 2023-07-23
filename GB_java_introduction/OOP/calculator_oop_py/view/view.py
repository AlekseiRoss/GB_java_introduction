# Класс для представления калькулятора
class CalculatorView:
    def __init__(self, calculable_factory):
        self.calculable_factory = calculable_factory

    def run(self):
        while True:
            primary_arg = self.prompt_int("Введите первый аргумент: ")
            calculator = self.calculable_factory.create(primary_arg)
            while True:
                cmd = self.prompt("Введите команду (*, +, /, =): ")
                if cmd == "*":
                    arg = self.prompt_int("Введите второй аргумент: ")
                    calculator.multi(arg)
                    continue
                if cmd == "+":
                    arg = self.prompt_int("Введите второй аргумент: ")
                    calculator.sum(arg)
                    continue
                if cmd == "/":
                    arg = self.prompt_int("Введите второй аргумент: ")
                    calculator.div(arg)
                    if arg == 0:
                        break
                    continue
                if cmd == "=":
                    result = calculator.get_result()
                    print(f"Результат: {result}")
                    break
            cmd = self.prompt("Еще посчитать (Y/N)? ")
            if cmd == "Y" or cmd == "y":
                continue
            else:
                break

    @staticmethod
    def prompt(message):
        return input(message)

    @staticmethod
    def prompt_int(message):
        return int(input(message))
