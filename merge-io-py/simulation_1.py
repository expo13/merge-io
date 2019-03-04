from car import car
import threading
import time
car_1 = car()

def simulation() :
    for x in range(0,30):
        time.sleep(1)
        print(str(car_1.velocity))

def gas() :
    time.sleep(4)
    car_1.give_it_gas(5,100)

t1 = threading.Thread(target=simulation)
t2 = threading.Thread(target=gas)

    # starting thread 1
t1.start()
time.sleep(1)
    # starting thread 2
t2.start()

    # wait until thread 1 is completely executed
t1.join()
    # wait until thread 2 is completely executed
t2.join()

# both threads completely executed
print("Done!")
