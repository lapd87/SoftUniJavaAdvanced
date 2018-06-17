import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 24.5.2018 г.
 * Time: 18:49 ч.
 */
public class _14DragonArmy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        Map<String, List<Dragon>> army = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] inputArgs = console.nextLine()
                    .split("\\s+");

            String type = inputArgs[0];
            String name = inputArgs[1];

            int damage = inputArgs[2].matches("\\d+") ? Integer.parseInt(inputArgs[2]) : 45;
            int health = inputArgs[3].matches("\\d+") ? Integer.parseInt(inputArgs[3]) : 250;
            int armor = inputArgs[4].matches("\\d+") ? Integer.parseInt(inputArgs[4]) : 10;

            Dragon dragon = new Dragon(name, damage, health, armor);

            army.putIfAbsent(type, new ArrayList<>());

            List<Dragon> dragons = army.get(type);
            dragons.removeIf(d -> d.getName().equals(name));
            dragons.add(dragon);

            army.put(type, dragons);
        }

        for (Map.Entry<String, List<Dragon>> dragons : army.entrySet()) {

            String type = dragons.getKey();
            Double damageAVG = 0.0;
            Double healthAVG = 0.0;
            Double armorAVG = 0.0;
            int dragonsCount = dragons.getValue().size();

            dragons.getValue()
                    .sort(Comparator
                            .comparing(Dragon::getName));

            StringBuilder dragonsResult = new StringBuilder();
            for (Dragon dragon : dragons.getValue()) {

                damageAVG += dragon.getDamage();
                healthAVG += dragon.getHealth();
                armorAVG += dragon.getArmor();
                dragonsResult.append(dragon.toString());
            }

            damageAVG /= dragonsCount;
            healthAVG /= dragonsCount;
            armorAVG /= dragonsCount;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
                    type, damageAVG, healthAVG, armorAVG);
            System.out.print(dragonsResult);
        }

    }
}

class Dragon {
    private String name;
    private int damage;
    private int health;
    private int armor;

    public Dragon() {
    }

    public Dragon(String name, int damage,
                  int health, int armor) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return String.format("-%s -> damage: %d, health: %d, armor: %d%n",
                name, damage, health, armor);
    }
}