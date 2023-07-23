from calculator_factory.calculabe_factory import CalculableFactory
from calculator.calculator_dec_log import CalculatorDecorator
from calculator.calculator import Calculator
from log.logger import ConsoleLogger


# Фабрика калькуляторов с логированием
class CalculatorFactoryWithLogger(CalculableFactory):
    def create(self, primary_arg):
        return CalculatorDecorator(Calculator(primary_arg), ConsoleLogger())
