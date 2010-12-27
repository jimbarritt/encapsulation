#!/usr/bin/ruby
x1 = 10
y1 = 20
x2 = 20
y2 = 30

b = x2 - x1
c = y2 - y1

distance = Math.hypot(b, c)

puts "The distance between the two points is %f" % distance
