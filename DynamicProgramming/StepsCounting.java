package DynamicProgramming;

public class StepsCounting {

    public static void main(String args[]) {

        final int steps = 36;

        int[] numbers = new int[steps + 1];
        numbers[0] = 1;
        numbers[1] = 1;

        int y = calculateSteps(numbers, steps);
        System.out.println(y);

    }

    static int calculateSteps(int[] stepNumbers, int step) {
        if (step < 0) {
            return 0;

        } else if (step == 0) {
            return stepNumbers[0];
        } else {
            if (stepNumbers[step] > 0) {
                return stepNumbers[step];
            } else {
                int s =
                        calculateSteps(stepNumbers, step - 1) + calculateSteps(stepNumbers, step - 2) + calculateSteps(stepNumbers, step - 3);
                stepNumbers[step] = s;
                return s;
            }
        }

    }
}
