from abc import ABC, abstractmethod


# Интерфейс для логгера
class Loggable(ABC):
    @abstractmethod
    def log(self, message):
        pass
