/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luqman A. Siswanto
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    long p = Constant.p;
    long a = Constant.a;
    long b = Constant.b;
    int k = Constant.k;
    
    for(int i = 0; i < 256; i++) {
      Pair<Point, Integer> key = Constant.getKey();
      //System.out.println("key : " + key);
      
      Point msg = new Point(Constant.fa[i], Constant.fb[i]);
      //System.out.println("msg : " + msg);
      
      Pair<Point, Point> cipher = msg.encrypt(key.first);
      //System.out.println("cipher : " + cipher);
      
      Point plain = new Point().decrypt(cipher, key.second);
      if(!plain.equals(msg)) {
        System.out.println("ADA YG SALAH");
      }
      //System.out.println("plain : " + plain);
      //System.out.println("");
    }
    
  }
}
