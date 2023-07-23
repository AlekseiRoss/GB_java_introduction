from sympy import sympify

# Создать калькулятор для работы с рациональными и комплексными числами,
# организовать меню, добавив в неё систему логирования.


def calc(action):
    try:
        result = sympify(action)
        return float(result)
    except Exception as e:
        return "Ошибка: {}".format(str(e))
