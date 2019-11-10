int cols, rows;
int scl = 20;
int w = 500;
int h = 1500;

float[][] terrain;
float flying = 0.0;

void setup() {
  
  size(640, 360, P3D);
    
  cols = w / scl;
  rows = h / scl;
  terrain = new float[cols][rows];
}

void draw() {
  
  flying -= 0.085;
  
  float yoff = flying;
  for (int y = 0; y < rows; y++) {
    float xoff = 0;
    for (int x = 0; x < cols; x++) {
      terrain[x][y] = map(noise(xoff, yoff), 0, 1, -60, 60);
      xoff += 0.18;
    }
    yoff += 0.18;
  }

  background(51);
  stroke(255);
  fill(125);
//noFill();
  
  translate(width / 2, height / 2 - 60, -400);
  rotateX(PI / 3.2);
  translate(-w / 2, -h / 2);
  for (int y = 0; y < rows - 1; y++) {
    beginShape(TRIANGLE_STRIP); 
    for (int x = 0; x < cols; x++) {
      vertex(x * scl, y * scl, terrain[x][y]);
      vertex(x * scl, (y + 1) * scl, terrain[x][y + 1]);
    }
    
    endShape();
  }
}
