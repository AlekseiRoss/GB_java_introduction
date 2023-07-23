from calculator.calculable import Calculable


# Декоратор для калькулятора с логированием
class CalculatorDecorator(Calculable):
    def __init__(self, calculator, logger):
        self.calculator = calculator
        self.logger = logger

    def sum(self, arg):
        self.logger.log(f"Суммирую {self.calculator.get_result()} с {arg}")
        result = self.calculator.sum(arg)
        self.logger.log(f"Результат: {result.get_result()}")
        return self

    def multi(self, arg):
        self.logger.log(f"Умножаю {self.calculator.get_result()} на {arg}")
        result = self.calculator.multi(arg)
        self.logger.log(f"Результат: {result.get_result()}")
        return self

    def div(self, arg):
        self.logger.log(f"Делю {self.calculator.get_result()} на {arg}")
        if arg != 0:
            result = self.calculator.div(arg)
            self.logger.log(f"Результат: {result.get_result()}")
        else:
            self.logger.log(f"Результат: Infinity")
        return self

    def get_result(self):
        return self.calculator.get_result()
