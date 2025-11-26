import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Person implements Comparable<Person> {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];

        for(int i=0; i<n; i++) {
            String[] parts = br.readLine().split(" ");
            int age = Integer.parseInt(parts[0]);
            String name = parts[1];
            people[i] = new Person(age, name);
        }

        Arrays.sort(people);

        StringBuilder sb = new StringBuilder();
        for(Person p : people) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }

        System.out.print(sb);
    }
}