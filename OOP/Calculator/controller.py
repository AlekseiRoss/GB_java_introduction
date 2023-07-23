import view
import operations
import log


def button_click():
    print("Программа калькулятор")
    while True:
        value_lst = view.get_value()
        log.logwrite("Ввод: ", value_lst)
        result = operations.calc(value_lst)
        log.logwrite("Результат вычислений: ", result)
        view.output(result)
        cont = input('Вычислить ещё что-нибудь? (Y/N) ')
        if cont == "Y" or cont == "y":
            continue
        else:
            break
