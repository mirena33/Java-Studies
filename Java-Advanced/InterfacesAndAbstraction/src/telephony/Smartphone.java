package telephony;
import java.util.LinkedList;
import java.util.List;


public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new LinkedList<>(numbers);
        this.urls = new LinkedList<>(urls);
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {

            if (validateNumber(number)) {
                sb.append("Calling... ")
                        .append(number)
                        .append(System.lineSeparator());
            } else {
               sb.append("Invalid number!");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (validateURL(url)) {

                sb.append("Browsing: ")
                        .append(url)
                        .append("!")
                        .append(System.lineSeparator());
            } else {
              sb.append("Invalid URL!");
            }
        }
        return sb.toString().trim();
    }

    private boolean validateNumber(String number) {
        boolean check = false;

        if (number.matches("\\d+")) {
            check = true;
        }
        return check;
    }

    private boolean validateURL(String url) {
        boolean check = false;
        if (url.matches("\\D+")) {
            check = true;
        }
        return check;
    }
}
