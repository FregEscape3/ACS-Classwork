public class NameOps {
    public static String printMethodCall(String method, String name) {
        return (method + "(\"" + name + "\"): ");
    }

    public static String whoIsAwesome(String name) {
        return (name + " is awesome!");
    }

    public static int indexOfFirstSpace(String name) {
        return (name.indexOf(' '));
    }

    public static int indexOfSecondSpace(String name) {
        if (indexOfFirstSpace(name) == -1) {
            return -1;
        } else {
            String name1 = name.substring(indexOfFirstSpace(name) + 1, name.length());
            if (name1.indexOf(' ') == -1) {
                return -1;
            } else {
                return (name1.indexOf(' ') + indexOfFirstSpace(name) + 1);
            }
        }
    }

    public static String findFirstName(String name) {
        int index1 = indexOfFirstSpace(name);
        if (index1 == -1) {
            return name;
        } else {
            return (name.substring(0, indexOfFirstSpace(name)));
        }
    }

    public static String findLastName(String name) {
        int index1 = indexOfSecondSpace(name);
        if (index1 == -1) {
            int index2 = indexOfFirstSpace(name);
            if (index2 == -1) {
                return ("");
            } else {
                return (name.substring(indexOfFirstSpace(name) + 1, name.length()));
            }
        } else {
            return (name.substring(indexOfSecondSpace(name) + 1, name.length()));    
        }
    }

    public static String findMiddleName(String name) {
        int index1 = indexOfSecondSpace(name);
        if (index1 == -1) {
            return ("");
        } else {
            return (name.substring(indexOfFirstSpace(name) + 1, index1));
        }
    }

    public static String generateLastFirstMidInitial(String name) {
        if (indexOfSecondSpace(name) == -1) {
            if (indexOfFirstSpace(name) == -1) {
                return (name);
            } else {
                return (findLastName(name) + ", " + findFirstName(name));
            }
        } else {
            return (findLastName(name) + ", " + findFirstName(name) + " "
                     + findMiddleName(name).substring(0, 1) + ".");
        }
    }
}