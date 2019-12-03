package com.streifeneder.max;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.streifeneder.max.base.AdventOfCodeHelper;

/**
 * Day02
 */
public class Day02 {

    static final int ADDITION = 1;
    static final int MULTIPLICATION = 2;
    static final int STOP = 99;
    private static final int TARGET = 19690720;

    public static void main(String[] args) throws IOException {
        int[] originalNums = Stream.of(AdventOfCodeHelper.getFileAsString().split(",")).mapToInt(Integer::valueOf)
                .toArray();
        int[] part1Nums = Arrays.copyOf(originalNums, originalNums.length);
        int[] part2Nums = Arrays.copyOf(originalNums, originalNums.length);
        System.out.printf("Part1 solution is %d %n", solveDay1(part1Nums));
        System.out.printf("Part2 solution is %d %n", solveDay2(part2Nums));
    }

    private static int solveDay1(int[] originalNums) {
        originalNums[1] = 12;
        originalNums[2] = 2;
        return runIntProgram(originalNums);
    }

    private static int solveDay2(int[] originalNums) {
        for (int noun = 0; noun < 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                int[] initNums = Arrays.copyOf(originalNums, originalNums.length);
                initNums[1] = noun;
                initNums[2] = verb;
                if (runIntProgram(initNums) == TARGET)
                    return 100 * noun + verb;
            }
        }
        return 0;
    }

    public static int runIntProgram(int[] numbers) {
        int position = 0;
        int opcode = Integer.valueOf(numbers[position]);

        do {
            switch (opcode) {
            case ADDITION:
                numbers[numbers[position + 3]] = numbers[numbers[position + 1]] + numbers[numbers[position + 2]];
                break;
            case MULTIPLICATION:
                numbers[numbers[position + 3]] = numbers[numbers[position + 1]] * numbers[numbers[position + 2]];
                break;
            default:
                System.out.println("Eric Wastl tries to screw my code, I don't care");
            }
            position = position + 4;
            opcode = Integer.valueOf(numbers[position]);
        } while (opcode != STOP);

        return numbers[0];
    }

}
