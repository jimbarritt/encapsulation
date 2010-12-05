distance_cartesian = function(p1, p2) {
	x1 <- p1[1]
	y1 <- p1[2]
		
	x2 <- p2[1]
	y2 <- p2[2]

	sqrt((x2 - x1)^2 + (y2 - y1)^2)
}

cartesian_to_polar = function(p1) {
	x <- p1[1]
	y <- p1[2]
	
	r <- sqrt(x^2 + y^2)
	theta <- atan(y / x)
	c(theta, r)
}

polar_to_cartesian = function(p1) {
	theta <- p1[1]
	r <- p1[2]
	
	x <- r * cos(theta)
	y <- r * sin(theta)
	c(x, y)
}

p1 <- c(10, 20)
p2 <- c(20, 30)
distance_cartesian(p1, p2)

p3 <- cartesian_to_polar(p1)
p3
p4 <- cartesian_to_polar(p2)
p4

polar_to_cartesian(p3)
atan(30 / 20)