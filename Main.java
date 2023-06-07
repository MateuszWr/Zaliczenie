import java.io.IOException;
import java.util.*;

class Main {
    public static enum ACTIONS {
        zamien, lista, koniec
    };

    public static List<String> CHARS_LIST = new ArrayList<>();

    public static void listAllChars() throws IOException {
        for (int i = 0; i < CHARS_LIST.size(); i++) {
            String msg = "\t" + i + ": \"" + CHARS_LIST.get(i) + "\"";
            System.out.println(msg);
        }
    }

    public static void change(Scanner scanner) {
        int i1 = -1;
        int i2 = -1;
        int size = CHARS_LIST.size();

        while (i1 == -1) {
            System.out.println("Wybierz index pierwszej wartosci:");

            String iNewStr = scanner.next().trim();
            int iNew = Integer.parseInt(iNewStr);

            if (iNew >= size || iNew < 0) {
                System.out.println("Element o podanym indexie nie wystepuje w tablicy znakowej (wybierz pomiedzy 0 a " + (size - 1) + ")");
            } else {
                i1 = iNew;
            }
        }

        while (i2 == -1) {
            System.out.println("Wybierz index drugiej wartosci:");

            String iNewStr = scanner.next().trim();
            int iNew = Integer.parseInt(iNewStr);

            if (iNew >= size || iNew < 0) {
                System.out.println("Element o podanym indexie nie wystepuje w tablicy znakowej (wybierz pomiedzy 0 a " + (size - 1) + ")");
            } else {
                i2 = iNew;
            }
        }

        System.out.println("Wybierz nowa wartosc dla podanych indeksow:");
        String iNewStr = scanner.next().trim();

        CHARS_LIST.set(i1, iNewStr);
        CHARS_LIST.set(i2, iNewStr);
        System.out.println("Wartosci zostale podmienione pomyslnie");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CHARS_LIST.add("a");
        }

        try {
            boolean stillWork = true;

            while(stillWork) {
                System.out.println("Wybierz z listy dostępnych opcji (zamien, lista, koniec):\n");
                Scanner scanner = new Scanner(System.in);
                String action = scanner.next().trim();

                switch (ACTIONS.valueOf(action)) {
                    case zamien:
                        change(scanner);
                        System.out.println("Nowa tablica po zamianie danych:");
                        listAllChars();
                        break;
                    case lista:
                        listAllChars();
                        break;
                    case koniec:
                        stillWork = false;
                        break;
                    default:
                    System.out.println("Nieznana akcja");
                }
            }
        } catch (IOException e) {
              e.printStackTrace();
        }
    }
}
