package shkryl.task9.part2.bridge;

public class AdvancedPainter extends Painter {

    public AdvancedPainter(CarBody carBody) {
        super(carBody);
    }

    public void paintGold() {
        System.out.println("Кузов площадью " + carBody.getSquare() + " покрашен в золотой");
    }
}
