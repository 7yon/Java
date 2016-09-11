public class lab_1_1 {

    public static void main(String[] args) {

        String[][] arrayTypes = new String[2][args.length];

        long typeLong;
        int typeInt;
        short typeShort;
        byte typeByte;

        for (int i = 0; i < args.length; i++) {
            arrayTypes[0][i] = args[i];
            try {
                typeLong = Long.parseLong(args[i]);
                arrayTypes[1][i] = "long";

                typeInt = Integer.parseInt(args[i]);
                arrayTypes[1][i] = "int";

                typeShort = Short.parseShort(args[i]);
                arrayTypes[1][i] = "short";

                typeByte = Byte.parseByte(args[i]);
                arrayTypes[1][i] = "byte";
            }
            catch (Exception e) {

            }
        }
        for (int i = 0; i < arrayTypes[0].length; i++) {
            System.out.println(arrayTypes[0][i] + "-" + arrayTypes[1][i] + "\n");
        }
    }
}
