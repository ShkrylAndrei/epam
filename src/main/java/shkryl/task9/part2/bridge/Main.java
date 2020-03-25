package shkryl.task9.part2.bridge;

public class Main {
    public static void main(String[] args) {
        SedanBody sedanBody = new SedanBody();
        HatchbackBody hatchbackBody = new HatchbackBody();

        Painter painter = new Painter(sedanBody);
        AdvancedPainter advancedPainter = new AdvancedPainter(hatchbackBody);

        painter.paintRed();
        advancedPainter.paintGold();
    }

}
