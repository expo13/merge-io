class car:
    image = ''
    mass = 1580
    velocity = 0
    position = 0 ##TODO linear position
    throttle_delay = .2
    max_gas_force = 320
    #assumes no slipping 
    max_brake_force=mass * 9.8 * 1.0 ##friction coeffecient = 1
    distance_to_object = 0


    def __init__(self):
        print('Car built!')

    #This is a janky acceleration method that needs to address complexities of
    #braking, but is sufficient for 1.0
    def accelerate(self, force, time):
        acceleration = force / self.mass
        self.velocity += acceleration * time
        print('Car accelerated to '+str(self.velocity)+' m/s')

    def give_it_gas(self, time, throttle_percentage):
        print('Giving it gas! '+str(time)+'s @'+str(throttle_percentage)+'%')
        self.accelerate((self.max_gas_force * throttle_percentage / 100),time)

    #janky way to brake
    def brake(self, time, brake_percentage):
        print('Hittin\' da brakes!' +str(time)+'s @'+str(brake_percentage)+'%')
        force_applied = self.max_brake_force * brake_percentage
        if self.velocity <= 0 :
            force_applied = 0
            self.velocity = 0
        self.accelerate(-(force_applied / 100), time)

    def setDistanceToObject(self, relative_position_block,
                            relative_position_car) :
        distance_to_object = relative_position_block - relative_position_car

