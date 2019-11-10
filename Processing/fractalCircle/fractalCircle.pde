void setup() {
  size(800, 800);
  background(61);
}

void draw() {
  drawCircle(width / 2, height / 2, 300);
  
}

void drawCircle(float x, float y, float d) {
  stroke(180);
  strokeWeight(1);
  noFill();
  ellipse(x, y, d, d);
  if (d > 10) {
    drawCircle(x, y, d / 2);
    drawCircle(x - d / 2, y, d / 2);
    drawCircle(x + d / 2, y, d / 2);
    drawCircle(x, y - d / 2, d / 2);
    drawCircle(x, y + d / 2, d / 2);
  }
}
