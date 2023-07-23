from abc import ABC, abstractmethod


# Интерфейс для операций
class Calculable(ABC):
    @abstractmethod
    def sum(self, arg):
        pass

    @abstractmethod
    def multi(self, arg):
        pass

    @abstractmethod
    def div(self, arg):
        pass

    @abstractmethod
    def get_result(self):
        pass
