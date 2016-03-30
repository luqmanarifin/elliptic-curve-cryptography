/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luqman A. Siswanto
 */
public class Pair<K, E> {
  public K first;
  public E second;
  
  public Pair(K first, E second) {
    this.first = first;
    this.second = second;
  }
  
  @Override
  public String toString() {
    return "{" + first.toString() + ", " + second.toString() + ")"; 
  }
}
