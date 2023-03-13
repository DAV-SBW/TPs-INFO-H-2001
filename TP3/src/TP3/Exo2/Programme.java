package TP3.Exo2;

public class Programme {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Illustration illu = new Illustration();
        Rectangle r1 = new Rectangle(new Point(5,5), 3, 7, 'A');
        Rectangle r2 = new Rectangle(new Point(6,7), 8, 3, 'B');
        AsciiNumber ascii2 = new AsciiNumber(2, new Point(15,16));
        illu.add(r1);
        illu.add(r2);
        illu.add(ascii2);
        r1.bouge(1, -1);
        System.out.println(illu);
    }

}