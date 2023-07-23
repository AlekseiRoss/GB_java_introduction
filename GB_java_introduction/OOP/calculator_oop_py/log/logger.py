from log.loggable import Loggable
from datetime import datetime


# Конкретный класс логгера для вывода в консоль
class ConsoleLogger(Loggable):
    def log(self, message):
        print(datetime.now(), message)
