package pl.pjatk.s36691.gui.zad18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Device[] devices = {
            new LandlinePhone("Home Phone", "Panasonic", 59.50F),
            new Cellphone("Blackberry S", "Blackberry", 399.99F, true),
            new Cellphone("Nokia 3210", "Nokia", 220F, false),
            new GameConsole("PS5", "Playstation", 2500F, true),
            new GameConsole("xBox One", "Microsft", 2600F, false),
            new Smartphone("iPhone 16", "Apple", 4600F, true, true),
            new Smartphone("Fold 6", "Samsung", 3600F, false, true),
            new Smartphone("Huawei Phone","Huawei", 1100F, false, false),
            new Smartphone("Me 12", "Xiaomi", 600F, true, false)
        };

        List<Device> callableList = new ArrayList<>();
        List<Device> internetableList = new ArrayList<>();
        List<Device> playableList = new ArrayList<>();
        List<Device> messagableList = new ArrayList<>();

        Arrays.sort(devices,  new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return Float.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("Urządzenia posegregowane względem ceny:");
        System.out.println("= = = = = = =");
        for (Device device : devices) {
            addByFunction(device, Callable.class, callableList);
            addByFunction(device, Internetable.class, internetableList);
            addByFunction(device, Playable.class, playableList);
            addByFunction(device, SMSable.class, messagableList);
            System.out.println(device.toString());
            System.out.println("- - - - - - - ");
        }

        System.out.println();
        System.out.println("Urządzenia z funkcją dzwonienia:");
        System.out.println("= = = = = = =");
        for (Device device : callableList) {
            System.out.println(device.getName() + " - " + ((Callable) device).call());
        }
        System.out.println("= = = = = = =");
        System.out.println();
        System.out.println("Urządzenia z funkcją surfowania po internecie:");
        System.out.println("= = = = = = =");
        for (Device device : internetableList) {
            System.out.println(device.getName() + " - " + ((Internetable) device).internet());
        }
        System.out.println("= = = = = = =");
        System.out.println();
        System.out.println("Urządzenia z funkcją grania w gry:");
        System.out.println("= = = = = = =");
        for (Device device : playableList) {
            System.out.println(device.getName() + " - " + ((Playable) device).play());
        }
        System.out.println("= = = = = = =");
        System.out.println();
        System.out.println("Urządzenia z funkcją SMS:");
        System.out.println("= = = = = = =");
        for (Device device : messagableList) {
            System.out.println(device.getName() + " - " + ((SMSable) device).sms());
        }
        System.out.println("= = = = = = =");

    }

    private static void addByFunction(Device device, Class<?> type,  List<Device> list) {
        if (type.isInstance(device))  {
            list.add(device);
        }
    }
}
