class car:
    image = ''
    mass = 1580
    velocity = 0
    position = 0 ##TODO linear position
    throttle_delay = .2
    max_force = 320

    def __init__(self):
        print('Car built!')

    def accelerate(self, force, time):
        acceleration = force / self.mass
        self.velocity += acceleration * time

    def give_it_gas(self, time, throttle_percentage):
        print('Giving it gas! '+str(time)+'s @'+str(throttle_percentage)+'%')
        self.accelerate((self.max_force * throttle_percentage / 100) , time)

    def brake(self, time, brake_percentage):
        print('Hittin\' da brakes!' +str(time)+'s @'+str(brake_percentage)+'%')
        self.accelerate(-(self.max_force * brake_percentage / 100), time)


#        learn about friction before learning about running into something?
#
#        teaching computer a function?gravity? is it just that a function...?
#
#        First reaction is to slow as quickly as possible (because of unknown of
#                                                          calculation) then if
#        failure path is unavoidable .. plan b.
#
#        car applying the model vs god applying the brakes.
#
#        1) Start with car distance to object should never be 0 or less than 0.
#        Features distance between objects, gas, gas_percenrtage, brake,
#        brake_percentage, time, velocity.
#        SINGLE POINT DECISION.
#
#        1) Create a data set through pseudo-random simulations. Learn on the
#        fly? Using just learned model to run next simulation (step 2) to
#        increase the learning rate.
#        - classification model (1st... fail or succee)
#        - next.. neural net.
#
#        1) Start with presence of an object = take braking actions. Hard part
#        here will be visualizings simulation.
#
#        2) Then go to time based action that slows the car as it approaches the
#        object.
#
#        Idea - learn to take an action. Each new milisecond allows for a new
#        action to be taken. Is there something else? Yep SINGLE POINT DECISION
#        FROM ABOVE... this idea is
