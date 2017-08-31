def ask():
    while True:
        try:
            user_input = int(raw_input("Enter an integer to be squared away: "))
        except ValueError:
            print("That is actually not an integer, try again...")
            continue
        else:
            print("Thank you, your number squared is: {}".format(user_input**2))
            user_input = raw_input("Do you want to square more integers (y/n)? ")
            if user_input == 'n':
                break

try:
    for i in ['a', 'b', 'c']:
        print(i**2)
except:
    print("You have made a serious mistake!")


x = 5
y = 0

try:
    z = x/y
except ZeroDivisionError:
    print("You really can't divide by zero")
finally:
    print("All done")

ask()
