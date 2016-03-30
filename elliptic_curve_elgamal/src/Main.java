
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
    System.out.println("Command :\n");
    System.out.println("[enc/dec][inputfile][outputfile][key]");
    System.out.println("[req][outputfile]");
    System.out.println("Note :"
            + "   For encryption, key must be 2 integer (public key)\n"
            + "   For decryption, key must be 1 integer (private key)");
    InputReader in = new InputReader(System.in);
    String com = in.next();
    if(com.equals("req")) {
      
      Pair<Point, Integer> key = Constant.getKey();
      System.out.println("Your public key   : " + key.first);
      System.out.println("Your private key  : " + key.second);
      String name = in.next();
      try {
        System.out.println("Writing to file named " + name);
        PrintWriter out = new PrintWriter(new File(name));
        out.println("Your public key   : " + key.first);
        out.println("Your private key  : " + key.second);
        out.close();
      } catch(Exception e) {
        e.printStackTrace();
      }
      
    } else if(com.equals("enc")) {
      
      String nameFileInput = in.next();
      String nameFileOutput = in.next();
      int a = in.nextInt();
      int b = in.nextInt();
      byte[] buffer = null;
      File a_file = new File(nameFileInput);
      try {
        FileInputStream fis = new FileInputStream(nameFileInput);
        int length = (int)a_file.length();
        buffer = new byte [length];
        fis.read(buffer);
        fis.close();
      } catch(IOException e) {
        e.printStackTrace();
      }
      Point key = new Point(a, b);
      ArrayList<Pair<Point, Point>> cipher = Ecc.encrypt(buffer, key);
      try {
        PrintWriter out = new PrintWriter(new File(nameFileOutput));
        for(Pair<Point, Point> p : cipher) {
          out.println(p.first.x + " " + p.first.y + " " + p.second.x + " " + p.second.y);
        }
        out.close();
      } catch(Exception e) {
        e.printStackTrace();
      }
      System.out.println(cipher.size() + " encrypted successfully");
      
    } else if(com.equals("dec")) {
      
      String nameFileInput = in.next();
      String nameFileOutput = in.next();
      int key = in.nextInt();
      ArrayList<Pair<Point, Point>> cipher = new ArrayList<Pair<Point, Point>>();
      Scanner scanner = null;
      try {
        scanner = new Scanner(new File(nameFileInput));
        while(scanner.hasNextInt()) {
          int a = scanner.nextInt();
          int b = scanner.nextInt();
          int c = scanner.nextInt();
          int d = scanner.nextInt();
          cipher.add(new Pair(new Point(a, b), new Point(c, d)));
        }
      } catch(Exception e) {
        e.printStackTrace();
      } finally {
        if(scanner != null) {
          scanner.close();
        }
      }
      byte[] plain = Ecc.decrypt(cipher, key);
      try {
        OutputStream out = new FileOutputStream(nameFileOutput);
        out.write(plain);
        out.close();
      } catch(Exception e) {
        e.printStackTrace();
      }
      System.out.println(plain.length + " decrypted successfully");
      
    } else {
      System.out.println("Command not found");
    }
  }
}

class InputReader {
  public BufferedReader reader;
  public StringTokenizer tokenizer;

  public InputReader(InputStream stream) {
    reader = new BufferedReader(new InputStreamReader(stream), 32768);
    tokenizer = null;
  }

  public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new StringTokenizer(reader.readLine());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }
	
  public double nextDouble() {
    return Double.parseDouble(next());
  }
}