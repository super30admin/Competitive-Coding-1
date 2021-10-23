package CompetitiveCoding1;

class Problem1 {

    static int search(int ar[],

                      int size) {

        int a = 0, b = size - 1;

        int mid = 0;

        while ((b - a) > 1) {

            mid = (a + b) / 2;

            if ((ar[a] - a) != (ar[mid] - mid))

                b = mid;

            else if ((ar[b] - b) != (ar[mid] - mid))

                a = mid;

        }

        return (ar[a] + 1);

    }
}
