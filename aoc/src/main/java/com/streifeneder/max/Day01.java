package com.streifeneder.max;

import java.io.IOException;
import java.util.stream.Stream;

import com.streifeneder.max.base.AdventOfCodeHelper;

public class Day01 {

    public static void main(String[] args) throws IOException {
        System.out.println("Part1: " + getPart1(AdventOfCodeHelper.getLinesOfFile()));
        System.out.println("Part2: " + getPart2(AdventOfCodeHelper.getLinesOfFile()));
    }

    public static int getPart1(Stream<String> lines) {
        return lines.mapToInt(Integer::valueOf).map(module -> module / 3 - 2).reduce(Integer::sum).getAsInt();
    }
    
    public static int getPart2(Stream<String> lines) {
        return lines.mapToInt(Integer::valueOf).map(module ->calcFuelPart2(module)).reduce(Integer::sum).getAsInt();
    }

    public static int calcFuelPart2(int mass){
        if(mass/3 - 2 <= 0) 
            return 0;
        return mass/3 - 2 + calcFuelPart2(mass / 3 - 2);
    } 

}