
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luqman A. Siswanto
 */
public class Constant {
  public static final long p = (long) 2e9 + 89;
  public static final long a = 69;
  public static final long b = -857254909;
  public static final int k = 1000;
  public static final Random random = new Random();
  
  public static final long Pa = 13513024;
  public static final long Pb = 952340467; 
  public static final Point P = new Point(Pa, Pb);
  
  public static final long[] fa = {1,1003,2001,3002,4002,5004,6001,7001,8001,9001,10003,11001,12001,13003,14003,15001,16003,17001,18006,19005,20001,21003,22002,23003,24001,25001,26001,27002,28001,29001,30001,31002,32005,33001,34001,35001,36001,37005,38002,39001,40002,41005,42001,43003,44003,45001,46004,47001,48001,49004,50002,51001,52003,53001,54002,55002,56001,57001,58001,59001,60004,61002,62001,63001,64004,65002,66002,67001,68002,69001,70002,71001,72001,73004,74001,75001,76001,77001,78002,79002,80001,81002,82002,83003,84002,85002,86003,87004,88001,89004,90001,91003,92001,93006,94001,95003,96001,97001,98006,99003,100002,101001,102003,103001,104002,105006,106003,107002,108001,109002,110002,111001,112002,113003,114001,115002,116001,117005,118003,119003,120001,121002,122001,123002,124002,125001,126002,127008,128003,129001,130002,131001,132001,133001,134001,135001,136004,137001,138001,139001,140001,141005,142002,143001,144001,145001,146001,147003,148001,149001,150002,151003,152002,153001,154001,155001,156001,157001,158001,159004,160001,161004,162003,163001,164002,165002,166001,167001,168002,169001,170001,171001,172002,173002,174001,175001,176003,177001,178001,179001,180001,181003,182001,183001,184001,185004,186004,187001,188003,189002,190001,191003,192001,193002,194001,195001,196002,197002,198004,199003,200002,201002,202001,203003,204002,205001,206001,207002,208002,209002,210001,211001,212001,213003,214001,215003,216002,217001,218003,219001,220003,221002,222001,223001,224004,225004,226001,227002,228002,229003,230001,231004,232001,233007,234002,235002,236004,237003,238001,239001,240001,241004,242001,243003,244002,245001,246002,247001,248005,249002,250002,251001,252001,253001,254002,255004};
  public static final long[] fb = {496813446,131158869,443834976,834534985,636665538,900223397,243966477,434235179,732258264,910611168,503353404,176382187,390754765,115682100,147614423,546963072,853269472,220110484,772806634,892541836,794221210,745722634,850457858,174935446,536144829,829961373,224214851,988021688,858526482,916322464,468501784,367935516,543662772,587139582,212915426,402200322,757761674,734049180,466624148,158495665,519213400,258576295,512095458,935518749,205425905,152322294,576409635,20731155,931870662,877545432,744862702,171425346,782975419,572865528,431074628,837382235,971443240,598069041,778666744,852850447,559930921,85299395,844428896,346336275,622524412,898969928,689832825,756416546,278062249,304099455,95521123,149790588,516297041,9366434,669985398,439596808,607361934,62524268,821525577,69809081,295110051,785806263,317803757,672440518,786639828,385064657,601528852,263348241,609717947,858282189,527662932,137054542,995253782,489381645,794190001,476251412,942328861,381826150,454788141,643534542,319335497,296752905,130093672,505731519,626080250,540289050,328959683,185131970,421449093,427314661,754550113,649105851,960214156,804423913,407908494,547516258,186634769,632946084,467128278,821419392,923265769,228089860,441865007,249474535,696553710,116349145,986738490,59952876,475200291,356806199,644186660,293117518,373710703,227977831,220233306,838108277,488317808,104486472,55083503,491402748,308351303,266356632,793903406,806025934,406631967,29197622,243235490,483980608,96182156,870486733,162596209,23062247,227467980,197487878,290988113,897800470,657752538,839975379,508787684,514218021,162909088,761351600,908207245,421067576,59841712,450911841,226732428,149799468,645097663,569593822,655107723,659669515,635474357,31946542,179708751,976527245,232120344,456052450,928371470,114158743,338012182,653709267,20590490,350739949,856788970,312346543,273172351,748224279,287595088,959063157,449839825,355310979,202511983,508220695,939568278,618538040,962065049,917517007,107214886,603549145,892639466,392033028,468837587,982928806,885483445,452980047,447685136,287479715,10504587,863873981,384700548,625364974,428595023,457082482,680217945,168318570,278237884,505622308,316720768,25043035,226439035,94498080,733343336,862223667,489072172,790855789,544767880,867235930,11607521,993349473,489198659,122754978,479652216,203435861,424671286,530641907,824792491,241206981,716336105,146938354,222703241,151019772,724446623,171184083,647405008,567695339,869406121,400757934,25982746,542642216,572595014,280138969,267841655,171849995,458673436,469407345};
  
  // compute c^d mod m
  public static long power(long c, long d, long m) {
    if(d == 0) return 1 % m;
    long tmp = power(c, d / 2, m);
    tmp = tmp * tmp % m;
    if(d % 2 == 1) {
      tmp = tmp * c % m;
    }
    return tmp;
  }
  
  // public inverse of d
  public static long inv(long d) {
    return power(d, p - 2, p);
  }
  
  // get random number in range (inclusive)
  public static long getRandom(long l, long r) {
    long rand = random.nextLong();
    if(rand < 0) rand = -rand;
    return rand % (r - l + 1) + l;
  }
  
  public static Point getPublicKey(int secretKey) {
    Point base = new Point(P);
    return new Point().multiply(base, secretKey);
  }
  
  public static Pair<Point, Integer> getKey() {
    int secretKey = (int) getRandom(1, p - 1);
    return new Pair(getPublicKey(secretKey), secretKey);
  }
}
