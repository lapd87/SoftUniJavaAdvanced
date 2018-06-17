import java.util.*;

import static java.util.stream.Collectors.joining;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.6.2018 г.
 * Time: 13:31 ч.
 */
public class _13OfficeStuff {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        List<Company> companies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine()
                    .split("\\|| - ");

            String name = input[1];
            int amount = Integer.parseInt(input[2]);
            String product = input[3];

            Company company = companies.stream()
                    .filter(c -> c.getName().equals(name))
                    .findFirst()
                    .orElse(null);

            if (company == null) {
                company = new Company();
                company.setName(name);
                company.getProducts()
                        .put(product, amount);

                companies.add(company);
            } else {
                company.getProducts()
                        .putIfAbsent(product, 0);
                company.getProducts()
                        .put(product,
                                company.getProducts()
                                        .get(product) + amount);
            }
        }

        companies.stream()
                .sorted(Comparator.comparing(Company::getName))
                .forEach(System.out::println);
    }
}

class Company {
    private String name;
    private Map<String, Integer> products;

    public Company() {
        this.products = new LinkedHashMap<>();
    }

    public Company(String name, Map<String, Integer> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(getName())
                .append(": ");

        String mapToString = getProducts().entrySet()
                .stream()
                .map(e -> e.getKey() + "-" + e.getValue())
                .collect(joining(", "));

        result.append(mapToString);

        return result.toString();
    }
}