package gun16;

import utils.BaseStaticDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class yyy extends BaseStaticDriver {
    public static void main(String[] args) {
        String fileName ="ScreenShot_" +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        System.out.println(fileName);
    }
}
