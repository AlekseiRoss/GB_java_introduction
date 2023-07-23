from calculator.calculable import Calculable


# Класс калькулятора
class Calculator(Calculable):
    def __init__(self, primary_arg):
        self.result = primary_arg

    def sum(self, arg):
        self.result += arg
        return self

    def multi(self, arg):
        self.result *= arg
        return self

    def div(self, arg):
        self.result /= arg
        return self

    def get_result(self):
        return self.result
