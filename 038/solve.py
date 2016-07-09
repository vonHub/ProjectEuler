# Find largest 1-9 pandigital number as concatenated
# product of an interger with (1, 2, ..., n), n > 1
# (So it's not 987654321 concatenated with (1))

max = 918273645

#Has to start with a nine
for x in range(0, 100):
    num = int('9' + str(x))

