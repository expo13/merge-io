from car import car
import threading
import time
import configparser
#we have a car, set an initial (variable) velocity, set the (variable) position of the object.

#create world time loop.

config = configparser.ConfigParser()
config.read('simulation_params1.ini')
max_int_starting_velocity = int(config['DEFAULT']['max_int_starting_velocity'])
road_length = int(config['DEFAULT']['simulation_road_length'])

def generate_pseudo_random_block_position() :
    scalar = random.randint(5,15)*.1
    return road_length*scalar

def generate_pseudo_random_starting_velocity() :
    return random.randint(1,max_int_starting_velocity)

def generate_random_braking() :
    return random.randint(1,15)

car = car()
car.velocity = generatePsuedoRandomStartingVelocity()
block_point = generate_pseudo_random_block_position()
braking_action = generate_random_braking()


