package JSONParser;

public class JSONParser {
    public static Object parse(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        if (value.matches("-?\\d+(\\.\\d+)?")) {
            if (value.contains(".")) {
                return Double.parseDouble(value);
            }
            return Integer.parseInt(value);
        }
        if (value.equals("true") || value.equals("false")) {
            return Boolean.parseBoolean(value);
        }
        if (value.length() == 1) {
            return null;
        }
        if (value.charAt(0) == '"' && value.charAt(value.length() - 1) == '"') {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }
}

