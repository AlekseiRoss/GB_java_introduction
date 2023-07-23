from abc import ABC, abstractmethod


# Абстрактный класс для фабрики калькуляторов
class CalculableFactory(ABC):
    @abstractmethod
    def create(self, primary_arg):
        pass
