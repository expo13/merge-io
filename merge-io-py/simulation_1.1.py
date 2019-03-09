from car import car
import threading
import time
import configparser
import random
import os
#we have a car, set an initial (variable) velocity, set the (variable) position of the object.

#create world time loop.

config = configparser.ConfigParser()
config.read('simulation_params1.ini')
max_int_starting_velocity = int(config['DEFAULT']['max_int_starting_velocity'])
road_length = int(config['DEFAULT']['simulation_road_length'])

car = car()

def generate_pseudo_random_block_position() :
    scalar = random.randint(5,11)*.1
    return road_length*scalar

def generate_pseudo_random_starting_velocity() :
    return random.randint(1,max_int_starting_velocity)

def generate_random_braking_actions() :
    return random.randint(1,10)

#This would need to be tuple set with the braking actions. For 1.1
def generate_random_braking_percentages() :
    return random.randint(1,100)

#TODO - use braking percentages instead of hardcoded 100 for 1.1
def perform_braking_actions(braking_actions, car) :
    for x in range(braking_actions) :
        car.brake(1, 25)

dirname = os.path.dirname(__file__)
data_file = os.path.join(dirname, 'data_run_1.log')
count_of_accidents = 0
count_of_nonaccidents = 0
#TODO parameterize data quantity
for x in range(10):

    car.velocity = generate_pseudo_random_starting_velocity()
    starting_velocity = car.velocity
    block_point = generate_pseudo_random_block_position()
    braking_actions = generate_random_braking_actions()
    time_to_object = block_point / car.velocity
    perform_braking_actions(braking_actions, car)

    classification = 1
    if block_point > 500 :
        classification = 0
        count_of_nonaccidents += 1
    elif car.velocity <= 0 :
        classification = 0
        count_of_nonaccidents += 1
    else :
        count_of_accidents += 1

    #Write to file. TODO - break out
    data_line=str(block_point)+','+str(starting_velocity)+','+str(braking_actions)+','+str(classification)
    with open(data_file, 'a') as myfile:
        myfile.write(data_line+"\n")

print('accidents -'+str(count_of_accidents)+'\nnon-accidents-'+str(count_of_nonaccidents))
