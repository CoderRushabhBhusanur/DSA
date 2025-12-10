package Linked_List_Examples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Polynode {
    float co;
    int power;

    Polynode(float co, int power) {
        this.co = co;
        this.power = power;
    }

    String termAbsString() {
        float absCo = Math.abs(co);
        boolean isWhole = absCo == (int) absCo;
        String coefStr = isWhole ? String.valueOf((int) absCo) : trimTrailingZeros(absCo);

        if (power == 0) {
            return coefStr;
        }

        if (absCo == 1.0f) {
            if (power == 1) return "X";
            else return "X^" + power;
        } else {
            if (power == 1) return coefStr + "X";
            else return coefStr + "X^" + power;
        }
    }

    private String trimTrailingZeros(float v) {
        String s = Float.toString(v);
        if (s.indexOf('.') >= 0) {
            s = s.replaceAll("0+$", "").replaceAll("\\.$", "");
        }
        return s;
    }
}

public class Polynomial_Addition_Functional {

    private static Map<Integer, Float> readPolynomial(Scanner in) {
        System.out.print("\nEnter highest power: ");
        int hp = in.nextInt();

        List<Pnode> nodes = new ArrayList<>();
        for (int p = hp; p >= 0; p--) {
            System.out.print("Enter coefficient for power " + p + ": ");
            float co = in.nextFloat();
            if (co != 0f) {
                nodes.add(new Pnode(co, p));
            }
        }

        Map<Integer, Float> map = nodes.stream()
                .collect(Collectors.toMap(
                        node -> node.power,
                        node -> node.co,
                        Float::sum        
                ));

        return map;
    }

    private static Map<Integer, Float> addPolynomials(Map<Integer, Float> a, Map<Integer, Float> b) {
        return Stream.concat(a.entrySet().stream(), b.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,                    
                        e -> e.getValue(),                    
                        Float::sum                       
                ));
    }

    private static List<Pnode> mapToSortedList(Map<Integer, Float> map) {
        return map.entrySet().stream()
                .filter(e -> e.getValue() != 0f)               
                .sorted(Map.Entry.<Integer, Float>comparingByKey(Comparator.reverseOrder()))
                .map(e -> new Pnode(e.getValue(), e.getKey()))
                .collect(Collectors.toList());
    }

    private static void printPolynomial(List<Pnode> poly) {
        if (poly.isEmpty()) {
            System.out.println("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < poly.size(); i++) {
            Pnode p = poly.get(i);
            String term = p.termAbsString();
            if (i == 0) {
                if (p.co < 0) sb.append("-");
                sb.append(term);
            } else {
                if (p.co < 0) {
                    sb.append(" - ").append(term);
                } else {
                    sb.append(" + ").append(term);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Polynomial 1:");
        Map<Integer, Float> poly1 = readPolynomial(in);
        System.out.print("Polynomial 1: ");
        printPolynomial(mapToSortedList(poly1));

        System.out.println("\nEnter Polynomial 2:");
        Map<Integer, Float> poly2 = readPolynomial(in);
        System.out.print("Polynomial 2: ");
        printPolynomial(mapToSortedList(poly2));

        Map<Integer, Float> sumMap = addPolynomials(poly1, poly2);

        List<Pnode> result = mapToSortedList(sumMap);
        System.out.print("\nSum polynomial: ");
        printPolynomial(result);

        in.close();
    }
}
