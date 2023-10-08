import java.util.ArrayList;



public class Main {

    public static class Straight {

        private double slope;

        private double intercept;



        public Straight(double slope, double intercept) {

            this.slope = slope;

            this.intercept = intercept;

        }



        public double getXIntersect() {

            return -intercept / slope;

        }



        public double getYIntersect() {

            return intercept;

        }



        public static double[] intersect(Straight straight1, Straight straight2) {

            if (straight1.slope == straight2.slope) {

                return null;  // Прямі паралельні, немає точки перетину

            }

            double x = (straight2.intercept - straight1.intercept) / (straight1.slope - straight2.slope);

            double y = straight1.slope * x + straight1.intercept;

            return new double[]{x, y};

        }

    }



    public static void main(String[] args) {

        ArrayList<Straight> straights = new ArrayList<>();



        // Додавання прямих до масиву

        straights.add(new Straight(2, 3));

        straights.add(new Straight(2, 5));

        straights.add(new Straight(-1, 2));

        straights.add(new Straight(0, 4));



        // Групування паралельних прямих

        ArrayList<ArrayList<Straight>> parallelGroups = new ArrayList<>();

        for (Straight straight1 : straights) {

            boolean added = false;

            for (ArrayList<Straight> group : parallelGroups) {

                Straight straight2 = group.get(0);

                if (straight1.slope == straight2.slope) {

                    group.add(straight1);

                    added = true;

                    break;

                }

            }

            if (!added) {

                ArrayList<Straight> newGroup = new ArrayList<>();

                newGroup.add(straight1);

                parallelGroups.add(newGroup);

            }

        }



        // Виведення груп паралельних прямих

        for (int i = 0; i < parallelGroups.size(); i++) {

            System.out.println("Група " + (i + 1) + " паралельних прямих:");

            for (Straight straight : parallelGroups.get(i)) {

                System.out.println("Пряма з коефіцієнтом нахилу " + straight.slope + " та зміщенням " + straight.intercept);

            }

        }

    }

}
