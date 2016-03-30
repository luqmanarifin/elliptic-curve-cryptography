/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luqman A. Siswanto
 */
public class Point {
  public long x, y;
  public Point() {
    x = 0;
    y = 0;
  }
  public Point(boolean isZero) {
    x = -1;
    y = -1;
  }
  public Point(long x, long y) {
    this.x = x;
    this.y = y;
  }
  public Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  }
  public boolean isZero() {
    return this.x == -1 && this.y == -1;
  }
  public boolean equals(Point p) {
    return this.x == p.x && this.y == p.y;
  }
  @Override
  public String toString() {
    return "{" + this.x + ", " + this.y + ")";
  }
  
  // this + p
  public Point add(Point p) {
    if(this.isZero()) return new Point(p);
    if(p.isZero()) return new Point(this);
    if(this.equals(p.negate())) return new Point(true);
    if(this.equals(p)) {      // find gradien using tangent, different method than standard adding
      if(this.y == 0) return new Point(true);
      long d = ((3*this.x%Constant.p*this.x%Constant.p + Constant.a) * Constant.inv(2 * this.y)) % Constant.p;
      if(d < 0) d += Constant.p;
      long ra = (d * d - 2 * this.x) % Constant.p;
      if(ra < 0) ra += Constant.p;
      long rb = (d * (this.x - ra) - this.y) % Constant.p;
      if(rb < 0) rb += Constant.p;
      return new Point(ra, rb);
    }
    long d = ((this.y - p.y) * Constant.inv(this.x - p.x)) % Constant.p;
    long ra = (d * d - this.x - p.x) % Constant.p;
    if(ra < 0) ra += Constant.p;
    long rb = (d * (this.x - ra) - this.y) % Constant.p;
    if(rb < 0) rb += Constant.p;
    return new Point(ra, rb);
  }
  
  // this - p
  public Point subtract(Point p) {
    return add(p.negate());
  }
  
  // -this
  public Point negate() {
    if(isZero()) return new Point(this);
    return new Point(this.x, (-this.y + Constant.p) % Constant.p);
  }
  
  // p * k
  public static Point multiply(Point p, int k) {
    if(k == 0) return new Point(true);
    Point temp = multiply(p, k / 2);
    temp = temp.add(temp);
    if(k % 2 == 1) {
      temp = temp.add(p);
    }
    return temp;
  }
  
  public Pair<Point, Point> encrypt(Point publicKey) {
    int k = (int) Constant.getRandom(1, Constant.p - 1);
    Point c1 = multiply(Constant.P, k);
    Point c2 = multiply(publicKey, k);
    c2 = this.add(c2);
    return new Pair(c1, c2);
  }
  public static Point decrypt(Pair<Point, Point> cipher, int secretKey) {
    Point c = cipher.first;
    Point d = cipher.second;
    c = multiply(c, secretKey);
    return d.subtract(c);
  }
}
