package lgcns.inspire.loop;

public class LoopDemo {

    public int sumOntToTem(int startIdx, int endIdx) {
        int sum = 0;

        for (int i = startIdx; i <= endIdx; ++i) {
            sum += i;
        }

        return sum;
    }

    public void sumRandom() {
        int randomNumber = (int) (Math.random() * 100) + 1;

        System.out.println(randomNumber);

        int idx = 0;
        int sum = 0;

        while (idx <= randomNumber) {
            sum += idx++;
        }

        System.out.println(sum);
    }

    public void loopBreak(int number) {
        int idx = 0;
        int sum = 0;

        while (true) {
            sum += idx++;
            if (sum >= number)
                break;
        }
        System.out.println("마지막으로 더해진 값 : " + (idx - 1));
        System.out.println("합 : " + sum);
    }

    public void popStr(String str) {
        System.out.println(">>>>>>> params = " + str);

        for (int i = 0; i < str.length(); ++i) {
            System.out.print(str.charAt(i) + "\t");
        }
        System.out.println();
    }

    public void gugudanTable() {

        outer: 
        for (int dan = 2; dan <= 9; ++dan) {
            for (int col = 1; col <= 9; ++col) {

                if (dan == 5) {
                    break outer;
                }

                System.out.print(dan + "*" + col + "=" + (dan * col) + "\t");
            }
            System.out.println();
        }
    }
}
