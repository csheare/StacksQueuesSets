package edu.clemson.cpsc2150.project4;

/**
 * Created by csheare on 11/4/2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Extra Credit Map
        Map map = new HashMap();

        //JCL or GenericSets?
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("\n JCL(0) or Custom(1): ");
        String type = reader.readLine();


        // Be sure that the user has provided arguments.
        if (args.length == 0 || args.length > 1) {
            System.err.println("Incorrect number of parameters:  " + args.length + ".");
            System.err.println("Should be 1.");
            System.exit(1);
        }

        // Get a path to the file specified.
        Path path = null;
        try {
            path = Paths.get(args[0]);
        } catch (InvalidPathException e) {
            System.err.println("Could not resolve the given filepath: " + args[0] + ".");
            System.exit(1);
        }
        if (type.equals("1")){//Custom
            // Read all of the lines from the file.
            GenericSetExtended[] sets = new GenericSetExtended[100];
            int setCount = 0;
            try {
                for (String line : Files.readAllLines(path)) {
                    if (setCount % 2 == 0) {
                        sets[setCount] = new GenericSet1(100);
                    } else {
                        sets[setCount] = new GenericSet2();
                    }

                    for (String word : line.split("\\W+")) {
                        if(map.containsKey(word)){
                            Integer oldCount = (Integer) map.get(word);
                            map.remove(word);
                            map.put(word,++oldCount);

                        }
                        if (!sets[setCount].contains(word)) {
                            sets[setCount].insert(word);
                            if(!map.containsKey(word)) {
                                int count = 1;
                                map.put(word, count);
                            }

                        }
                    }
                    ++setCount;
                }
            } catch (IOException e) {
                System.err.println("Could not read all lines from the file at the given path.");
            }



            for (int i = 0; i < setCount; i += 2) {
                GenericSetExtended union = new GenericSet1(100), intersection = new GenericSet1(100), difference = new GenericSet1(100);
                GenericSetExtended union2 = new GenericSet2(), intersection2 = new GenericSet2(), difference2 = new GenericSet2();
                ArrayList<Object> line1 = new ArrayList<Object>();
                ArrayList<Object> line2 = new ArrayList<Object>();
                int line1Length = sets[0].size();
                int line2Length = sets[1].size();
                for (int j = 0; j < line1Length; j++) {
                    Object s1 = sets[i].removeAny();
                    line1.add(s1);
                    union.insert(s1);
                    intersection.insert(s1);
                    difference.insert(s1);
                }
                for (int j = 0; j < line2Length; j++) {
                    Object s2 = sets[i + 1].removeAny();
                    line2.add(s2);
                    union2.insert(s2);
                    intersection2.insert(s2);
                    difference2.insert(s2);
                }
                for (int j = 0; j < line1Length; j++) {
                    sets[i].insert(line1.get(j));
                }
                for (int j = 0; j < line2Length; j++) {
                    sets[i + 1].insert(line2.get(j));
                }
                System.out.println("First line: " + sets[i]);
                System.out.println("Second line: " + sets[i + 1]);

                union.union(union2);
                intersection.intersect(intersection2);
                difference.difference(difference2);

                // Print all of the sets, including the state of the initial sets.


                System.out.println();

                System.out.println("Union: " + union);
                System.out.println("Intersection: " + intersection);
                System.out.println("Difference: " + difference);

                System.out.println();
            }
        } else {// Read all of the lines from the file.
            Set[] sets = new Set[100];
            int setCount = 0;
            try {
                for (String line : Files.readAllLines(path)) {
                    if (setCount % 2 == 0) {
                        sets[setCount] = new HashSet(100);
                    } else {
                        sets[setCount] = new TreeSet();
                    }

                    for (String word : line.split("\\W+")) {
                        if(map.containsKey(word)){
                            Integer oldCount = (Integer) map.get(word);
                            map.remove(word);
                            map.put(word,++oldCount);

                        }
                        if (!sets[setCount].contains(word)) {
                            sets[setCount].add(word);
                            if(!map.containsKey(word)) {
                                int count = 1;
                                map.put(word, count);
                            }

                        }
                    }

                    ++setCount;
                }
            } catch (IOException e) {
                System.err.println("Could not read all lines from the file at the given path.");
            }

            for (int i = 0; i < setCount; i += 2) {
                Set union = new java.util.HashSet(100), intersection = new java.util.HashSet(100), difference = new java.util.HashSet(100);
                Set union2 = new TreeSet(), intersection2 = new TreeSet(), difference2 = new TreeSet();
                union.addAll(sets[i]);
                intersection.addAll(sets[i]);
                difference.addAll(sets[i]);
                union2.addAll(sets[i + 1]);
                intersection2.addAll(sets[i + 1]);
                difference2.addAll(sets[i + 1]);

                System.out.println("First line: " + sets[i]);
                System.out.println("Second line: " + sets[i + 1]);

                union(union,union2);
                intersect(intersection,intersection2);
                difference(difference,difference2);

                // Print all of the sets, including the state of the initial sets.


                System.out.println();

                System.out.println("Union: " + union);
                System.out.println("Intersection: " + intersection);
                System.out.println("Difference: " + difference);

                System.out.println();

            }
        }
        System.out.println(map.entrySet());
    }
    //aguments line1
    public static void union(Set line1, Set line2) {
        //Iterator first = line1.iterator();
        Iterator second = line2.iterator();
            while (second.hasNext()) {
                Object element = second.next();
                if (!line1.contains(element)){
                        line1.add(element);
                }
            }
            line2.clear();


    }
    public static void intersect(Set line1, Set line2) {
        Set intersect = new HashSet(100);//for line1
        Iterator second = line2.iterator();
        while (second.hasNext()) {
            Object element = second.next();
            if (line1.contains(element)){
                intersect.add(element);
            }
        }
        line2.clear();
        line1.clear();
        line1.addAll(intersect);


    }

    public static void difference(Set line1, Set line2) {
        Set diff = new HashSet(100);//for line1
        Iterator second = line2.iterator();
        Iterator first = line1.iterator();

        while (first.hasNext()) {
            Object element = first.next();
            if (!line2.contains(element)){
                diff.add(element);
            }
        }
        line2.clear();
        line1.clear();
        line1.addAll(diff);
    }

}