import tkinter as tk
from tkinter import Canvas, Frame, BOTH, PhotoImage, Label
from car import car
import threading
import time
import configparser

class Application(tk.Frame):

    def gas(self):
        for t in range(7):
            time.sleep(2)
            if t%3==0 and t > 0:
                self.car_1.brake(-5,200)
                continue
            self.car_1.give_it_gas(-5,100)
    def simulation(self):
        t2 = threading.Thread(target=self.gas)
        time.sleep(2)
        t2.start()
        self.animation()
        t2.join
    def animation(self):
        for x in range(0, 1000):
            self.canvas.move(self.car_image, 0, self.car_1.velocity)
            self.canvas.update()
            time.sleep(.01)
            if x % 100 == 0 :
                print('Car at ' + str(self.car_1.velocity))
    def __init__(self, block_position, master=None):
        super().__init__(master)
        self.master = master
        self.pack()
        self.car_1 = car()
        self.car_image = 0
        self.block_position = block_position
        self.canvas = self.create_widgets(block_position)
        self.simulation()
    def create_widgets(self, block_position):
        self.start = tk.Button(self, text="START", fg="green",
                               command=self.animation)
        self.quit = tk.Button(self, text="QUIT", fg="red",
                              command=self.master.destroy)
        self.start.pack(side="top")
        self.quit.pack(side="bottom")
        canvas = Canvas(self, width=1000, height = 800)
        canvas.create_rectangle(0, 0, 450, 750, fill="#0f0")
        canvas.create_rectangle(550, 0, 1000, 750, fill="#0f0")
        canvas.create_rectangle(450, 0, 550, 750,
            outline="#fff", fill="#222")
        canvas.create_rectangle(510, 685-block_position, 540,
                                715-block_position, fill="#a55")
        canvas.create_line(500, 0, 500, 750, dash=(4, 2), fill="#ff0")
        gif1 = PhotoImage(file = '/Users/ccolquitt/repos/expo/merge-io/merge-io-py/car.gif')
        self.car_image = canvas.create_image(525,700,image = gif1)
        label = Label(image=gif1)
        label.image = gif1
        canvas.pack(fill=BOTH, expand=1)
        return canvas

##Initation
config = configparser.ConfigParser()
config.read('simulation_params1.ini')

#initial_velocity = config['DEFAULT']['starting_velocity']
block_point = int(config['DEFAULT']['simulation_road_length'])*.8

print (str(block_point))

root = tk.Tk()
car_image = 0
app = Application(block_point, master=root)
app.mainloop()
