package shkryl.task9.part2.bridge;

public class Painter implements Paiting {
    protected CarBody carBody;

    public Painter(CarBody carBody){
        this.carBody = carBody;
    }

    @Override
    public void paintRed() {
        System.out.println("Кузов площадью "+carBody.getSquare()+" покрашен в красный");
    }

    @Override
    public void paintWhite() {
        System.out.println("Кузов площадью "+carBody.getSquare()+" покрашен в белый");
    }
}
