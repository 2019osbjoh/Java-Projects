int y = 100;

void setup() {
  size(640, 360);
  frameRate(30);
  stroke(255);
  strokeWeight(2);

  
}

void draw() {
  background(0);
  line(0 , y, width, y);
  
  
  if (y > 0) {
    y = y - 1;
  } else if (y == 0) {
    y = height; 
  }
  
}
