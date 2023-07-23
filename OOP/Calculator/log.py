from datetime import datetime as dt

log_file = open('log_file.txt', 'a')
operation_time = dt.now().strftime('%Y-%m-%d %H:%M:%S')


def logwrite(note, message_text):
    log_file.write(operation_time + ' ' + note + str(message_text) + '\n')
