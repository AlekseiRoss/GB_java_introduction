from calculator_factory.calc_fact_logger import CalculatorFactoryWithLogger
from view.view import CalculatorView


if __name__ == "__main__":
    calculable_factory1 = CalculatorFactoryWithLogger()
    view = CalculatorView(calculable_factory1)
    view.run()
