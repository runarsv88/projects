class Line(object):
    def __init__(self, coor1, coor2):
        self.coor1 = coor1
        self.coor2 = coor2
    
    def distance(self):
        x_delta = self.coor2[0] - self.coor1[0]
        y_delta = self.coor2[1] - self.coor1[1]
        return ( x_delta**2 + y_delta**2 )**0.5

    def slope(self):
        x_delta = self.coor2[0] - self.coor1[0]
        y_delta = self.coor2[1] - self.coor1[1]
        return y_delta/x_delta

class Cylinder(object):
    def __init__(self,height = 1, radius = 1):
        self.height = height
        self.radius = radius

    def volume(self):
        return self.radius**2*3.14*self.height

    def surface_area(self):
        return 2*self.radius*3.14*self.height + 2*self.radius**2*3.14 

coor1= (3,2)
coor2 = (8,10)
li = Line(coor1, coor2)
print(li.distance())
print(li.slope())
cy = Cylinder(2,3)
print(cy.volume())
print(cy.surface_area())
