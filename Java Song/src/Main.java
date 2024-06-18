  // Lab1b.java
  // This is a practice lab to output a few verses of
  //"99 bottles of beer on the wall"
  // Authors: Carol Zander, Clark Olson
  //Completed by: PradaFit

public class Main {
    public static void main(String[] args) {
        int numBottles; //# of bottles currently on the wall
        
        numBottles = 5;
        System.out.println(numBottles);
        onWall();
        System.out.println(numBottles);
        botBeer();
        takeOneDown();
        numBottles = 4;
        System.out.println(numBottles);
        botBeer();
        onWall();
        System.out.println();
        numBottles = 4;
        System.out.println(numBottles);
        botBeer();
        onWall();
        takeOneDown();
        numBottles = 3;
        System.out.println(numBottles);
        botBeer();
        onWall();
        System.out.println(numBottles);
        botBeer();
        takeOneDown();
        numBottles = 2;
        System.out.println(numBottles);
        botBeer();
        onWall();
        System.out.println(numBottles);
        botBeer();
        onWall();
        System.out.println(numBottles);
        botBeer();
        fail();
        numBottles = 1;
        System.out.println(numBottles);
        botBeer();
        onWall();
        numBottles = 1;
        System.out.println(numBottles);
        botBeer();
        onWall();
        numBottles = 1;
        System.out.println(numBottles);
        botBeer();
        takeOneDown();
        noMore();
        theEnd();

    }

    public static void onWall() {
        System.out.println("Bottles on the wall");
    }

    public static void botBeer() {
        System.out.println("Bottles of beer");
    }

    public static void takeOneDown() {
        System.out.println("Take one down and pass it around");
    }

    public static void theEnd() {
        System.out.println("The end");
    }

    public static void fail() {
        System.out.println("If one of those bottles should happen to fall");
    }

    public static void noMore() {
        System.out.println("No more bottles of beer on the wall");
    }

}
