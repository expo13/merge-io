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
