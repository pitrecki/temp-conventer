/**
 * Created by Pitrecki on 2016-08-18.
 */
public class TemperatureConventer
{
    private Fahrenheit fahrenheit;
    private Celsius celsius;
    private Kelwin kelwin;

    public TemperatureConventer() {
        fahrenheit = new Fahrenheit();
        celsius = new Celsius();
        kelwin = new Kelwin();
    }

    public double convertToCelsius(double temp) {
        temp = (5.0 / 9.0) * (temp - 32);
        celsius.setTempValue(temp);
        return temp;
    }

    public double converToFahrenheit(double temp) {
        temp = (9.0 / 5.0) * temp + 32;
        fahrenheit.setTempValue(temp);
        return temp;
    }

    public void converToKelwin(String temp) {
        Double parseStringToDouble = new Double(temp.substring(0, temp.length()-1));
        final double k = 273.15;
        if (temp.contains("k")) {
            celsius.setTempValue(parseStringToDouble - k);
            fahrenheit.setTempValue((9.0/5.0) * (parseStringToDouble - k) + 32);
        }
        else if (temp.contains("c")) {
            kelwin.setTempValue(parseStringToDouble + k);
        }
        else {
            kelwin.setTempValue((parseStringToDouble - 32) * (5.0/9.0) + k);
        }
    }

    public void inputData(String s) {
        String tmp;
        s = s.toLowerCase();

        if (!s.contains("c") && !s.contains("f") && !s.contains("k")) {
            System.out.println("Niepoprawny format.");
            System.out.println("Wpisz <wartosc>f konwersja na st. Celsiusza | <wartosc>c konwersja na st. Fahrenheita.");
            System.out.println("Przyklad 25.0c");
        }
        else {
            if (!s.contains(".") || !s.contains(".0")) {
                tmp = s;
                if (!tmp.contains("."))
                    s = tmp.replace(tmp.substring(tmp.length() -1), ".0" + tmp.substring(tmp.length() - 1));
                else
                    s = tmp.replace(tmp.substring(tmp.length() -1), "0" + tmp.substring(tmp.length() - 1));
            }

            tmp = s.substring(s.length()-1);
            Double parseStringToDouble = new Double(s.substring(0, s.length() - 1));

            switch (tmp) {
                case "f":
                    fahrenheit.setTempValue(parseStringToDouble);
                    convertToCelsius(parseStringToDouble);
                    converToKelwin(s);
                    System.out.println("Konwersja temperatury z " + fahrenheit.getTempValue() + "f na " + celsius.getTempValue() + "c i" + kelwin.getTempValue() + "k");
                    break;
                case "c":
                    celsius.setTempValue(parseStringToDouble);
                    converToFahrenheit(parseStringToDouble);
                    converToKelwin(s);
                    System.out.println("Konwersja temperatury z " + celsius.getTempValue() + "c na " + fahrenheit.getTempValue() + "f i " + kelwin.getTempValue() + "k");
                    break;
                case "k":
                    kelwin.setTempValue(parseStringToDouble);
                    converToKelwin(s);
                    System.out.println("Konwersja temperatury z " + kelwin.getTempValue() + "k na " + celsius.getTempValue() + "c i " + fahrenheit.getTempValue() + "f");
                    break;
            }
        }

    }
}
