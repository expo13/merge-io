import tkinter as tk
from tkinter import Canvas, Frame, BOTH, PhotoImage, Label
from car import car
import time

class Application(tk.Frame):

    def simulation():
        t2 = threading.Thread(target=gas)
        t1 = threading.Thread(target=animation)
        t1.start()
        time.sleep(1)
        t2.start()

    def gas():
        time.sleep(4)
        self.car_1.give_it_gas(10,100)

    def animation(self):
        for x in range(0, 1000):
            dy = car_1.velocity
            dx = 0
            self.canvas.move(self.car_1, dx, dy)
            self.canvas.update()
            time.sleep(.01)

    def __init__(self, master=None):
        super().__init__(master)
        self.master = master
        self.pack()
        self.car_1 = None
        self.canvas = self.create_widgets()
        self.simulation()

    def create_widgets(self):
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
        canvas.create_line(500, 0, 500, 750, dash=(4, 2), fill="#ff0")
        gif1 = PhotoImage(file = '/Users/ccolquitt/repos/expo/merge-io/merge-io-py/car.gif')
        self.car_1 = canvas.create_image(525,700,image = gif1)
        label = Label(image=gif1)
        label.image = gif1
        canvas.pack(fill=BOTH, expand=1)
        return canvas

root = tk.Tk()
car_1 = car()
app = Application(master=root)
app.mainloop()
