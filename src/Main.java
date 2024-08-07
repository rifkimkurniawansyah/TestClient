import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> input1 = List.of("Abc", "bCd");
        System.out.println(sortedList(input1));     //cetak hasil input 1

        List<String> input2 = List.of("Oke", "One");
        System.out.println(sortedList(input2));     //cetak hasil input 2

        List<String> input3 = List.of("Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti");
        System.out.println(sortedList(input3));     //cetak hasil input 3
    }
    public static String sortedList (List<String> inputValue){
        HashMap<Character, Integer> charInHashMap = new HashMap<>();    //HashMap berfungsi untuk menyimpan frekuensi kemunculan setiap karakter
        for(String strToChar : inputValue){
            char [] charValue = strToChar.toCharArray();    //Konversi string menjadi array char
            for(char c : charValue){
                charInHashMap.put(c, charInHashMap.getOrDefault(c, 0) + 1);     //tambah frekuensi kemunculan karakter dalam HashMap
            }
        }
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(charInHashMap.entrySet());

        // Mengurutkan berdasarkan frekuensi menurun, kemudian abjad
        sortedList.sort((a, b) -> {
            int compare = b.getValue() - a.getValue(); // Urutkan frekuensi secara menurun
            if (compare != 0) {
                return compare;
            } else {
                return Character.compare(a.getKey(), b.getKey()); // Urutkan berdasarkan abjad
            }
        });

        StringBuilder resultChar = new StringBuilder();     //Menggabungkan Karakter
        for (Map.Entry<Character, Integer> entry : sortedList) {
            resultChar.append(entry.getKey());      //Tambahkan Karakter Ke StringBuilder
        }
        String result = inputValue + " = " + resultChar.toString();
        return result;
    }
}