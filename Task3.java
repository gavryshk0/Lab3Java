public class Main {

    // Нелінійна функція, для якої ми шукаємо корінь.

    public static double f(double x, double y) {

        // Введіть вашу функцію тут. Наприклад, f(x, y) = x^2 + y^2 - 25.

        return x * x + y * y - 25;

    }



    // Метод бісекції для знаходження кореня.

    public static double bisection(double a, double b, double tolerance, double y) {

        double left = a;

        double right = b;



        if (f(left, y) * f(right, y) >= 0) {

            System.out.println("Неможливо знайти корінь в заданому інтервалі.");

            return Double.NaN; // Повертаємо NaN у разі невдачі.

        }



        while ((right - left) >= tolerance) {

            double mid = (left + right) / 2;



            if (f(mid, y) == 0.0) {

                return mid; // Знайдено корінь.

            }



            if (f(mid, y) * f(left, y) < 0) {

                right = mid;

            } else {

                left = mid;

            }

        }

        return (left + right) / 2;

    }



    public static void main(String[] args) {

        double a = 0; // Ліва межа інтервалу

        double b = 5; // Права межа інтервалу

        double tolerance = 0.0001; // Точність

        double y = 2; // Фіксоване значення y



        double root = bisection(a, b, tolerance, y);



        if (!Double.isNaN(root)) {

            System.out.println("Знайдено корінь x: " + root + ", y: " + y);

        } else {

            System.out.println("Корінь не знайдено.");

        }

    }

}
