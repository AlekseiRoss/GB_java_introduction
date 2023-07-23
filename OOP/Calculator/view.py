import re

# Здесь интерфейс


def get_value():
    allowed_chars = set("0123456789.+-*/ ")
    allowed_pattern = r'^\s*\d+(\s*[\+\-\*/]\s*\d+)*\s*$'
    while True:
        inp = input("Введите операцию, отделяя цифры и символы операции "
                    "(+, -, *, /) пробелом: ")
        if not all(char in allowed_chars for char in inp) or \
                not re.match(allowed_pattern, inp):
            print("Некорректный ввод.")
        else:
            break
    return inp


def output(result):
    print(f"Ваш результат:", result)
